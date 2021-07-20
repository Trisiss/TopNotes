package ru.trisiss.topnotes.util

import android.view.View
import androidx.databinding.BindingAdapter

/**
 * Created by trisiss on 7/2/2021.
 */
object BindingUtil {

    @JvmStatic
    @BindingAdapter("onLongClick")
    fun setOnLongClickListener(view: View, func: View.OnLongClickListener) {
        view.setOnLongClickListener(func)
    }
}