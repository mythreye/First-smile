package com.shris.backEndConnectivity.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MysiteCredentials {

	@Id
	private String credentialemail;
	private String credentialpassword;
	private String credentialrole;
	private boolean  credentialstatus;

	public String getCredentialemail() {
		return credentialemail;
	}

	public void setCredentialemail(String credentialemail) {
		this.credentialemail = credentialemail;
	}

	public String getCredentialpassword() {
		return credentialpassword;
	}

	public void setCredentialpassword(String credentialpassword) {
		this.credentialpassword = credentialpassword;
	}

	public String getCredentialrole() {
		return credentialrole;
	}

	public void setCredentialrole(String credentialrole) {
		this.credentialrole = credentialrole;
	}

	public boolean isCredentialstatus() {
		return credentialstatus;
	}

	public void setCredentialstatus(boolean credentialstatus) {
		this.credentialstatus = credentialstatus;
	}

}
