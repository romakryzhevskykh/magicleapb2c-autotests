package com.template.storefront.models;

import org.springframework.stereotype.Component;

@Component
public class UserModelBuilder {
	private String newCountry;
	private String newTitle;
	private String newFirstLastName;
	private String newCompanyId;
	private String newCompanyName;
	private String newAddr1;
	private String newAddr2;
	private String newCity;
	private String newPostCode;
	private String newPosition;
	private String newTelephone;
	private String newExt;
	private String newEmailAddr;
	private String newConfirmEmailaddr;
	private String newComment;

	public UserModelBuilder() {
	}

	public UserModelBuilder setNewCountry(String newCountry) {
		this.newCountry = newCountry;
		return this;
	}

	public UserModelBuilder setNewTitle(String newTitle) {
		this.newTitle = newTitle;
		return this;
	}

	public UserModelBuilder setNewFirstLastName(String newFirstLastName) {
		this.newFirstLastName = newFirstLastName;
		return this;
	}

	public UserModelBuilder setNewCompanyId(String newCompanyId) {
		this.newCompanyId = newCompanyId;
		return this;
	}

	public UserModelBuilder setNewCompanyName(String newCompanyName) {
		this.newCompanyName = newCompanyName;
		return this;
	}

	public UserModelBuilder setNewAddr1(String newAddr1) {
		this.newAddr1 = newAddr1;
		return this;
	}

	public UserModelBuilder setNewAddr2(String newAddr2) {
		this.newAddr2 = newAddr2;
		return this;
	}

	public UserModelBuilder setNewCity(String newCity) {
		this.newCity = newCity;
		return this;
	}

	public UserModelBuilder setNewPostCode(String newPostCode) {
		this.newPostCode = newPostCode;
		return this;
	}

	public UserModelBuilder setNewPosition(String newPosition) {
		this.newPosition = newPosition;
		return this;
	}

	public UserModelBuilder setNewTelephone(String newTelephone) {
		this.newTelephone = newTelephone;
		return this;
	}

	public UserModelBuilder setNewExt(String newExt) {
		this.newExt = newExt;
		return this;
	}

	public UserModelBuilder setNewEmailAddr(String newEmailAddr) {
		this.newEmailAddr = newEmailAddr;
		return this;
	}

	public UserModelBuilder setNewConfirmEmailaddr(String newConfirmEmailaddr) {
		this.newConfirmEmailaddr = newConfirmEmailaddr;
		return this;
	}

	public UserModelBuilder setNewComment(String newComment) {
		this.newComment = newComment;
		return this;
	}

	public UserModel createUserModel() {
		return new UserModel(newCountry, newTitle, newFirstLastName, newCompanyId, newCompanyName, newAddr1, newAddr2,
				newCity, newPostCode, newPosition, newTelephone, newExt, newEmailAddr, newConfirmEmailaddr, newComment);
	}

}
