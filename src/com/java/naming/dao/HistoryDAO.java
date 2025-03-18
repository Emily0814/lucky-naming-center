package com.java.naming.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.java.naming.model.HistoryDTO;
import com.java.naming.service.LanguageService;
import com.java.naming.view.HistoryView;
import com.java.naming.view.MainView;

//작명 이력 저장/로드
public class HistoryDAO {

	private HistoryView view;
	private Scanner scan;
	private MainView mainView;
	
	private BufferedReader reader;
	
	public HistoryDAO() {
		this.view = new HistoryView();
		this.scan = new Scanner(System.in);
		this.mainView = new MainView();
	}
	
	private final String PATH = ".\\resources\\";

	//정보 불러오는 메서드
	
	public String get() {	//이력보기
		
		ArrayList<HistoryDTO> lineArray = new ArrayList<HistoryDTO>();
		String line = null;
		String[] temp = null;
		String tempHistory = "";
		
		view.titleSpecific();
		
		try {
			this.reader = new BufferedReader(new FileReader(PATH + "history.txt"));
			
			//번호, 날짜, 성별, 타입, 성, 글자수, 추천이름
			while((line = reader.readLine()) != null) {
				
				temp = line.split("\\|");	//파이프 문자를 이스케이프 처리
				
				// 배열 길이 확인 추가 (안전성 확보)
                if (temp.length >= 7) {
                    HistoryDTO dto = new HistoryDTO();
                    dto.setNo(temp[0]);              //번호
                    dto.setDate(temp[1]);            //날짜
                    dto.setGender(temp[2]);          //성별
                    dto.setType(temp[3]);            //타입
                    dto.setSurname(temp[4]);         //성
                    dto.setCharactercount(temp[5]);  //글자수
                    dto.setRecommendedname(temp[6]); //추천이름
                    //temp[7]은 전체 이름(성+이름)
                    
                    lineArray.add(dto);
                }
			}
			
			// 이력 목록 생성 > lineArray에 저장된 DTO 객체들을 순회하면서 포맷팅된 문자열을 tempHistory에 추가
			for (HistoryDTO dto : lineArray) {
				//성별, 타입, 글자수 항목 번역
			    String translatedGender = LanguageService.get(dto.getGender());
			    String translatedType = LanguageService.get(dto.getType());
			    String translatedCharCount = LanguageService.get(dto.getCharactercount());
				
				//각 필드에 고정 너비 적용 (번역된 문자열 사용)
			    String typeStr = padKoreanString(translatedType, 15);         // 타입 (더 넓은 공간)
			    String surnameStr = padKoreanString(dto.getSurname(), 5);     // 성
			    String charCountStr = padKoreanString(translatedCharCount, 10); // 글자수
			    String nameStr = padKoreanString(dto.getRecommendedname(), 10);     // 추천이름
				
				tempHistory += String.format("%-8s %-23s %-6s %-17s %-13s %-8s %-12s %s\n", 
                        dto.getNo(), 
                        dto.getDate(), 
                        translatedGender,   // 번역된 성별
                        typeStr,            // 패딩 적용된 번역 타입
                        surnameStr,         // 패딩 적용된 성
                        charCountStr,       // 패딩 적용된 번역 글자수
                        nameStr,            // 패딩 적용된 추천이름
                        dto.getSurname() + dto.getRecommendedname());  //성과 이름을 합쳐서 표시
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("history.txt 파일을 읽는 중 오류가 발생했습니다.");
			e.printStackTrace();
		}
		
		return tempHistory;
	}
	
	/**
	 * 한글 문자열에 패딩을 적용하는 메소드
	 * 한글은 영문보다 넓은 공간을 차지하므로 이를 고려하여 패딩
	 */
	private String padKoreanString(String str, int totalWidth) {
	    int currentWidth = 0;
	    for (char c : str.toCharArray()) {
	        // 한글 또는 한자인 경우 2칸 너비로 계산
	        if (c >= '가' && c <= '힣' || (c >= 0x4E00 && c <= 0x9FFF)) {
	            currentWidth += 2;
	        } else {
	            currentWidth += 1;
	        }
	    }
	    
	    // 남은 공간을 공백으로 채움
	    int padSize = totalWidth - currentWidth;
	    if (padSize > 0) {
	        return str + " ".repeat(padSize);
	    }
	    return str;
	}
	
	
}


















