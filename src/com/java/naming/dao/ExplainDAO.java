package com.java.naming.dao;

import java.io.BufferedReader;
import java.io.FileReader;

import com.java.naming.Main;
import com.java.naming.service.LanguageService;
import com.java.naming.view.MainView;

public class ExplainDAO {
	
	private static MainView mainView;

	public ExplainDAO() {
		this.mainView = new MainView();
	}
	
	public String getExplain() {
		
		int langIndex = Main.langIndex;
		String result = "";
		String path = "";
		
		result += mainView.getSeperator();
		result += mainView.setRowMargin(LanguageService.get("설명"));	//설명을 가운데 정렬해 출력해주는 메서드
		result += mainView.getSeperatorThin();
		
		if(langIndex == 1) {
			path = "resources/explain_en.txt";
		} else if(langIndex == 2) {
			path = "resources/explain_jp.txt";
		} else {
			path = "resources/explain_kr.txt";
		}
		
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			String line = "";
			
			while ((line = reader.readLine()) != null) {
				
				try {
					String[] temp = line.split("\\.");
					Integer.parseInt(temp[0]);
					result += line + "\r\n";
				} catch (Exception e) {
					result += line + "\r\n";
				}
			}
		} catch (Exception e) {
			System.out.println("ExplainDAO.getExplain - 파일 읽기 실패: " + path);
			e.printStackTrace();
		}
		return result;
	}

}
