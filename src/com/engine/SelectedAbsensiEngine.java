package com.engine;

import java.util.ArrayList;

import android.content.Intent;
import android.location.Address;

import com.dewantara_android.AbsensiActivity;
import com.dewantara_android.SelectAbsensiFragment;
import com.models.DataSingleton;
import com.models.Guru;
import com.models.Kelas;
import com.models.MataPelajaran;

public class SelectedAbsensiEngine {
	private SelectAbsensiFragment absensiFragment;
	private ArrayList<MataPelajaran> listMataPelajaran;
	private ArrayList<Kelas> listKelas;
	public SelectedAbsensiEngine(SelectAbsensiFragment absensiFragment) {
		super();
		this.absensiFragment = absensiFragment;
		listMataPelajaran = DataSingleton.getInstance().getListMataPelajaran();
		listKelas = DataSingleton.getInstance().getListKelas();
	}
	
	public ArrayList<String> getListKelasName(){
		ArrayList<String> kelasName = new ArrayList<String>();
		for (Kelas kelas : listKelas) {
			kelasName.add(kelas.getNamaKelas());
		}
		return kelasName;
	}
	
	public ArrayList<String> getListMataPelajaranName(){
		ArrayList<String> matapelajaranName = new ArrayList<String>();
		
		for (MataPelajaran matapelajaran : listMataPelajaran) {
			matapelajaranName.add(matapelajaran.getNamaMataPelajaran());
		}
		
		return matapelajaranName;
	}
	
	public void selectedAbsensi(){
		Kelas kelas = listKelas.get(absensiFragment.spinnerKelas.getSelectedItemPosition());
		MataPelajaran mataPelajaran = listMataPelajaran.get(absensiFragment.spinnerMataPelajaran.getSelectedItemPosition());
		Guru guru = DataSingleton.getInstance().getGuru();
		Intent intent = new Intent(absensiFragment.getActivity(), AbsensiActivity.class);
		intent.putExtra("kelas", kelas);
		intent.putExtra("matapelajaran", mataPelajaran);
		intent.putExtra("guru", guru);
		absensiFragment.getActivity().startActivity(intent);
	}

}
