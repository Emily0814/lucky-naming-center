package com.java.naming.service;

import com.java.naming.dao.ExplainDAO;
import com.java.naming.view.MainView;

public class ExplainService {

	private ExplainDAO dao;
	private MainView mainView;
	
	public ExplainService() {
		dao = new ExplainDAO();
		mainView = new MainView();
	}
	
	public void get() {
		MainService.printLine(dao.getExplain());
		mainView.pause();
	}

}
