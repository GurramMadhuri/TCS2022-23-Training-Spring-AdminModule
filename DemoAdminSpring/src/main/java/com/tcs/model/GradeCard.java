package com.tcs.model;

public class GradeCard {

	private int id;
	public GradeCard() {}
	public GradeCard(int id, String result) {
		super();
		this.id = id;
		this.result = result;
	}
	private String result;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	}


