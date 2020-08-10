/*
 * 	MemberVO, MemberDTO, MemberBean
 * 	자바빈즈 
 */

package kr.co.twocamp.admin;


public class AdminBean {
	private String id;
	private String pw;
	private String name;
	private String email;
	private int phone1;
	private int phone2;
	
	AdminBean(){}
	
	
	@Override
	public String toString() {
		return "MemberleeBean [id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email
				+ ", phone1=" + phone1 + ", phone2=" + phone2 + "]";
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone1() {
		return phone1;
	}

	public void setPhone1(int phone1) {
		this.phone1 = phone1;
	}

	public int getPhone2() {
		return phone2;
	}

	public void setPhone2(int phone2) {
		this.phone2 = phone2;
	}
}

	