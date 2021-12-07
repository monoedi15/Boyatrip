package com.faberhurt.boyatrip_fragment.tabbed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.faberhurt.boyatrip_fragment.databinding.ActivityTabbedBinding

class TabbedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTabbedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTabbedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
            binding.viewPager.adapter = sectionsPagerAdapter
            binding.tabs.setupWithViewPager(binding.viewPager)

    }
}