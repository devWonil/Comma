![image](https://user-images.githubusercontent.com/102580743/181183965-fc5d9834-bc84-44f2-8101-28d6fd12e8fd.png)
# 숙박 서비스 웹 구현 팀 프로젝트

## 숙박 서비스 플랫폼 airBnb를 참고하여 만든 프로젝트입니다.

- 숙박업소 검색, 조회, 예약 기능을 구현하였으며, airBnb와의 차별성을 두기 위해서 리뷰에 답글을 달아 조금더 사용자 친화적인 시스템을 구현하는 것을 목표로 하였습니다.
- 게스트, 호스트, 관리자 모드로 나누어 개발하였습니다.

## 프로젝트에 사용한 언어 및 프레임워크 / 라이브러리

- [ ]  Backend : JAVA, Spring Boot, JPA, MySQL
- [ ]  Frontend : HTML5, CSS, JQuery, Javascript, BootStrap4
- [ ]  Security : CSRF
- [ ]  버전관리 : Git

## 프로젝트 기간

- 2022 07.04 ~ 2022 07.26

## 프로그램 기능

### 공통기능

1. 회원가입 / 로그인 / 회원정보 수정
2. 소셜 로그인 (카카오)
3. 게스트 / 호스트 전환
4. 숙소 조회

### 게스트 기능

1. 예약하기
2. 찜하기
3. 리뷰 작성 / 수정 / 관리
4. 예약현황 보기
5. 결제

### 호스트 기능

1. 숙소 등록
2. 숙소 정보 수정 / 삭제
3. 예약 관리
4. 리뷰 관리

### 관리자 기능

1. 회원 검색

## 페이지 구성

### 메인

![https://user-images.githubusercontent.com/96460131/181153554-252fc86e-7bc7-4d18-813f-3bbaf25f5955.png](https://user-images.githubusercontent.com/96460131/181153554-252fc86e-7bc7-4d18-813f-3bbaf25f5955.png)

![https://user-images.githubusercontent.com/96460131/181153584-d80b0445-e416-4e65-aa18-220e94921140.png](https://user-images.githubusercontent.com/96460131/181153584-d80b0445-e416-4e65-aa18-220e94921140.png)

![https://user-images.githubusercontent.com/96460131/181153595-ff403ffc-2d44-4f4d-8b86-2be4ccb41450.png](https://user-images.githubusercontent.com/96460131/181153595-ff403ffc-2d44-4f4d-8b86-2be4ccb41450.png)

![https://user-images.githubusercontent.com/96460131/181153613-961e406c-817e-482a-910e-113f4731dbea.png](https://user-images.githubusercontent.com/96460131/181153613-961e406c-817e-482a-910e-113f4731dbea.png)

![https://user-images.githubusercontent.com/96460131/181153622-5f4ed15a-dbb5-4c16-a36c-8e6e627337d6.png](https://user-images.githubusercontent.com/96460131/181153622-5f4ed15a-dbb5-4c16-a36c-8e6e627337d6.png)

### 숙소 리스트

![https://user-images.githubusercontent.com/96460131/181153660-57d29c8a-05c1-49a2-bf73-e4b3c3d0c979.png](https://user-images.githubusercontent.com/96460131/181153660-57d29c8a-05c1-49a2-bf73-e4b3c3d0c979.png)

![https://user-images.githubusercontent.com/96460131/181153666-024a0a80-16ff-4dad-b022-af69de2b5d72.png](https://user-images.githubusercontent.com/96460131/181153666-024a0a80-16ff-4dad-b022-af69de2b5d72.png)

### 숙소 검색

![https://user-images.githubusercontent.com/96460131/181153715-4066c0eb-f062-4f41-b0ea-f37b16cc7dfb.png](https://user-images.githubusercontent.com/96460131/181153715-4066c0eb-f062-4f41-b0ea-f37b16cc7dfb.png)

![https://user-images.githubusercontent.com/96460131/181153732-daca7bb9-4c82-4add-a76a-2e98bdb51987.png](https://user-images.githubusercontent.com/96460131/181153732-daca7bb9-4c82-4add-a76a-2e98bdb51987.png)

### 숙소 상세정보 조회

![https://user-images.githubusercontent.com/96460131/181153776-dcad94b4-0062-4351-bfc5-41ae0e9378c3.png](https://user-images.githubusercontent.com/96460131/181153776-dcad94b4-0062-4351-bfc5-41ae0e9378c3.png)

![https://user-images.githubusercontent.com/96460131/181153784-0c60beae-bc0c-4a08-8f56-e49fcd4cb5cb.png](https://user-images.githubusercontent.com/96460131/181153784-0c60beae-bc0c-4a08-8f56-e49fcd4cb5cb.png)

## 게스트

### 숙소 예약

![https://user-images.githubusercontent.com/96460131/181153824-95a567d8-5a88-448c-865c-0edfd9ad1607.png](https://user-images.githubusercontent.com/96460131/181153824-95a567d8-5a88-448c-865c-0edfd9ad1607.png)

![https://user-images.githubusercontent.com/96460131/181153838-be92492e-a70d-47a1-8cea-21957e65a0d9.png](https://user-images.githubusercontent.com/96460131/181153838-be92492e-a70d-47a1-8cea-21957e65a0d9.png)

![https://user-images.githubusercontent.com/96460131/181153846-14e4f4f0-5e2a-46f5-aedf-d552a09e55b8.png](https://user-images.githubusercontent.com/96460131/181153846-14e4f4f0-5e2a-46f5-aedf-d552a09e55b8.png)

### 예약 내역 조회

![https://user-images.githubusercontent.com/96460131/181153898-224285d1-1679-41c3-9000-4f0024f9ced5.png](https://user-images.githubusercontent.com/96460131/181153898-224285d1-1679-41c3-9000-4f0024f9ced5.png)

![https://user-images.githubusercontent.com/96460131/181153904-8b5805e6-9280-4b08-b864-6803ac0e9ad7.png](https://user-images.githubusercontent.com/96460131/181153904-8b5805e6-9280-4b08-b864-6803ac0e9ad7.png)

### 결제

![https://user-images.githubusercontent.com/96460131/181154799-264297b8-ad33-48cf-9d4c-63e48fec3b18.png](https://user-images.githubusercontent.com/96460131/181154799-264297b8-ad33-48cf-9d4c-63e48fec3b18.png)

### 리뷰 작성, 리뷰

![https://user-images.githubusercontent.com/96460131/181153934-10ca8218-6faf-4976-9d45-1e50686a3947.png](https://user-images.githubusercontent.com/96460131/181153934-10ca8218-6faf-4976-9d45-1e50686a3947.png)

![https://user-images.githubusercontent.com/96460131/181153938-a841361e-b0a7-4249-8707-aefdd5b65edc.png](https://user-images.githubusercontent.com/96460131/181153938-a841361e-b0a7-4249-8707-aefdd5b65edc.png)

### 위시리스트

![https://user-images.githubusercontent.com/96460131/181154074-643d2d4c-9920-431e-be3c-7d330d1f6db4.png](https://user-images.githubusercontent.com/96460131/181154074-643d2d4c-9920-431e-be3c-7d330d1f6db4.png)

![https://user-images.githubusercontent.com/96460131/181154077-d1b4983d-464b-4eb6-8c2c-4bf0bb7ab3ce.png](https://user-images.githubusercontent.com/96460131/181154077-d1b4983d-464b-4eb6-8c2c-4bf0bb7ab3ce.png)

## 호스트

### 숙소 관리

### 등록

![https://user-images.githubusercontent.com/96460131/181154360-38952971-4fdc-4a6c-8571-b0cb73e36eed.png](https://user-images.githubusercontent.com/96460131/181154360-38952971-4fdc-4a6c-8571-b0cb73e36eed.png)

### 조회

![https://user-images.githubusercontent.com/96460131/181154391-c8c5a543-4ccf-47c7-b3e8-0b2f3dd61d93.png](https://user-images.githubusercontent.com/96460131/181154391-c8c5a543-4ccf-47c7-b3e8-0b2f3dd61d93.png)

![https://user-images.githubusercontent.com/96460131/181154394-eff277fa-4ca6-466c-9b6f-79dacc57d9e6.png](https://user-images.githubusercontent.com/96460131/181154394-eff277fa-4ca6-466c-9b6f-79dacc57d9e6.png)

### 에약 내역 조회

![https://user-images.githubusercontent.com/96460131/181154410-ce8d4035-f553-460e-b2d1-8c90fa4cf3ca.png](https://user-images.githubusercontent.com/96460131/181154410-ce8d4035-f553-460e-b2d1-8c90fa4cf3ca.png)

![https://user-images.githubusercontent.com/96460131/181154418-a0fee679-8fa2-4dfe-8023-1868e51a8fe0.png](https://user-images.githubusercontent.com/96460131/181154418-a0fee679-8fa2-4dfe-8023-1868e51a8fe0.png)

## 관리자

### 회원 조회

![https://user-images.githubusercontent.com/96460131/181155327-950b3b21-2568-4d37-bb3f-bc7d8db105b1.png](https://user-images.githubusercontent.com/96460131/181155327-950b3b21-2568-4d37-bb3f-bc7d8db105b1.png)
