DROP PROCEDURE IF EXISTS SP_ADD_ACCOUNT;
DELIMITER //
CREATE PROCEDURE SP_ADD_ACCOUNT
(OUT ACCOUNT_NO INT,
 IN CUSTOMER_NO INT,
 IN ACCOUNT_TYPE CHAR(1),
 IN CURRENCY CHAR(10),
 IN BALANCE DECIMAL(18,3) )
BEGIN
	SELECT MAX(ACCOUNT_ID) + 1 INTO ACCOUNT_NO FROM SP_ACCOUNT04A;
	IF ACCOUNT_NO IS NULL THEN
		SET ACCOUNT_NO = 1;
	END IF;
	INSERT INTO SP_ACCOUNT04A ( ACCOUNT_ID, CUSTOMER_NO, CURRENCY, TYPE, BALANCE )
	VALUES (ACCOUNT_NO, CUSTOMER_NO, CURRENCY, ACCOUNT_TYPE, BALANCE );
END //
DELIMITER ;
