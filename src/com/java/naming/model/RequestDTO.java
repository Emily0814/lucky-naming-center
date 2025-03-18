package com.java.naming.model;

//이름 생성 요청 정보(조건, 선호 스타일 등)
public class RequestDTO {
    private int gender;          // 1: 여자, 2: 남자
    private int type;            // 1: 귀여운, 2: 강한, 3: 부드러운, 4: 전통적인, 5: 2025년 핫한
    private String surname;      // 성: 김, 이, 박 등
    private int characterCount;  // 1: 외자, 2: 2글자, 3: 3글자
    
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
    
    public String getSurname() {
        return surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public int getCharacterCount() {
        return characterCount;
    }
    
    public void setCharacterCount(int characterCount) {
        this.characterCount = characterCount;
    }
}