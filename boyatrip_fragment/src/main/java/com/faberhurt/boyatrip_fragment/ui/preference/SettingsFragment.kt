package com.faberhurt.boyatrip_fragment.ui.preference

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.preference.PreferenceFragmentCompat
import com.faberhurt.boyatrip_fragment.R.*
import com.faberhurt.boyatrip_fragment.ui.main.MainActivity

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        (activity as MainActivity?)?.showIcon()
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(xml.root_preferences, rootKey)
    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
    }
}//TODO