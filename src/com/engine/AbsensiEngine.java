package com.engine;

import java.util.ArrayList;

import org.json.JSONObject;

import android.widget.Toast;

import com.dewantara_android.AbsensiActivity;
import com.framework.rest_clients.MyRestClient;
import com.google.gson.Gson;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.models.Absensi;
import com.models.Constantstas;
import com.models.DataAbsensi;
import com.models.DataSingleton;
import com.models.Guru;
import com.models.Kelas;
import com.models.MataPelajaran;
import com.models.Siswa;

public class AbsensiEngine implements Constantstas {

	private AbsensiActivity absensiActivity;
	private ArrayList<Absensi> listAbsensi;
	private Guru guru;
	private Kelas kelas;
	private MataPelajaran mataPelajaran;

	public AbsensiEngine(AbsensiActivity absensiActivity) {
		super();
		this.absensiActivity = absensiActivity;
		initialData();
		setListAbsensi();
	}
	
	private void initialData (){
		guru = (Guru) absensiActivity.getIntent().getSerializableExtra("guru");
		kelas = (Kelas) absensiActivity.getIntent().getSerializableExtra("kelas");
		mataPelajaran = (MataPelajaran) absensiActivity.getIntent().getSerializableExtra("matapelajaran");
	}
	
	private void setListAbsensi(){
		listAbsensi = new ArrayList<Absensi>();
		ArrayList<Siswa> listSiswa = kelas.getListSiswa();
		if(listSiswa != null){
			for (Siswa siswa : listSiswa) {
				listAbsensi.add(new Absensi(siswa));
			}		
		}
	}
	
	public ArrayList<Absensi> getListAbsensi() {
		return listAbsensi;
	}
	
	public void absen(){
		RequestParams params = new RequestParams();
		params.put("auth_key", DataSingleton.getInstance().getAuthKey());
		params.put("data_absensi", new Gson().toJson(extractDataAbsensi()));
		MyRestClient.post(API_BULK_ABSENSI, params, new JsonHttpResponseHandler(){
			@Override
			public void onSuccess(JSONObject response) {
				Toast.makeText(absensiActivity, "Success absen siswa", Toast.LENGTH_LONG).show();
				absensiActivity.finish();
			}
		});
	}
	
	private ArrayList<DataAbsensi> extractDataAbsensi(){
		ArrayList<DataAbsensi> listDataAbsensi = new ArrayList<DataAbsensi>();
		for (Absensi absensi : listAbsensi) {
			listDataAbsensi.add(absensi.convertToDataAbsensi(guru, kelas, mataPelajaran));
		}
		return listDataAbsensi;
	}

}
