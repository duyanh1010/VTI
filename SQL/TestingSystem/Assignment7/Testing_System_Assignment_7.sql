USE Testing_System_Assignment_2;
-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo
-- trước 1 năm trước
DROP TRIGGER IF EXISTS insert_no_group;
DELIMITER $$
CREATE TRIGGER insert_no_group
BEFORE INSERT ON `Group`
FOR EACH ROW
BEGIN
	IF NEW.CreateDate < NOW() - INTERVAL 1 YEAR THEN
    SIGNAL SQLSTATE '12345'
    SET MESSAGE_TEXT= 'Ban khong duoc insert group co ngay tao lon hon mot nam truoc ';
    END IF;
END$$
DELIMITER ;
INSERT INTO `Group`(GroupName,CreatorID,CreateDate) 	
VALUES 											   ('mayLAND',1,'2021-12-20');
-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào
-- department "Sale" nữa, khi thêm thì hiện ra thông báo "Department
-- "Sale" cannot add more user"
DROP TRIGGER IF EXISTS add_no_user_department_sale;
DELIMITER $$
	CREATE TRIGGER add_no_user_department_sale
    BEFORE INSERT ON `Account`
    FOR EACH ROW
    BEGIN
		DECLARE in_departmentID TINYINT UNSIGNED;
		SELECT DepartmentID INTO in_departmentID FROM Department
        WHERE DepartmentName='Sale';
        IF NEW.DepartmentID= in_departmentID THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT= 'Department "Sale" cannot add more user';
        END IF;
		
    END$$
DELIMITER ;
INSERT INTO `Account`(Email,Username,FullName,DepartmentID,PositionID) 
VALUES ('du01@gmail.com','Anhfd','NguyenDuyAnh',2,1);
-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user suwar thanfh 2
DROP TRIGGER IF EXISTS add_no_user_group_5;
DELIMITER $$
	CREATE TRIGGER add_no_user_group_5
    BEFORE INSERT ON GroupAccount
    FOR EACH ROW
    BEGIN
		DECLARE soluong_acc INT UNSIGNED;
		SELECT COUNT(a.AccountId) INTO soluong_acc  FROM `Account` a JOIN GroupAccount ga 
        ON a.AccountID=ga.AccountID 
        WHERE 	ga.GroupID = New.GroupID;
        IF soluong_acc >=2 THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT= ' ban khong the insert  1 group có nhiều hon là 2 user ';
        END IF;
		
    END$$
DELIMITER ;
INSERT INTO GroupAccount(GroupID,AccountID) VALUES (1,4);
SELECT*FROM GroupAccount;
-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question
DROP TRIGGER IF EXISTS add_no_exam_10;
DELIMITER $$
	CREATE TRIGGER add_no_exam_10
    BEFORE INSERT ON ExamQuestion
    FOR EACH ROW
    BEGIN
		DECLARE soluong_question INT UNSIGNED;
		SELECT COUNT(QuestionID) INTO soluong_question  FROM ExamQuestion eq
        WHERE 	eq.ExamID = NEW.ExamID;
        IF soluong_question >=2 THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT= ' ban khong the insert 1 bai thi co nhieu hon 10 cau hoi ';
        END IF;
		
    END$$
DELIMITER ;
INSERT INTO ExamQuestion(ExamID,QuestionID) VALUES (1,5);

-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là
-- admin@gmail.com (đây là tài khoản admin, không cho phép user xóa),
-- còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông
-- tin liên quan tới user đó
DROP TRIGGER IF EXISTS delete_no_account_admin;
DELIMITER $$
	CREATE TRIGGER delete_no_account_admin
    BEFORE DELETE ON `Account`
    FOR EACH ROW
    BEGIN
        IF OLD.Email='duyanhr01@gmail.com' THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT= ' Day la tai khoan admin ban khong duoc pep xoa  ';
        END IF;
    END$$
