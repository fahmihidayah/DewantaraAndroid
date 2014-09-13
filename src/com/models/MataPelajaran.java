package com.models;

import java.io.Serializable;

public class MataPelajaran implements Serializable{
	private Long idMataPelajaran;
	private String namaMataPelajaran;

	public Long getIdMataPelajaran() {
		return idMataPelajaran;
	}

	public void setIdMataPelajaran(Long idMataPelajaran) {
		this.idMataPelajaran = idMataPelajaran;
	}

	public String getNamaMataPelajaran() {
		return namaMataPelajaran;
	}

	public void setNamaMataPelajaran(String namaMataPelajaran) {
		this.namaMataPelajaran = namaMataPelajaran;
	}

}
