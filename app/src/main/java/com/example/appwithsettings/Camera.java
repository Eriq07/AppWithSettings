package com.example.appwithsettings;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

public class Camera extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }
}