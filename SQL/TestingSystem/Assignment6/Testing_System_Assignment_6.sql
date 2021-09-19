USE Testing_System_Assignment_2;
-- Viết procedure cho phép truyền vào tên 1 người, kết quả trả về là những câu hỏi mà người đó đã tạo
DROP PROCEDURE IF EXISTS acc_name;
DELIMITER $$
CREATE PROCEDURE acc_name(IN in_FullName  VARCHAR(50), OUT out_questionid INT UNSIGNED)
DETERMINISTIC
BEGIN
SELECT QuestionID  INTO out_questionid
FROM `Account` a
JOIN Question q
ON a.AccountID=q.CreatorID
WHERE a.FullName=in_FullName ;
END$$
DELIMITER ;
SET @qacc=0;
CALL acc_name('NguyenDuyAnh',@qacc);
SELECT @qacc;
-- Viết 1 function truyền vào 1 id của group bất kỳ, trả về số lượng account có trong group đó
DROP FUNCTION IF EXISTS f_so_luong_acc;
DELIMITER $$
CREATE FUNCTION f_so_luong_acc(id_group INT UNSIGNED) RETURNS  INT UNSIGNED
DETERMINISTIC
BEGIN

	DECLARE in_id_group INT UNSIGNED;
	SELECT COUNT(a.AccountID) as so INTO in_id_group
	FROM `Account` a
	JOIN GroupAccount ga
	ON a.AccountID=ga.AccountID
    WHERE ga.GroupID=id_group
	GROUP BY GroupID ;
    RETURN in_id_group;
END$$
DELIMITER ;
SELECT f_so_luong_acc(2);

-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các
-- account thuộc phòng ban đó
DROP PROCEDURE IF EXISTS department_name;
DELIMITER $$
CREATE PROCEDURE department_name(IN in_departmentName VARCHAR(50))
BEGIN
SELECT * 
FROM department d
LEFT JOIN `Account` a 
ON d.DepartmentID=a.DepartmentID
WHERE DepartmentName=in_departmentName ;
END$$
DELIMITER ;
CALL department_name('Sale');

-- Question 2: Tạo store để in ra số lượng account trong mỗi group
DROP PROCEDURE IF EXISTS p_so_luong_acc;
DELIMITER $$
CREATE PROCEDURE p_so_luong_acc()
BEGIN
SELECT ga.GroupID,COUNT(a.AccountID),GROUP_CONCAT(a.AccountID)
FROM `Account` a
JOIN GroupAccount ga
ON a.AccountID=ga.AccountID
GROUP BY GroupID ;
END$$
DELIMITER ;
CALL p_so_luong_acc();
-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo
-- trong tháng hiện tại

DROP PROCEDURE IF EXISTS p_question_type;
DELIMITER $$
CREATE PROCEDURE  p_question_type()
BEGIN
	SELECT t.*,COUNT(q.QuestionID),GROUP_CONCAT(q.QuestionID),GROUP_CONCAT(q.CreateDate)
	FROM TypeQuestion  t
	JOIN  Question q
	ON t.TypeID=q.TypeID 
    WHERE  month(q.CreateDate) = month(now())
	GROUP BY TypeID ;
END$$
DELIMITER ;
CALL p_question_type();


-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
DROP PROCEDURE IF EXISTS p_id_type;
DELIMITER $$
CREATE PROCEDURE  p_id_type()
BEGIN
	SELECT t.*,COUNT(q.QuestionID) as soluong_q_max -- INTO id_type_max
	FROM TypeQuestion t
	JOIN  Question q
	ON t.TypeID=q.TypeID 
    GROUP BY t.TypeID 
    HAVING soluong_q_max =(SELECT MAX(soluong_q_max) FROM (SELECT t.*,COUNT(q.QuestionID) as soluong_q_max
	FROM TypeQuestion  t
	JOIN  Question q
	ON t.TypeID=q.TypeID 
	GROUP BY t.TypeID  )AS maxso) ;
END$$
DELIMITER ;

