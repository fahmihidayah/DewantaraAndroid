package com.engine;

import org.json.JSONObject;

import android.widget.Toast;

import com.dewantara_android.LoginActivity;
import com.framework.rest_clients.MyRestClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.models.Constantstas;

public class LoginEngine implements Constantstas {
	private LoginActivity loginActivity;
	
	public LoginEngine(LoginActivity loginActivity) {
		super();
		this.loginActivity = loginActivity;
	}

	public void login(String userName, String password){
		RequestParams params = new RequestParams();
		params.put("userName", userName);
		params.put("password", password);
		MyRestClient.post(API_LOGIN, params, new JsonHttpResponseHandler(){
			@Override
			public void onSuccess(JSONObject response) {
				Toast.makeText(loginActivity, "Success login", Toast.LENGTH_LONG).show();
			}
		});
	}

}
