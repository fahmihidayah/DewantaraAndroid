package com.models;

import java.io.Serializable;

/**
 * 
 { status: "200" message: "success" data: { guru: { nik: "0784734834" name:
 * "sarosa" address: "malang" phone: "085646616284" email: "sarosa@gmail.com"
 * account: { id: 3 userName: "a" password: "a" type: "GURU" }- }- }- }
 * 
 * @author fahmi
 * 
 */
public class Guru implements Serializable {
	private String nik;
	private String name;
	private String address;
	private String phone;
	private String email;

	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		String returnValue = "";
		returnValue += "NIK : " + getNik() + "\n\n\n";
		returnValue += "Nama : " + getName() + "\n\n\n";
		returnValue += "Alamat : " + getAddress() + "\n\n\n";
		returnValue += "Telepon : " + getPhone() + "\n\n\n";
		returnValue += "Email : " + getEmail() + "\n\n\n";
		return returnValue;
	}

}
