CREATE TABLE userDTO(
id VARCHAR2(10),
name VARCHAR2(15),
cash NUMBER,
point NUMBER
)


CREATE TABLE buybook(
userid VARCHAR2(10),
buybookcode NUMBER
)


CREATE TABLE book(
code NUMBER,
name VARCHAR2(30),
genre VARCHAR2(15),
price NUMBER
)

CREATE TABLE fkgn(
fkgn VARCHAR2(15)
)

INSERT INTO fkgn VALUES ('�ܱ���')
INSERT INTO fkgn VALUES ('�ι���')
INSERT INTO fkgn VALUES ('�ڱ���')
INSERT INTO fkgn VALUES ('�����濵')
INSERT INTO fkgn VALUES ('��ȭ')
INSERT INTO fkgn VALUES ('���')
INSERT INTO fkgn VALUES ('�丮')
INSERT INTO fkgn VALUES ('����')
INSERT INTO fkgn VALUES ('����')
INSERT INTO fkgn VALUES ('����')
INSERT INTO fkgn VALUES ('�Ҽ�')
INSERT INTO fkgn VALUES ('������')



ALTER TABLE userDTO ADD CONSTRAINT pk_userDTO_id PRIMARY KEY(id)
ALTER TABLE book ADD CONSTRAINT pk_book_id PRIMARY KEY(code)
ALTER TABLE fkgn ADD CONSTRAINT pk_fkgn_id PRIMARY KEY(fkgn)
ALTER TABLE book ADD CONSTRAINT fk_book_genre FOREIGN key(genre) REFERENCES fkgn(fkgn)

SELECT * FROM userDTO
SELECT * FROM book



INSERT INTO book VALUES (1,'���̾� ��ȭ���� ����','�Ҽ�',12000)
INSERT INTO book VALUES (2,'������ ���� ����','�Ҽ�',8000)
INSERT INTO book VALUES (3,'�Ŵ�','�Ҽ�',13000)
