package com.response;

import java.util.ArrayList;

import com.models.Guru;
import com.models.Kelas;
import com.models.MataPelajaran;

public class GuruMetaDataResponse extends BaseResponse {
	private Data data;

	public class Data {
		private Guru dataUser;
		private ArrayList<Kelas> kelas;
		private ArrayList<MataPelajaran> matapelajaran;
		public Guru getDataUser() {
			return dataUser;
		}

		public void setDataUser(Guru dataUser) {
			this.dataUser = dataUser;
		}

		public ArrayList<Kelas> getKelas() {
			return kelas;
		}

		public void setKelas(ArrayList<Kelas> kelas) {
			this.kelas = kelas;
		}

		public ArrayList<MataPelajaran> getMatapelajaran() {
			return matapelajaran;
		}

		public void setMatapelajaran(ArrayList<MataPelajaran> matapelajaran) {
			this.matapelajaran = matapelajaran;
		}
		

	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

}
