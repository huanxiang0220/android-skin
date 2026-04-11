@file:JvmName("SkinEx")

package com.util.skin.library

import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes
import com.util.skin.library.widget.SkinTextColorable
import com.util.skin.library.widget.SkinTintable

fun TextView.setTextColorId(color: Int) {
    if (this is SkinTextColorable) {
        setTextColorId(color)
    }
}

fun ImageView.setTintColorId(@ColorRes color: Int) {
    if (this is SkinTintable) {
        setTintColorId(color)
    }
}