CALL p_id_type();

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
SELECT t.*,COUNT(q.QuestionID) as soluong_q_max  
	FROM TypeQuestion t
	JOIN  Question q
	ON t.TypeID=q.TypeID 
    GROUP BY t.TypeID 
    HAVING soluong_q_max= @max_so_luong_q;
    
-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
-- chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa
-- chuỗi của người dùng nhập vào
DROP PROCEDURE IF EXISTS p_id_group;
DELIMITER $$
CREATE PROCEDURE  p_id_group(IN in_GroupName VARCHAR(50), OUT out_id_group	TINYINT UNSIGNED)
BEGIN
	SELECT GroupID   INTO out_id_group
	FROM `Group`
    WHERE GroupName=in_GroupName;
END$$
DELIMITER ;
SET @search_group='';
CALL p_id_group('ADN LAND',@search_group);
SELECT @search_group;

-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và
-- trong store sẽ tự động gán:
-- username sẽ giống email nhưng bỏ phần @..mail đi
-- positionID: sẽ có default là developer
-- departmentID: sẽ được cho vào 1 phòng chờ
-- Sau đó in ra kết quả tạo thành công
DROP PROCEDURE IF EXISTS p_update;
DELIMITER $$
CREATE PROCEDURE  p_update(IN in_FullName VARCHAR(50),IN in_email VARCHAR(50))
BEGIN
		
		DECLARE p_positionID TINYINT UNSIGNED;
		DECLARE p_departmentID TINYINT UNSIGNED;
		SELECT PositionID INTO p_positionID
		FROM Position
		WHERE PositionName='Dev'; -- positionID: sẽ có default là developer
        SELECT DepartmentID INTO p_departmentID 
        FROM Department
        WHERE DepartmentName='Ban Hang'; -- departmentID: sẽ được cho vào bán hàng
	INSERT INTO `Account`(Email,Username,FullName,DepartmentID,PositionID) 
	VALUES (in_email,substring_index(in_email,'@',1 ),in_FullName,p_departmentID,p_positionID); 
    IF ROW_COUNT() > 0 THEN
		SELECT 'thanh cong';
    ELSE 
		SELECT 'that bai';
	END IF;
END$$
DELIMITER ;

CALL p_update('Nguyen Hang','hangng@gmail.com');

-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
-- để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất
DROP PROCEDURE IF EXISTS type_question;
DELIMITER $$
CREATE PROCEDURE type_question( IN  in_TypeName ENUM('Essay', 'Multiple-Choice'))
	BEGIN
		SELECT q.*,length(q.Content) as length_content 
        FROM typequestion t 
        JOIN question q 
        ON t.TypeID=q.TypeID
        HAVING length(q.Content)=(SELECT MAX(length_content) FROM (SELECT q.*,length(q.Content) as length_content
        FROM typequestion t 
        JOIN question q 
        ON t.TypeID=q.TypeID
        WHERE TypeName=in_TypeName)as max_length);
        
    END$$
DELIMITER ;
CALL type_question('Multiple-Choice');
-- câu 8 cách 2 cho ngắn gọn 
		SELECT q.*,max( length(q.Content) )as length_content 
        FROM typequestion t 
        JOIN question q 
        ON t.TypeID=q.TypeID
         WHERE TypeName='Essay';
-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
DROP PROCEDURE IF EXISTS delete_exam;
DELIMITER $$
CREATE PROCEDURE delete_exam(IN in_examid INT UNSIGNED)
	BEGIN
		DELETE FROM Exam WHERE ExamID=in_examid;
    END$$
DELIMITER ;
CALL delete_exam(10);
-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử
-- dụng store ở câu 9 để xóa)
-- Sau đó in số lượng record đã remove từ các table liên quan trong khi
-- removing
DROP PROCEDURE IF EXISTS exam_3year;
DELIMITER $$
CREATE PROCEDURE exam_3year()
	BEGIN
		DECLARE de_ex TINYINT UNSIGNED ;
		SELECT ExamID INTO de_ex 
        FROM Exam WHERE year(now())-year( CreateDate	)>=3;
        CALL delete_exam(de_ex);
    END$$
