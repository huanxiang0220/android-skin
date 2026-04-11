package com.util.skinnable.support.compat.helpers

import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.ImageView
import androidx.annotation.ColorRes
import com.util.skin.library.helpers.SkinHelper
import com.util.skinnable.support.compat.R
import com.util.skinnable.support.compat.res.SkinCompatVectorResources

class SkinImageHelper(view: ImageView) : SkinHelper(view) {
    private var mSrcCompatResId = INVALID_ID
    private var mTintResId = INVALID_ID

    fun setTintColorId(@ColorRes colorId: Int) {
        mTintResId = colorId
        if (checkResourceIdValid(mTintResId)) {
            applyTintResource()
        }
    }

    override val mView: ImageView
        get() = super.mView as ImageView

    override fun loadFromAttributes(attrs: AttributeSet?, defStyleAttr: Int) {
        var a: TypedArray? = null
        try {
            a = mView.context.obtainStyledAttributes(
                attrs,
                R.styleable.SkinCompatImageView,
                defStyleAttr,
                0
            )
            mSrcId = a!!.getResourceId(R.styleable.SkinCompatImageView_android_src, INVALID_ID)
            mSrcCompatResId = a.getResourceId(R.styleable.SkinCompatImageView_srcCompat, INVALID_ID)
            mTintResId = a.getResourceId(R.styleable.SkinCompatImageView_tint, INVALID_ID)
        } finally {
            a?.recycle()
        }
        applySkin()
    }

    private fun applyTintResource() {
        if (checkResourceIdValid(mTintResId)) {
            mView.imageTintList = com.util.skin.library.res.SkinResourcesManager.getColorStateList(
                mView.context,
                mTintResId
            )
        }
    }

    override fun applySkin() {
        if (checkResourceIdValid(mSrcCompatResId)) {
            val drawable =
                SkinCompatVectorResources.getDrawableCompat(mView.context, mSrcCompatResId)
            if (drawable != null) {
                mView.setImageDrawable(drawable)
            }
        } else {
            if (checkResourceIdValid(mSrcId)) {
                val drawable = SkinCompatVectorResources.getDrawableCompat(
                    mView.context,
                    mSrcId
                )
                if (drawable != null) {
                    mView.setImageDrawable(drawable)
                }
            }
        }
        applyTintResource()
    }

}
