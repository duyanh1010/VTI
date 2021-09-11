USE Testing_System_Assignment_2;
-- Exercise 1: Join
-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT 
    *
FROM
    `Account` a
        JOIN
    department d ON a.DepartmentID = d.DepartmentID;
-- sử dụng union,left, right cho các TH tương tự nếu có câu hỏi 
-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010
SELECT*FROM   `Account` 
WHERE CreateDate > 2010-12-20;
--  Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010 cua tung phong ban 
SELECT 
    *
FROM
    `Account` a
        JOIN
    department d ON a.DepartmentID = d.DepartmentID
WHERE
    CreateDate > 2010 - 12 - 20;
-- Question 3: Viết lệnh để lấy ra tất cả các developer
SELECT 
    *
FROM
    `Account` a
        JOIN
    Position p ON a.PositionID = p.PositionID
WHERE
    PositionName='Dev';
-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên sửa thanh >1nv
SELECT 
   d.*, COUNT(AccountID) AS dem
FROM
    `Account` a
	RIGHT JOIN -- lấy right vì muốn lấy ra phòng ban không có nhân viên nao nua 
    department d ON a.DepartmentID = d.DepartmentID 
    GROUP BY(departmentID) 
    HAVING dem > 1
    ORDER BY dem DESC;
-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều
-- nhất
SELECT q.*,COUNT(eq.QuestionID)  
FROM Question q 
 JOIN ExamQuestion eq
ON q.QuestionID=eq.QuestionID 
GROUP BY eq.QuestionID 
ORDER BY COUNT(eq.QuestionID) DESC 
LIMIT 1;
-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT c.*,COUNT(q.QuestionID) FROM CategoryQuestion c LEFT JOIN Question q ON c.CategoryID=q.CategoryID 
GROUP BY CategoryID 
ORDER BY COUNT(q.QuestionID) DESC;
-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT q.*,COUNT(eq.ExamID) FROM Question q 
JOIN ExamQuestion eq 
ON q.QuestionID=eq.QuestionID
JOIN Exam e 
ON eq.ExamID=e.ExamID
GROUP BY QuestionID ;
-- Question 8: Lấy ra Question có nhiều câu trả lời nhất
SELECT q.*,COUNT(an.QuestionID)  
FROM Question q 
 JOIN Answer an 
ON q.QuestionID=an.QuestionID 
GROUP BY an.QuestionID 
ORDER BY COUNT(an.QuestionID) DESC 
LIMIT 1;
-- Question 9: Thống kê số lượng account trong mỗi group
SELECT g.*, COUNT(ga.AccountID)
FROM `Account` a 
 JOIN  GroupAccount ga
ON a.AccountID=ga.AccountID
 JOIN `Group` g 
ON ga.GroupID=g.GroupID
GROUP BY ga.GroupID;
SELECT*FROM GroupAccount;
-- cách 2 có thể join 2 bảng 
SELECT g.*, COUNT(ga.AccountID)
FROM 
 GroupAccount ga
 JOIN `Group` g 
ON ga.GroupID=g.GroupID
GROUP BY ga.GroupID;
SELECT*FROM GroupAccount;
-- Question 10: Tìm chức vụ có ít người nhất
SELECT p.*, COUNT(a.AccountID) 
FROM Position p 
LEFT JOIN `Account` a 
ON p.PositionID=a.PositionID
GROUP BY PositionName
ORDER BY COUNT(a.AccountID) 
LIMIT 1;
-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
SELECT p.*, COUNT(a.AccountID) 
FROM Position p 
LEFT JOIN `Account` a 
ON p.PositionID=a.PositionID
GROUP BY PositionName
ORDER BY COUNT(a.AccountID) ;
-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của
-- question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, ...
SELECT q.*, an.*
FROM Question q
JOIN Answer an
ON q.QuestionID=an.QuestionID;
-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT tq.*, COUNT(QuestionID)
FROM TypeQuestion tq 
JOIN Question q  
ON tq.TypeID=q.TypeID
GROUP BY tq.TypeID ;
-- Question 14:Lấy ra group không có account nào
SELECT*FROM `Group`;
SELECT g.*,ga.*,COUNT(ga.AccountID)
FROM `Group` g 
LEFT JOIN GroupAccount ga
ON g.GroupID=ga.GroupID
GROUP BY g.GroupID
HAVING COUNT(ga.AccountID)=0;

-- Question 15: Lấy ra group không có account nào
SELECT*FROM `Group`;
SELECT g.*,ga.*,COUNT(ga.AccountID)
FROM `Group` g 
LEFT JOIN GroupAccount ga
ON g.GroupID=ga.GroupID
GROUP BY g.GroupID
HAVING COUNT(ga.AccountID)=0;
-- Question 16: Lấy ra question không có answer nào
SELECT*FROM Answer;
SELECT q.*,COUNT(an.AnswerID)
FROM Question q
LEFT JOIN Answer an
ON q.QuestionID=an.QuestionID
GROUP BY q.QuestionID
HAVING COUNT(an.AnswerID)=0;
-- Exercise 2: Union
-- Question 17:
-- a) Lấy các account thuộc nhóm thứ 1
SELECT a.* FROM `Account` a 
JOIN GroupAccount ga
ON a.AccountID=ga.AccountID
WHERE GroupID=1;
-- b) Lấy các account thuộc nhóm thứ 2
SELECT a.*FROM `Account` a 
JOIN GroupAccount ga
ON a.AccountID=ga.AccountID
WHERE GroupID=2;
-- c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau
SELECT a.*FROM `Account` a 
JOIN GroupAccount ga
ON a.AccountID=ga.AccountID
WHERE GroupID=1
UNION 
SELECT a.*FROM `Account` a 
JOIN GroupAccount ga
ON a.AccountID=ga.AccountID
WHERE GroupID=2;
-- Question 18:
-- a) Lấy các group có lớn hơn 5 thành viên >1 thành  viên 
SELECT g.*, COUNT(ga.AccountID)
FROM `Group` g
JOIN GroupAccount ga
ON g.GroupID=ga.GroupID
GROUP BY ga.GroupID
HAVING COUNT(ga.AccountID)>1;

-- b) Lấy các group có nhỏ hơn 7 thành viên
SELECT g.*, COUNT(ga.AccountID)
FROM `Group` g
JOIN GroupAccount ga
ON g.GroupID=ga.GroupID
GROUP BY ga.GroupID
HAVING COUNT(ga.AccountID)<3;

-- c) Ghép 2 kết quả từ câu a) và câu b)
SELECT g.*, COUNT(ga.AccountID)
FROM `Group` g
JOIN GroupAccount ga
ON g.GroupID=ga.GroupID
GROUP BY ga.GroupID
HAVING COUNT(ga.AccountID)>1
UNION 
SELECT g.*, COUNT(ga.AccountID)
FROM `Group` g
JOIN GroupAccount ga
ON g.GroupID=ga.GroupID
GROUP BY ga.GroupID
HAVING COUNT(ga.AccountID)<3;


