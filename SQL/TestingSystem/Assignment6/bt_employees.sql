USE employees;
DROP PROCEDURE IF EXISTS get_department_name;
DELIMITER $$
CREATE PROCEDURE get_department_name (IN in_dept_no CHAR(4),OUT out_department_name VARCHAR(40))
BEGIN
	SELECT dept_name INTO out_department_name
	FROM departments
	WHERE dept_no=in_dept_no;
END$$
DELIMITER ;
SET @v_department_1_name='';
CALL get_department_name('d001',@v_department_1_name);
SELECT @v_department_1_name;

