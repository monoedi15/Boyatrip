package com.faberhurt.boyatrip_fragment.tabbed

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.faberhurt.boyatrip_fragment.R
import com.faberhurt.boyatrip_fragment.preference.SettingsFragment

private val TAB_TITLES = arrayOf(
    R.string.title_list,
    R.string.title_preference
)
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

        when (position){
            0-> return TabContainerFragmnet()
            else -> return SettingsFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 2
    }
}