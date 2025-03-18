package com.java.naming.dao;

import java.io.BufferedReader;
import java.io.FileReader;

import com.java.naming.view.MainView;

public class SettingDAO {

	private static MainView mainView;
	
	public SettingDAO() {
		this.mainView = new MainView();
	}

	public String getDeveloper() {
		
		String result = "";
		String path = "resources/developer.txt";
		
		result += mainView.getSeperator();
		result += mainView.setRowMargin("개발자 정보");
		result += mainView.getSeperator();
		
		try {
			//파일 전체 내용을 하나의 문자열로 읽기
			StringBuilder contentBuilder = new StringBuilder();
			try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
				String line = "";
				while((line = reader.readLine()) != null) {
					contentBuilder.append(line).append("\r\n");
				}
			}
			
			String content = contentBuilder.toString();
			
			//[로 시작하는 부분으로 분리
			String[] sections = content.split("(?=\\[)");
			
			for (String section : sections) {
				if ( section.trim().isEmpty()) continue;
				
				//섹션이 비어있지 않는 경우에만 처리
				result += section + "\r\n";
				result += mainView.getSeperator();
			}
			
			//result += "\r\n";
		} catch (Exception e) {
			System.out.println("SettingDAO.getDeveloper - 파일 읽기 실패: " + path);
			e.printStackTrace();
		}
		return result;
	}
}
