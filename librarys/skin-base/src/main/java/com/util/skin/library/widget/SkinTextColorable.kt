package com.util.skin.library.widget

import androidx.annotation.ColorRes

/**
 * 专用于代码动态设置文字颜色的接口
 */
interface SkinTextColorable {
    /**
     * 设置文字颜色资源ID
     * @param colorId 颜色资源ID
     */
    fun setTextColorId(@ColorRes colorId: Int)
}
