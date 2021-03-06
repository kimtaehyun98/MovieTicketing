# 🔥Spring 토이 프로젝트 - 영화 예매 시스템

- 내가 예제 코드 없이 직접 만드는 첫 스프링 프로젝트!
- 요구사항부터 도메인 설계 등 내 생각대로 만드는 프로젝트!

## 요구사항

### 1. 회원 기능
- 회원 등록
- 로그인
- 예매 내역 조회
- 예매 취소
### 2. 예매 기능
- 영화관 선택
- 현재 상영중인 영화
- 현재 남은 좌석
- 티켓 예매
### 3. 기타 요구사항
- 세 종류의 좌석이 존재한다. (Prime, Standard, Economy)
- 각 영화관 별로 상영하는 영화, 시간대가 다르다.
- 결제에 대한 부분은 신경쓰지 않는다.

## 도메인 모델
![image](https://user-images.githubusercontent.com/65909160/126879401-9efb5654-b692-403e-abb5-4c9cf727abe5.png)

## 서비스 아키텍쳐
![image](https://user-images.githubusercontent.com/65909160/127740770-3b225eb5-9d03-414c-8b78-73aa9e05a268.png)

## 최종 구현된 모델

- 로그인 및 회원가입
- 자신의 결제 내역 선택 버튼 -> 결제한 내역 확인 가능 및 취소 가능
- 예매 선택 버튼 -> 영화관, 상영중인 영화, 상영시간, 구입 가능한 좌석 -> 예매

## 실행 화면

### 로그인 기능

https://user-images.githubusercontent.com/65909160/126902874-81adb5d1-0399-49de-be34-2dabe07fe6fa.mp4

### 영화 생성 기능

https://user-images.githubusercontent.com/65909160/126902885-504636af-0439-4cc3-a438-663ccef190e8.mp4

### 영화 예매 기능

https://user-images.githubusercontent.com/65909160/126902895-1948cd12-74de-4eb6-8ee3-22681dbd898f.mp4

### 예매 내역 기능

https://user-images.githubusercontent.com/65909160/126902903-7a34a99c-c375-4a8d-acec-06a1aff4d9cd.mp4


## 후기

### 배운 점
- 단순히 강의로 듣기만 했던 내용들을 직접 필요에 의해 사용해 보니 어떤 부분에서 사용되는지 더 잘 이해할 수 있었다.
- 앞으로 어떤 부분들에 대해 공부해야 할 지 감이 잡히기 시작했다
- Front에 대한 이해도가 조금은 높아진 것 같다.

### 남기고 싶은 내용
- login 기능에 대해 자세히 생각해보지 않고 시도한게 굉장히 큰 실수였다. 결국 의미 없는 로그인 기능을 구현하게 되었다.
- 이 프로젝트를 통해 왜 쿠키, Session 등이 필요한지를 절실히 깨닫게 되었다. 더 성장하는 계기가 된 것 같다.
- 너무 거창하게 프로젝트를 기획했었다.. 앞으로 수준에 맞게 계획을 세워야 겠다.
- 프로그램 전체의 동작과정에 대한 궁금증이 많이 생겼다. 따라서 "MVC 패턴"을 제대로 공부할 예정이다!

