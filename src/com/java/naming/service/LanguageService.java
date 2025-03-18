package com.java.naming.service;

import com.java.naming.Main;
import com.java.naming.dao.LanguageDAO;
import com.java.naming.view.MainView;

//다국어 처리
public class LanguageService {

	private MainView mainView;
	
	public final int langKr = 0;
	public final int langEn = 1;
	public final int langJp = 2;
	
	public LanguageService() {
		this.mainView = new MainView();
	}
	
	//다른 클래스에서 호출할 때 > static 메소드로 정의되어 있어서 초기화 없이 직접 클래스 이름으로 호출 가능
	public static String get(String line) {
		return LanguageDAO.get(line, Main.langIndex);
	}
	
	public void set(int num) {
		if(num == 1) {	//한국어
			Main.langIndex = langKr;
			System.out.println(mainView.getSeperator());
			System.out.println(mainView.setRowMargin("한국어로 설정되었습니다."));
			System.out.println(mainView.getSeperator());
		} else if(num == 2) {
			Main.langIndex = langEn;
			System.out.println(mainView.getSeperator());
			System.out.println(mainView.setRowMargin("Changed to English."));
			System.out.println(mainView.getSeperator());
		} else if(num == 3) {
			Main.langIndex = langJp ;
			System.out.println(mainView.getSeperator());
			System.out.println(mainView.setRowMargin("日本語に設定されました。"));
			System.out.println(mainView.getSeperator());
		}
		
	}

}
