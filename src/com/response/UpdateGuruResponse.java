package com.response;

import com.models.Guru;

public class UpdateGuruResponse extends BaseResponse {
	private Guru data;

	public Guru getData() {
		return data;
	}

	public void setData(Guru data) {
		this.data = data;
	}

}
