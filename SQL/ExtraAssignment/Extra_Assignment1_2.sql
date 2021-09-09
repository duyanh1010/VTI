-- Exercise 1:Design a table
DROP DATABASE IF EXISTS Extra_Assignment1_2;
CREATE DATABASE Extra_Assignment1_2;
USE Extra_Assignment1_2;
DROP TABLE IF EXISTS Trainee;
CREATE TABLE Trainee(
	TraineeID 			INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    Full_Name			VARCHAR(50),
    Birth_Date 			DATETIME,
    Gender 				ENUM('male', 'female', 'unknown'),
    ET_IQ 				TINYINT(20) UNSIGNED,
    ET_English  		TINYINT(50) UNSIGNED,
    Training_Class 		SMALLINT,
    Evaluation_Notes 	VARCHAR(200)
   --  VTI_Account		VARCHAR(50) NOT NULL UNIQUE
);
ALTER TABLE Trainee 
ADD COLUMN  VTI_Account	VARCHAR(50) NOT NULL UNIQUE;
-- Exercise 2: Data Types
DROP TABLE IF EXISTS Data_Types_2;
CREATE TABLE Data_Types_2(
	ID_2				INT UNSIGNED PRIMARY KEY AUTO_INCREMENT, -- mediumint,bigint
    `Name_2`			VARCHAR(50),
    `Code_2`			CHAR(5),
    ModifiedDate_2		DATETIME
);
-- Exercise 3: Data Types (2)
DROP TABLE IF EXISTS Data_Types_3;
CREATE TABLE Data_Types_3(
	ID_3				INT UNSIGNED PRIMARY KEY AUTO_INCREMENT, -- mediumint,bigint
    `Name_3`			VARCHAR(50),
    BirthDate			DATETIME,
    Gender				BIT,
    IsDeletedFlag		BOOLEAN
);

