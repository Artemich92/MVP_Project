package ru.artkolest.spidertestproject.base.extensions

import android.content.Context
import android.graphics.Color
import android.os.SystemClock
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.SearchView
import androidx.annotation.ColorInt
import androidx.constraintlayout.widget.Group
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

inline fun View.hide() {
    visibility = View.GONE
}

inline fun View.onClick(delayMillis: Long = 500, crossinline clickListener: (View) -> Unit) {
    var clickMillis = 0L
    setOnClickListener {
        val elapsedRealTime = SystemClock.elapsedRealtime()
        if (elapsedRealTime > clickMillis) {
            clickMillis = elapsedRealTime + delayMillis
            clickListener.invoke(it)
        }
    }
}
