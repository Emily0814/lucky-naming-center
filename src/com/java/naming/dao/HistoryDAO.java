package com.java.naming.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.java.naming.model.HistoryDTO;
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
                    
                    lineArray.add(dto);
                }
			}
			
			// 이력 목록 생성 > lineArray에 저장된 DTO 객체들을 순회하면서 포맷팅된 문자열을 tempHistory에 추가
			for (HistoryDTO dto : lineArray) {
				tempHistory += String.format("%-10s %-20s %-6s %-10s %-4s %-6s %s\n", 
                        dto.getNo(), 
                        dto.getDate(), 
                        dto.getGender(), 
                        dto.getType(), 
                        dto.getSurname(), 
                        dto.getCharactercount(), 
                        dto.getRecommendedname());
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("history.txt 파일을 읽는 중 오류가 발생했습니다.");
			e.printStackTrace();
		}
		
		return tempHistory;
	}
	
	
	
}


















