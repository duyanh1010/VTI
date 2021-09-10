DROP DATABASE IF EXISTS Testing_System_Assignment_2;
CREATE DATABASE Testing_System_Assignment_2;
USE Testing_System_Assignment_2;
DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
	 DepartmentID 	TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	 DepartmentName VARCHAR(50) UNIQUE KEY 
     
);
DROP TABLE IF EXISTS `Position`;
CREATE TABLE `Position`(
	PositionID 		TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT ,
    PositionName 	ENUM('Dev', 'Test', 'Scrum Master', 'PM')
);
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	AccountID 		INT UNSIGNED PRIMARY KEY AUTO_INCREMENT ,
	Email 			VARCHAR(50) UNIQUE KEY,
	Username 		VARCHAR(50) UNIQUE KEY ,
	FullName 		VARCHAR(50) NOT NULL,
	DepartmentID 	TINYINT 	UNSIGNED NOT NULL,
	PositionID 		TINYINT 	UNSIGNED NOT NULL,
	CreateDate 		DATETIME DEFAULT NOW(),
    FOREIGN KEY (DepartmentID) 	REFERENCES  Department( DepartmentID) ON DELETE CASCADE,
    FOREIGN KEY (PositionID) 	REFERENCES  `Position`(PositionID) ON DELETE CASCADE
    
);
DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group`(
	GroupID 		INT UNSIGNED PRIMARY KEY AUTO_INCREMENT ,
	GroupName 		VARCHAR(50)  UNIQUE KEY  ,
	CreatorID 		INT UNSIGNED NOT NULL,
	CreateDate 		DATETIME DEFAULT NOW(),
    FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID) ON DELETE CASCADE
);
DROP TABLE IF EXISTS GroupAccount;
CREATE TABLE GroupAccount(
	GroupID 		INT 	UNSIGNED,
    AccountID		INT 	UNSIGNED,
    JoinDate		DATETIME	DEFAULT NOW(),
    PRIMARY KEY	(GroupID,AccountID),
    FOREIGN KEY (GroupID) 	REFERENCES `Group`(GroupID) ON DELETE CASCADE,
    FOREIGN KEY (AccountID) REFERENCES `Account`(AccountID) ON DELETE CASCADE
);
DROP TABLE IF EXISTS TypeQuestion ;
CREATE TABLE TypeQuestion(
	TypeID			TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    TypeName		ENUM('Essay', 'Multiple-Choice')
);
DROP TABLE IF EXISTS CategoryQuestion ;
CREATE TABLE CategoryQuestion(
	CategoryID 		TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    CategoryName	VARCHAR(50) NOT NULL
);
DROP TABLE IF EXISTS Question ;
CREATE TABLE Question(
	QuestionID 		INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    Content			VARCHAR(1000) NOT NULL,
    CategoryID		TINYINT UNSIGNED NOT NULL,
    TypeID			TINYINT UNSIGNED NOT NULL,
    CreatorID		INT 	UNSIGNED NOT NULL,
    CreateDate		DATETIME DEFAULT NOW(),
    FOREIGN KEY (CategoryID) 	REFERENCES CategoryQuestion(CategoryID) ON DELETE CASCADE,
    FOREIGN KEY (TypeID)		REFERENCES TypeQuestion(TypeID) ON DELETE CASCADE,
    FOREIGN KEY (CreatorID)		REFERENCES `Account`(AccountID) ON DELETE CASCADE
);
DROP TABLE IF EXISTS  Answer ;
CREATE TABLE Answer(
	AnswerID 		INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    Content			VARCHAR(1000) NOT NULL,
    QuestionID		INT UNSIGNED NOT NULL,
    isCorrect		ENUM('T','F'),
    -- 				BIT
    FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID) ON DELETE CASCADE
);
DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam(
	ExamID			INT 	UNSIGNED PRIMARY KEY  AUTO_INCREMENT ,
    `Code`			CHAR(4) NOT NULL,
    Title			VARCHAR(100),
    CategoryID		TINYINT UNSIGNED NOT NULL,
    Duration 		TIME NOT NULL ,
    CreatorID		INT 	UNSIGNED NOT NULL,
    CreateDate		DATETIME	DEFAULT NOW(),
    FOREIGN KEY (CategoryID) 	REFERENCES CategoryQuestion(CategoryID) ON DELETE CASCADE ,
	FOREIGN KEY (CreatorID)		REFERENCES `Account`(AccountID) ON DELETE CASCADE
);
CREATE TABLE ExamQuestion(
	ExamID			INT UNSIGNED,
    QuestionID		INT UNSIGNED,
    PRIMARY KEY (ExamID,QuestionID),
    FOREIGN KEY (ExamID)	REFERENCES Exam(ExamID) ON DELETE CASCADE,
    FOREIGN KEY (QuestionID)REFERENCES Question(QuestionID) ON DELETE CASCADE
);
INSERT INTO Department(DepartmentName) 	VALUES ('Marketing'),('Sale'),('Bao Ve'),('Nhan Su'),('Ky Thuat'),
											   ('Tai Chinh'),('Pho Giam Doc'),('Giam Doc'),('Thu Ky'),('Ban Hang');
-- SELECT*FROM Department;
INSERT INTO `Position`(PositionName) 	VALUES ('Dev'), ('Test'), ('Scrum Master'), ('PM');	
-- SELECT*FROM 	`Position`;
INSERT INTO `Account`(Email,Username,FullName,DepartmentID,PositionID) 
VALUES ('duyanhr01@gmail.com','Anh','NguyenDuyAnh',1,1),
	   ('trung@gmail.com','Trung','Phan Thai Trung',2,3),
       ('huong@gmail.com','Huong','Nguyen Duy Huong',3,1),
	   ('linh@gmail.com','Linh','Phan My Linh',1,3),
       ('hue@gmail.com','Hue','Nguyen Hue',3,3),
       ('kim@gmail.com','DuKimHo','Kim Kim',5,2),
       ('hoa@gmail.com','hoavti','Nguyen Hoa',8,1),
       ('lam@gmail.com','lamnd','Nguyen Thi Thanh Lam',7,2),
       ('Hoang@gmail.com','Hoangpq','Phung Quynh Hoang',2,4),
       ('Chung@gmail.com','ChungPK','Phung Kien Chung',6,3);
-- SELECT*FROM `Account`;
INSERT INTO `Group`(GroupName,CreatorID,CreateDate) 	
VALUES 											   ('ADN LAND',1,'2019-12-20'), ('Home88',4,'2020-11-11'), ('AD Homes',2,'2018-2-2'),
												   ('HD Group',3,'2019-2-3'), ('Kim Cuong',6,'2021-1-2'), ('Lap Trinh Vien',6,'2019-4-6'),
                                                   ('Tuyen Dung',7,'2020-11-2'),('Ke Toan ',9,'2019-8-5'),('Bao ve',5,'2019-12-19'),('Noi Bo',6,'2019-12-18');
-- SELECT*FROM `Group`;

INSERT INTO GroupAccount(GroupID,AccountID) VALUES (1,1),(1,2),(2,2),(2,3),(3,1),(3,3),(4,3),(5,5),(6,1),(7,8);

-- SELECT*FROM  GroupAccount;
INSERT INTO TypeQuestion(TypeName) 			VALUES ('Essay'),('Multiple-Choice');
-- SELECT *FROM TypeQuestion;
INSERT INTO CategoryQuestion(CategoryName) 	VALUES ('Java'),('SQL'),('Ruby'),('Postman'),('PHP'),
												   ('Nodejs'),('React js'),('Mongo db'),('Python'),('Blockchain');
-- SELECT*FROM CategoryQuestion;
INSERT INTO Question(Content,CategoryID,TypeID,CreatorID)VALUES ('cau hoi Java day la noi dung content dau tien ',1,1,2),
																('tai sao ban hoc SQL day la noi dung content   ',2,2,2),
																('tai sao ban hoc Ruby day la noi dung content   ',3,1,2),
																('tai sao ban hoc Postman day la noi dung content   ',4,2,1),
																('cau hoi ban hoc PHP day la noi dung content ',5,1,1),
																('tai sao ban hoc Nodejs day la noi dung content  ',6,2,2);
																
                                                               
INSERT INTO Question(Content,CategoryID,TypeID,CreatorID,CreateDate)
VALUES 															('tai sao ban hoc Blockchain day la noi dung content  ',9,1,6,'2019-12-12'),
																('tai sao ban hoc React js day la noi dung content  ',8,2,4,'2019-1-1'),
																('tai sao ban hoc Mongo db day la noi dung content  ',9,1,8,'2020-2-2'),
																('tai sao ban hoc Python day la noi dung content  ',5,2,5,'2019-8-9');
-- SELECT*FROM Question;
INSERT INTO Answer(Content,QuestionID,isCorrect) 		 VALUES ('Java day la noi dung cau tra loi cho cau hoi cau hoi ',1,'T'),
																('SQL day la noi dung cau tra loi cho cau hoi sao ban hoc ',2,'F'),
																('Ruby day la noi dung cau tra loi cho cau hoi sao ban hoc ',3,'F'),
																('Postman day la noi dung cau tra loi cho cau hoi sao ban hoc ',4,'T'),
																('PHP day la noi dung cau tra loi cho cau hoi sao ban hoc',5,'F'),
																('Nodejs day la noi dung cau tra loi cho cau hoi sao ban hoc   ',7,'T'),
																('React js day la noi dung cau tra loi cho cau hoi sao ban hoc   ',6,'T'),
																('Mongo db  day la noi dung cau tra loi cho cau hoi sao ban hoc   ',8,'T'),
																('Python  day la noi dung cau tra loi cho cau hoi sao ban hoc   ',9,'T'),
																('Blockchain 1 la noi dung cau tra loi cho cau hoi sao ban hoc   ',10,'T'),
                                                                ('Blockchain 2 la noi dung cau tra loi cho cau hoi sao ban hoc   ',10,'F'),
                                                                ('Blockchain 3 la noi dung cau tra loi cho cau hoi sao ban hoc   ',10,'F'),
                                                                ('Blockchain 4 la noi dung cau tra loi cho cau hoi sao ban hoc   ',10,'F'),
                                                                ('Blockchain 5 la noi dung cau tra loi cho cau hoi sao ban hoc   ',10,'F');
-- SELECT*FROM Answer;
INSERT INTO Exam(`Code`,Title,CategoryID,Duration,CreatorID) 
VALUES 															('11AE','Tieu de bai thi 11 ', 2,3000,2),
																('PC11','Tieu de bai thi 12 ', 4,20000,1),
																('F855','Tieu de bai thi 13 ', 1,5000,3),
																('HH04','Tieu de bai thi 14 ', 3,3000,5),
																('S102','Tieu de bai thi 15 ', 3,10000,5),
																('992E','Tieu de bai thi 16 ', 4,4000,8),
																('UQ21','Tieu de bai thi 17 ', 4,5000,9);
INSERT INTO Exam(`Code`,Title,CategoryID,Duration,CreatorID,CreateDate)
VALUES 									
																('DA88','Tieu de bai thi 18 ', 4,55000,10,'2019-12-20'),
																('HA67','Tieu de bai thi 19 ', 4,40000,2,'2018-1-1'),
																('QP12','Tieu de bai thi 20 ', 4,10000,4,'2019-12-10');
 SELECT*FROM Exam;
INSERT INTO ExamQuestion(ExamID,QuestionID) VALUES (1,2),(1,3),(2,2),(3,4),(2,3),(5,6),(5,5),(10,10),(2,7),(6,6),(8,9),(8,6);
-- SELECT*FROM ExamQuestion;