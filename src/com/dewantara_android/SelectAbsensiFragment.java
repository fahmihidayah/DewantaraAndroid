package com.dewantara_android;

import com.dewantara_android.R;
import com.engine.SelectedAbsensiEngine;

import android.os.Bundle;
import android.app.Fragment;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class SelectAbsensiFragment extends Fragment{
	
	public Spinner spinnerKelas, spinnerMataPelajaran;
	public Button buttonAbsen;
	public View rootView;
	
	private SelectedAbsensiEngine absensiEngine;
	
	private void initialComponent(){
		spinnerMataPelajaran = (Spinner) rootView.findViewById(R.id.spinnerMataPelajaran);
		spinnerKelas = (Spinner) rootView.findViewById(R.id.spinnerKelas);
		buttonAbsen = (Button) rootView.findViewById(R.id.buttonAbsen);
		absensiEngine = new SelectedAbsensiEngine(this);
		ArrayAdapter<String> adapterKelas = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, absensiEngine.getListKelasName());
		ArrayAdapter<String> adapterMataPelajaran = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, absensiEngine.getListMataPelajaranName());
		spinnerKelas.setAdapter(adapterKelas);
		spinnerMataPelajaran.setAdapter(adapterMataPelajaran);
		
		buttonAbsen.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				absensiEngine.selectedAbsensi();
			}
		});
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.absen_fragment, null);
		initialComponent();
		return rootView;
	}

}
