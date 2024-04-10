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
--where o.od_dt BETWEEN TO_DATE('2024-04-20', 'YYYY-MM-DD') AND TO_DATE('2025-01-01', 'YYYY-MM-DD')
--where (o.od_dt >= TO_DATE('2024-04-20', 'YYYY-MM-DD')) AND (o.od_dt <= TO_DATE('2025-01-01', 'YYYY-MM-DD'))
WHERE 
d.pd_cd like '%P%'
AND p.pd_name like '% %'
AND o.cli_cd like '%0%'
--AND c.cli_name like '%
AND c.cli_chg like '% %'
--AND o.od_chg like '%
AND o.od_dt >= TO_DATE('2023-01-01', 'YYYY-MM-DD')
AND o.od_dt <= TO_DATE('2025-01-01', 'YYYY-MM-DD') 			
AND d.due_dt >= TO_DATE('2023-01-01', 'YYYY-MM-DD') 			
AND d.due_dt <= TO_DATE('2025-01-01', 'YYYY-MM-DD') 			
AND d.od_detail_st IN (0,1,2)
ORDER BY d.od_detailno;



select o.OD_NO, o.OD_DT, o.OD_CHG, o.DC_RATE, o.TOTAL_PRICE, o.CLI_CD,
        c.cli_name,c.cli_chg,
        d.od_no,d.od_detailno,
        p.pd_name,d.due_dt,d.od_detail_st,d.pd_cd
from cli c JOIN od o
                ON c.cli_cd = o.cli_cd
            JOIN (select count(*) as cnt, od_no
                    from od_detail
                    group by od_no) c
                ON o.od_no = c.od_no
                
            JOIN (select od.pd_cd, od.od_no, od.od_detailno, od.due_dt, od.od_detail_st,
                        op.pd_name, op.pd_cd
                    from od_detail od JOIN pd op
                    ON od.pd_cd = op.pd_cd
                    WHERE ROWNUM <= 1 ) d
                ON o.od_no = od.od_no;
                
                
select o.OD_NO, o.OD_DT, o.OD_CHG, o.DC_RATE, o.TOTAL_PRICE, o.CLI_CD,
        c.cli_name,c.cli_chg,
        d.od.od_no,d.od.od_detailno,
        p.pd_name,d.od.due_dt,d.od.od_detail_st,d.od.pd_cd, cd.cnt
from cli c JOIN od o
                ON c.cli_cd = o.cli_cd
            JOIN (select count(*) as cnt, od_no
                    from od_detail
                    group by od_no) cd
                ON o.od_no = cd.od_no
                
            JOIN (select od.pd_cd, od.od_no, od.od_detailno, od.due_dt, od.od_detail_st,
                        op.pd_name, op.pd_cd
                    from od_detail od JOIN pd op
                    ON od.pd_cd = op.pd_cd
                    WHERE ROWNUM <= 1 ) d
                ON o.od_no = od.od_no;


select distinct o.OD_NO, o.OD_DT, o.OD_CHG, o.DC_RATE, o.TOTAL_PRICE, o.CLI_CD,
        c.cli_name,c.cli_chg,
        d.od_no,
        --d.pd_name,d.pd_cd,
        d.due_dt,d.od_detail_st,
        t.od_cnt
from cli c JOIN od o 
                ON c.cli_cd = o.cli_cd
            JOIN (select ((count(*))||'건') as od_cnt, od_no
                                    from od_detail
                                    group by od_no) t
                ON o.od_no = t.od_no
            JOIN (select od.od_no od_no, od.pd_cd pd_cd, od.due_dt due_dt, od.od_detail_st od_detail_st, op.pd_name pd_name
                    from od_detail od JOIN pd op
                    ON od.pd_cd = op.pd_cd
                    ) d
                ON o.od_no = d.od_no
ORDER BY o.od_no;

            
select ('외 '||(count(*)-1)||'건') as cnt, od_no
from od_detail
where od_no = 87
group by od_no;
--having od_no = 87; 

select od.od_no, od.pd_cd, od.due_dt, od_detail_st, op.pd_name
from od_detail od JOIN pd op
ON od.pd_cd = op.pd_cd
WHERE ROWNUM <= 1;

select od.od_no, od.pd_cd, od.due_dt, od_detail_st, op.pd_name
from od_detail od JOIN pd op
ON od.pd_cd = op.pd_cd
;




select od_no, pd_cd, due_dt, od_detail_st
from od_detail
GROUP BY od_no;

select * from od;
select * from od_detail
order by od_detailno;         




select distinct o.od_no
						, o.od_dt
						, o.od_chg
						, o.dc_rate
						, o.total_price
						, o.cli_cd
						, c.cli_name
						, c.cli_chg
						, d.od_no
						,
				        
				        d.due_dt
				        , d.od_detail_st
				        , t.od_cnt
		from cli c JOIN od o 
                		ON c.cli_cd = o.cli_cd
            		JOIN (select ((count(*))||'건') as od_cnt, od_no
                          from od_detail
                          group by od_no) t
                		ON o.od_no = t.od_no
            		JOIN (select od.od_no od_no
            					, od.pd_cd pd_cd
            					, od.due_dt due_dt
            					, od.od_detail_st od_detail_st
            					, op.pd_name pd_name
                    		from od_detail od JOIN pd op
                    							ON od.pd_cd = op.pd_cd
                    		) d
                		ON o.od_no = d.od_no;
                        
                        
                    

/* 재고관리 페이지 - 전체 재고 조회 */
select * from pd;
select * from pd_stk;

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


--화면에 보일 정보만 추리기
select de.od_no, o.od_dt, c.cli_name, c.cli_chg ,   
        CASE WHEN (de.cnt > 0) THEN p.pd_name || ' 외 ' || de.cnt || '건'
             ELSE p.pd_name
             END AS pdName  ,
        o.total_price,  d.due_dt,
        CASE (d.od_detail_st)
            WHEN 1 THEN '주문접수' 
            WHEN 2 THEN '생산요청'
            WHEN 3 THEN '출고완료'
            WHEN 4 THEN '구매확정'
            WHEN 5 THEN '반품접수'
            WHEN 9 THEN '반품완료'
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
ORDER BY de.od_no DESC;

