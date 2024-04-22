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



/* 재고관리 페이지 - 전체 재고 조회 */
select * from pd;
select * from pd_stk;

-- 생산계획코드, 주간계획시작일, 계획명
select * from pdtplan;
-- 생산계획상세번호, 생산계획코드, 제품명, 수량, 납기일, 제품코드
select * from pdt_plan_detail;

select wk_plan_stt_dt, NEXT_DAY(wk_plan_stt_dt+21, '토')
from pdtplan;

--p, c, t, n
select p.pd_cd, p.pd_name, p.unit, c.curStk, t.threeWnotSend, n.notSend,
trunc((p.safe_stk_qt/21)*30.5, 0)as monthlyPrd, trunc((p.safe_stk_qt/3), 0)as weeklyPrd,
CASE WHEN t.threeWnotSend > c.curStk
        THEN t.threeWnotSend - c.curStk
    ELSE 0
    END AS shortage
from pd p 
JOIN (select count(*) as curStk, pd_cd
from pd_stk
where qt >0 and exp_dt > sysdate
group by pd_cd) c
ON c.pd_cd = p.pd_cd
JOIN (select count(*) as threeWnotSend, pd_cd
from od_detail
where od_detail_st<3 and (sysdate-due_dt) <21
group by pd_cd) t
    ON p.pd_cd = t.pd_cd    
JOIN (select count(*) as notSend, pd_cd
from od_detail
where od_detail_st<3
group by pd_cd) n
ON p.pd_cd = n.pd_cd
;

--미출고주문량
select count(*) as notSend, pd_cd
from od_detail
where od_detail_st<3
group by pd_cd;

--현재수량
select count(*) as curStk, pd_cd
from pd_stk
where qt >0 and exp_dt > sysdate
group by pd_cd;

--1. 월별 예측 생산 수량(디비에는 3주단위, 전체 3주 생산량의 100%)
select round((safe_stk_qt/21)*30.5, 0)as monthlyPrd, pd_cd
from pd;
--2. 주별 예측 생산 수량
select round((safe_stk_qt/3), 0)as weeklyPrd, pd_cd
from pd;

-- 납기일 3주 미만 남은 주문량
select count(*) as threeWnotSend, pd_cd
from od_detail
where od_detail_st<3 and (sysdate-due_dt) <21
group by pd_cd;









/* 재고관리 페이지 - LOT 재고 조회 */
select l.pd_lot, l.pd_cd, p.pd_name, l.qt, l.pdt_dt, l.exp_dt
from pd p, pd_stk l
where l.qt > 0
    and l.pd_cd = 'PBR01'
ORDER BY l.pdt_dt DESC;

select l.pd_lot, l.pd_cd, l.qt, l.pdt_dt, l.exp_dt, p.pd_name
from pd_stk l JOIN ( select pd_name, pd_cd
from pd) p
ON l.pd_cd = p.pd_cd
where l.qt > 0
    and l.pd_cd = 'PBR01'
ORDER BY l.pdt_dt DESC;

select l.pd_lot, l.pd_cd, l.qt, l.pdt_dt, l.exp_dt, p.pd_name
from pd_stk l JOIN ( select pd_name, pd_cd
from pd) p
ON l.pd_cd = p.pd_cd
where l.qt > 0
    and l.pd_cd = 'PBR01'
ORDER BY l.pdt_dt DESC;

select * from pd_stk;




/*  다시 만드는 주문조회~    */
-- 주문, 주문상세, 거래처, 제품
select * from pd;
select * from cli;
select * from od;
select * from od_detail;

--제품명 외 2건
select o.od_dt, o.cli_cd, o.total_price, c.cli_name, c.cli_chg , d.pd_cd, d.due_dt, d.od_detail_st, de.od_no, 
        CASE WHEN (de.cnt > 0) THEN p.pd_name || ' 외 ' || de.cnt || '건'
             ELSE p.pd_name
             END AS pdName        
from od_detail d 
    JOIN (select min(od_detailno) as minDetailNo, (count(*)-1) as cnt, od_no
            from od_detail
            group by od_no) de 
    ON d.od_detailno = de.minDetailNO
    JOIN pd p
    ON d.pd_cd = p.pd_cd
    JOIN od o
    ON o.od_no = de.od_no
    JOIN cli c
    ON c.cli_cd = o.cli_cd
ORDER BY de.od_no DESC;

select de.od_no, o.od_dt, c.cli_name, c.cli_chg ,
        CASE WHEN (de.cnt > 0) THEN p.pd_name || ' 외 ' || de.cnt || '건'
             ELSE p.pd_name
             END AS pdName  ,
        o.total_price, o.od_chg, d.due_dt,
        CASE (o.od_st)
            WHEN 1 THEN '주문접수' 
            WHEN 2 THEN '생산요청'
            WHEN 3 THEN '출고완료'
            WHEN 4 THEN '구매확정'
            WHEN 9 THEN '반품완료'
            ELSE '반품중'
            END AS odSt
from od_detail d 
    JOIN (select min(od_detailno) as minDetailNo, (count(*)-1) as cnt, od_no
            from od_detail
            group by od_no) de 
    ON d.od_detailno = de.minDetailNO
    JOIN pd p
    ON d.pd_cd = p.pd_cd
    JOIN od o
    ON o.od_no = de.od_no
    JOIN cli c
    ON c.cli_cd = o.cli_cd
    
