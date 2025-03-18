package com.java.naming.model;
//이름 정보(철자, 발음, 의미, 출처 등)
public class NameDTO {

	private String no;			//일련번호
	private int gender;			//성별 (1: 여자, 2: 남자)
	private int type;			//타입 (1: 귀여운, 2: 강한, 3: 부드러운, 4: 전통적인, 5: 2025년 핫한)
	private String surName;		//성
	private String firstName;	//이름
	private int charCount;		//글자수 (1: 외자, 2: 2글자, 3: 3글자)
	private String meaning;		//이름의 의미 (옵션)
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getCharCount() {
		return charCount;
	}
	public void setCharCount(int charCount) {
		this.charCount = charCount;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	
	//성 + 이름 합쳐서 반환하는 메소드 추가
	public String getFullName() {
		return this.surName + this.firstName;
	}
	

	
}