DELIMITER ;
CALL exam_3year();
-- cahc 2 xoa nhieu ho n1 cot 
DROP PROCEDURE IF EXISTS exam_3year_cach2;
DELIMITER $$
CREATE PROCEDURE exam_3year_cach2(IN in_ExamID TINYINT UNSIGNED)
	BEGIN
		
        WITH exam_3_yearold AS(
		SELECT ExamID
        FROM Exam WHERE year(now())-year( CreateDate	)>=3)
		DELETE	
		FROM	Exam
		WHERE	ExamID = (SELECT* 
					FROM 	exam_3_yearold
					WHERE	ExamID = in_ExamID);
    END$$
DELIMITER ;
CALL exam_3year_cach2(9);
-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng
-- nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được
-- chuyển về phòng ban default là phòng ban chờ việc
DROP PROCEDURE IF EXISTS delete_name_department;
DELIMITER $$
CREATE PROCEDURE delete_name_department(IN  in_DepartmentName VARCHAR(50))
	BEGIN
		DELETE  FROM department WHERE DepartmentName='Bao ve';
        -- default là về phòng bán hàng 
        UPDATE Department
        SET  DepartmentName='Ban Hang'
        WHERE DepartmentName=in_DepartmentName;
        -- (SELECT*FROM uni_accountupdate)
--         UNION
-- 		(SELECT *FROM `Account` WHERE DepartmentID=(SELECT DepartmentID FROM department WHERE DepartmentName='Ban Hang')) ;
		
    END$$
DELIMITER ;    
CALL delete_name_department('Bao ve');
SELECT*FROM department;
SELECT*FROM `account`;
-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm
-- nay

DROP PROCEDURE IF EXISTS in_month;
DELIMITER $$
	CREATE PROCEDURE in_month()
    BEGIN
    SELECT month_12.MONTH ,COUNT(q.QuestionID),GROUP_CONCAT(q.QuestionID)
    FROM 
	(SELECT  1 AS MONTH UNION
	SELECT	2 AS MONTH UNION
	SELECT	3 AS MONTH UNION
	SELECT	4 AS MONTH UNION
	SELECT	5 AS MONTH UNION
	SELECT	6 AS MONTH UNION
	SELECT	7 AS MONTH UNION
	SELECT	8 AS MONTH UNION
	SELECT	9 AS MONTH UNION
	SELECT	10 AS MONTH UNION
	SELECT	11 AS MONTH UNION
	SELECT	12 AS MONTH) AS month_12
    LEFT JOIN question q
    ON month_12.month=month(CreateDate)
    GROUP BY	month_12.Month;
    END$$
DELIMITER ;
CALL in_month();
-- 2

-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6
-- tháng gần đây nhất
-- (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong
-- tháng")
DROP PROCEDURE IF EXISTS in_month_6;
DELIMITER $$
	CREATE PROCEDURE in_month_6()
    BEGIN
    SELECT month_6.MONTH ,COUNT(q.QuestionID),GROUP_CONCAT(q.QuestionID)
    FROM 
	(SELECT	MONTH(NOW() - INTERVAL 0 MONTH) AS MONTH
	UNION	
	SELECT	MONTH(NOW() - INTERVAL 1 MONTH) AS MONTH
	UNION
	SELECT	MONTH(NOW() - INTERVAL 2 MONTH) AS MONTH
	UNION
	SELECT	MONTH(NOW() - INTERVAL 3 MONTH) AS MONTH
	UNION
	SELECT	MONTH(NOW() - INTERVAL 4 MONTH) AS MONTH
	UNION
	SELECT	MONTH(NOW() - INTERVAL 5 MONTH) AS MONTH)  AS month_6
    LEFT JOIN question q
    ON month_6.month=month(CreateDate)
    GROUP BY	month_6.Month;
    END$$
DELIMITER ;
CALL in_month_6();