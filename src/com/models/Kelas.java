package com.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Kelas implements Serializable{
	private Long idKelas;
	private String namaKelas;
	private ArrayList<Siswa> listSiswa = new ArrayList<Siswa>();

	public Long getIdKelas() {
		return idKelas;
	}

	public void setIdKelas(Long idKelas) {
		this.idKelas = idKelas;
	}

	public String getNamaKelas() {
		return namaKelas;
	}

	public void setNamaKelas(String namaKelas) {
		this.namaKelas = namaKelas;
	}

	public ArrayList<Siswa> getListSiswa() {
		return listSiswa;
	}

	public void setListSiswa(ArrayList<Siswa> listSiswa) {
		this.listSiswa = listSiswa;
	}

}
