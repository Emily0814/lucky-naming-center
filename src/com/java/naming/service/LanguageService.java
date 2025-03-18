package com.java.naming.service;

import com.java.naming.Main;
import com.java.naming.dao.LanguageDAO;

//다국어 처리
public class LanguageService {

	public final int langKr = 0;
	public final int langEn = 0;
	public final int langJp = 0;
	
	public static String get(String line) {
		return LanguageDAO.get(line, Main.langIndex);
	}
	
	public void set(int num) {
		if(num == 1) {	//한국어
			Main.langIndex = langKr;
		} else if(num == 2) {
			Main.langIndex = langEn;
		} else if(num == 3) {
			Main.langIndex = langJp ;
		}
		
	}

}
