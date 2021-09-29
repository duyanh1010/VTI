package com.vti.entity;
public class CategoryQuestion {
	byte categoryId;
	String categoryName;
	Question[] questions;
	public byte getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(byte categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Question[] getQuestions() {
		return questions;
	}
	public void setQuestions(Question[] questions) {
		this.questions = questions;
	}
}
