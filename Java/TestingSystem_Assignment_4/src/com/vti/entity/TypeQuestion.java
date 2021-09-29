package com.vti.entity;
public class TypeQuestion {
	byte typeId;
	TypeName typeName;
	Question[] questions;
	public byte getTypeId() {
		return typeId;
	}
	public void setTypeId(byte typeId) {
		this.typeId = typeId;
	}
	public TypeName getTypeName() {
		return typeName;
	}
	public void setTypeName(TypeName typeName) {
		this.typeName = typeName;
	}
	public Question[] getQuestions() {
		return questions;
	}
	public void setQuestions(Question[] questions) {
		this.questions = questions;
	}
}
