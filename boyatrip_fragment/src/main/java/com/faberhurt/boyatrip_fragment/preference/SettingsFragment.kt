package com.faberhurt.boyatrip_fragment.preference

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.faberhurt.boyatrip_fragment.R.*

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(xml.root_preferences, rootKey)
    }
}