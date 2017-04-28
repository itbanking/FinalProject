set termout on
set echo on

--
-- drop table
--

drop table memo;

--
--  sequence
--
drop sequence memo_mno_seq;
create sequence memo_mno_seq start with 100;

select memo_seq.nextval from dual; 
--
-- create table
--

create table memo (
	mno				number(5) constraint pk_memo primary key,
	mname			varchar2(100) not null,
	mcontent 		varchar2(4000),
	mdate 			date,
	membersrl 		number(10) constraint fk_membersrl2 references member(membersrl) on delete set null
);


--
-- insert into memo
--

insert into memo values  (memo_mno_seq.nextval, 'test_name', 'test_content', sysdate, 1);

--
-- commit;
--

commit;

--
-- select
--

set linesize 200
set pagesize 100

select table_name from user_tables;

select * from memo;


SET TERMOUT ON
SET ECHO ON
