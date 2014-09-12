package com.dewantara_android;

import com.models.DataSingleton;

import android.app.Application;
import android.content.res.Configuration;

public class DewantaraApp extends Application{
	
	@Override
	public void onCreate() {
		DataSingleton.getInstance().setActive(true);
		DataSingleton.getInstance().saveData(this);
		super.onCreate();
	}
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
	}
	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		super.onLowMemory();
	}
	@Override
	public void onTerminate() {
		DataSingleton.getInstance().setActive(false);
		DataSingleton.getInstance().saveData(this);
		super.onTerminate();
	}

}
