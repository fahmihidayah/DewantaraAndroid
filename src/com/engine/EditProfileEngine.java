package com.engine;

import org.json.JSONObject;

import com.dewantara_android.EditProfileActivity;
import com.framework.rest_clients.MyRestClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.models.Constantstas;
import com.models.DataSingleton;
import com.models.Guru;

public class EditProfileEngine implements Constantstas {
	private EditProfileActivity editProfileActivity;
	private Guru guru;

	public EditProfileEngine(EditProfileActivity editProfileActivity) {
		super();
		this.editProfileActivity = editProfileActivity;
		this.guru = DataSingleton.getInstance().getGuru();
	}

	public Guru getGuru() {
		return guru;
	}

	public void setGuruToView() {
		editProfileActivity.editTextAlamat.setText(guru.getAddress());
		editProfileActivity.editTextEmail.setText(guru.getEmail());
		editProfileActivity.editTextNama.setText(guru.getName());
		editProfileActivity.editTextNIK.setText(guru.getNik());
		editProfileActivity.editTextTelepon.setText(guru.getPhone());
	}

	public void updateProfile() {
		RequestParams params = new RequestParams();
		params.put("nik", editProfileActivity.editTextNIK.getText().toString());
		params.put("name", editProfileActivity.editTextNama.getText()
				.toString());
		params.put("address", editProfileActivity.editTextAlamat.getText()
				.toString());
		params.put("phone", editProfileActivity.editTextTelepon.getText()
				.toString());
		params.put("email", editProfileActivity.editTextEmail.getText()
				.toString());
		params.put("auth_key", DataSingleton.getInstance().getAuthKey());
		MyRestClient.post(API_UPDATE_GURU, params,
				new JsonHttpResponseHandler() {
					@Override
					public void onSuccess(JSONObject response) {
						
					}
				});

	}

}
