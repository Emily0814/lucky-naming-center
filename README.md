# 운수 좋은 작명소 (Lucky Naming Center)
### 다국어를 지원하는 자바 기반 콘솔 애플리케이션으로, 사용자의 선호도에 맞는 이름을 추천해주는 프로그램입니다.
## 📝 기능 소개
- 이름 추천: 성별, 이름 타입, 성(姓), 글자수에 따른 맞춤형 이름 추천
- 이력 관리: 생성된 이름의 저장 및 조회 기능
- 다국어 지원: 한국어, 영어, 일본어 인터페이스 제공
- 직관적인 메뉴: 콘솔 기반의 사용하기 쉬운 인터페이스

## 💻 시스템 요구사항
- Java 8 이상
- 콘솔 환경 (터미널, 명령 프롬프트 등)
- 외부 라이브러리: JFiglet (ASCII 아트 타이틀용)

## 🔧 기술 스택
- 자바 (Java)
- MVC 아키텍처
- 파일 I/O
- 다국어 처리

## 🚀 설치 및 실행 방법
### 1.저장소 클론
```
git clone https://github.com/yourusername/lucky-naming-center.git
cd lucky-naming-center
```
### 2.컴파일
```
javac -cp ".:lib/*" -d bin src/com/java/naming/*.java src/com/java/naming/*/*.java
```
### 3. 실행
```
java -cp "bin:lib/*" com.java.naming.Main
```

## 📱 사용 방법
### [간단 설명서]
#### - 메인 메뉴
1. 작명하기 - 성별, 이름 타입, 성, 글자수를 선택하여 이름 추천 받기
2. 이력보기 - 이전에 만든 이름 기록 확인하기
3. 설명보기 - 프로그램 사용 방법 안내
4. 환경설정 - 언어 변경 및 개발자 정보 확인
5. 종료하기 - 프로그램 종료

#### - 작명 과정
1. 성별 선택: 여자 또는 남자
2. 이름 타입: 귀여운, 강한, 부드러운, 전통적인, 2025년 핫한
3. 성(姓) 입력: 김, 이, 박 등
4. 글자수 선택: 외자, 2글자, 3글자
5. 추천 이름 중 선택 또는 다시 생성

## 📸 스크린샷
![image](https://github.com/user-attachments/assets/527dcc86-e1e3-447d-aaa4-9ca5937e154c)
![image](https://github.com/user-attachments/assets/4d2882b6-186a-4b23-97c0-a0abf80adb65)
![image](https://github.com/user-attachments/assets/c905552a-57a0-4e44-970e-276fcd61b220)
![image](https://github.com/user-attachments/assets/9c1f5228-819e-4017-be89-b6512dc034ce)



