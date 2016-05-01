package com.form;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

public class LoginForm extends ActionForm{
	private String userName = null;
	private String password = null;
	
	public String getUserName() {
		System.out.println("get & return this.userName="+this.userName);
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
		System.out.println("set to this.userName from username="+this.userName);
		
	}
	public String getPassword() {
		System.out.println("get & return this.password="+this.password);
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
		System.out.println("set to this.userName from username="+this.password);
	}
	
}
