# 커피 주문 API
    Environment :
      Java11, Spring Boot3.0.2, JPA, MySQL, Gradle, SwaggerV3, InteliJ

### swagger 주소 :
http://localhost:8080/swagger-ui/index.html

### 어플리케이션 실행 :
1. 로컬 환경에서 mysql 구동


### 요구사항 구현여부 :

1. 커피 메뉴 목록 조회
2. 포인트 충전
3. 커피 주문/결제
4. 인기 메뉴 목록 조회

### 구현 방법 및 검증결과 :
1. 커피 메뉴 목록 조회
   - JPA findAll을 이용한 단순 데이터 조회
   - import.sql 파일로 초기 데이터 세팅
   #### Request
   ```
   http://localhost:8080/menu/hot
   ```
   #### Response
   ```json
   [
       {
           "id": 1,
           "coffeeName": "Americano",
           "price": 4500
       },
       {
           "id": 2,
           "coffeeName": "Cappuccino",
           "price": 5000
       },
       {
           "id": 3,
           "coffeeName": "Coldbrew",
           "price": 5500
       },
       {
           "id": 4,
           "coffeeName": "Latte",
           "price": 5000
       },
       {
           "id": 5,
           "coffeeName": "Espresso",
           "price": 3000
       }
   ]
   ```
2. 포인트 충전
   - 회원 식별번호와 포인트 금액을 파라미터로 전달
   - 신규 회원의 경우 새로 포인트 생성
   - 기존 회원의 경우 기존 포인트 누적
   #### Request
   ```
   http://localhost:8080/point
   ```
   ```json
   {"memberId":1, "point":10000}
   ```
   #### Response
   ```json
   {
    "memberId": 1,
    "totalPoint": 18500
   }
   ```
3. 커피 주문/결제
   - 회원 식별번호와 커피,수량 파라미터로 전달
   - 주문과 동시에 결제 프로세스 진행
   - 없는 회원일 경우/포인트가 모자랄 경우 예외처리
   #### Request
   ```
   http://localhost:8080/order
   ```
   ```json
   {
    "memberId": 1,
    "menu": {
         "Americano":1,
         "Espresso":1,
         "Latte":4
     }
   }
   ```
   #### Response
   1. 정상 처리
   ```json
   {
    "id": 1,
    "memberId": 1,
    "totalPoint": 33500
   }
   ```
   2. 포인트 예치 이력이 없는 신규 회원
   ```json
   {
    "code": "MEMBER_NOT_FOUND",
    "errorMsg": "존재하지 않는 유저입니다."
   }
   ```
   3. 결제 포인트 부족
   ```json
   {
    "code": "NOT_ENOUGH_POINT",
    "errorMsg": "포인트가 부족합니다."
   }
   ```
4. 인기 메뉴 목록 조회
   - 일주일 간 주문 횟수 많은 음료 3순위 출력
   - 주문 수량 및 횟수로 순위 결정
   #### Request
   ```
   http://localhost:8080/menu/hot
   ```
      #### Response
   ```json
   [
       "Espresso",
       "Americano",
       "Latte"
   ]
   ```