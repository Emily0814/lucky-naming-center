package com.java.naming.service;

import java.awt.Desktop;
import java.net.URI;
import java.util.Scanner;

import com.java.naming.dao.SettingDAO;
import com.java.naming.view.MainView;
import com.java.naming.view.SettingView;

public class SettingService {

	private Scanner scan;
	private MainView mainView;
	private SettingView view;
	private LanguageService languageService;
	private SettingDAO dao;
	
	
	public SettingService() {
		scan = new Scanner(System.in);
		mainView = new MainView();
		view = new SettingView();
		languageService = new LanguageService();
		dao = new SettingDAO();
	}
	
	public void main() {
		
		boolean stop = true;
		
		while(stop) {
			
			view.mainView();
			String input = scan.nextLine();
			
			if(input.equals("1")) {
				//언어설정
				setLang();
			} else if(input.equals("2")) {
				//만든이
				setDeveloper();
			} else if(input.equals("3")) {
				//메인메뉴로 돌아가기
				stop = false;
			} else {
				mainView.errorInput();
			}
		}
		
	}
	
	private void setDeveloper() {
		
		boolean loop = true;
		
		while(loop) {
		
			view.setDeveloper();
			System.out.print(mainView.input());
			
			String input = scan.nextLine();
			try {
				int num = Integer.parseInt(input.trim());
				
				if(num == 1) {
					getDeveloper();
					mainView.pause();
				} else if(num == 2) {
					getGithub();
					mainView.pause();
				} else if(num == 3) {
					loop = false;
					mainView.returnMainMenu();
				} else {
					throw new Exception("잘못된 입력입니다.");
				}
			} catch (Exception e) {
				mainView.errorInput();
				mainView.pause();  //오류 메세지 후 잠시 멈춤
			}
		}
		
	}

	private void getDeveloper() {
		
		MainService.printLine(dao.getDeveloper());
		
	}

	private void getGithub() {
		
		view.getGithub();
		
		String url = "https://github.com/Emily0814/ajaaja-portfolio";
		
		try {
			Desktop.getDesktop().browse(new URI(url));
		} catch (Exception e) {
			System.out.println("SettingService.getGithub");
			e.printStackTrace();
		}
		
	}

	public void setLang() {
		
		boolean loop = true;
		
		while(loop) {
			
			view.setLang();
			System.out.print(mainView.input());
			
			String input = scan.nextLine();
			try {
				int num = Integer.parseInt(input.trim());
				
				if(num >= 1 && num <= 3) {
					languageService.set(num);
				} else if(num == 4) {
					loop = false;
					mainView.returnMainMenu();
				} else {
					throw new Exception("잘못된 입력입니다.");
				}
			} catch (Exception e) {
				mainView.errorInput();
				mainView.pause();
			}
			
		}
		
	}
	
}
