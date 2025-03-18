package com.java.naming.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.java.naming.model.RequestDTO;

public class NameDAO {
    
    private final String RESOURCE_PATH = "resources\\";
    private final String MALE_PREFIX = "male_";
    private final String FEMALE_PREFIX = "female_";
    private final String HISTORY_PATH = "resources\\history.txt";
    
    private Random random = new Random();
    
    public List<String> getNames(RequestDTO request) {
        List<String> recommendedNames = new ArrayList<>();
        
        try {
            // 성별에 따른 접두사 선택
            String genderPrefix = (request.getGender() == 1) ? FEMALE_PREFIX : MALE_PREFIX;
            
            // 타입에 따른 파일 선택
            String typeFileName = "";
            switch (request.getType()) {
                case 1: typeFileName = "cute"; break;
                case 2: typeFileName = "strong"; break;
                case 3: typeFileName = "soft"; break;
                case 4: typeFileName = "traditional"; break;
                case 5: typeFileName = "trendy"; break;
            }
            
            // 파일 경로 생성: 예) resource\female_cute_1.txt (여성, 귀여운, 외자)
            String filePath = RESOURCE_PATH + genderPrefix + typeFileName + "_" + request.getCharacterCount() + ".txt";
            
            // 파일에서 이름 목록 읽기
            File file = new File(filePath);
            if (file.exists()) {
                recommendedNames = loadNamesFromFile(filePath);
            }
            
            // 추천 이름이 없는 경우, 성별만 맞는 이름 중에서 선택
            if (recommendedNames.isEmpty()) {
                String genderFilePath = RESOURCE_PATH + genderPrefix + "all_" + request.getCharacterCount() + ".txt";
                File genderFile = new File(genderFilePath);
                if (genderFile.exists()) {
                    recommendedNames = loadNamesFromFile(genderFilePath);
                }
            }
            
            // 최대 5개까지만 랜덤하게 선택
            List<String> result = new ArrayList<>();
            if (!recommendedNames.isEmpty()) {
                int count = Math.min(5, recommendedNames.size());
                List<String> tempList = new ArrayList<>(recommendedNames);
                
                for (int i = 0; i < count; i++) {
                    if (tempList.isEmpty()) break;
                    int index = random.nextInt(tempList.size());
                    result.add(tempList.get(index));
                    tempList.remove(index);
                }
            }
            
            return result;
            
        } catch (Exception e) {
            System.out.println("이름 데이터 로드 중 오류 발생: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    private List<String> loadNamesFromFile(String filePath) {
        List<String> names = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    names.add(line.trim());
                }
            }
        } catch (Exception e) {
            System.out.println("파일 읽기 오류: " + e.getMessage());
        }
        
        return names;
    }
    
    public int getNextHistoryNo() {
        int maxNo = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(HISTORY_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] parts = line.split("\\|");
                    if (parts.length > 0) {
                        try {
                            int no = Integer.parseInt(parts[0]);
                            if (no > maxNo) {
                                maxNo = no;
                            }
                        } catch (NumberFormatException e) {
                            // 번호가 아닌 경우 무시
                        }
                    }
                }
            }
        } catch (Exception e) {
            // 파일이 없거나 읽기 오류 시 0 반환
        }
        
        return maxNo + 1;
    }
}