# 쇼핑몰 프로그램 만들기

## 시나리오
```text
1. 상품등록
2. 회원가입
3. 상품목록보기
4. 장바구니담기 (상품 하나만 개수를 포함해서 담을 수 있다)
- 여러 상품을 담지 못하는 쇼핑몰
5. 장바구니보기
6. 주문하기 (장바구니에 있는 것을 주문테이블에 그대로 옮겨담고, totalPrice 계산)
7. 주문이력보기 (유저별)
```

## 0. 코드 실행 흐름
- ShopApp의 main에서 필요한 서비스 메서드 호출
- 서비스 메서드는 필요한 레포지토리 메서드 호출
- 레포지토리 메서드는 DB에서 CRUD

## 1. root접속 DB생성
- 워크벤치에서 root로 접속하기
```sql
create database shopdb;
use shopdb;
```

## 2. 테이블 생성
- shop.model 패키지를 확인해서 워크벤치 툴에서 테이블 만들기
- root로 접속한 상태에서 use shopdb; 명령어 실행후 테이블생성
```sql
CREATE TABLE product_tb (
    p_id INT AUTO_INCREMENT PRIMARY KEY,
    p_name VARCHAR(10),
    p_price INT,
    p_stock INT
) ENGINE=InnoDB
CHARACTER SET utf8mb4; 
```

## 3. model 완성
- shop.model 패키지에 만들어져있음. 
- 생성자, get, set, toString 만들기 (Lombok 사용해도 됨)

## 4. 각 service 책임
- 기능담당 (여러 기능을 묶어서 하나의 트랜잭션으로 관리)

## 5. 각 repository 책임
- CRUD 책임을 가진다.
- 이제 복잡한 조인쿼리도 필요하다.

## 6. view 패키지 역할
- 단순한 테이블 조회는 model패키지에 클래스로 파싱하면 됨
- 조인을 하면 view 패키지의 클래스에 파싱하면 됨.

