package com.engine;

import org.json.JSONObject;

import android.content.Intent;
import android.widget.Toast;

import com.dewantara_android.LoginActivity;
import com.dewantara_android.MainActivity;
import com.framework.rest_clients.MyRestClient;
import com.google.gson.Gson;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.models.Constantstas;
import com.models.DataSingleton;
import com.response.GuruMetaDataResponse;
import com.response.LoginResponse;

public class LoginEngine implements Constantstas {
	private LoginActivity loginActivity;
	
	public LoginEngine(LoginActivity loginActivity) {
		super();
		this.loginActivity = loginActivity;
	}

	public void login(final String userName, String password){
		RequestParams params = new RequestParams();
		params.put("userName", userName);
		params.put("password", password);
		Toast.makeText(loginActivity, params.toString(), 2000).show();
		MyRestClient.post(API_LOGIN, params, new JsonHttpResponseHandler(){
			@Override
			public void onSuccess(JSONObject response) {
				LoginResponse loginResponse = new Gson().fromJson(response.toString(), LoginResponse.class);
				if(loginResponse.getStatus().equalsIgnoreCase("200")){
					Toast.makeText(loginActivity, "Success Login", Toast.LENGTH_LONG).show();
					DataSingleton.getInstance().setAuthKey(loginResponse.getData().getAuthToken());
					DataSingleton.getInstance().setLogin(true);
					getMetadata(userName);
				}
				else {
					Toast.makeText(loginActivity, "User not found", Toast.LENGTH_LONG).show();
				}
			}
		});
	}
	
	public void getMetadata(String userName){
		RequestParams params = new RequestParams();
		params.put("userName", userName);
		params.put("auth_key", DataSingleton.getInstance().getAuthKey());
		MyRestClient.post(API_METADATA, params, new JsonHttpResponseHandler(){
			@Override
			public void onSuccess(JSONObject response) {
				GuruMetaDataResponse guruMetaDataResponse = new Gson().fromJson(response.toString(), GuruMetaDataResponse.class);
				DataSingleton.getInstance().setGuru(guruMetaDataResponse.getData().getGuru());
				DataSingleton.getInstance().saveData(loginActivity);
				loginActivity.startActivity(new Intent(loginActivity, MainActivity.class));
				loginActivity.finish();
			}	
			
		});
	}

}
