package com.action;
public class User
{
	private long id;
	private String name;
	private String pwd;
	public long getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
	public String getName() {
		return name;
	}
	public void setId(long string) {
		id = string;
	}
	public void setPwd(String string) {
		pwd = string;
	}
	public void setName(String string) {
		name = string;
	}
public String toString() {
		return name;
	}
}