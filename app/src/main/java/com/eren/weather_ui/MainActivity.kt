package com.eren.weather_ui

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.eren.weather_ui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /** Animation*/
        val animDrawable = binding.constraint.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val ViewPager: ViewPager2 = binding.ViewPager
        val fragments: ArrayList<Fragment> = arrayListOf(
            CloudyFragment(),
            RainyFragment(),
            SunnyFragment()
        )
        val adapter = ViewPagerAdapter(fragments, this)
        ViewPager.adapter = adapter
    }

    override fun onBackPressed() {
        if (binding.ViewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            binding.ViewPager.currentItem = binding.ViewPager.currentItem - 1
        }
    }
}