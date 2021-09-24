DROP DATABASE IF EXISTS kiem_tra;
CREATE DATABASE kiem_tra;
USE kiem_tra;
-- tạo bảng 
DROP TABLE IF EXISTS GiangVien;
CREATE TABLE  GiangVien(
	magv 	SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    hoten	VARCHAR(50),
    luong	DECIMAL(10,2)
);

DROP TABLE IF EXISTS SinhVien;
CREATE TABLE  SinhVien(
	masv 	SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    hoten	VARCHAR(50),
	namsinh	YEAR,
    quequan	VARCHAR(50)
);

DROP TABLE IF EXISTS DeTai;
CREATE TABLE  DeTai(
	madt 	SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    tendt	VARCHAR(50),
	kinhphi	DECIMAL(10,2),
    NoiThucTap	VARCHAR(50)
);

DROP TABLE IF EXISTS HuongDan;
CREATE TABLE HuongDan(
	id 		SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    masv	SMALLINT UNSIGNED NOT NULL,
    magv	SMALLINT UNSIGNED NOT NULL,
	madt	SMALLINT UNSIGNED NOT NULL,
    ketqua	VARCHAR(100),
    FOREIGN KEY(masv) REFERENCES SinhVien( masv) ON DELETE CASCADE,
    FOREIGN KEY(magv) REFERENCES GiangVien(magv)	ON DELETE CASCADE,
    FOREIGN KEY(madt) REFERENCES DeTai(madt) ON DELETE CASCADE	
);
-- insert bản ghi vao
INSERT INTO GiangVien(hoten,luong) 
VALUES	('Nguyen Duy Anh','10000000.00'),
		('Phan My Linh','30000000.00'),
		('Phung Hoang Anh','60000000.00'),
		('Phan Huu Trung','50000000.00'),
		('Nguyen Huy','30000000.00');
INSERT INTO SinhVien(hoten,namsinh,quequan) 
VALUES 	('Pham Thien Duy','1999','Nam Dinh'),
		('Phan Van Tuyen','1999','Bac Giang'),
		('Hoang Tien Viet','1998','Ha Noi'),
		('Tran Trung Kien','1999','Bac Giang'),
		('Nguyen Thi Thanh Hang','1999','Nghe an');
INSERT INTO DeTai(tendt,kinhphi,NoiThucTap)
VALUES	('CONG NGHE SINH HOC','20000000.00',' Vien Nong Lam Viet Nam'),
		('CONG NGHE ROBOT','50000000.00',' Vien Tin học quốc gia '),
		('Ung Dung Nong Nghiep','40000000.00',' Vien Nong Lam Viet Nam'),
		('Che Tao Ten Lua','90000000.00',' Vien Phong Khong Khong quan'),
		('CONG NGHE O TO','90000000.00','HONDA');
INSERT INTO HuongDan(masv,magv,madt,ketqua)
VALUES	(1,1,1,'Giai Nhat Cuoc THI SANG TAO SINH VIEN'),
		(4,1,2,'Giai Khuyen Khich'),
		(3,4,1,'Giai BA Cuoc THI SANG TAO SINH VIEN'),
		(5,3,3,'Khong duoc giai'),
		(4,2,4,'Khong duoc giai');
-- cau hoi 
-- 2. Viết lệnh để
-- a) Lấy tất cả các sinh viên chưa có đề tài hướng dẫn
SELECT s.*,hd.madt
FROM SinhVien s 
LEFT JOIN HuongDan hd
ON s.masv=hd.masv
WHERE hd.madt IS NULL;
-- b) Lấy ra số sinh viên làm đề tài ‘CONG NGHE SINH HOC’
SELECT dt.*,COUNT(hd.masv) AS so_luong_sv, GROUP_CONCAT(hd.masv) 
FROM HuongDan hd
JOIN DeTai dt
ON hd.madt=dt.madt
WHERE dt.tendt='CONG NGHE SINH HOC';
-- Tạo view có tên là "SinhVienInfo" lấy các thông tin về học sinh bao gồm:
-- mã số, họ tên và tên đề tài
-- (Nếu sinh viên chưa có đề tài thì column tên đề tài sẽ in ra "Chưa có")
DROP VIEW IF EXISTS SinhVienInfo;
CREATE VIEW SinhVienInfo AS
SELECT s.*,CASE WHEN dt.tendt IS NULL THEN 'Chua co'
							   ELSE dt.tendt END AS Ten_de_tai
FROM SinhVien s 
LEFT JOIN HuongDan hd
ON s.masv=hd.masv
LEFT JOIN DeTai dt
ON hd.madt=dt.madt;
SELECT *FROM SinhVienInfo;

-- Tạo trigger cho table SinhVien khi insert sinh viên có năm sinh <= 1900
-- thì hiện ra thông báo "năm sinh phải > 1900"
DROP TRIGGER IF EXISTS insert_sinhvien;
DELIMITER $$
	CREATE TRIGGER insert_sinhvien
    BEFORE INSERT ON SinhVien
    FOR EACH ROW
    BEGIN
        IF NEW.namsinh<=1900 THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT= ' nam sinh phai  > 1900 ';
        END IF;
    END$$
DELIMITER ;
--  chú ý 
-- INSERT INTO SinhVien(hoten,namsinh,quequan) 
-- VALUES 	('Pham  Duy','1900','Dinh'); -- vi de csdl laf year rooi len check luon udng , YEAR có thể từ 1901 tới 2155. Độ dài mặc định là 4.




-- 5. Hãy cấu hình table sao cho khi xóa 1 sinh viên nào đó thì sẽ tất cả thông
-- tin trong table HuongDan liên quan tới sinh viên đó sẽ bị xóa đi
-- cách 1 
-- ddax theem ondelete cascase tu khi tao table
-- cash  2 khác là tạo thêm trigger 
DROP TRIGGER IF EXISTS delete_sinhvien;
DELIMITER $$
	CREATE TRIGGER delete_sinhvien
    BEFORE DELETE ON HuongDan
    FOR EACH ROW
    BEGIN
       DELETE FROM HuongDan WHERE masv=OLD.masv;
    END$$
DELIMITER ;
DELETE FROM SinhVIen WHERE masv=4;
SELECT*FROM HuongDan; -- chekc xem da duoc xoa o bang huong dan chua 