WHERE d.pd_cd LIKE '%01%'
    AND p.pd_name LIKE '%%'
    AND o.cli_cd LIKE '%%'
    AND c.cli_name LIKE '%%'
    AND c.cli_chg LIKE '%%'
    AND o.od_chg LIKE '%%'
    AND o.od_dt >= '2023-01-01'
    AND o.od_dt <= '2025-01-01'
    AND d.due_dt >= '2023-01-01'
    AND d.due_dt <= '2025-01-01'
    AND o.od_st = '1'
ORDER BY de.od_no DESC;



--화면에 보일 정보만 추리기
select de.od_no, o.od_dt, c.cli_name, c.cli_chg ,
        CASE WHEN (de.cnt > 0) THEN p.pd_name || ' 외 ' || de.cnt || '건'
             ELSE p.pd_name
             END AS pdName  ,
        o.total_price, o.od_chg, d.due_dt, o.od_st,
        CASE (o.od_st)
            WHEN 1 THEN '주문접수' 
            WHEN 2 THEN '생산요청'
            WHEN 3 THEN '출고완료'
            WHEN 4 THEN '구매확정'
            WHEN 9 THEN '반품완료'
            ELSE '반품중'
            END AS odSt
from od_detail d 
    JOIN (select min(od_detailno) as minDetailNo, (count(*)-1) as cnt, od_no
            from od_detail
            group by od_no) de 
    ON d.od_detailno = de.minDetailNO
    JOIN pd p
    ON d.pd_cd = p.pd_cd
    JOIN od o
    ON o.od_no = de.od_no
    JOIN cli c
    ON c.cli_cd = o.cli_cd
    
WHERE d.pd_cd LIKE '%01%'
    AND p.pd_name LIKE '%%'
    AND o.cli_cd LIKE '%%'
    AND c.cli_name LIKE '%%'
    AND c.cli_chg LIKE '%%'
    AND o.od_chg LIKE '%%'
    AND o.od_dt >= '2023-01-01'
    AND o.od_dt <= '2025-01-01'
    AND d.due_dt >= '2023-01-01'
    AND d.due_dt <= '2025-01-01'
    AND o.od_st = '1'
ORDER BY de.od_no DESC;



-- 제품명 조건으로 주문 검색 where절 재수정중
select * from od_detail;
select * from pd;
-- OR이 들어가야 할듯...결국 프로시저? 수정하자....

select de.od_no, o.od_dt, c.cli_name, c.cli_chg ,
        CASE WHEN (de.cnt > 0) THEN p.pd_name || ' 외 ' || de.cnt || '건'
             ELSE p.pd_name
             END AS pdName  ,
        o.total_price, o.od_chg, d.due_dt,
        CASE (o.od_st)
            WHEN 1 THEN '주문접수' 
            WHEN 2 THEN '생산요청'
            WHEN 3 THEN '출고완료'
            WHEN 4 THEN '구매확정'
            WHEN 9 THEN '반품완료'
            ELSE '반품중'
            END AS odSt
from od_detail d 
    JOIN (select min(od_detailno) as minDetailNo, (count(*)-1) as cnt, od_no
            from od_detail
            group by od_no) de 
    ON d.od_detailno = de.minDetailNO
    JOIN pd p
    ON d.pd_cd = p.pd_cd
    JOIN od o
    ON o.od_no = de.od_no
    JOIN cli c
    ON c.cli_cd = o.cli_cd
    
WHERE d.pd_cd LIKE '%01%'
    AND p.pd_name LIKE '%%'
    AND o.cli_cd LIKE '%%'
    AND c.cli_name LIKE '%%'
    AND c.cli_chg LIKE '%%'
    AND o.od_chg LIKE '%%'
    AND o.od_dt >= '2023-01-01'
    AND o.od_dt <= '2025-01-01'
    AND d.due_dt >= '2023-01-01'
    AND d.due_dt <= '2025-01-01'
    AND o.od_st = '1'
ORDER BY de.od_no DESC;



select dn.od_detailno, dn.pd_cd, dn.od_no
from od_detail dn JOIN (
select pd_cd, pd_name
from pd
where pd_name like '%프리미엄%') pn
ON dn.pd_cd = pn.pd_cd;

select de.od_no, o.od_dt, c.cli_name, c.cli_chg ,
        CASE WHEN (de.cnt > 0) THEN p.pd_name || ' 외 ' || de.cnt || '건'
             ELSE p.pd_name
             END AS pdName  ,
        o.total_price, o.od_chg, d.due_dt, o.od_st,
        CASE (o.od_st)
            WHEN 1 THEN '주문접수' 
            WHEN 2 THEN '생산요청'
            WHEN 3 THEN '출고완료'
            WHEN 4 THEN '구매확정'
            WHEN 9 THEN '반품완료'
            ELSE '반품중'
            END AS odSt
from od_detail d 
    JOIN 
    
    (select dn.od_detailno, dn.pd_cd, dn.od_no
from od_detail dn JOIN (
select pd_cd, pd_name
from pd
where pd_name like '%프리미엄%') pn
ON dn.pd_cd = pn.pd_cd) de 
            
            
            
    ON d.od_detailno = de.od_detailno
    JOIN pd p
    ON d.pd_cd = p.pd_cd
    JOIN od o
    ON o.od_no = de.od_no
    JOIN cli c
    ON c.cli_cd = o.cli_cd
    

ORDER BY de.od_no DESC;


