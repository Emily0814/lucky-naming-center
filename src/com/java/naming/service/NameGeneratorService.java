package com.java.naming.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.java.naming.dao.NameDAO;
import com.java.naming.model.HistoryDTO;
import com.java.naming.model.NameDTO;
import com.java.naming.model.RequestDTO;
import com.java.naming.view.MainView;
import com.java.naming.view.NameGeneratorView;

//이름 생성 로직
public class NameGeneratorService {
	
	private final String HISTORY_PATH = "resources\\history.txt";
	
	private NameGeneratorView view = new NameGeneratorView();
	private  NameDTO dto = new NameDTO();
	private Scanner scan = new Scanner(System.in);
	private MainView mainView = new MainView();
	private NameDAO dao = new NameDAO();
	
	public void start() {
		
		RequestDTO request = new RequestDTO();
		//어떤 느낌의 이름을 원하시나요?
		int gender = 0;	//여자, 남자
		int type = 0;	//귀여운, 강한, 부드러운, 전통적인, chill한
		String surname = "";	//성 - 김, 이, 박 등
		int charcount = 0;	//글자수 - "외자", "2글자", "3글자"
		
		//성별
		boolean loop = true;
		while (loop) {
			try {
				view.selectGender();
				gender = Integer.parseInt(scan.nextLine());
				//dto.setType(gender);	//타입
				
				if(gender == 1 || gender == 2) {	//♀️여자", "♂️남자
					request.setGender(gender);
					loop = false;
				} else {
					throw new Exception("잘못된 입력");
				}
			} catch (Exception e) {
				mainView.errorInput();
			}
		}	
		
		//타입
		loop = true;
		while (loop) {
			try {
				view.selectType();
				type = Integer.parseInt(scan.nextLine());
				dto.setType(type);	//타입
				
				if(type >= 1 && type <= 5) {    // "귀여운","강한","부드러운","전통적인","2025년 핫한"
                    request.setType(type);
					loop = false;
				} else {
					throw new Exception("잘못된 입력");
				}
			} catch (Exception e) {
				mainView.errorInput();
			}
		}
		
		//성(Surname) 입력
		loop = true;
		while (loop) {
			try {
				view.selectSurname();
				surname = scan.nextLine();
				
				if(surname.matches("^[가-힣]+$")) {	//한글만 입력되는지 확인하는 정규식
					dto.setSurName(surname);
					request.setSurname(surname);
					loop = false;
				} else {
					throw new Exception("성씨는 한글만 입력 가능합니다.");
				}
			} catch (Exception e) {
				mainView.errorInput();
			}
		}	
		
		//글자수
		loop = true;
		while (loop) {
			try {
				view.selectCharacterCount(); 
				charcount = Integer.parseInt(scan.nextLine());
				//dto.setType(charcount);	//타입
				
				if(charcount >= 1 && charcount <= 3) {    // 1: "외자", 2: "2글자", 3: "3글자"
                    request.setCharacterCount(charcount);
					loop = false;
				} else {
					throw new Exception("잘못된 입력입니다.");
				}
			} catch (Exception e) {
				mainView.errorInput();
			}
		}		
		
		 // 이름 생성 및 추천 절차
        generateAndSelectName(request);
    }
	
	private void generateAndSelectName(RequestDTO request) {
        boolean isSatisfied = false;
        
        while (!isSatisfied) {
            // 이름 생성
            List<String> recommendedNames = dao.getNames(request);
            
            // 추천 이름이 없을 경우
            if (recommendedNames.isEmpty()) {
                view.noRecommendedNames();
                return;
            }
            
            // 결과 보여주기 (성 + 이름 합쳐서 표시)
            view.showRecommendedNames(recommendedNames, request);
            
            // 이름 선택하기
            int selection = selectName(recommendedNames);
            
            if (selection == -1) {
                // 다시 생성하기 선택
                continue;
            } else if (selection == -2) {
                // 메인으로 돌아가기 선택
                return;
            } else {
                // 이름 선택 완료
                String selectedName = recommendedNames.get(selection);
                String fullName = request.getSurname() + selectedName;
                
                // 이력 저장하기
                saveHistory(request, selectedName, fullName);
                isSatisfied = true;
            }
        }
    }
	
	private int selectName(List<String> recommendedNames) {
        boolean loop = true;
        int selection = 0;
        
        while (loop) {
            try {
                view.selectName(recommendedNames.size());
                String input = scan.nextLine();
                selection = Integer.parseInt(input);
                
                if (selection >= 1 && selection <= recommendedNames.size()) {
                    return selection - 1; // 인덱스로 변환
                } else if (selection == recommendedNames.size() + 1) {
                    // 다시 이름 생성하기 옵션 선택시
                    return -1;
                } else if (selection == recommendedNames.size() + 2) {
                    // 메인으로 돌아가기 옵션 선택시
                    return -2;
                } else {
                    throw new Exception("잘못된 입력입니다.");
                }
            } catch (Exception e) {
                mainView.errorInput();
            }
        }
        
        return -2; // 기본적으로 메인으로 돌아가기
    }
    
    private void saveHistory(RequestDTO request, String selectedName, String fullName) {
        try {
            // 현재 날짜 가져오기
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime = sdf.format(new Date());
            
            // 다음 번호 가져오기
            int nextNo = dao.getNextHistoryNo();
            
            // HistoryDTO 객체 생성
            HistoryDTO history = new HistoryDTO();
            history.setNo(String.valueOf(nextNo));
            history.setDate(currentTime);
            history.setGender(request.getGender() == 1 ? "여자" : "남자");
            
            String[] types = {"귀여운", "강한", "부드러운", "전통적인", "2025년 핫한"};
            history.setType(types[request.getType() - 1]);
            
            history.setSurname(request.getSurname());
            
            String[] charCounts = {"외자", "2글자", "3글자"};
            history.setCharactercount(charCounts[request.getCharacterCount() - 1]);
            
            history.setRecommendedname(selectedName);
            
            // 파일에 이력 저장
            BufferedWriter writer = new BufferedWriter(new FileWriter(HISTORY_PATH, true));
            writer.write(history.getNo() + "|" + 
                        history.getDate() + "|" + 
                        history.getGender() + "|" + 
                        history.getType() + "|" + 
                        history.getSurname() + "|" + 
                        history.getCharactercount() + "|" + 
                        selectedName);
            writer.newLine();
            writer.close();
            
            // 이력 저장 완료 메시지 표시
            view.showSaveCompleted(history, fullName);
            
        } catch (Exception e) {
        	System.out.println("이력 저장 중 구체적인 오류: " + e);
            e.printStackTrace(); // 스택 트레이스 출력
            mainView.errorMessage("이력 저장 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
	
	
}
