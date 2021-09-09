DROP DATABASE IF EXISTS  Testing_System_Assignment_1;
CREATE DATABASE Testing_System_Assignment_1;
USE Testing_System_Assignment_1;
DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
	 DepartmentID 	TINYINT,
	 DepartmentName VARCHAR(50)
     
);
DROP TABLE IF EXISTS `Position`;
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
	CreateDate 		DATETIME
);
CREATE TABLE `Group`(
	GroupID 		INT,
	GroupName 		VARCHAR(50),
	CreatorID 		INT,
	CreateDate 		DATETIME
);
CREATE TABLE GroupAccount(
	GroupID 		INT,
    AccountID		INT,
    JoinDate		DATETIME
);
CREATE TABLE TypeQuestion(
	TypeID			TINYINT,
    TypeName		ENUM('Essay', 'Multiple-Choice')
);
CREATE TABLE CategoryQuestion(
	CategoryID 		TINYINT,
    CategoryName	VARCHAR(50)
);
DROP TABLE IF EXISTS Question;
CREATE TABLE Question(
	QuestionID 		INT,
    Content			VARCHAR(1000),
    CategoryID		TINYINT,
    TypeID			TINYINT,
    CreatorID		INT,
    CreateDate		DATETIME
);
DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer(
	AnswerID 		INT,
    Contenr			VARCHAR(1000),
    QuestionID		INT,
    isCorrect		ENUM('T','F')
    -- 				BIT
);
DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam(
	ExamID			INT,
    `Code`			INT,
    Title			VARCHAR(100),
    CategoryID		TINYINT,
    Duration 		TIME,
    CreatorID		INT,
    CreateDate		DATETIME
);
CREATE TABLE ExamQuestion(
	ExamID			INT,
    QuestionID		INT
);
