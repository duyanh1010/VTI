USE Testing_System_Assignment_2;
-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
DROP VIEW IF EXISTS v_dsnv;
CREATE VIEW   v_dsnv AS
SELECT a.AccountID,a.Email,a.FullName
FROM `Account` a 
JOIN Department d 
ON d.DepartmentID=a.DepartmentID
WHERE d.DepartmentName = 'Sale';
SELECT * 
FROM v_dsnv;
-- CTE
WITH department_sale AS
(SELECT*FROM department WHERE DepartmentName = 'Sale')
SELECT*FROM `Account` WHERE DepartmentID=(SELECT DepartmentID  FROM department_sale);



-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
DROP VIEW IF EXISTS accountInformation;
CREATE VIEW accountInformation AS
(SELECT a.*,COUNT(a.AccountID) as demex, Group_Concat(ga.GroupID)  
FROM `Account` a
JOIN GroupAccount ga
ON a.AccountID=ga.AccountID
GROUP BY ga.AccountID
HAVING demex= (SELECT Max(demex) FROM (SELECT COUNT(a.AccountID) as demex  FROM `Account` a  JOIN GroupAccount ga
ON a.AccountID=ga.AccountID
GROUP BY ga.AccountID) as max ));
-- cách 2  dùng CTE
WITH	gaJoin	AS
(	SELECT		a.*, COUNT(a.AccountID) AS  demex, Group_Concat(ga.GroupID)
	FROM `Account` a
	JOIN GroupAccount ga
	ON a.AccountID=ga.AccountID
	GROUP BY ga.AccountID
)
SELECT		*
FROM		gaJoin
WHERE		demex = (	SELECT 	Max(demex) 
									FROM 	gaJoin);

 
-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ
-- được coi là quá dài) và xóa nó đi

DROP VIEW IF EXISTS v_length_content;
WITH length_content_50 AS
(SELECT QuestionID FROM Question WHERE length(content)>50)
DELETE FROM Question 
WHERE  QuestionID=(SELECT*FROM length_content_50);

SELECT*FROM Question;



-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
DROP VIEW IF EXISTS v_list_department;
CREATE VIEW v_list_department AS
SELECT d.*, COUNT(a.AccountID) AS so_luong_account , GROUP_CONCAT(d.DepartmentID)
FROM Department d
JOIN `Account` a 
ON d.DepartmentID=a.DepartmentID
GROUP BY DepartmentID
HAVING so_luong_account=(SELECT MAX(so_luong_account) FROM (SELECT d.*, COUNT(a.AccountID) AS so_luong_account FROM Department d
JOIN `Account` a 
ON d.DepartmentID=a.DepartmentID
GROUP BY DepartmentID) as max_soluongac);
--  cách 2 CTE chua toi ưu
WITH so_luong_acc AS
(SELECT MAX(so_luong_account) FROM (SELECT d.*, COUNT(a.AccountID) AS so_luong_account FROM Department d
JOIN `Account` a 
ON d.DepartmentID=a.DepartmentID
GROUP BY DepartmentID) as max_soluongac)
SELECT d.*, COUNT(a.AccountID) AS so_luong_account , GROUP_CONCAT(d.DepartmentID)
FROM Department d
JOIN `Account` a 
ON d.DepartmentID=a.DepartmentID
GROUP BY DepartmentID
HAVING so_luong_account=(SELECT * FROM so_luong_acc );
-- cahc 3  CTE tối ưu
WITH list_max_acc AS
(SELECT d.*, COUNT(a.AccountID) AS so_luong_account , GROUP_CONCAT(d.DepartmentID)
FROM Department d
JOIN `Account` a 
ON d.DepartmentID=a.DepartmentID
GROUP BY DepartmentID)
SELECT*FROM list_max_acc
HAVING so_luong_account=(SELECT MAX(so_luong_account) FROM (SELECT*FROM list_max_acc) as max_list);

-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
DROP VIEW IF EXISTS v_user_nguyen;
CREATE VIEW  v_user_nguyen AS
SELECT q.*,AccountID,a.FullName FROM `Account` a 
JOIN Question q 
ON a.AccountID=q.CreatorID 
WHERE a.FullName LIKE 'Nguyen%';

-- CTE
WITH			Question_Nguyen AS
(SELECT q.*,AccountID,a.FullName FROM `Account` a 
JOIN Question q 
ON a.AccountID=q.CreatorID 
WHERE a.FullName LIKE 'Nguyen%')

SELECT	*
FROM	Question_Nguyen;