select * from od_detail;
select * from od;
select * from pd;



/* 주문 상세 조회 */
select * from od;
select * from od_detail order by od_detailno;
select * from cli;
select * from pd;
--거래처명, 거래처코드, 사업자번호, 전화번호, 주소, 이메일, 거래처담당자, 주문담당자, 주문일, 납기일, 할인율, 총금액
--제품코드	제품명	수량	단위	단가	합계
select min(due_dt) due_dt, od_no
from od_detail
group by od_no;

select c.cli_name, o.cli_cd, c.bussno, c.tel, c.addr, c.mail, c.cli_chg, o.od_chg, o.od_dt, d.due_dt, (o.dc_rate*100) || '%' as dc_percent, o.total_price
from od o
    JOIN cli c
    ON o.cli_cd = c.cli_cd
    JOIN (select min(due_dt) due_dt, od_no
from od_detail
group by od_no) d
    ON o.od_no = d.od_no
where o.od_no = d.od_no;

-- 주문상품
select d.pd_cd, p.pd_name, d.qt, p.unit, p.cost, d.detail_price
from od_detail d JOIN pd p
    ON d.pd_cd = p.pd_cd
where d.od_no = 90
order by od_detailno;

select * from od;
select * from od_detail;
-- 1:주문접수 2:출고중(처리취소 가능) 3:출고완료(처리취소 불가능)
ALTER TABLE od_detail ADD send_st NUMBER(10, 0) DEFAULT 1 NOT NULL;
COMMENT ON COLUMN od_detail.send_st IS '제품 출고 상태';




/* 출고 미처리, 처리 목록 */
-- 조건 : 거래처코드, 거래처명, 주문일, 납기일, 주문담당자명
-- 주문번호+주문상세번호(자릿수 맞추기), 주문일, 거래처명, 제품명, 수량, 납기일, 상세출고상태
select LPAD(o.od_no, 5,0)||'-'||LPAD(d.od_detailno, 6, 0) as "no", o.od_dt, c.cli_name, p.pd_name, d.qt, d.due_dt
from od o 
    JOIN od_detail d
        ON o.od_no = d.od_no
    JOIN cli c
        ON c.cli_cd = o.cli_cd
    JOIN pd p
        ON p.pd_cd = d.pd_cd
WHERE d.SEND_OD_ST = 1        
    AND p.pd_name LIKE '%커피%'
ORDER BY o.od_no ASC, d.od_detailno DESC;





        
/* 공통코드 테이블 이용 함수 만들기~~~        
        공통 코드	주 코드 번호	코드 명	코드 설명	
공통 상세 코드  	세부 코드 번호	주 코드 번호	세부 코드 명	세부 코드 설명*/


select * from com_cd;

insert into com_cd (wk_cd_no, cd_name)
values( 'od_st', '주문상태');

insert into com_detail_cd (wk_cd_no, detail_cd_no, detail_cd_name )
values( 'od_st', 1, '주문접수');
insert into com_detail_cd (wk_cd_no, detail_cd_no, detail_cd_name )
values( 'od_st', 2, '출고중');
insert into com_detail_cd (wk_cd_no, detail_cd_no, detail_cd_name )
values( 'od_st', 3, '출고완료');
insert into com_detail_cd (wk_cd_no, detail_cd_no, detail_cd_name )
values( 'od_st', 4, '구매확정');
insert into com_detail_cd (wk_cd_no, detail_cd_no, detail_cd_name )
values( 'od_st', 5, '반품접수');
insert into com_detail_cd (wk_cd_no, detail_cd_no, detail_cd_name )
values( 'od_st', 6, '제품회수중');
insert into com_detail_cd (wk_cd_no, detail_cd_no, detail_cd_name )
values( 'od_st', 7, '제품회수완료');
insert into com_detail_cd (wk_cd_no, detail_cd_no, detail_cd_name )
values( 'od_st', 8, '반품거부');
insert into com_detail_cd (wk_cd_no, detail_cd_no, detail_cd_name )
values( 'od_st', 9, '반품완료');

select * from com_cd;
select * from com_detail_cd;

create or replace FUNCTION FIND_CODE_NAME 
(
  P_WK_CD_NO IN VARCHAR2 
, P_DETAIL_CD_NO IN NUMBER 
) RETURN VARCHAR2 AS 
v_detail_de_name VARCHAR2(100);
BEGIN
  select detail_cd_name 
    into v_detail_de_name
  from com_detail_cd
  where wk_cd_no = p_wk_cd_no
    and detail_cd_no = p_detail_cd_no;
  RETURN v_detail_de_name;
END FIND_CODE_NAME;
/




/* 재품재고 테이블 데이터 생성 */
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs ('PCB01-240408-0001', 'box', 2, '24/04/08','24/05/08','PCB01',13);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs ('PCB01-240408-0002', 'box', 2, '24/04/08','24/05/08','PCB01',14);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PBR01-240408-0001', 'box', 2, '24/04/08','24/05/08','PBR01',15);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PBR01-240408-0002', 'box', 2, '24/04/08','24/05/08','PBR01',16);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PBR01-240408-0003', 'box', 2, '24/04/08','24/05/08','PBR01',17);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PET01-240409-0001', 'box', 2, '24/04/09','24/05/09','PET01',18);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PET01-240409-0002', 'box', 2, '24/04/09','24/05/09','PET01',19);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PET01-240409-0003', 'box', 2, '24/04/09','24/05/09','PET01',20);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PET01-240410-0004', 'box', 2, '24/04/10','24/05/10','PET01',21);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PET01-240410-0005', 'box', 2, '24/04/10','24/05/10','PET01',22);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PCT01-240410-0001', 'box', 2, '24/04/10','24/05/10','PCT01',23);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PCT01-240410-0002', 'box', 2, '24/04/10','24/05/10','PCT01',24);

insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PPR01-240420-0001', 'box', 2, '24/04/20','25/04/20','PPR01',25);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PPR01-240420-0002', 'box', 2, '24/04/20','25/04/20','PPR01',26);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PPR01-240420-0003', 'box', 2, '24/04/20','25/04/20','PPR01',27);





select * from od order by od_no DESC; --o
select * from od_detail order by od_no DESC; --d
select * from pd_stk order by pd_lot; --t
select * from pd_stk where (exp_dt - sysdate) >= 30;
select * from send; --s

insert into send
(send_no, qt, send_dt, od_no, pd_lot)
--values ( send_seq.nextval, 1  ,sysdate, p_od_no, p_pd_lot);
values ( send_seq.nextval, 100 ,sysdate, 181, 'PBR01-240408-0001');

update od_detail set send_od_st = 3 where od_detailno = 161;
update od set od_st = 3 where od_no = p_od_no;

SET SERVEROUTPUT ON;



-- 생산계획상세
select * from pdt_inst_detail;



/* 재품재고 테이블 데이터 생성 */
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs ('PCB01-240416-0001', 'box', 2, '24/04/08','25/05/08','PCB01',13);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs ('PCB01-240416-0002', 'box', 2, '24/04/08','25/05/08','PCB01',14);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PBR01-240416-0001', 'box', 2, '24/04/08','25/05/08','PBR01',15);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PBR01-240416-0002', 'box', 2, '24/04/08','25/05/08','PBR01',16);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PBR01-240416-0003', 'box', 2, '24/04/08','25/05/08','PBR01',17);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PET01-240416-0001', 'box', 2, '24/04/09','25/05/09','PET01',18);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PET01-240416-0002', 'box', 2, '24/04/09','25/05/09','PET01',19);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PET01-240416-0003', 'box', 2, '24/04/09','25/05/09','PET01',20);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PET01-240416-0004', 'box', 2, '24/04/10','25/05/10','PET01',21);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PET01-240416-0005', 'box', 2, '24/04/10','25/05/10','PET01',22);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PCT01-240416-0001', 'box', 2, '24/04/10','25/05/10','PCT01',23);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PCT01-240416-0002', 'box', 2, '24/04/10','25/05/10','PCT01',24);


select * from pd_stk;





/*  주문조회 최~~~~~~~종  */
select * from pd ORDER BY pd_name;
select * from cli;
select * from od;
select * from od_detail;
select count(*), pd_cd from od_detail group by pd_cd; --PCB01 콜롬비아



select de.od_no, o.od_dt, c.cli_name, c.cli_chg ,
        CASE WHEN (de.cnt > 0) THEN p.pd_name || ' 외 ' || de.cnt || '건'
             ELSE p.pd_name
             END AS pdName  ,
        o.total_price, o.od_chg, d.due_dt, o.od_st,
        CASE (o.od_st)
            WHEN 1 THEN '주문접수' 
            WHEN 2 THEN '생산요청'
            WHEN 3 THEN '출고완료'
            WHEN 4 THEN '구매확정'
            WHEN 9 THEN '반품완료'
            ELSE '반품중'
            END AS odSt
from od_detail d 
    JOIN (select min(od_detailno) as minDetailNo, (count(*)-1) as cnt, od_no
            from od_detail
            group by od_no) de 
    ON d.od_detailno = de.minDetailNO
    JOIN pd p
    ON d.pd_cd = p.pd_cd
    JOIN od o
    ON o.od_no = de.od_no
    JOIN cli c
    ON c.cli_cd = o.cli_cd
    
WHERE d.pd_cd LIKE '%01%'
    AND p.pd_name LIKE '%%'
    AND o.cli_cd LIKE '%%'
    AND c.cli_name LIKE '%%'
    AND c.cli_chg LIKE '%%'
    AND o.od_chg LIKE '%%'
    AND o.od_dt >= '2023-01-01'
    AND o.od_dt <= '2025-01-01'
    AND d.due_dt >= '2023-01-01'
    AND d.due_dt <= '2025-01-01'
    AND o.od_st = '1'
ORDER BY de.od_no DESC;


select d.od_no, d.od_detailno, p.pd_name
from od_detail d
    JOIN pd p 
        ON d.pd_cd = p.pd_cd
WHERE 
p.pd_name LIKE '%콜롬비아%'
--d.pd_cd LIKE '%PCB01%'
;

-- 주문조회 조건검색 condition 하나 더 만들면 됨!
select min(od_detailno) as minDetailNo, (count(*)-1) as cnt, od_no
            from (select d.od_no, d.od_detailno, p.pd_name, d.pd_cd
                    from od_detail d
                        JOIN pd p 
                            ON d.pd_cd = p.pd_cd
                    WHERE 
                        d.pd_cd LIKE '%PCB01%' 
                        AND p.pd_name LIKE '%%'                    
                    )
            group by od_no;





