package com.java.naming.service;

import java.util.Scanner;

import com.java.naming.dao.HistoryDAO;
import com.java.naming.view.HistoryView;
import com.java.naming.view.MainView;

//작명 이력 관리
public class HistoryService {

	private HistoryDAO dao;
	private MainView mainView;
	private HistoryView view;
	private Scanner scan;
	
	public HistoryService() {
		this.dao = new HistoryDAO();
		this.mainView = new MainView();
		this.view = new HistoryView();
		this.scan = new Scanner(System.in);
	}
	
	//이력보기 전체 작동
	public void history() {
		
		boolean stop = true;
		
		while(stop) {
			
			view.mainMenu();	//이력보기 메뉴
			String menu = scan.nextLine();
			
			if(menu.equals("1")) {
				MainService.printLine(dao.get());
			} else if(menu.equals("2")) {
				stop = false;
				mainView.returnMainMenu();
			} else {
				mainView.errorInput();
				mainView.pause();
			}
			
		}
		
	}

}
