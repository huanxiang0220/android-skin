@file:JvmName("SkinEx")
package com.util.skin.library

import android.widget.TextView
import com.util.skin.library.widget.SkinTextColorable

fun TextView.setTextColorId(color: Int) {
    if (this is SkinTextColorable) {
        setTextColorId(color)
    }
}