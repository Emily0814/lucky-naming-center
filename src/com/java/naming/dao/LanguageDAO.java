package com.java.naming.dao;

import java.io.BufferedReader;
import java.io.FileReader;

//다국어 처리
public class LanguageDAO {

	private static final String path = "resources\\lang.txt";
	
	public static String get(String sentence, int langIndex) {
		String result = "";
		if(langIndex == 0) {
			return sentence;
		} else {
			try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
				
				String line = "";
				
				while((line = reader.readLine()) != null) {
					String[] sentences = line.split(",");
					
					if(sentences[0].equals(sentence)) {
						//배열 범위 확인 추가
                        if(langIndex < sentences.length) {
                            result = sentences[langIndex];
                        } else {
                            System.out.println("해당 언어 번역이 없습니다: " + sentence);
                            return sentence; //번역이 없으면 원본 반환
                        }
                        break;
					}
				}
				
				//번역을 찾지 못한 경우
                if(result.isEmpty()) {
                    System.out.println("번역을 찾을 수 없습니다: " + sentence);
                    return sentence; //원본 반환
                }
			} catch (Exception e) {
				System.out.println("LanguageDAO.get - 오류 발생: " + e.getMessage());
                e.printStackTrace();
                return sentence; //오류 발생 시 원본 반환
			}
		}
		return result;
	}
	
}
