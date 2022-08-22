-- 작업 데이터베이스 변경
USE market_db;

-- (1) 박지성이 구매한 도서의 출판사 수 ( customer, orders, book )
SELECT b.*-- count(DISTINCT b.publisher) 출판사수
FROM book b
INNER JOIN orders o ON b.bookid = o.bookid 
INNER JOIN customer c ON o.custid = c.custid 
WHERE c.name = '박지성';

SELECT count(DISTINCT b.publisher) "박지성 고객의 구매 도서 출판사 수"
FROM book b, orders o, customer c
WHERE b.bookid = o.bookid AND 
	  o.custid = c.custid AND 
      c.name = '박지성';

-- (2) 박지성이 구매한 도서의 이름, 가격, 정가와 판매가격의 차이 ( customer, orders, book )
SELECT b.bookname, b.price, (b.price - o.saleprice) discount
FROM book b
INNER JOIN orders o ON b.bookid = o.bookid 
INNER JOIN customer c ON o.custid = c.custid 
WHERE c.name = '박지성';

-- (3) 박지성이 구매하지 않은 도서의 이름 ( customer, orders, book )
SELECT b.*
FROM book b
INNER JOIN orders o ON b.bookid = o.bookid 
INNER JOIN customer c ON o.custid = c.custid 
WHERE c.name <> '박지성';

SELECT b.*
FROM book b
INNER JOIN orders o ON b.bookid = o.bookid 
WHERE o.custid <> ( SELECT custid 
					FROM customer
                    WHERE name = '박지성');

(4) 주문하지 않은 고객의 이름 ( customer, orders )
(5) 고객의 이름과 고객별 구매액 ( customer, orders )
(6) 고객의 이름과 고객이 구매한 도서 목록 ( customer, orders, book )
(7) 도서의 가격(Book 테이블)과 판매가격(Orders 테이블)의 차이가 가장 많은 주문 ( book, orders )
(8) 도서의 판매액 평균보다 자신의 구매액 평균이 더 높은 고객의 이름 ( orders, book, customer )
