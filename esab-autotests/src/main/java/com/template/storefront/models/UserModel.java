package com.template.storefront.models;

public class UserModel {
	private String country;
	private String title;
	private String firstLastName;
	private String companyId;
	private String companyName;
	private String addr1;
	private String addr2;
	private String city;
	private String postCode;
	private String position;
	private String telephone;
	private String ext;
	private String emailAddr;
	private String confirmEmailaddr;
	private String comment;

	@Override
	public String toString() {
		return "UserModel [country=" + country + ", title=" + title + ", firstLastName=" + firstLastName
				+ ", companyId=" + companyId + ", companyName=" + companyName + ", addr1=" + addr1 + ", addr2=" + addr2
				+ ", city=" + city + ", postCode=" + postCode + ", position=" + position + ", telephone=" + telephone
				+ ", ext=" + ext + ", emailAddr=" + emailAddr + ", confirmEmailaddr=" + confirmEmailaddr + ", comment="
				+ comment + "]";
	}

	public UserModel() {
	}

	public UserModel(String country, String title, String firstLastName, String companyId, String companyName,
			String addr1, String addr2, String city, String postCode, String position, String telephone, String ext,
			String emailAddr, String confirmEamilAddr, String comment) {
		this.country = country;
		this.title = title;
		this.firstLastName = firstLastName;
		this.companyId = companyId;
		this.companyName = companyName;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.city = city;
		this.postCode = postCode;
		this.position = position;
		this.telephone = telephone;
		this.ext = ext;
		this.emailAddr = emailAddr;
		this.confirmEmailaddr = confirmEamilAddr;
		this.comment = comment;

	}
}
