package ru.artkolest.spidertestproject.presentation.list_photos

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.artkolest.spidertestproject.App
import ru.artkolest.spidertestproject.R
import ru.artkolest.spidertestproject.base.BaseFragment
import ru.artkolest.spidertestproject.databinding.FragmentPhotosBinding

class PhotosFragment : BaseFragment<PhotosContract.Presenter>(R.layout.fragment_photos),
    PhotosContract.View {

    private val binding by viewBinding(FragmentPhotosBinding::bind)
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.view = this
        navController = view.findNavController()
        onInitUi()


    }

    private fun onInitUi() = with(binding) {

        btnPhotoInfo.setOnClickListener{
            navController.navigate(R.id.action_photosFragment_to_photoInfoFragment)
        }
    }

    override fun createComponent() = App.instance.getAppComponent()
        .createPhotosFragment().inject(this)
}



