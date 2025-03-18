package com.java.naming.model;
//작명 이력 정보
public class HistoryDTO {
	//번호, 날짜, 성별, 타입, 성, 글자수, 추천이름
	private String no;
	private String date;
	private String gender;
	private String type;
	private String surname;
	private String charactercount;
	private String recommendedname;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getCharactercount() {
		return charactercount;
	}
	public void setCharactercount(String charactercount) {
		this.charactercount = charactercount;
	}
	public String getRecommendedname() {
		return recommendedname;
	}
	public void setRecommendedname(String recommendedname) {
		this.recommendedname = recommendedname;
	}
	
}
