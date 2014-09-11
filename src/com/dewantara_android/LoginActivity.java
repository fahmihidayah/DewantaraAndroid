package com.dewantara_android;

import com.engine.LoginEngine;
import com.models.Constantstas;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends Activity implements Constantstas{

	LoginEngine loginEngine;
	public EditText editTextUserName, editTextPassword;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_activity);
		initialComponent();
	}

	private void initialComponent(){
		loginEngine = new LoginEngine(this);
		editTextUserName = (EditText) findViewById(R.id.editTextUserName);
		editTextPassword = (EditText) findViewById(R.id.editTextPassword);
	}
	public void onClickLogin(View view){
		loginEngine.login(editTextUserName.getText().toString(), editTextPassword.getText().toString());
	}

}
