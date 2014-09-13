package com.engine;

import java.util.ArrayList;

import com.dewantara_android.AbsensiActivity;
import com.models.Absensi;
import com.models.DataSingleton;
import com.models.Guru;
import com.models.Kelas;
import com.models.MataPelajaran;
import com.models.Siswa;

public class AbsensiEngine {

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

}
