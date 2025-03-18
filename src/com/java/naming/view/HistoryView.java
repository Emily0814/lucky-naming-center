package com.java.naming.view;

import com.java.naming.service.LanguageService;

//작명 이력 조회 인터페이스
public class HistoryView {

	private MainView mainView;
	
	public HistoryView() {
		this.mainView = new MainView();
	}
	
	public void title(String title) {
		
		String result = "";
		result += "\r\n";
		result += mainView.getSeperator();
		result += mainView.getSubTitle(title);
		System.out.print(result);
		
	}
	
	public void titleSpecific() {
	    String result = "";
	    
	    result += mainView.getSeperator();
	    result += mainView.setRowMargin(
	        LanguageService.get("번호"), 
	        LanguageService.get("날짜"), 
	        LanguageService.get("성별"), 
	        LanguageService.get("타입"), 
	        LanguageService.get("성"), 
	        LanguageService.get("글자수"), 
	        LanguageService.get("추천이름"), 
	        LanguageService.get("전체이름"));
	    result += mainView.getSeperator();
	    System.out.print(result);
	}

	public void mainMenu() {
	    String result = "";
	    result += "\r\n";
	    result += mainView.getSeperator();
	    result += mainView.getSubTitle(LanguageService.get("이력보기"));
	    result += mainView.getSeperator();
	    result += mainView.setNumRowMargin(
	        LanguageService.get("전체보기"), 
	        LanguageService.get("메인으로 돌아가기"));
	    result += mainView.getSeperatorThin();
	    result += mainView.input();
	    System.out.print(result);
	}
	
}
