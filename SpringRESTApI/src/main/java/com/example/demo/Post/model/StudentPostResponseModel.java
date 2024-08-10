package com.example.demo.Post.model;

public class StudentPostResponseModel {
	
	private int id;
	private String name;
	private int roll;
	private String[] sub = {"oops, os, dbms"};
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String[] getSub() {
		return sub;
	}
	public void setSub(String[] sub) {
		this.sub = sub;
	}
	public StudentPostResponseModel(int id, String name, int roll) {
		super();
		this.id = id;
		this.name = name;
		this.roll = roll;
	}
	public StudentPostResponseModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
