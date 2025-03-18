package com.java.naming.view;

import com.java.naming.service.LanguageService;

//환경 설정 인터페이스
public class SettingView {

	private MainView mainView;
	
	public SettingView() {
		mainView = new MainView();
	}
	
	public void mainView() {
	    String result = "";
	    result += mainView.getSeperator();
	    result += mainView.getSubTitle(LanguageService.get("환경설정"));
	    result += mainView.getSeperator();
	    result += mainView.setNumRowMargin(
	        LanguageService.get("언어설정"), 
	        LanguageService.get("만든이"), 
	        LanguageService.get("메인으로 돌아가기"));
	    result += mainView.getSeperatorThin();
	    result += mainView.input();
	    System.out.print(result);
	}

	public void setLang() {
	    String result = "";
	    result += mainView.getSeperator();
	    result += mainView.getSubTitle(LanguageService.get("언어설정"));
	    result += mainView.getSeperator();
	    result += mainView.setNumRowMargin(
	        LanguageService.get("한국어"), 
	        LanguageService.get("영어"), 
	        LanguageService.get("일본어"), 
	        LanguageService.get("전 단계로 돌아가기"));
	    result += mainView.getSeperatorThin();
	    System.out.print(result);
	}

	public void setDeveloper() {
	    String result = "";
	    result += mainView.getSeperator();
	    result += mainView.getSubTitle(LanguageService.get("만든이"));
	    result += mainView.getSeperator();
	    result += mainView.setNumRowMargin(
	        LanguageService.get("개발자 정보"), 
	        LanguageService.get("코드보기"), 
	        LanguageService.get("전 단계로 돌아가기"));
	    result += mainView.getSeperatorThin();
	    System.out.print(result);
	}

	public void getGithub() {
	    String result = "";
	    result += mainView.getSeperator();
	    result += mainView.setRowMargin(LanguageService.get("Github 사이트에서 코드를 확인할 수 있습니다."));
	    result += mainView.setRowMargin(LanguageService.get("Github 사이트로 안내합니다^-^"));
	    result += mainView.getSeperator();
	    System.out.println(result);
	}
	
}
