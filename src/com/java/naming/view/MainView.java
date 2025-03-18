package com.java.naming.view;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.github.lalyos.jfiglet.FigletFont;
import com.java.naming.service.MainService;
//메인 메뉴 및 공통 UI 요소
public class MainView {

	private Scanner scan;
	private String path;
	
	public MainView() {
		scan = new Scanner(System.in);
		path = "flf/ANSI Shadow.flf";
	}
	public void getMainMenu() {
		String result = "";
		result += getSeperator();
		result += "\r\n";
		result += getTitle();
		result += getSeperator();
		result += getSubTitle("📜 환영합니다! 운수 좋은 작명소입니다.");
		result += getSeperatorThin();
		result += getSubTitle("메뉴 선택");
		result += getSeperatorThin();
		result += setNumRowMargin("작명하기", "이력보기", "설명보기", "환경설정", "종료하기");
		result += getSeperatorThin();
		result += input();
		MainService.printLine(result, 300);
	}
	
	public String getSubTitle(String title) {
		String result = "";
		result = setRowMargin(title);
		return result;
	}
	
	public String setRowMargin(String... rows) {

		StringBuilder sb = new StringBuilder();
		
	    for (int i=0; i<rows.length; i++) {
	        sb.append(arrangeRow(rows[i], rows.length));
	    }
	    sb.append("\r\n");
	    
	    return sb.toString();
	}
	
	public String setNumRowMargin(String... rows) {

		StringBuilder sb = new StringBuilder();

	    for (int i=0; i<rows.length; i++) {
	        sb.append(arrangeRow(String.format("%d. %s", (i + 1), rows[i]), rows.length));
	    }
	    
	    sb.append("\r\n");
	    
	    return sb.toString();
	}
	
	public String arrangeRow(String text, int len) {
		double lineLength = 122.0;
		double width = lineLength / len; 
	    int padding = (int)(lineLength / len - calcKRJPStringCount(text) - text.length())/ 2 ;
	    if(padding < 0) {
	    	padding = 0;
	    }
	    // 패딩을 추가하여 텍스트를 가운데로 정렬
	    StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat(padding));
	    sb.append(text);
	    sb.append(" ".repeat(padding));
	    return sb.toString();
	}
	
	public int calcKRJPStringCount(String str) {
		double result = 0;
		//기본 폰트에 맞춰 크기 설정 하기
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c >= '가' && c <= '힣') {
				//한국어
				result += 1.00;
			} else if(c >= 'あ' && c <= 'ん'
					|| c >= 'ア' && c <= 'ン') {
				//일본어
				result += 0.5;
			} else if(c >= 0x4E00 && c <= 0x9FFF 
					|| c >= 0x3400 && c <= 0x4DBF
					|| c >= 0x20000 && c <= 0x2A6DF
					|| c >= 0x2A700 && c <= 0x2B73F
					|| c >= 0x2B740 && c <= 0x2B81F
					|| c >= 0x2B820 && c <= 0x2CEAF 
					|| c >= 0x2CEB0 && c <= 0x2EBEF
					|| c >= 0xF900 && c <= 0xFAFF) {
				//한자
				result += 0.8;
			}
		}
		return (int) result;
	}
	
	public String getTitle() {
		String result = "";
    	try {
			result = FigletFont.convertOneLine(new File(path), "  Naming Center");
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return result;
	}
	
	public void end() {

	    String result = "";
	    result += getSeperator();
	    result += getSubTitle("시스템을 종료합니다.");
	    result += getSubTitle("안녕히 가십시오.");
	    result += getSeperator();
	    result += addRowMarginMultiLine("\r\n"
	    		+ " ██████╗  ██████╗  ██████╗ ██████╗ ██████╗ ██╗   ██╗███████╗   ██╗ \r\n"
	    		+ "██╔════╝ ██╔═══██╗██╔═══██╗██╔══██╗██╔══██╗╚██╗ ██╔╝██╔════╝██╗╚██╗\r\n"
	    		+ "██║  ███╗██║   ██║██║   ██║██║  ██║██████╔╝ ╚████╔╝ █████╗  ╚═╝ ██║\r\n"
	    		+ "██║   ██║██║   ██║██║   ██║██║  ██║██╔══██╗  ╚██╔╝  ██╔══╝  ▄█╗ ██║\r\n"
	    		+ "╚██████╔╝╚██████╔╝╚██████╔╝██████╔╝██████╔╝   ██║   ███████╗▀═╝██╔╝\r\n"
	    		+ " ╚═════╝  ╚═════╝  ╚═════╝ ╚═════╝ ╚═════╝    ╚═╝   ╚══════╝   ╚═╝ \r\n"
	    		+ "                                                                   \r\n");

	    MainService.printLine(result, 220, 5);
	}
	
	public String addRowMarginMultiLine(String multiLine) {
		String result = "";
		String[] lines = multiLine.split("(\r)?\n");
		
		for(String line : lines) {
			result += setRowMarginNotTrans(line);
		}
		
		return result;
	}
	
	public String setRowMarginNotTrans(String... rows) {
		StringBuilder sb = new StringBuilder();
		
	    for (int i=0; i<rows.length; i++) {
	        sb.append(arrangeRow(rows[i], rows.length));
	    }
	    
	    sb.append("\r\n");
	    
	    return sb.toString();
	}
	
	public void pause() {
		String result = "";
		result += "\r\n";
		result += getSeperator();
		result += getSubTitle("계속하시려면 엔터를 입력해주세요.");
		result += getSeperator();
		System.out.println(result);
		scan.nextLine();	//Block
		System.out.println();
	}
	
	public void errorInput() {
		String result = "";
		result += getSeperator();
		result += getSubTitle("❌ 잘못된 입력입니다.");
		result += getSubTitle("다시 입력해주세요.");
		result += getSeperator();
		System.out.println(result);
	}
	
	public String errorMessage(String title) {
		String result = "";
		result = setRowMargin(title);
		return result;
	}
	
	public String input() {
		return "입력 > ";
	}
	
	public String returnMenu() {
		return "이전 메뉴로 돌아갑니다.";
	}
	
	public String returnMainMenu() {
		return "메인 메뉴로 돌아갑니다.";
	}
	
	public String getSeperator() {
		return "==================================================================="
				+ "=======================================================\r\n";
	}
	
	public String getSeperatorThin() { //메뉴 외 구분선
		return "-------------------------------------------------------------------"
				+ "-------------------------------------------------------\r\n";
	}
	
}