select de.od_no
				, o.cli_cd
				, c.cli_name
				, c.cli_chg 
				, d.od_detailno
             	, d.pd_cd
				, p.pd_name
				, CASE WHEN (de.cnt > 0) THEN p.pd_name || ' 외 ' || de.cnt || '건'
             		   ELSE p.pd_name
             	  END AS pd  
             	, o.od_chg
				, o.od_dt
             	, d.due_dt
             	, o.dc_rate
             	, o.total_price
             	, o.od_st 
             	, FIND_CODE_NAME ('od_st', o.od_st)	AS st
		from od_detail d 
		    JOIN  (select min(dcnt.od_detailno) as minDetailNo
		          			, (count(*)-1) as cnt
		          			, dcnt.od_no
            		from od_detail dcnt JOIN(         --상세 181번 요주의 번호....
                                            ) dpd
                                        ON dcnt.od_detailno = dpd.od_detailno
                    group by dcnt.od_no
                    order by dcnt.od_no) de
		          
		    ON d.od_detailno = de.minDetailNo
		    JOIN pd p
		    ON d.pd_cd = p.pd_cd
		    JOIN od o
		    ON o.od_no = de.od_no
		    JOIN cli c
		    ON c.cli_cd = o.cli_cd
         
		ORDER BY de.od_no DESC;



-- with로 정리
with dpd as ( select d.od_no
                    , d.od_detailno
                    , p.pd_name
                    , d.pd_cd
                from od_detail d
                JOIN pd p 
                  ON d.pd_cd = p.pd_cd
                  where p.pd_name LIKE '%%'
            ),
de as (select min(dcnt.od_detailno) as minDetailNo
		          			, (count(*)-1) as cnt
		          			, dcnt.od_no
            		from od_detail dcnt JOIN dpd
                                            ON dcnt.od_no = dpd.od_no
            	group by dcnt.od_no
                order by dcnt.od_no)


select de.od_no
				, o.cli_cd
				, c.cli_name
				, c.cli_chg 
				, d.od_detailno
             	, d.pd_cd
				, p.pd_name
				, CASE WHEN (de.cnt > 0) THEN p.pd_name || ' 외 ' || de.cnt || '건'
             		   ELSE p.pd_name
             	  END AS pd  
             	, o.od_chg
				, o.od_dt
             	, d.due_dt
             	, o.dc_rate
             	, o.total_price
             	, o.od_st 
             	, FIND_CODE_NAME ('od_st', o.od_st)	AS st
		from od_detail d 
		    JOIN   de
		          
		    ON d.od_detailno = de.minDetailNo
		    JOIN pd p
		    ON d.pd_cd = p.pd_cd
		    JOIN od o
		    ON o.od_no = de.od_no
		    JOIN cli c
		    ON c.cli_cd = o.cli_cd
      --where c.cli_name LIKE '%콩%'
		ORDER BY de.od_no DESC;
        
--재수정




select d.od_no, d.od_detailno, d.pd_cd
from od_detail d LEFT OUTER JOIN (
                                                select  d.od_no                                                    
                                                    , p.pd_name
                                                    --, d.pd_cd
                                                from od_detail d
                                                JOIN pd p 
                                                  ON d.pd_cd = p.pd_cd
--                                               WHERE 
--                                                    --d.pd_cd LIKE '%PCB01%' 
--                                                    --AND 
--                                                    p.pd_name LIKE '%브라질%'
                         ) x
ON d.od_no = x.od_no
order by od_detailno;
        


/*  재고 조회   */

-- 226/ 231,232,233 / 3,3,3 / PCT01, PET01, PCB01
select * from od;
select * from od_detail 
--where od_no = 226
--where pd_cd = 'PPR01'
;
select * from send;
select * from pd_stk;
select * from pd;
/* 폐기 - 불량유형: 파손, 스크래치,... */



SELECT NVL( (SELECT SUM(qt) as qt
                   FROM pd_stk 
                  WHERE pd_cd = 'PCT01'
                  GROUP BY pd_cd )
                  , 0) as qt
   -- INTO v_lot_sum
    FROM pd_stk
    WHERE rownum = 1;
    
    
/*  제품 재고 목록(예측수량) */
select * from pdtplan;
select * from pdt_plan_detail;
select * from od;
select * from od_detail;
select * from pd_stk;
select * from pd; --3주 안전재고 

select d.due_dt, NEXT_DAY(d.due_dt + 28 , '월'), 
        sum(pld.qt) as qt, pl.pdt_plan_cd, plwk_plan_stt_dt
from od_detail d 
    JOIN pdtplan pl
        ON , pdt_plan_detail pld
where ;



select d.pd_cd, NEXT_DAY(d.due_dt + 21 , '월'), sum(d.qt) as total_not_send,
    (select sum(qt) from od_detail where sysdate+21 < due_dt) as three_not_send,
    sum(t.qt) as total_stk,
    CASE when (three_not_send - total_stk) > 0 
            then (three_not_send - total_stk)
        else 0
        as shortage,
    ()
    
        
    ADD_MONTHS(sysdate, 6) >=exp_dt;
    
select ld.qt, l.pdt_plan_cd
from pdtplan l 
    LEFT OUTER JOIN (select sum(qt) qt, pdt_plan_cd from pdt_plan_detail group by pdt_plan_cd) ld
        ON l.pdt_plan_cd = ld.pdt_plan_cd
where l.wk_plan_stt_dt > sysdate 
    AND l.wk_plan_stt_dt < NEXT_DAY(sysdate + 28 , '월');

