package com.dewantara_android;

import com.engine.EditProfileEngine;
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
import android.widget.EditText;
import android.widget.Toast;

public class EditProfileActivity extends Activity implements Constantstas {

	public EditText editTextNIK, editTextNama, editTextAlamat, editTextTelepon, editTextEmail;
	private EditProfileEngine editProfileEngine;
	
	private void initialComponent(){
		editTextNIK = (EditText) findViewById(R.id.editTextNik);
		editTextAlamat = (EditText) findViewById(R.id.editTextAddress);
		editTextEmail = (EditText) findViewById(R.id.editTextEmail);
		editTextNama = (EditText) findViewById(R.id.editTextName);
		editTextTelepon = (EditText) findViewById(R.id.editTextPhone);
		editProfileEngine = new EditProfileEngine(this);
		editProfileEngine.setGuruToView();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_profile_activity);
	}
	
	
	public void onClickSimpan(View view){
		
	}
}
