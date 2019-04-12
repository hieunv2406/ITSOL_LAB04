CREATE TABLE ACCOUNT
(
	account varchar(20) primary key,
	first_Name varchar(20) not null,
	last_Name varchar(20) not null,
	email varchar(20)
	
)

CREATE table STUDENT
(
	id VARCHAR(20) primary key,
	studentName varchar(20) not null,
	account VARCHAR(20);
	studentEmail varchar(30),
	phoneNumber number,
	StudentClass varchar(20),
	note VARCHAR(50)
	)
	
ALTER TABLE STUDENT
ADD constraint fk_student_account foreign key (account_id) references ACCOUNT (account_id);
