package com.java.naming;

import java.util.Scanner;

import com.java.naming.service.ExplainService;
import com.java.naming.service.HistoryService;
import com.java.naming.service.NameGeneratorService;
import com.java.naming.service.SettingService;
import com.java.naming.view.MainView;

public class Main {

	//기본 한국어 설정
	public static int langIndex = 0;
	//메인메뉴 반복문 true 기본값
	public static boolean loop = true;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MainView view = new MainView();
		NameGeneratorService namingService = new NameGeneratorService();
		HistoryService historyService = new HistoryService(); 
		SettingService settingService = new SettingService();
		ExplainService explainService = new ExplainService();
		
		while(loop) {
			view.getMainMenu();
			
			String input = scan.nextLine();
			
			if (input.equals("1")) {
				//작명하기
				namingService.start();
			} else if (input.equals("2")) {
				//이력보기
				historyService.history();
			} else if (input.equals("3")) {
				//설명보기
				explainService.get();
			} else if (input.equals("4")) {
				//환경 설정
				settingService.main();
			} else if (input.equals("5")) {
				//종료하기
				view.end();
				loop = false;
			} else {
				//입력 오류
				view.errorInput();
			}
			
		}

	}
	
}
