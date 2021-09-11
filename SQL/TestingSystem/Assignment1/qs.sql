USE classicmodels;
-- cross join
SELECT 
    *
FROM
    customers
        JOIN
    orders;
-- inner join
SELECT 
    *
FROM
    customers c
        JOIN
    orders  o ON c.customerNumber = o.customerNumber;
-- left
-- left excluding
-- moi khach hang thu hien bn oder
SELECT 
 c.customerNumber, COUNT(o.orderNumber)
FROM
    customers c
        INNER JOIN
    orders  o ON c.customerNumber = o.customerNumber
    GROUP BY(c.customerNumber) ;

SELECT*FROM  customers;
SELECT*FROM orders;
-- moi kh dem lai boa nhieu doanh thu cho cua hang
SELECT*FROM orderdetails;
SELECT 
 c.customerNumber,SUM( os.priceEach*quantityOrdered)
FROM
    customers c
        INNER JOIN
    orders  o ON c.customerNumber = o.customerNumber
       INNER JOIN 
	 orderdetails as os ON o.orderNumber=os.orderNumber
      GROUP BY(c.customerNumber)
      ORDER BY SUM( os.priceEach);
 --  ke ten 5 mat hang so luong ban ra nhieu nhat 
 SELECT 
 p.productCode,SUM(o.quantityOrdered)
FROM
    products p
        JOIN
   orderdetails as o ON p.productCode=o.productCode
   GROUP BY (p.productCode);