select ld.pd_cd, sum(qt) as qt
from pdtplan l pdt_plan_detail ld
where l.wk_plan_stt_dt > sysdate 
    AND l.wk_plan_stt_dt < NEXT_DAY(sysdate + 28 , '월');

--제품코드, 제품명, 단위, 총 미출고, 납기3주/2주/1주미만 미출고, 재고량(유통기한 6개월 이상 남은), 납기3주미만 재고미달, 3주예상생산
select pdt_plan_cd, TO_DATE(NEXT_DAY(sysdate + 14 , '일')) --2주예상생산량
from pdtplan
where wk_plan_stt_dt > sysdate 
    AND wk_plan_stt_dt < TO_DATE(NEXT_DAY(sysdate + 14 , '일'));
--계획상세 kg단위 (무조건 24kg - 2박스)



--제품코드 제품명 단위 총재고,총미출고, 2주예상생산,2주미출고, 총재고+예상생산량 / 2주미출고 
select DISTINCT d.pd_cd, p.pd_name, p.unit, 
        st.total_stk as "총재고", 
        dn.total_not_send as "총미출고", 
        tl.tw_prdt as "2주예상생산", 
        wn.tw_not_send as "2주미출고",  
       TRUNC((wn.tw_not_send/(st.total_stk + tl.tw_prdt)*100),1) as "통계",
       TRUNC(((st.total_stk + tl.tw_prdt)-wn.tw_not_send), 0) as "출고가능예상량"
from pd p LEFT OUTER JOIN od_detail d
            ON p.pd_cd = d.pd_cd
             --총재고
            JOIN (select NVL(sum(qt)/12,0) as total_stk, pd_cd
                    from pd_stk
                    where ADD_MONTHS(sysdate, 6) <=exp_dt
                    group by pd_cd) st
            ON d.pd_cd = st.pd_cd
             --총미출고
            JOIN (select sum(qt) as total_not_send, pd_cd
                    from od_detail
                    where send_od_st = 1
                    group by pd_cd) dn
            ON d.pd_cd = dn.pd_cd
            --2주예상생산
            JOIN (select sum(lan.qt/12) as tw_prdt, lan.pd_cd 
                    from pdt_plan_detail lan
                         JOIN ( select pdt_plan_cd, wk_plan_stt_dt
                                            from pdtplan
                                            where wk_plan_stt_dt > sysdate
                                                AND wk_plan_stt_dt < TO_DATE(NEXT_DAY(sysdate+ 14 , '월')) ) lnn --2주(14일)
                        ON lan.pdt_plan_cd = lnn.pdt_plan_cd
                    group by lan.pd_cd) tl
            ON d.pd_cd = tl.pd_cd
            -- 2주미출고
            JOIN (select sum(nsn.qt) as tw_not_send, nsn.pd_cd
                    from od_detail nsn 
                        JOIN (select od_detailno, pd_cd
                                from od_detail
                                where send_od_st = 1
                                    and (due_dt -sysdate) <= 14) nsq
                    ON nsn.od_detailno = nsq.od_detailno
                    group by nsn.pd_cd) wn
            ON d.pd_cd = wn.pd_cd
            --(총재고+예상생산량) - 출고 가능한 예상량 
            
            ;
  
            
/
--총재고
select sum(qt), pd_cd
from pd_stk
where ADD_MONTHS(sysdate, 6) <=exp_dt
group by pd_cd;

--총미출고
select * from od_detail;
select sum(qt), pd_cd
from od_detail
where send_od_st = 1
group by pd_cd;

-- 2주예상생산
select pdt_plan_cd, wk_plan_stt_dt
                        from pdtplan
                        where wk_plan_stt_dt > sysdate
                            AND wk_plan_stt_dt < TO_DATE(NEXT_DAY(sysdate+ 21 , '월'))  --7, 14, 21 숫자변경
/
(select sum(ld.qt/12) as "2주예상생산", ld.pd_cd
from pdt_plan_detail ld
     JOIN ( select pdt_plan_cd, wk_plan_stt_dt
                        from pdtplan
                        where wk_plan_stt_dt > sysdate
                            AND wk_plan_stt_dt < TO_DATE(NEXT_DAY(sysdate+ 14 , '월')) ) l --2주(14일)
    ON ld.pdt_plan_cd = l.pdt_plan_cd
group by ld.pd_cd);
/

--2주 미출고
select * from od_detail;
select sum(nsn.qt), nsn.pd_cd
from od_detail nsn 
    JOIN (select od_detailno, pd_cd
            from od_detail
            where send_od_st = 1
                and (due_dt -sysdate) <= 14) nsq
ON nsn.od_detailno = nsq.od_detailno
group by nsn.pd_cd;

--총재고+예상생산량 / 2주미출고 



select * from od order by od_no DESC;
select * from od_detail order by od_detailno DESC;

select * 
from pd_stk 
where pd_cd = 'PPR01'
    --AND qt>0
    --AND ADD_MONTHS(sysdate, 6) <= exp_dt
order by pd_lot;

select * from pd_stk;

SELECT DISTINCT NVL( (SELECT SUM(qt) as qt
                   FROM pd_stk 
                  WHERE pd_cd = 'PPR01' ) , 0) as qt
   -- INTO v_lot_sum
    FROM pd_stk
    --WHERE rownum = 1
/
    
