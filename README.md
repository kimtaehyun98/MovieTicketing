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
- 각 좌석별로 예매 가격이 다르다. (Prime, Standard, Economy)
- 각 영화관 별로 상영하는 영화, 시간대가 다르다.
- 이미 상영 기간이 지난 영화라면 구매, 예매 취소가 불가능하다.
- 결제에 대한 부분은 신경쓰지 않는다.

## 도메인 모델
![image](https://user-images.githubusercontent.com/65909160/126879401-9efb5654-b692-403e-abb5-4c9cf727abe5.png)


## 예상하는 최종 구현된 모델

- 로그인 및 회원가입
- 자신의 결제 내역 선택 버튼 -> 결제한 내역 확인 가능 및 취소 가능(이때 취소는 아직 상영시간이 안지나야 함)
- 예매 선택 버튼 -> 영화관 -> 상영중인 영화 -> 상영시간 -> 구입 가능한 좌석 -> 예매
