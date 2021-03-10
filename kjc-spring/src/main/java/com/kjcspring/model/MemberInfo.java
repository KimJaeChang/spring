package com.kjcspring.model;

public class MemberInfo {
	
	private int memberUID;
	private String memberEmail;
	private String memberPassword;
	private String memberName;
	
	@Override
	public String toString() {
		return "MemberInfo [memberUID=" + memberUID + ", memberEmail=" + memberEmail + ", memberPassword="
				+ memberPassword + ", memberName=" + memberName + "]";
	}

	public int getMemberUID() {
		return memberUID;
	}

	public void setMemberUID(int memberUID) {
		this.memberUID = memberUID;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	
	
}
