package com.dewantara_android;

import com.engine.AbsensiEngine;
import com.framework.adapter.CustomAdapter;
import com.framework.common_utilities.ViewSetterUtilities;
import com.models.Absensi;
import com.models.Constantstas;
import com.models.DataSingleton;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class AbsensiActivity extends Activity implements Constantstas {

	public ListView listViewAbsensi;
	public CustomAdapter<Absensi> customAdapter;
	public AbsensiEngine absensiEngine;
	private void iniitalComponent(){
		absensiEngine = new AbsensiEngine(this);
		listViewAbsensi = (ListView) findViewById(R.id.listViewAbsensi);
		customAdapter = new CustomAdapter<Absensi>(this, R.layout.absensi_item_layout, absensiEngine.getListAbsensi()) {
			
			@Override
			public void setViewItems(View view, int position) {
				final Absensi absensi = listData.get(position);
				ViewSetterUtilities.setTextToView(view, R.id.textViewNamaSiswa, absensi.getSiswa().getName());
				TextView textViewKeterangan = ViewSetterUtilities.setTextToView(view, R.id.textViewKeterangan, absensi.getKeterangan());
				ViewSetterUtilities.setStateToCheckBox(view, R.id.checkBox1, absensi.isHadir())
				.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
					
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
						absensi.setHadir(isChecked);
						customAdapter.notifyDataSetChanged();
					}
				});
				
			}
		};
		listViewAbsensi.setAdapter(customAdapter);
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.absensi_activity);
		iniitalComponent();

	}
	
	public void onClickAbsen(View view){
		
	}

}