DELIMITER ;
DELETE FROM `Account` WHERE Email='duyanhr01@gmail.com';
-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table
-- Account, hãy tạo trigger cho phép người dùng khi tạo account không điền
-- vào departmentID thì sẽ được phân vào phòng ban "waiting Department" sua thanh mac dinh ve phong Ban Hang
DROP TRIGGER IF EXISTS insert_account_auto_Banhang;
DELIMITER $$
	CREATE TRIGGER insert_account_auto_Banhang
    BEFORE INSERT ON `Account`
    FOR EACH ROW
    BEGIN
        IF NEW.DepartmentID IS NULL THEN
		SET	NEW.DepartmentID=(SELECT DepartmentID FROM Department WHERE DepartmentName='Ban Hang'  );
        END IF;
    END$$
DELIMITER ;
INSERT INTO `Account`(Email,Username,FullName,PositionID) 
VALUES ('d@gmail.com','d','Duy',1);
SELECT*FROM `Account`;
-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi
-- question, trong đó có tối đa 2 đáp án đúng.
DROP TRIGGER IF EXISTS insert_exam_4question_2answertrue;
DELIMITER $$
	CREATE TRIGGER insert_exam_4question_2answertrue
    BEFORE INSERT ON Answer
    FOR EACH ROW
    BEGIN
		DECLARE so_luong_answer INT UNSIGNED ;
        DECLARE so_luong_answer_true INT UNSIGNED;
		SELECT COUNT(AnswerID)  INTO so_luong_answer
        FROM Answer 
        WHERE QuestionID=NEW.QuestionID;
        SELECT COUNT(isCorrect) INTO so_luong_answer_true
        FROM Answer 
        WHERE QuestionID=NEW.QuestionID AND  isCorrect='T';
        IF NEW.isCorrect='T' THEN SET so_luong_answer_true = so_luong_answer_true + 1;
        END IF;
        IF so_luong_answer>=5 OR so_luong_answer_true>=2 THEN
        SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT= 'user tạo tối đa 5 answers cho mỗi question, trong đó có tối đa 1 đáp án đúng. ';
        END IF;
    END$$
DELIMITER ;
INSERT INTO Answer(Content,QuestionID,isCorrect) VALUES  ('Blockchain 6 la noi dung cau tra loi cho cau hoi sao ban hoc   ',10,'T');
INSERT INTO Answer(Content,QuestionID,isCorrect) VALUES  ('Blockchain 6 la noi dung cau tra loi cho cau hoi sao ban hoc   ',9,'F');
SELECT*FROM Answer;
-- SELECT COUNT(AnswerID) ,COUNT(isCorrect) 
--         FROM Answer 
--         WHERE QuestionID=10 AND isCorrect='T' ;
-- Question 8: Viết trigger sửa lại dữ liệu cho đúng:
-- Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định
-- Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database
ALTER TABLE `Account`
ADD COLUMN Gender ENUM('M','F','U') DEFAULT 'U' ; -- theem vao cho khop yeu cau  de bai 
SELECT*FROM `Account`;
DROP TRIGGER IF EXISTS insert_update_gender;
DELIMITER $$
	CREATE TRIGGER insert_update_gender
    BEFORE INSERT ON `Account`
    FOR EACH ROW
    BEGIN
        IF NEW.Gender ='Nam' THEN
			SET	NEW.Gender='M';
        END IF;
        IF NEW.Gender ='Nu' THEN
			SET	NEW.Gender='F';
        END IF;
        IF NEW.Gender ='Chua xac dinh' THEN
			SET	NEW.Gender='U';
        END IF;
    END$$
DELIMITER ;
INSERT INTO `Account`(Email,Username,FullName,DepartmentID,PositionID,CreateDate,Gender) 
VALUES ('du01@gmail.com','Anhfd','NguyenDuyAnh',4,2,'2020-10-10','Nam');
-- check
-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày
DROP TRIGGER IF EXISTS delete_exam_2;
DELIMITER $$
	CREATE TRIGGER delete_exam_2
    BEFORE DELETE ON Exam
    FOR EACH ROW
    BEGIN
  
		IF curdate()> DATE_SUB(curdate(), INTERVAL 2 DAY) THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT= 'Ban khong duoc xao bài thi mới tạo được 2 ngày';
        END IF;
    END$$
