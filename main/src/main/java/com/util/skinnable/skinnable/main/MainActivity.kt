package com.util.skinnable.skinnable.main

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.util.skin.library.SkinManager
import com.util.skin.library.loader.SkinStrategy
import com.util.skin.library.widget.SkinTextColorable
import com.util.skinnable.skinnable.main.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    when (tab!!.position) {
                        0 -> {
                            SkinManager.restoreDefaultSkin()
                        }

                        1 -> {
                            SkinManager.loadSkin(SkinStrategy.BuildIn("night"))
                        }

                        2 -> {
                            SkinManager.loadSkin(SkinStrategy.Assets("skin.night"))
                        }
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                }
            })
        }
//        binding.tvText2.setTextAppearance(R.style.Base_Widget_AppCompat_ListView)
        binding.tvText2.setTextColorId(R.color.red_1)
    }
}

fun TextView.setTextColorId(color: Int) {
    if (this is SkinTextColorable) {
        setTextColorId(color)
    }
}