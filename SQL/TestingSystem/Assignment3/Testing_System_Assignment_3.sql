USE Testing_System_Assignment_2;
-- Question 1: Thêm ít nhất 10 record vào mỗi table đã thêm ở Testing_System_Assignment_2;
-- Question 2: lấy ra tất cả các phòng ban
SELECT*FROM Department;
-- Question 3: lấy ra id của phòng ban "Sale"
SELECT 
    DepartmentID
FROM
    Department
WHERE
    DepartmentName = 'Sale';
-- Question 4: lấy ra thông tin account có full name dài nhất
SELECT 
    *
FROM
    `Account`
WHERE
    LENGTH(FullName) = (SELECT 
							MAX(LENGTH(FullName))
						FROM
							`Account`);
-- cách 2
SELECT 
    *
FROM
    `Account`
ORDER BY LENGTH(FullName) DESC
LIMIT 1;
-- Question 5: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id= 3
WITH de as (SELECT*FROM `Account` WHERE DepartmentID=3 )
SELECT *FROM de WHERE length(FullName)=(SELECT MAX(length(FullName)) FROM de);
-- cách 2 
SELECT 
    *
FROM
    `Account`
WHERE
    DepartmentID = 3
ORDER BY LENGTH(FullName) DESC
LIMIT 1;
-- Question 6: Lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT 
    *
FROM
    `Group`
WHERE
    CreateDate < '2019-12-20';
-- Question 7: Lấy ra ID của question có >= 4 câu trả lời
SELECT 
    QuestionID
FROM
    Answer
GROUP BY QuestionID
HAVING COUNT(QuestionID) >= 4;
-- cách 2 
SELECT 
    QuestionID,GROUP_CONCAT(AnswerID SEPARATOR ',') AS Answer4
FROM
    Answer
GROUP BY QuestionID
HAVING COUNT(QuestionID) >= 4;

-- Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày
-- 20/12/2019
SELECT*FROM Exam WHERE Duration>=10000 AND CreateDate<'2019-12-20';
-- Question 9: Lấy ra 5 group được tạo gần đây nhất
SELECT*FROM `group` ORDER BY CreateDate DESC LIMIT 5;
-- Question 10: Đếm số nhân viên thuộc department có id = 2
SELECT COUNT(AccountID)  FROM `Account` WHERE DepartmentID=2;
-- Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"
SELECT*FROM `Account` WHERE Username LIKE'D%o';
-- Question 12: Xóa tất cả các exam được tạo trước ngày 20/12/2019
DELETE FROM Exam WHERE CreateDate <'2019-12-20';
-- Question 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi"
DELETE FROM Question WHERE Content LIKE 'cau hoi%';
-- Question 14: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và
-- email thành loc.nguyenba@vti.com.vn
UPDATE `Account` SET FullName='Nguyễn Bá Lộc',Email='loc.nguyenba@vti.com.vn' WHERE AccountID=5;
SELECT*FROM `Account`;
-- Question 15: update account có id = 5 sẽ thuộc group có id = 4
UPDATE `GroupAccount` SET  AccountID=5 WHERE GroupID=4 ;
SELECT 	*
From 	GroupAccount
where	GroupID = 4;