select * from pd;
select * from mt;
select * from bom;
select * from disc_pd;
delete disc_pd;

-- 폐기할 LOT들
-- 롯트번호, 단위, 수량, 생산일, 유통기한, 제품코드, 생산상세번호
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PET01-230212-0011', 'box', 2, '23/02/12','24/02/12','PET01',27);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PBR01-230225-0011', 'box', 2, '23/02/25','24/02/25','PBR01',27);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PCB01-230302-0011', 'box', 2, '23/03/02','24/03/02','PCB01',27);

insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PPR01-231004-0011', 'box', 2, '23/10/04','24/10/04','PPR01',27);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PCT01-231229-0011', 'box', 2, '23/12/29','24/12/29','PCT01',27);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PET01-240108-0011', 'box', 2, '24/01/08','25/01/08','PET01',27);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PBR01-230202-0011', 'box', 2, '24/02/02','25/02/02','PBR01',27);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PCB01-240225-0011', 'box', 2, '24/02/25','25/02/25','PCB01',27);

insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PPR01-230610-0011', 'box', 2, '23/06/10','24/06/10','PPR01',27);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PCT01-231112-0011', 'box', 2, '23/11/12','24/11/12','PCT01',27);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PET01-240304-0011', 'box', 2, '24/03/04','25/03/04','PET01',27);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PBR01-240320-0011', 'box', 2, '24/03/20','25/03/20','PBR01',27);

insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PCB01-230909-0011', 'box', 2, '23/09/09','24/09/09','PCB01',27);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PPR01-230921-0011', 'box', 2, '23/09/21','24/09/21','PPR01',27);
insert into PD_STK(pd_lot, unit, qt, pdt_dt, exp_dt, pd_cd, pdt_inst_detail_no) 
VALUEs('PCT01-240120-0011', 'box', 2, '24/01/20','25/01/20','PCT01',27);

PET01 113000
PBR01 91000
PCB01 124000
PPR01 245333
PCT01 140666

--금일, 금주 전주 금월 전월15
--유통기한 만료3, 품질불량5, 파손4, 기타3
insert into disc_pd(disc_no, qt, cost, disc_dt, rsn, disc_chg, pd_lot)
values(disc_pd_seq.nextval, 2, 113000*2, '24/03/02', 1, '김민수',  'PET01-230212-0011');
insert into disc_pd(disc_no, qt, cost, disc_dt, rsn, disc_chg, pd_lot)
values(disc_pd_seq.nextval, 2, 91000*2, '24/03/24', 1, '김민수',  'PBR01-230225-0011');
insert into disc_pd(disc_no, qt, cost, disc_dt, rsn, disc_chg, pd_lot)
values(disc_pd_seq.nextval, 2, 124000*2, '24/03/28', 1, '김민수',  'PCB01-230302-0011');

insert into disc_pd(disc_no, qt, cost, disc_dt, rsn, disc_chg, pd_lot)
values(disc_pd_seq.nextval, 1, 245333, '24/03/04', 2, '김민수',  'PPR01-231004-0011');
insert into disc_pd(disc_no, qt, cost, disc_dt, rsn, disc_chg, pd_lot)
values(disc_pd_seq.nextval, 2, 140666*2, '24/03/11', 2, '김민수',  'PCT01-231229-0011');
insert into disc_pd(disc_no, qt, cost, disc_dt, rsn, disc_chg, pd_lot)
values(disc_pd_seq.nextval, 2, 113000*2, '24/03/19', 2, '김민수',  'PET01-240108-0011');
insert into disc_pd(disc_no, qt, cost, disc_dt, rsn, disc_chg, pd_lot)
values(disc_pd_seq.nextval, 2, 91000*2, '24/03/22', 2, '김민수',  'PBR01-230202-0011');
insert into disc_pd(disc_no, qt, cost, disc_dt, rsn, disc_chg, pd_lot)
values(disc_pd_seq.nextval, 2, 124000*2, '24/03/29', 2, '김민수',  'PCB01-240225-0011');

insert into disc_pd(disc_no, qt, cost, disc_dt, rsn, disc_chg, pd_lot)
values(disc_pd_seq.nextval, 1, 113000, '24/03/04', 3, '이철수',  'PPR01-230610-0011');
insert into disc_pd(disc_no, qt, cost, disc_dt, rsn, disc_chg, pd_lot)
values(disc_pd_seq.nextval, 1, 140666, '24/03/06', 3, '이철수',  'PCT01-231112-0011');
insert into disc_pd(disc_no, qt, cost, disc_dt, rsn, disc_chg, pd_lot)
values(disc_pd_seq.nextval, 1, 113000, '24/03/09', 3, '이철수',  'PET01-240304-0011');
insert into disc_pd(disc_no, qt, cost, disc_dt, rsn, disc_chg, pd_lot)
values(disc_pd_seq.nextval, 1, 91000, '24/03/11', 3, '이철수',  'PBR01-240320-0011');

insert into disc_pd(disc_no, qt, cost, disc_dt, rsn, disc_chg, pd_lot)
values(disc_pd_seq.nextval, 1, 124000, '24/03/19', 4, '김민수',  'PCB01-230909-0011');
insert into disc_pd(disc_no, qt, cost, disc_dt, rsn, disc_chg, pd_lot)
values(disc_pd_seq.nextval, 1, 245333, '24/03/24', 4, '김민수',  'PPR01-230921-0011');
insert into disc_pd(disc_no, qt, cost, disc_dt, rsn, disc_chg, pd_lot)
values(disc_pd_seq.nextval, 1, 140666, '24/03/28', 4, '이철수',  'PCT01-240120-0011');

