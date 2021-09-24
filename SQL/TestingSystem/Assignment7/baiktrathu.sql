DROP DATABASE IF EXISTS demo;
CREATE DATABASE demo;
USE demo;
-- Tạo Bảng
DROP TABLE IF EXISTS CUSTOMER;
CREATE TABLE CUSTOMER(
	CustomerID 	INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `Name` 		VARCHAR(50),
    Phone		CHAR(10),
    Email		VARCHAR(50),
    Address		VARCHAR(50),
    Note		VARCHAR(50)
);
DROP TABLE IF EXISTS CAR;
CREATE TABLE CAR(
	CarID 		INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    Maker		ENUM('HONDA', 'TOYOTA','NISSAN'),
    Model		VARCHAR(50),
    `Year`		YEAR,
    Color		ENUM('Black','White','Yellow'),
    Note		VARCHAR(50)
);
DROP TABLE IF EXISTS CAR_ORDER;
CREATE TABLE CAR_ORDER(
	OrderID		INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    CustomerID	INT UNSIGNED NOT NULL,
    CarID		INT UNSIGNED NOT NULL,
    Amount		TINYINT UNSIGNED DEFAULT 1,
    SalePrice	DECIMAL(10,2),
    OrderDate	DATETIME,
    DeliveryDate	DATETIME,
    DeliveryAddress		VARCHAR(50),
    Staus		ENUM('0','1','2') DEFAULT '1',
    Note		VARCHAR(50),
    FOREIGN KEY (CustomerID) REFERENCES CUSTOMER(CustomerID) ON DELETE CASCADE,
    FOREIGN KEY	( CarID)	REFERENCES CAR( CarID) ON DELETE CASCADE	
);
-- insert du lieu 
INSERT INTO CUSTOMER(`Name`,Phone,Email, Address , Note) 
VALUES	('Nguyen Duy Anh','0355969717','duyanhr01@gmail.com','Ba Vi','Khach VIP'),
		('Nguyen Linh','0955969777','linh@gmail.com','Bac Giang','Khach VIP'),
		('Phan Huu Trung','0987809574','trungph@gmail.com','Nam Dinh','Khach Thuong'),
		('Nguyen Kim','0926157515','kim@gmail.com','Bac Ninh','Khach Moi'),
		('Phung Hoang Anh','0926157525','anhph@gmail.com','Phu Tho','Khach VIP');

INSERT INTO CAR(Maker,Model,`Year`,Color,Note) 
VALUES 	('HONDA','HONDA CR – V 2021','2021','White','Xe moi'),
		('TOYOTA','Toyota Corolla Altis','2021','Black','Xe moi'),
		('HONDA','Honda Civic','2014','Black','Xe mot chu'),
		('TOYOTA','Toyota Fortuner','2015','Yellow','Xe Dam Dung'),
		('HONDA','Honda City','2019','White','Xe moi'),
		('NISSAN','Nissan Maxima','2017','Yellow','Xe Ngap Nuoc'),
		('NISSAN','Nissan Versa','2021','White','Xe moi');
INSERT INTO CAR_ORDER(CustomerID,CarID,Amount,SalePrice,OrderDate,DeliveryDate,DeliveryAddress,Staus,Note)
VALUES 	(1,1,1,'20000000.00','2021-01-01','2021-01-10','Ba VI','0','Xe Can giao nhanh '),
		(1,4,4,'40000000.00','2021-06-05','2021-06-16','PHU THO','0','Xe  giao nhanh ok '),
		(2,3,2,'70000000.00','2021-04-08','2021-05-10','GIA LAM','0','Xe da giao khong van de '),
		(4,2,3,'60000000.00','2019-09-01','2019-09-10','CAO BANG','2','Xe loi dong co'),
		(5,3,1,'80000000.00','2021-01-12','2021-01-22','LANG SON','1','Xe Can giao nhanh duoc thuong  '),
		(5,5,1,'90000000.00','2021-06-01','2021-06-06','BAC NINH','0','Xe Can giao nhanh ');
