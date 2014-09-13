package com.dewantara_android;

import com.dewantara_android.R;
import com.engine.AbsensiEngine;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

public class AbsensiFragment extends Fragment{
	
	public Spinner spinnerKelas, spinnerMataPelajaran;
	public Button buttonAbsen;
	public View rootView;
	
	private AbsensiEngine absensiEngine;
	
	private void initialComponent(){
		spinnerMataPelajaran = (Spinner) rootView.findViewById(R.id.spinnerMataPelajaran);
		spinnerKelas = (Spinner) rootView.findViewById(R.id.spinnerKelas);
		buttonAbsen = (Button) rootView.findViewById(R.id.buttonAbsen);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.absen_fragment, null);
		return rootView;
	}

}
