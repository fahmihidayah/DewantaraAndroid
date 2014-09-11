package com.models;

import java.util.ArrayList;
import java.util.Observable;

public class DataSingleton extends Observable {
	private static DataSingleton instance;
	private String serverAddress = "192.168.1.4:9000";
	private Guru guru;
	private String authKey;

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