SELECT*FROM CAR_ORDER;
-- cau lenh 
-- Viết lệnh lấy ra thông tin của khách hàng: tên, số lượng oto khách hàng đã
-- mua và sắp sếp tăng dần theo số lượng oto đã mua.
SELECT c.*,SUM(co.Amount)
FROM CUSTOMER c
JOIN CAR_ORDER co
ON c.CustomerID=co.CustomerID
GROUP BY c.CustomerID
ORDER BY CustomerID;
-- Viết hàm (không có parameter) trả về tên hãng sản xuất đã bán được nhiều
-- oto nhất trong năm nay.
DROP FUNCTION IF EXISTS name_hang;
DELIMITER $$
CREATE FUNCTION name_hang() RETURNS ENUM('HONDA', 'TOYOTA','NISSAN')
DETERMINISTIC
BEGIN 	

	DECLARE out_name ENUM('HONDA', 'TOYOTA','NISSAN');
	SELECT Maker INTO out_name FROM CAR ca
    JOIN	(SELECT DISTINCT ca.CarID,SUM(co.Amount) AS tong_xe FROM CAR ca
    JOIN CAR_ORDER co
	ON ca.CarID=co.CarID
    WHERE year(now())=year(co.OrderDate) AND Staus='1'
    GROUP BY ca.CarID) AS ba
    ON ba.CarID=ca.CarID
    GROUP BY Maker
    ORDER BY SUM(tong_xe) DESC
    LIMIT 1; -- khong can dung den ham max vi khi viet ham ket qua tra ve se la mot out parameter
    RETURN out_name;
END$$
DELIMITER ;
SELECT name_hang();
-- Viết 1 thủ tục (không có parameter) để xóa các đơn hàng đã bị hủy của
-- những năm trước. In ra số lượng bản ghi đã bị xóa.
DROP PROCEDURE IF EXISTS delete_donbihuy;
DELIMITER $$
CREATE PROCEDURE delete_donbihuy()
BEGIN
	DELETE FROM CAR_ORDER 
    WHERE Staus='2' 
    AND year(NOW() - INTERVAL 1 year)>year(OrderDate);
    SELECT ROW_COUNT() AS so_luong_bi_xoa;
END$$
DELIMITER ;  
CALL   delete_donbihuy();
-- Viết 1 thủ tục (có CustomerID parameter) để in ra thông tin của các đơn
-- hàng đã đặt hàng bao gồm: tên của khách hàng, mã đơn hàng, số lượng oto
-- và tên hãng sản xuất.

DROP PROCEDURE IF EXISTS show_car_oder;
DELIMITER $$
CREATE PROCEDURE show_car_oder(IN in_customerID INT UNSIGNED)
BEGIN
	SELECT c.`Name` ,co.OrderID,co.Amount,ca.Maker
    FROM CUSTOMER c 
	JOIN CAR_ORDER co
    ON c.CustomerID=co.CustomerID
    JOIN CAR ca 
    ON co.CarID=ca.CarID
    WHERE Staus='0'AND co.CustomerID=in_customerID;
END$$
DELIMITER ;  
CALL show_car_oder(1);
-- Viết trigger để tránh trường hợp người dụng nhập thông tin không hợp lệ
-- vào database (DeliveryDate < OrderDate + 15).
DROP TRIGGER IF EXISTS date_no;
DELIMITER $$
CREATE TRIGGER date_no
BEFORE INSERT  ON CAR_ORDER
FOR EACH ROW
	BEGIN
    
	IF NEW.DeliveryDate <  NEW.OrderDate+ INTERVAL 15 DAY THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT= ' không hợp lệ vào database (DeliveryDate < OrderDate + 15).';
	END IF;
    END$$
DELIMITER ;
INSERT INTO CAR_ORDER(CustomerID,CarID,Amount,SalePrice,OrderDate,DeliveryDate,DeliveryAddress,Staus,Note)
VALUES 	(3,4,4,'20000000.00','2021-01-01','2021-01-20','Ba VI','0','Xe Can giao nhanh ');
    
    