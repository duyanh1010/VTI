package com.vti.entity;
import java.time.LocalDateTime;

public class Question {
	int questionId;
	String content;
	CategoryQuestion categoryQuestion;
	TypeQuestion	typeQuestion;
	Account creator;
	LocalDateTime createDate;
	Exam[] exams;
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public CategoryQuestion getCategoryQuestion() {
		return categoryQuestion;
	}
	public void setCategoryQuestion(CategoryQuestion categoryQuestion) {
		this.categoryQuestion = categoryQuestion;
	}
	public TypeQuestion getTypeQuestion() {
		return typeQuestion;
	}
	public void setTypeQuestion(TypeQuestion typeQuestion) {
		this.typeQuestion = typeQuestion;
	}
	public Account getCreator() {
		return creator;
	}
	public void setCreator(Account creator) {
		this.creator = creator;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	public Exam[] getExams() {
		return exams;
	}
	public void setExams(Exam[] exams) {
		this.exams = exams;
	}
	
}
