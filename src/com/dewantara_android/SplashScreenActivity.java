package com.dewantara_android;

import com.models.Constantstas;
import com.models.DataSingleton;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class SplashScreenActivity extends Activity implements Constantstas {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen_activity);
//		DataSingleton.getInstance().saveData(this);
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				DataSingleton.getInstance().loadData(SplashScreenActivity.this);
				if (DataSingleton.getInstance().isLogin()) {
					startActivity(new Intent(SplashScreenActivity.this,
							MainActivity.class));
				} else {
					startActivity(new Intent(SplashScreenActivity.this,
							LoginActivity.class));
				}
				SplashScreenActivity.this.finish();
			}
		}, DELAYED_SPLASH_SCREEN_TIME);

	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.splash_screen, menu);
	// return true;
	// }

}
