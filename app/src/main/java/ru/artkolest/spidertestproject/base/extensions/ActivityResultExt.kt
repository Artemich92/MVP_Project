package ru.artkolest.spidertestproject.base.extensions

import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment

fun Fragment.permissions(
    vararg permissions: String,
    extension: MultiplePermissionsBuilder.() -> Unit
) {
    val builder = MultiplePermissionsBuilder()
    builder.apply(extension)
    requestMultiplePermissions(
        permissions = permissions,
        allGranted = builder.allGranted,
        denied = builder.denied
    )
}

private inline fun Fragment.requestMultiplePermissions(
    vararg permissions: String,
    crossinline allGranted: () -> Unit = {},
    crossinline denied: (List<String>) -> Unit = {}
) {
    requireActivity().activityResultRegistry.register("permissionsKey", ActivityResultContracts.RequestMultiplePermissions()) { result: MutableMap<String, Boolean> ->
        val deniedList = result.filter { !it.value }.map { it.key }
        when {
            deniedList.isNotEmpty() -> {
                denied.invoke(deniedList)
            }
            else -> {
                allGranted.invoke()
            }
        }
    }.launch(permissions)
}