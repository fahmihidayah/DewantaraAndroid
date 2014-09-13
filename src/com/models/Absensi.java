package com.models;

import java.io.Serializable;

public class Absensi implements Serializable {
	private Siswa siswa;
	private boolean hadir = false;
	private String keterangan;

	public Absensi(Siswa siswa) {
		super();
		this.siswa = siswa;
	}

	public Siswa getSiswa() {
		return siswa;
	}

	public void setSiswa(Siswa siswa) {
		this.siswa = siswa;
	}

	public boolean isHadir() {
		return hadir;
	}

	public void setHadir(boolean hadir) {
		this.hadir = hadir;
		if(hadir){
			keterangan = "masuk";
		}
		else {
			keterangan = "tidak masuk";
		}
	}

	public String getKeterangan() {
		return (hadir ? "masuk" : keterangan);
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

	public DataAbsensi convertToDataAbsensi(Guru guru, Kelas kelas,
			MataPelajaran mataPelajaran) {
		DataAbsensi dataAbsensi = new DataAbsensi();
		dataAbsensi.setHadir(hadir);
		dataAbsensi.setIdMataPelajaran(mataPelajaran.getIdMataPelajaran());
		dataAbsensi.setKeterangan(getKeterangan());
		dataAbsensi.setNik(guru.getNik());
		dataAbsensi.setNim(siswa.getNim());
		return dataAbsensi;
		
	}

}
