DROP DATABASE IF EXISTS Testing_System_Assignment_2;
CREATE DATABASE Testing_System_Assignment_2;
USE Testing_System_Assignment_2;
DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
	 DepartmentID 	TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	 DepartmentName VARCHAR(50) UNIQUE KEY -- CHECK(length(FullName)>5)
     
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
    FOREIGN KEY (DepartmentID) 	REFERENCES  Department( DepartmentID),
    FOREIGN KEY (PositionID) 	REFERENCES  `Position`(PositionID)
    
);
DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group`(
	GroupID 		INT UNSIGNED PRIMARY KEY AUTO_INCREMENT ,
	GroupName 		VARCHAR(50)  UNIQUE KEY  ,
	CreatorID 		INT UNSIGNED NOT NULL,
	CreateDate 		DATETIME DEFAULT NOW(),
    FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID)
);
DROP TABLE IF EXISTS GroupAccount;
CREATE TABLE GroupAccount(
	GroupID 		INT 	UNSIGNED,
    AccountID		INT 	UNSIGNED,
    JoinDate		DATETIME	DEFAULT NOW(),
    PRIMARY KEY	(GroupID,AccountID),
    FOREIGN KEY (GroupID) 	REFERENCES `Group`(GroupID),
    FOREIGN KEY (AccountID) REFERENCES `Account`(AccountID)
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
    FOREIGN KEY (CategoryID) 	REFERENCES CategoryQuestion(CategoryID),
    FOREIGN KEY (TypeID)		REFERENCES TypeQuestion(TypeID),
    FOREIGN KEY (CreatorID)		REFERENCES `Account`(AccountID)
);
DROP TABLE IF EXISTS  Answer ;
CREATE TABLE Answer(
	AnswerID 		INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    Content			VARCHAR(1000) NOT NULL,
    QuestionID		INT UNSIGNED NOT NULL,
    isCorrect		ENUM('T','F'),
    -- 				BIT
    FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID)
);
DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam(
	ExamID			INT 	UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `Code`			INT 	UNSIGNED NOT NULL,
    Title			VARCHAR(100),
    CategoryID		TINYINT UNSIGNED NOT NULL,
    Duration 		TIME NOT NULL ,
    CreatorID		INT 	UNSIGNED NOT NULL,
    CreateDate		DATETIME	DEFAULT NOW(),
    FOREIGN KEY (CategoryID) 	REFERENCES CategoryQuestion(CategoryID),
	FOREIGN KEY (CreatorID)		REFERENCES `Account`(AccountID)
);
CREATE TABLE ExamQuestion(
	ExamID			INT UNSIGNED,
    QuestionID		INT UNSIGNED,
    PRIMARY KEY(ExamID,QuestionID),
    FOREIGN KEY (ExamID)	REFERENCES Exam(ExamID),
    FOREIGN KEY (QuestionID)REFERENCES Question(QuestionID)
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
       ('hue@gmail.com','Hue','Nguyen Thi Hue',3,3),
       ('kim@gmail.com','Kim','Kim Kim',2,2);
-- SELECT*FROM `Account`;
INSERT INTO `Group`(GroupName,CreatorID) 	VALUES ('ADN LAND',1), ('Home88',4), ('AD Homes',2),
												   ('HD Group',3), ('Kim Cuong',6), ('Lap Trinh Vien',6);
-- SELECT*FROM `Group`;

INSERT INTO GroupAccount(GroupID,AccountID) VALUES (1,1),(1,2),(2,2),(2,3),(3,1),(3,3),(4,3),(5,5),(6,1);
-- SELECT*FROM  GroupAccount;
INSERT INTO TypeQuestion(TypeName) 			VALUES ('Essay'),('Multiple-Choice');
-- SELECT *FROM TypeQuestion;
INSERT INTO CategoryQuestion(CategoryName) 	VALUES ('Java'),('SQL'),('Ruby'),('Postman'),('PHP'),('Nodejs');
-- SELECT*FROM CategoryQuestion;
INSERT INTO Question(Content,CategoryID,TypeID,CreatorID) VALUES ('cau hoi Java day la noi dung content dau tien ',1,1,2),
																 ('tai sao ban hoc SQL day la noi dung content   ',2,2,2),
                                                                 ('tai sao ban hoc Ruby day la noi dung content   ',3,1,2),
                                                                 ('tai sao ban hoc Postman day la noi dung content   ',4,2,1),
                                                                 ('tai sao ban hoc PHP day la noi dung content ',5,1,1),
                                                                 ('tai sao ban hoc Nodejs day la noi dung content  ',6,2,2);
-- SELECT*FROM Question;
INSERT INTO Answer(Content,QuestionID,isCorrect) VALUES ('Java day la noi dung cau tra loi cho cau hoi cau hoi ',1,'T'),
														('SQL day la noi dung cau tra loi cho cau hoi sao ban hoc ',2,'F'),
                                                        ('Ruby day la noi dung cau tra loi cho cau hoi sao ban hoc ',3,'F'),
                                                        ('Postman day la noi dung cau tra loi cho cau hoi sao ban hoc ',4,'T'),
                                                        ('PHP day la noi dung cau tra loi cho cau hoi sao ban hoc',5,'F'),
														('Nodejsday la noi dung cau tra loi cho cau hoi sao ban hoc   ',6,'T');
-- SELECT*FROM Answer;
INSERT INTO Exam(`Code`,Title,CategoryID,Duration,CreatorID) VALUES (11,'Tieu de bai thi 11 ', 2,3000,2),
																	(12,'Tieu de bai thi 12 ', 4,2000,1),
                                                                    (13,'Tieu de bai thi 13 ', 1,5000,3),
                                                                    (14,'Tieu de bai thi 14 ', 3,3000,5),
                                                                    (15,'Tieu de bai thi 15 ', 3,1000,5),
                                                                    (16,'Tieu de bai thi 16 ', 4,5000,2);
-- SELECT*FROM Exam;
INSERT INTO ExamQuestion(ExamID,QuestionID) VALUES (1,2),(1,3),(2,2),(3,4),(2,3),(5,6),(5,5);
-- SELECT*FROM ExamQuestion;