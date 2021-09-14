USE Extra_Assignment1_2;
INSERT INTO Trainee(
Full_Name, Birth_Date,Gender,ET_IQ,ET_English,Training_Class,Evaluation_Notes,VTI_Account	)
VALUES('Nguyen Duy Anh ', '1999-10-10','male',10,50,55,'Ca hoan Thien','anhnd'),
	('Phan Thai Trung ', '1997-12-10','female',20,50,55,'good','trungpt'),
    ('Nguyen Thanh Hang ', '1998-1-1','male',9,40,54,'Cai Thien ','hangnt'),
    ('Nguyen Duy ', '1999-6-6','male',20,50,55,'Good','duyn'),
    ('Phan My Linh ', '1998-5-5','female',15,45,52,'Ca hoan Thien','linhpm'),
    ('Nguyen Kim Cuc ', '1996-4-4','female',10,20,55,'Ca hoan Thien','cucnk'),
    ('Luong Van Giang ', '1998-12-2','male',8,50,55,'Ca hoan Thien','gianglv'),
    ('Bui Minh Hoang ', '1999-3-3','male',11,33,55,'Ca hoan Thien','hoangbm'),
    ('Nguyen Hoa ', '1992-3-1','male',10,34,55,'Ca hoan Thien','hoan'),
    ('Pham Thanh Tung ', '1999-10-10','male',10,50,55,'Ca hoan Thien','tungpt');
SELECT*FROM Trainee WHERE ET_IQ >10 AND ET_English>20
