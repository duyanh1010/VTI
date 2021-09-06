CREATE DATABASE Testing_System_Assignment_1;
USE Testing_System_Assignment_1;
CREATE TABLE Department(
	 DepartmentID 	TINYINT,
	 DepartmentName VARCHAR(50)
);
CREATE TABLE `Position`(
	PositionID 		TINYINT ,
    PositionName 	ENUM('Dev', 'Test', 'Scrum Master', 'PM')
);
CREATE TABLE `Account`(
	AccountID 		INT,
	Email 			VARCHAR(50),
	Username 		VARCHAR(50),
	FullName 		VARCHAR(50),
	DepartmentID 	TINYINT,
	PositionID 		TINYINT,
	CreateDate 		DATE
);
CREATE TABLE `Group`(
	GroupID 		INT,
	GroupName 		VARCHAR(50),
	CreatorID 		INT,
	CreateDate 		DATE
);
CREATE TABLE GroupAccount(
	GroupID 		INT,
    AccountID		INT,
    JoinDate		DATE
);
CREATE TABLE TypeQuestion(
	TypeID			TINYINT,
    TypeName		ENUM('Essay', 'Multiple-Choice')
);
CREATE TABLE CategoryQuestion(
	CategoryID 		TINYINT,
    CategoryName	VARCHAR(50)
);
CREATE TABLE Question(
	QuestionID 		INT,
    Content			VARCHAR(1000),
    CategoryID		TINYINT,
    TypeID			TINYINT,
    CreatorID		INT,
    CreateDate		DATE
);
CREATE TABLE Answer(
	AnswerID 		INT,
    Contenr			VARCHAR(1000),
    QuestionID		INT,
    isCorrect		ENUM('T','F')
    -- 				BIT
);
CREATE TABLE Exam(
	ExamID			INT,
    `Code`			INT,
    Title			VARCHAR(100),
    CategoryID		TINYINT,
    Duration 		TIME,
    CreatorID		INT,
    CreateDate		DATE
);
CREATE TABLE ExamQuestion(
	ExamID			INT,
    QuestionID		INT
);
