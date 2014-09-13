package com.models;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Observable;

import com.framework.common_utilities.SharedPreferenceUtilities;
import com.framework.file_handler.FileHandler;

import android.content.Context;
import android.content.BroadcastReceiver.PendingResult;

public class DataSingleton extends Observable implements Constantstas{
	private static DataSingleton instance;
	
	private Guru guru;
	private ArrayList<Kelas> listKelas;
	private ArrayList<MataPelajaran> listMataPelajaran;
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

	public ArrayList<Kelas> getListKelas() {
		return listKelas;
	}

	public void setListKelas(ArrayList<Kelas> listKelas) {
		this.listKelas = listKelas;
	}

	public ArrayList<MataPelajaran> getListMataPelajaran() {
		return listMataPelajaran;
	}

	public void setListMataPelajaran(ArrayList<MataPelajaran> listMataPelajaran) {
		this.listMataPelajaran = listMataPelajaran;
	}

	public void saveData(Context context) {
		SharedPreferenceUtilities preferenceUtilities = new SharedPreferenceUtilities(context);
		preferenceUtilities.putBoolean(ACTIVE_STATE, active);
		preferenceUtilities.putBoolean(LOGIN_STATE, login);
		preferenceUtilities.putString(AUTH_KEY, authKey);
		preferenceUtilities.putString(SERVER_ADDRESS, serverAddress);
		
		try {
			FileHandler.saveDataToFile(context, GURU_DATA, Context.MODE_PRIVATE, guru);
			FileHandler.saveDataToFile(context, LIST_KELAS_DATA, Context.MODE_PRIVATE, listKelas);
			FileHandler.saveDataToFile(context, LIST_MAPEL_DATA, Context.MODE_PRIVATE, listMataPelajaran);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadData(Context context){
		SharedPreferenceUtilities preferenceUtilities = new SharedPreferenceUtilities(context);
		active = preferenceUtilities.getBoolean(ACTIVE_STATE);
		login = preferenceUtilities.getBoolean(LOGIN_STATE);
		authKey = preferenceUtilities.getString(AUTH_KEY);
		serverAddress = preferenceUtilities.getString(SERVER_ADDRESS);
		
		try {
			guru = (Guru) FileHandler.loadDataFromFile(context, GURU_DATA);
			listKelas = (ArrayList<Kelas>) FileHandler.loadDataFromFile(context, LIST_KELAS_DATA);
			listMataPelajaran = (ArrayList<MataPelajaran>) FileHandler.loadDataFromFile(context, LIST_MAPEL_DATA);
		} catch (StreamCorruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
