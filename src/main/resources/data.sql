
/* 회원 샘플 데이터 */
insert into member(memail, mpassword, mname)
values('qwe1','1234','유재석')
,('qwe2','1234','하하')
,('qwe3','1234','강호동')
,('qwe4','1234','서장훈');

/* 보드 샘플 데이터 */
insert into board(bcontent, mno_fk)
values('게시물내용1', 1),
('게시물내용2', 2),
('게시물내용3', 3),
('게시물내용4', 4),
('게시물내용5', 1),
('게시물내용6', 1);

/* 댓글 샘플 데이터 */
insert
    into reply(rcontent, bno_fk, mno_fk)
    values('댓글내용1',1,1),
    ('댓글내용1',1,1),
    ('댓글내용1',2,2),
    ('댓글내용1',3,1),
    ('댓글내용1',4,2),
    ('댓글내용1',3,4),
    ('댓글내용1',1,4);

/* 게시물 사진 샘플 데이터 */
insert
    into boardimg(filename, bno)
     values('1.jpg',1),
    ('2.jpg',1),
    ('3.jpg',2),
    ('4.jpg',3),
    ('5.jpg',4),
    ('6.jpg',5),
    ('7.jpg',6);