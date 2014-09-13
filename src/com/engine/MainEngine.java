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
import com.response.StringResponse;

public class MainEngine implements Constantstas{
	private MainActivity mainActivity;

	public MainEngine(MainActivity mainActivity) {
		super();
		this.mainActivity = mainActivity;
	}
	
	public void logout(){
		RequestParams params = new RequestParams();
		params.put("auth_key", DataSingleton.getInstance().getAuthKey());
		Toast.makeText(mainActivity, "Logout", 1000).show();
		MyRestClient.post(API_LOGOUT, params, new JsonHttpResponseHandler(){
			@Override
			public void onSuccess(JSONObject response) {
				StringResponse stringResponse = new Gson().fromJson(response.toString(), StringResponse.class);
				if(stringResponse.getStatus().equalsIgnoreCase("200")){
					Toast.makeText(mainActivity, stringResponse.getData(), Toast.LENGTH_LONG).show();
					DataSingleton.getInstance().setLogin(false);
					DataSingleton.getInstance().setAuthKey("");
					DataSingleton.getInstance().saveData(mainActivity);
					mainActivity.startActivity(new Intent(mainActivity, LoginActivity.class));
					mainActivity.finish();
				}
				
			}
		});
	}
}
