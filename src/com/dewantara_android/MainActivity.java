package com.dewantara_android;

import java.util.ArrayList;

import com.engine.MainEngine;
import com.framework.navigation_drawer_v3.MenuDrawer;
import com.framework.navigation_drawer_v3.NavigationDrawerActivity;
import com.models.Constantstas;
import com.models.DataSingleton;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends NavigationDrawerActivity implements
		Constantstas {

	// @Override
	// protected void onCreate(Bundle savedInstanceState) {
	// super.onCreate(savedInstanceState);
	// setContentView(R.layout.splash_screen_activity);
	// }

	MainEngine mainEngine = new MainEngine(this);

	@Override
	public Fragment getFragmentFromIndex(int i) {
		if (i == 0) {
			return new ProfileFragment();
		} 
		else if(i == 1) {
			return new ProfileFragment();
		}else {
			mainEngine.logout();
		}
		return null;
	}

	@Override
	public void setListDrawerMenu(ArrayList<MenuDrawer> listMenuDrawers) {
		listMenuDrawers.add(new MenuDrawer(R.drawable.ic_launcher, "Profile"));
		listMenuDrawers.add(new MenuDrawer(R.drawable.ic_launcher, "Abseni"));
		listMenuDrawers.add(new MenuDrawer(R.drawable.ic_launcher, "Logout"));
	}
}
