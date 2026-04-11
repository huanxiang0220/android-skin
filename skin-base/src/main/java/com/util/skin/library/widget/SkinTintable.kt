package com.util.skin.library.widget

import androidx.annotation.ColorRes

interface SkinTintable {
    /**
     * 设置颜色资源ID
     * @param colorId 颜色资源ID
     */
    fun setTintColorId(@ColorRes colorId: Int)
}