 package com.example.empmanegmentsystem.exception;

public class EmpNotFoundException extends RuntimeException{
	private String entity;
	private String attribute;
	private String value;
	private String msg ="Emp Not Found For above Details";
	
	
	public EmpNotFoundException(String entity, String attribute, String value) {
		super();
		this.entity = entity;
		this.attribute = attribute;
		this.value = value;
	}
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
