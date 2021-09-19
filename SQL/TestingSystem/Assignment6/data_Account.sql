/*============================== CREATE DATABASE =======================================*/
/*======================================================================================*/
DROP DATABASE IF EXISTS TestingSystemLab3_SpringJPA;
CREATE DATABASE TestingSystemLab3_SpringJPA;
USE TestingSystemLab3_SpringJPA;

/*============================== CREATE TABLE=== =======================================*/
/*======================================================================================*/

-- create table 1: Department
DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
	DepartmentID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName 			NVARCHAR(30) NOT NULL UNIQUE KEY
);

-- create table 2: Posittion
DROP TABLE IF EXISTS Position;
CREATE TABLE `Position` (
	PositionID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    PositionName			ENUM('Dev','Test','Scrum_Master','PM') NOT NULL UNIQUE KEY
);


-- create table 3: Account
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	AccountID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email					VARCHAR(50) NOT NULL UNIQUE KEY,
    Username				VARCHAR(50) NOT NULL UNIQUE KEY,
	`Password` 				VARCHAR(100) NULL,
    FullName				NVARCHAR(50) NOT NULL,
    DepartmentID 			TINYINT UNSIGNED,
    PositionID				TINYINT UNSIGNED,
    CreateDate				DATETIME DEFAULT NOW(),
     `role` 				VARCHAR(100) DEFAULT 'User',
     `status`				TINYINT DEFAULT 0,  -- 0: Not Active, 1: Active
     `PathImage` 			VARCHAR(50),
    FOREIGN KEY(DepartmentID) REFERENCES Department(DepartmentID),
    FOREIGN KEY(PositionID) REFERENCES `Position`(PositionID)
);

DROP TABLE IF EXISTS 	`Registration_User_Token`;
CREATE TABLE IF NOT EXISTS `Registration_User_Token` ( 	
	id 				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`token`	 		CHAR(36) NOT NULL UNIQUE,
	`user_id` 		SMALLINT UNSIGNED NOT NULL,
	`expiryDate` 	DATETIME NOT NULL
);


/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data Department
INSERT INTO Department(DepartmentName) 
VALUES
						(N'Marketing'	),
						(N'Sale'		),
						(N'Bảo vệ'		),
						(N'Nhân sự'		),
						(N'Kỹ thuật'	),
						(N'Tài chính'	),
						(N'Phó giám đốc'),
						(N'Giám đốc'	),
						(N'Thư kí'		),
						(N'Bán hàng'	);
    
-- Add data position
INSERT INTO Position	(PositionName	) 
VALUES 					('Dev'			),
						('Test'			),
						('Scrum_Master'	),
						('PM'			); 


-- Add data Account
INSERT INTO `Account`(Email								, Username			,`Password`															, FullName				, DepartmentID	, PositionID, CreateDate	, `role`	, `status`)
VALUES 				('Email01@gmail.com'				, 'quanganh'		,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'		,'Fullname01'				,   '5'			,   '1'		,'2020-03-05', 'Manager',1),
					('Email02@gmail.com'				, 'vanchien'		,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'		,'Fullname02'				,   '1'			,   '2'		,'2020-07-05','User'	,0),
                    ('Email03@gmail.com'				, 'Username03'		,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'		,'Fullname03'				,   '2'			,   '2'		,'2021-07-07','User'	,0),
                    ('Email04@gmail.com'				, 'Username04'		,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'		,'Fullname04'				,   '3'			,   '4'		,'2020-03-08','User'	,0),
                    ('Email05@gmail.com'				, 'Username05'		,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'		,'Fullname05'				,   '4'			,   '4'		,'2020-03-10','User'	,0),
                    ('Email06@gmail.com'				, 'Username06'		,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'		,'Fullname06'				,   '6'			,   '3'		,'2021-07-15','User'	,0),
                    ('Email07@gmail.com'				, 'Username07'		,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'		,'Fullname07'				,   '2'			,   '2'		,'2021-07-25','User'	,0),
                    ('Email08@gmail.com'				, 'Username08'		,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'		,'Fullname08'				,   '8'			,   '1'		,'2020-06-07','User'	,0),
                    ('Email09@gmail.com'				, 'Username09'		,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'		,'Fullname09'				,   '2'			,   '2'		,'2020-04-07','User'	,0),
                    ('Email10@gmail.com'				, 'Username10'		,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'		,'Fullname10'				,   '1'			,   '1'		,'2021-07-09','User'	,0),
					('Email11@gmail.com'				, 'Username11'		,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'		,'Fullname10'				,   '2'			,   '3'		,'2021-07-09','User'	,0), 
					('Email12@gmail.com'				, 'trungkien'		,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'		,'Trần Trung Kiên'			,   '1'			,   '4'		,'2021-07-09','Admin'	,1), 
					('Email13@gmail.com'				, 'Username13'		,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'		,'Fullname13'				,   '4'			,   '3'		,'2021-07-09','User'	,0), 
					('Email14@gmail.com'				, 'Username14'		,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'		,'Fullname14'				,   '6'			,   '1'		,'2021-07-09','User'	,0);

-- INSERT INTO `Account`(Email								, Username	, FullName				, DepartmentID	, PositionID)
-- VALUES('Email@gmail.com'				, 'Username', 'KKK', '3', '3');
SELECT*FROM `Account`;