package com.response;

public class LoginResponse extends BaseResponse {
	private Data data;

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public class Data {
		private String auth_token;

		public String getAuthToken() {
			return auth_token;
		}

		public void setAuthToken(String authToken) {
			this.auth_token = authToken;
		}
	}
	
}
