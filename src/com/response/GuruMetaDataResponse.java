package com.response;

import com.models.Guru;

public class GuruMetaDataResponse extends BaseResponse{
	private Data data;

	public class Data{
		private Guru guru;

		public Guru getGuru() {
			return guru;
		}

		public void setGuru(Guru guru) {
			this.guru = guru;
		}
		
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
	

}
