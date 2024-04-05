/*  콩볶아조 The Caffeine */

/* 영업 테이블 조회 */
select * from pd; --제품
select * from cli; --거래처
select * from pd_stk; --제품 재고
select * from od; --주문
select * from od_detail; --주문 상세
select * from send; --제품 출고
select * from rtn; --제품 반품
select * from disc_pd; --제품 폐기
select * from bom;

--제품 안전재고량 월주문량의 20~30% 

/* 시퀀스 */
CREATE SEQUENCE od_seq;
DROP SEQUENCE od_seq;
CREATE SEQUENCE od_detail_seq;
DROP SEQUENCE od_detail_seq;
CREATE SEQUENCE send_seq;
DROP SEQUENCE send_seq;
CREATE SEQUENCE rtn_seq;
DROP SEQUENCE rtn_seq;
CREATE SEQUENCE disc_pd_seq;
DROP SEQUENCE disc_pd_seq;

/*  제품 등록   */
insert into pd
values ( 'PET01', '에티오피아 G1 예가체프 첼바', 'box',339000); --단위
insert into pd
values ( 'PBR01', '브라질 홀빈 로스팅 세하도 커피 원두', 'box',273000);
insert into pd
values ( 'PCB01', '콜롬비아 수프리모 후일라 싱글오리진 로스팅원두커피', 'box',372000);
insert into pd
values ( 'PPR01', '프리미엄 페루 싱글오리진 찬차마요 원두 커피', 'box',736000);
insert into pd
values ( 'PCT01', '코스타리카 따라주 로스팅 원두커피 홀빈 싱글오리진', 'box',422000);

delete from pd;

/*  거래처 등록  */
insert into cli
values('PCLI001', '콩다방', '120-86-07029', '02-1577-4708', '서울시 강남구 봉은사로 99길 7', '이콩다 대리', 'coffeebean01@gmail.com');

/*  주문 등록   */
insert into od
values (od_seq.nextval, '2024-04-01', '김주문', 0.05, 699200, 'PCLI001',1);

/*  거래처 목록 조회   */
select cli_cd, cli_name, bussno, tel, addr, cli_chg, mail
from cli
where cli_cd LIKE '%58%'
    OR cli_name LIKE '%58%'
    OR cli_chg LIKE '%58%'
    OR tel LIKE '%58%';
    
/*  상품 목록 조회    */
select pd_cd, pd_name, unit, cost
from pd
order by pd_cd;

/* 주문 등록 + 주문상세 등록 */
select * from od;
select * from od_detail;

insert into od (od_no, od_dt, od_chg, dc_rate, total_price, cli_cd)
values (od_seq.nextval,'2024-04-04', '콩볶아', 0.1, 10000, 'PCLI001');

insert into od_detail (od_detailno, qt, cost, detail_price, od_no, pd_cd, due_dt, od_detail_st)
values (od_detail_seq.nextval, 2, 10000, 20000, od_seq.currval, 'PET01', '2024-06-01', 1);
insert into od_detail (od_detailno, qt, cost, detail_price, od_no, pd_cd, due_dt, od_detail_st)
values (od_detail_seq.nextval, 3, 15000, 45000, od_seq.currval, 'PBR01', '2024-06-05', 1);

delete from od;
delete from od_detail;

/* 칼럼 타입 변경 */
alter table od modify dc_rate number(10,3);


/* 주문 조회 - 주문, 주문상세 */
select o.OD_NO, o.OD_DT, o.OD_CHG, o.DC_RATE, o.TOTAL_PRICE, o.CLI_CD,c.cli_name,c.cli_chg
from od o JOIN cli c
ON o.cli_cd = c.cli_cd;

select d.od_no,d.od_detailno,p.pd_name,d.due_dt,d.od_detail_st,d.pd_cd
from od_detail d JOIN pd p
ON d.pd_cd = p.pd_cd
where d.od_no= 87;


/* 주문관리 조건검색 주문조회 */
select o.OD_NO, o.OD_DT, o.OD_CHG, o.DC_RATE, o.TOTAL_PRICE, o.CLI_CD,
        c.cli_name,c.cli_chg,
        d.od_no,d.od_detailno,
        p.pd_name,d.due_dt,d.od_detail_st,d.pd_cd
from cli c JOIN od o
                ON c.cli_cd = o.cli_cd
            LEFT OUTER JOIN od_detail d
                ON o.od_no = d.od_no
            JOIN pd p
                ON d.pd_cd = p.pd_cd
where o.od_dt BETWEEN TO_DATE('2024-04-20', 'YYYY-MM-DD') AND TO_DATE('2025-01-01', 'YYYY-MM-DD')
ORDER BY d.od_detailno;



