package com.java.naming.view;
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
		result += mainView.setRowMargin("번호", "날짜", "여자", "타입", "성", "글자수", "추천이름");
		result += mainView.getSeperator();
		System.out.print(result);
		
	}

	public void mainMenu() {
		
		String result = "";
		result += "\r\n";
		result += mainView.getSeperator();
		result += mainView.getSubTitle("이력보기");
		result += mainView.getSeperator();
		result += mainView.setNumRowMargin("전체보기", "메인 메뉴로 돌아가기");
		result += mainView.getSeperatorThin();
		result += mainView.input();
		System.out.print(result);
		
	}
	
}
