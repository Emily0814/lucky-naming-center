package com.java.naming.view;
//환경 설정 인터페이스
public class SettingView {

	private MainView mainView;
	
	public SettingView() {
		mainView = new MainView();
	}
	
	public void mainView() {
		
		String result = "";
		result += mainView.getSeperator();
		result += mainView.getSubTitle("환경 설정");
		result += mainView.getSeperator();
		result += mainView.setNumRowMargin("언어설정", "만든이", "메인 메뉴로 돌아가기");
		result += mainView.getSeperatorThin();
		result += mainView.input();
		System.out.print(result);
		
	}
	
	public void setLang() {
		String result = "";
		result += mainView.getSeperator();
		result += mainView.getSubTitle("언어설정");
		result += mainView.getSeperator();
		result += mainView.setNumRowMargin("한국어", "English", "日本語", "전 단계로 돌아가기");
		result += mainView.getSeperatorThin();
		System.out.print(result);
	}
	
	public void setDeveloper() {
		String result = "";
		result += mainView.getSeperator();
		result += mainView.getSubTitle("만든이");
		result += mainView.getSeperator();
		result += mainView.setNumRowMargin("개발자 정보", "코드보기", "전 단계로 돌아가기");
		result += mainView.getSeperatorThin();
		System.out.print(result);
	}
	
	public void getGithub() {
		
		String result = "";
		result += mainView.getSeperator();
		result += mainView.setRowMargin("Github 사이트에서 코드를 확인할 수 있습니다.");
		result += mainView.setRowMargin("Github 사이트로 안내합니다^-^");
		result += mainView.getSeperator();
		System.out.println(result);
		
	}
	
}
