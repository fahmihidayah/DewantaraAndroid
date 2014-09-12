package com.framework.common_utilities;

import java.io.Serializable;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPreferenceUtilities {
	private Context context;
	private SharedPreferences preferences;

	public SharedPreferenceUtilities(Context context) {
		super();
		this.context = context;
		preferences = PreferenceManager.getDefaultSharedPreferences(context);
	}

	public void putString(String key, String value) {
		preferences.edit().putString(key, value).apply();
	}

	public void putBoolean(String key, boolean value) {
		preferences.edit().putBoolean(key, value).apply();
	}

	public String getString(String key) {
		return preferences.getString(key, "");
	}

	public boolean getBoolean(String key) {
		return preferences.getBoolean(key, false);
	}

}
