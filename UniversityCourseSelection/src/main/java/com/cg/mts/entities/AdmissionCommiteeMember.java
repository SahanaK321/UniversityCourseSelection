package com.cg.mts.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdmissionCommiteeMember {
	@Id
	@Column(name = "ad_id",length=20)
	int adminId;
	@Column(name = "ad_name",length=20)
	String adminName;
	@Column(name = "ad_contact",length=20)
	String adminContact;

	public AdmissionCommiteeMember() {
	}

	public AdmissionCommiteeMember(int adminId, String adminName, String adminContact) {

		this.adminId = adminId;
		this.adminName = adminName;
		this.adminContact = adminContact;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminContact() {
		return adminContact;
	}

	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}

}