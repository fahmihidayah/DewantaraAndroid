package com.dewantara_android;

import com.engine.LoginEngine;
import com.models.Constantstas;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends FragmentActivity implements Constantstas {

	LoginEngine loginEngine;
	public EditText editTextUserName, editTextPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_activity);
		initialComponent();
	}

	private void initialComponent() {
		loginEngine = new LoginEngine(this);
		editTextUserName = (EditText) findViewById(R.id.editTextUserName);
		editTextPassword = (EditText) findViewById(R.id.editTextPassword);
	}

	public void onClickLogin(View view) {
		loginEngine.login(editTextUserName.getText().toString(),
				editTextPassword.getText().toString());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash_screen, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.setting_server:
			SettingServerAddressDialog addressDialog = new SettingServerAddressDialog();
			addressDialog.show(getSupportFragmentManager(), "setting_server");
			break;

		default:
			return super.onOptionsItemSelected(item);
		}
		return true;
		
	}
}
