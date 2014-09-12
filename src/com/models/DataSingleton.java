package com.models;

import java.util.ArrayList;
import java.util.Observable;

import com.framework.common_utilities.SharedPreferenceUtilities;

import android.content.Context;
import android.content.BroadcastReceiver.PendingResult;

public class DataSingleton extends Observable implements Constantstas{
	private static DataSingleton instance;
	
	private Guru guru;
	
	private String serverAddress = "192.168.1.5:9000";
	private String authKey;
	private boolean login;
	private boolean active;

	protected DataSingleton() {

	}

	public Guru getGuru() {
		return guru;
	}

	public void setGuru(Guru guru) {
		this.guru = guru;
	}

	public String getServerAddress() {
		return serverAddress;
	}

	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}

	public String getAuthKey() {
		return authKey;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}

	public void saveData(Context context) {
		SharedPreferenceUtilities preferenceUtilities = new SharedPreferenceUtilities(context);
		preferenceUtilities.putBoolean(ACTIVE_STATE, active);
		preferenceUtilities.putBoolean(LOGIN_STATE, login);
		preferenceUtilities.putString(AUTH_KEY, authKey);
		preferenceUtilities.putString(SERVER_ADDRESS, serverAddress);
	}
	
	public void loadData(Context context){
		SharedPreferenceUtilities preferenceUtilities = new SharedPreferenceUtilities(context);
		active = preferenceUtilities.getBoolean(ACTIVE_STATE);
		login = preferenceUtilities.getBoolean(LOGIN_STATE);
		authKey = preferenceUtilities.getString(AUTH_KEY);
		serverAddress = preferenceUtilities.getString(SERVER_ADDRESS);
	}

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public static DataSingleton getInstance() {
		if (instance == null) {
			instance = new DataSingleton();
		}
		return instance;
	}

	public void notifyObserverDataChange() {
		setChanged();
		notifyObservers();
	}

}
