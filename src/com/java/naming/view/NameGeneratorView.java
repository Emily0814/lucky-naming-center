package com.java.naming.view;

import java.util.List;

import com.java.naming.model.HistoryDTO;
import com.java.naming.model.RequestDTO;
import com.java.naming.service.LanguageService;

//이름 생성 인터페이스
public class NameGeneratorView {
	
	MainView mainView;
	
	public NameGeneratorView() {
		mainView = new MainView();
		
	}
	
	public void selectGender() {
	    String temp = "";
	    
	    temp += "\r\n";
	    temp += mainView.getSeperator();
	    temp += mainView.getSubTitle(LanguageService.get("⚧️ 성별을 선택해주세요."));
	    temp += mainView.getSeperator();
	    temp += mainView.setNumRowMargin(
	        LanguageService.get("♀️ 여자"), 
	        LanguageService.get("♂️ 남자"));
	    temp += mainView.getSeperatorThin();
	    temp += mainView.input();
	    
	    System.out.print(temp);
	}

	public void selectType() {
	    String temp = "";
	    
	    temp += "\r\n";
	    temp += mainView.getSeperator();
	    temp += mainView.getSubTitle(LanguageService.get("어떤 느낌의 이름을 원하시나요?"));
	    temp += mainView.getSeperator();
	    temp += mainView.setNumRowMargin(
	        LanguageService.get("귀여운"),
	        LanguageService.get("강한"),
	        LanguageService.get("부드러운"),
	        LanguageService.get("전통적인"),
	        LanguageService.get("2025년 핫한"));
	    temp += mainView.getSeperatorThin();
	    temp += mainView.input();
	    
	    System.out.print(temp);
	}

	public void selectSurname() {
	    String temp = "";
	    
	    temp += "\r\n";
	    temp += mainView.getSeperator();
	    temp += mainView.getSubTitle(LanguageService.get("성을 입력해주세요."));
	    temp += mainView.getSeperator();
	    // 예시는 번역할 필요가 없을 수 있으므로 그대로 유지
	    temp += mainView.setRowMargin("예시) 김, 이, 박, 최, 정, 강, 조, 윤..");
	    temp += mainView.getSeperatorThin();
	    temp += mainView.input();
	    
	    System.out.print(temp);
	}

	public void selectCharacterCount() {
	    String temp = "";
	    
	    temp += "\r\n";
	    temp += mainView.getSeperator();
	    temp += mainView.getSubTitle(LanguageService.get("원하는 이름의 글자수를 선택해주세요."));
	    temp += mainView.getSeperator();
	    temp += mainView.setNumRowMargin(
	        LanguageService.get("외자"), 
	        LanguageService.get("2글자"), 
	        LanguageService.get("3글자"));
	    temp += mainView.getSeperatorThin();
	    temp += mainView.input();
	    
	    System.out.print(temp);        
	}

	public void showRecommendedNames(List<String> names, RequestDTO request) {
	    String temp = "";
	    
	    temp += "\r\n";
	    temp += mainView.getSeperator();
	    temp += mainView.getSubTitle(LanguageService.get("추천 이름 목록"));
	    temp += mainView.getSeperator();
	    
	    // 사용자 선택 정보 표시 (번역 적용)
	    String gender = request.getGender() == 1 ? 
	        LanguageService.get("여자") : LanguageService.get("남자");
	    
	    String[] typeLabels = {
	        LanguageService.get("귀여운"), 
	        LanguageService.get("강한"), 
	        LanguageService.get("부드러운"), 
	        LanguageService.get("전통적인"), 
	        LanguageService.get("2025년 핫한")
	    };
	    String type = typeLabels[request.getType() - 1];
	    
	    String[] charCountLabels = {
	        LanguageService.get("외자"), 
	        LanguageService.get("2글자"), 
	        LanguageService.get("3글자")
	    };
	    String charCount = charCountLabels[request.getCharacterCount() - 1];
	    
	    temp += mainView.setRowMargin(LanguageService.get("성별:") + " " + gender);
	    temp += mainView.setRowMargin(LanguageService.get("유형:") + " " + type);
	    temp += mainView.setRowMargin(LanguageService.get("성:") + " " + request.getSurname());
	    temp += mainView.setRowMargin(LanguageService.get("글자수:") + " " + charCount);
	    temp += mainView.getSeperatorThin();
	    
	    if (names.isEmpty()) {
	        temp += mainView.setRowMargin(LanguageService.get("조건에 맞는 이름을 찾을 수 없습니다."));
	    } else {
	        for (int i = 0; i < names.size(); i++) {
	            // 성 + 이름을 합쳐서 표시
	            temp += mainView.setRowMargin((i + 1) + ". " + request.getSurname() + names.get(i));
	        }
	    }
	    
	    temp += mainView.getSeperator();
	    
	    System.out.print(temp);
	}

	public void selectName(int nameCount) {
	    String temp = "";
	    
	    temp += "\r\n";
	    temp += mainView.getSeperator();
	    temp += mainView.getSubTitle(LanguageService.get("마음에 드는 이름을 선택해주세요."));
	    temp += mainView.getSeperator();
	    temp += mainView.setRowMargin(LanguageService.get("이름 번호를 입력하세요."));
	    temp += mainView.setNumRowMargin(
	        (nameCount + 1) + ". " + LanguageService.get("이름 다시 생성하기"),
	        (nameCount + 2) + ". " + LanguageService.get("메인으로 돌아가기"));
	    temp += mainView.getSeperatorThin();
	    temp += mainView.input();
	    
	    System.out.print(temp);
	}

	public void noRecommendedNames() {
	    String temp = "";
	    
	    temp += "\r\n";
	    temp += mainView.getSeperator();
	    temp += mainView.getSubTitle(LanguageService.get("알림"));
	    temp += mainView.getSeperator();
	    temp += mainView.setRowMargin(LanguageService.get("조건에 맞는 이름을 찾을 수 없습니다."));
	    temp += mainView.setRowMargin(LanguageService.get("다른 조건으로 다시 시도해주세요."));
	    temp += mainView.getSeperator();
	    
	    System.out.print(temp);
	}

	public void showSaveCompleted(HistoryDTO history, String fullName) {
	    String temp = "";
	    
	    temp += "\r\n";
	    temp += mainView.getSeperator();
	    temp += mainView.getSubTitle(LanguageService.get("이름 생성 완료"));
	    temp += mainView.getSeperator();
	    temp += mainView.setRowMargin(LanguageService.get("선택하신 이름:") + " " + fullName);
	    temp += mainView.setRowMargin(LanguageService.get("성별:") + " " + LanguageService.get(history.getGender()));
	    temp += mainView.setRowMargin(LanguageService.get("유형:") + " " + LanguageService.get(history.getType()));
	    temp += mainView.setRowMargin(LanguageService.get("글자수:") + " " + LanguageService.get(history.getCharactercount()));
	    temp += mainView.setRowMargin(LanguageService.get("이력이 저장되었습니다."));
	    temp += mainView.getSeperator();
	    
	    System.out.print(temp);
	}
	
}