select * from disc_pd;

select d.disc_no, d.qt, d.cost, d.disc_dt, d.rsn, FIND_CODE_NAME ('rsn', d.rsn)	AS reason , d.disc_chg, d.pd_lot, SUBSTR(d.pd_lot, 1, 5) as pd_cd,
p.pd_name
--,LAST_DAY(ADD_MONTHS(sysdate, -2)),LAST_DAY(ADD_MONTHS(sysdate, -1))
from disc_pd d JOIN pd p
ON SUBSTR(d.pd_lot, 1, 5) = p.pd_cd
where
d.disc_dt > LAST_DAY(ADD_MONTHS(sysdate, -2))
and d.disc_dt <= LAST_DAY(ADD_MONTHS(sysdate, -1))
--and SUBSTR(pd_lot, 1, 5) = 'PCT01'
order by d.disc_dt DESC
		 			, p.pd_cd
;
--금일, 금주 전주 금월 전월15
select * from disc_pd;

select c.rsn, sum(c.qt) as sum_qt, FIND_CODE_NAME ('rsn', c.rsn) AS reason 
from disc_pd d JOIN
(select disc_no, qt, cost, disc_dt, rsn, disc_chg, pd_lot, SUBSTR(pd_lot, 1, 5) as pd_cd
from disc_pd
--where SUBSTR(pd_lot, 1, 5) LIKE '%PET01%'
) c
ON d.disc_no = c.disc_no
group by c.rsn;


select case 
        when(due_dt - sysdate) <7
            then 2
        else 1
        end
        as dueColor
    from od_detail;
    
    
    
    SELECT LPAD(o.od_no, 5,0)||'-'||LPAD(d.od_detailno, 6, 0) as "no"
				, o.od_no
				, d.od_detailno
				, o.od_dt
				, c.cli_name
				, o.od_chg
				, p.pd_cd
				, p.pd_name
				, d.qt
				, d.due_dt
				, d.send_od_st
				, CASE WHEN(d.due_dt - sysdate) <7 then 2
				       ELSE 1
				       END
				  as due_color
		FROM od o 
		    JOIN od_detail d
		        ON o.od_no = d.od_no
		    JOIN cli c
		        ON c.cli_cd = o.cli_cd
		    JOIN pd p
		        ON p.pd_cd = d.pd_cd
		WHERE d.send_od_st = 1;
        
select * from od;



select DISTINCT d.pd_cd
									, p.pd_name
									, p.unit
									, st.total_stk as "curStk"
									, dn.total_not_send as "totalNotSend"
									, tl.tw_prdt as "twoWPrdt"
									, wn.tw_not_send as "twoWNotSend"
									, TRUNC((wn.tw_not_send/(st.total_stk + tl.tw_prdt)*100),1) as "possStats"
									, TRUNC(((st.total_stk + tl.tw_prdt)-wn.tw_not_send), 0) as "possTwoSend"
					from pd p JOIN od_detail d
				            	ON p.pd_cd = d.pd_cd
				              JOIN ( select sum(qt)/12 as total_stk
				              				, pd_cd
				                       from pd_stk
				                      where ADD_MONTHS(sysdate, 6) <= exp_dt
				                      group by pd_cd) st
				            	ON d.pd_cd = st.pd_cd
				              JOIN ( select sum(qt) as total_not_send
				              				, pd_cd
				                       from od_detail
				                      where send_od_st = 1
				                      group by pd_cd) dn
				            	ON d.pd_cd = dn.pd_cd
				              JOIN ( select sum(lan.qt/12) as tw_prdt
				            				, lan.pd_cd 
				                      from pdt_plan_detail lan JOIN ( select pdt_plan_cd
				                     										, wk_plan_stt_dt
							                                           from pdtplan
							                                          where wk_plan_stt_dt > sysdate
							                                                AND wk_plan_stt_dt < TO_DATE(NEXT_DAY(sysdate+ 14 , '월')) ) lnn
				              									ON lan.pdt_plan_cd = lnn.pdt_plan_cd
				                  group by lan.pd_cd) tl
				            	ON d.pd_cd = tl.pd_cd
				             JOIN (select sum(nsn.qt) as tw_not_send
				             			, nsn.pd_cd
				                     from od_detail nsn JOIN (select od_detailno
				                     								, pd_cd
								                                from od_detail
								                               where send_od_st = 1
								                                    and (due_dt -sysdate) <= 14) nsq
				                    					  ON nsn.od_detailno = nsq.od_detailno
				                    group by nsn.pd_cd) wn
				              ON d.pd_cd = wn.pd_cd
				order by d.pd_cd;
                
                
-- 총재고 총미출고 2주예상생산 2주미출고 2주예상출고가능량 
select * from pd_stk;
select sum(qt), pd_cd
from pd_stk
group by pd_cd;

select * from od_detail;
select o.pd_cd, t.total
from od_detail o JOIN (

select sum(qt) as total, pd_cd
from od_detail
where send_od_st =1
group by pd_cd) t
ON o.pd_cd = t.pd_cd
;

SELECT NVL((select sum(qt), pd_cd
from od_detail
where send_od_st =1
group by pd_cd ) , 0) as qt  
    FROM od_detail;