DELIMITER ;		
DELETE FROM Exam WHERE ExamID=1;
    -- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các
-- question khi question đó chưa nằm trong exam nào
DROP TRIGGER IF EXISTS update_question_exam_no;
DELIMITER $$
	CREATE TRIGGER update_question_exam_no
    BEFORE UPDATE  ON Question
    FOR EACH ROW
    BEGIN
			DECLARE quetionid_examquestion INT UNSIGNED;
            SELECT DISTINCT	QuestionID INTO quetionid_examquestion FROM ExamQuestion WHERE QuestionID=OLD.QuestionID;
			IF quetionid_examquestion>0 THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT= 'Ban khong duoc xao bài thi mới tạo được 2 ngày';
            -- casch  2 
			-- IF	OLD.QuestionID IN (SELECT	DISTINCT QuestionID FROM Examquestion) OR 
-- 			OLD.QuestionID IN (SELECT	DISTINCT QuestionID FROM Answer) THEN
-- 			SIGNAL SQLSTATE '12345' )
-- 			SET MESSAGE_TEXT = 'Ban khong duoc xao bài thi mới tạo được 2 ngày';
        END IF;
    END$$
DELIMITER ;		
UPDATE Question SET QuestionID=110 WHERE QuestionID=3 ;
-- delete
DROP TRIGGER IF EXISTS delete_question_exam_no;
DELIMITER $$
	CREATE TRIGGER delete_question_exam_no
    BEFORE DELETE  ON Question
    FOR EACH ROW
    BEGIN
			DECLARE quetionid_examquestion INT UNSIGNED;
            SELECT DISTINCT	QuestionID INTO quetionid_examquestion FROM ExamQuestion WHERE QuestionID=OLD.QuestionID;
			IF quetionid_examquestion>0 THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT= 'Ban khong duoc xao bài thi mới tạo được 2 ngày';
            -- casch  2 
			-- IF	OLD.QuestionID IN (SELECT	DISTINCT QuestionID FROM Examquestion) OR 
-- 			OLD.QuestionID IN (SELECT	DISTINCT QuestionID FROM Answer) THEN
-- 			SIGNAL SQLSTATE '12345' )
-- 			SET MESSAGE_TEXT = 'Ban khong duoc xao bài thi mới tạo được 2 ngày';
        END IF;
    END$$
DELIMITER ;	
DELETE FROM Question WHERE QuestionID=3;
-- Question 12: Lấy ra thông tin exam trong đó:
-- sua lai vi kieu du lieu dung la time
-- Duration <= 30 thì sẽ đổi thành giá trị "Short time"
-- 30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
-- Duration > 60 thì sẽ đổi thành giá trị "Long time"
SELECT *,CASE
	WHEN Duration <= 3000 THEN  'Short time' -- sua lai vi kieu du lieu dung la time
	WHEN 3000 < Duration <= 6000 THEN 'Medium time'
	WHEN Duration > 6000 THEN 'Long time'
	END AS time_Duration
                                                                    
FROM Exam;
-- Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên
-- là the_number_user_amount và mang giá trị được quy định như sau:
-- Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
-- Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher

SELECT GroupID,COUNT(AccountID) ,CASE
										WHEN COUNT(AccountID)<=5 	THEN 'few'
                                        WHEN COUNT(AccountID)<=20 	THEN 'normal'
                                        ELSE 'higher'
                                        END AS the_number_user_amount
FROM GroupAccount
GROUP BY GroupID;
-- Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào
-- không có user thì sẽ thay đổi giá trị 0 thành "Không có User"
-- thử tạo mới 1 phòng ban trống r chjay lại cho chac
INSERT INTO Department(DepartmentName) 	VALUES ('Phong hoc');
SELECT*FROM department;
SELECT d.*,COUNT(a.AccountID) AS so_luong, CASE 
								WHEN COUNT(a.AccountID) = 0  THEN 'khong co user'
                                ELSE COUNT(a.AccountID)
                                END AS soluong_department_0user
FROM Department d LEFT JOIN `Account` a ON d.DepartmentID=a.DepartmentID
GROUP BY DepartmentID;



