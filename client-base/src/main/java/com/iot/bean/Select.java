package com.iot.bean;

public class Select {

	private String text;
	private String value;
	
	public Select() {
	}

	public Select(String value) {
		this.value = value;
	}

	public Select(String text, String value) {
		this.text = text;
		this.value = value;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}