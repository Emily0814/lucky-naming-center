package com.java.naming.view;

import java.util.List;

import com.java.naming.model.HistoryDTO;
import com.java.naming.model.RequestDTO;

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
		temp += mainView.getSubTitle("⚧️성별을 선택해주세요.");
		temp += mainView.getSeperator();
		temp += mainView.setNumRowMargin("♀️여자", "♂️남자");
		temp += mainView.getSeperatorThin();
		temp += mainView.input();
		
		System.out.print(temp);
	}
	
	public void selectType() {
		String temp = "";
		
		temp += "\r\n";
		temp += mainView.getSeperator();
		temp += mainView.getSubTitle("어떤 느낌의 이름을 원하시나요?");
		temp += mainView.getSeperator();
		temp += mainView.setNumRowMargin("귀여운","강한","부드러운","전통적인","2025년 핫한");
		temp += mainView.getSeperatorThin();
		temp += mainView.input();
		
		System.out.print(temp);
	}
	
	public void selectSurname() {
		String temp = "";
		
		temp += "\r\n";
		temp += mainView.getSeperator();
		temp += mainView.getSubTitle("성을 입력해주세요.");
		temp += mainView.getSeperator();
		temp += mainView.setRowMargin("예시) 김, 이, 박, 최, 정, 강, 조, 윤..");
		temp += mainView.getSeperatorThin();
		temp += mainView.input();
		
		System.out.print(temp);
	}
	
	public void selectCharacterCount() {
		String temp = "";
		
		temp += "\r\n";
		temp += mainView.getSeperator();
		temp += mainView.getSubTitle("원하는 이름의 글자수를 선택해주세요.");
		temp += mainView.getSeperator();
		temp += mainView.setNumRowMargin("외자", "2글자", "3글자");
		temp += mainView.getSeperatorThin();
		temp += mainView.input();
		
		System.out.print(temp);		
	}

	public void showRecommendedNames(List<String> names, RequestDTO request) {
        String temp = "";
        
        temp += "\r\n";
        temp += mainView.getSeperator();
        temp += mainView.getSubTitle("추천 이름 목록");
        temp += mainView.getSeperator();
        
        // 사용자 선택 정보 표시
        String gender = request.getGender() == 1 ? "여자" : "남자";
        String[] typeLabels = {"귀여운", "강한", "부드러운", "전통적인", "2025년 핫한"};
        String type = typeLabels[request.getType() - 1];
        String[] charCountLabels = {"외자", "2글자", "3글자"};
        String charCount = charCountLabels[request.getCharacterCount() - 1];
        
        temp += mainView.setRowMargin("성별: " + gender);
        temp += mainView.setRowMargin("유형: " + type);
        temp += mainView.setRowMargin("성: " + request.getSurname());
        temp += mainView.setRowMargin("글자수: " + charCount);
        temp += mainView.getSeperatorThin();
        
        if (names.isEmpty()) {
            temp += mainView.setRowMargin("조건에 맞는 이름이 없습니다.");
        } else {
            for (int i = 0; i < names.size(); i++) {
                // 성 + 이름을 합쳐서 표시
                temp += mainView.setNumRowMargin((i + 1) + ". " + request.getSurname() + names.get(i));
            }
        }
        
        temp += mainView.getSeperator();
        
        System.out.print(temp);
    }
    
    public void selectName(int nameCount) {
        String temp = "";
        
        temp += "\r\n";
        temp += mainView.getSeperator();
        temp += mainView.getSubTitle("마음에 드는 이름을 선택해주세요.");
        temp += mainView.getSeperator();
        temp += mainView.setRowMargin("이름 번호를 입력하세요.(1-" + nameCount + ")");
        temp += mainView.setNumRowMargin((nameCount + 1) + ". 이름 다시 생성하기", (nameCount + 2) + ". 메인으로 돌아가기");
        temp += mainView.getSeperatorThin();
        temp += mainView.input();
        
        System.out.print(temp);
    }
    
    public void noRecommendedNames() {
        String temp = "";
        
        temp += "\r\n";
        temp += mainView.getSeperator();
        temp += mainView.getSubTitle("알림");
        temp += mainView.getSeperator();
        temp += mainView.setRowMargin("조건에 맞는 이름을 찾을 수 없습니다.");
        temp += mainView.setRowMargin("다른 조건으로 다시 시도해주세요.");
        temp += mainView.getSeperator();
        
        System.out.print(temp);
    }
    
    public void showSaveCompleted(HistoryDTO history, String fullName) {
        String temp = "";
        
        temp += "\r\n";
        temp += mainView.getSeperator();
        temp += mainView.getSubTitle("이름 생성 완료");
        temp += mainView.getSeperator();
        temp += mainView.setRowMargin("선택하신 이름: " + fullName);
        temp += mainView.setRowMargin("성별: " + history.getGender());
        temp += mainView.setRowMargin("스타일: " + history.getType());
        temp += mainView.setRowMargin("글자수: " + history.getCharactercount());
        temp += mainView.setRowMargin("이력이 저장되었습니다.");
        temp += mainView.getSeperator();
        
        System.out.print(temp);
    }
	
}
