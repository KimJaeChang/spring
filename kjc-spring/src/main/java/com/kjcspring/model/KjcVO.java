package com.kjcspring.model;

public class KjcVO {
	private String kid = "";
	private String kname = "";
	private String kaddress = "";
	private String kphone = "";
	
	@Override
	public String toString() {
		return "KjcVO [kid=" + kid + ", kname=" + kname + ", kaddress=" + kaddress + ", kphone=" + kphone + "]";
	}
	
	public String getKid() {
		return kid;
	}
	public void setKid(String kid) {
		this.kid = kid;
	}
	public String getKname() {
		return kname;
	}
	public void setKname(String kname) {
		this.kname = kname;
	}
	public String getKaddress() {
		return kaddress;
	}
	public void setKaddress(String kaddress) {
		this.kaddress = kaddress;
	}
	public String getKphone() {
		return kphone;
	}
	public void setKphone(String kphone) {
		this.kphone = kphone;
	}
	
	
	
}

