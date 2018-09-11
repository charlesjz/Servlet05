CREATE TABLE [SP_CUSTOMER04A] (
	[CUSTOMER_NO] [int] NOT NULL ,
	[FIRST_NAME] [char] (32) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[LAST_NAME] [char] (32) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[PHONE_NUMBER] [char] (32) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[ADDRESS] [char] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[EMAIL] [char] (32) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[CREDIT_LIMIT] [int] NOT NULL ,
	CONSTRAINT [PK_SP_CUSTOMER04A] PRIMARY KEY  CLUSTERED 
	(
		[CUSTOMER_NO]
	)  ON [PRIMARY] 
) ON [PRIMARY]
GO

CREATE TABLE [SP_ACCOUNT04A] (
	[ACCOUNT_ID] [int] NOT NULL ,
	[CUSTOMER_NO] [int] NOT NULL ,
	[CURRENCY] [char] (10) COLLATE Latin1_General_CS_AI NOT NULL ,
	[TYPE] [char] (1) COLLATE Latin1_General_CS_AI NOT NULL ,
	[BALANCE] [decimal](18, 3) NOT NULL ,
	CONSTRAINT [PK_SP_ACCOUNT04A] PRIMARY KEY  CLUSTERED 
	(
		[ACCOUNT_ID]
	)  ON [PRIMARY] ,
	CONSTRAINT [FK_SP_ACCOUNT04A_SP_CUSTOMER04A] FOREIGN KEY 
	(
		[CUSTOMER_NO]
	) REFERENCES [SP_CUSTOMER04A] (
		[CUSTOMER_NO]
	)
) ON [PRIMARY]
GO


drop procedure SP_ADD_ACCOUNT;
create procedure SP_ADD_ACCOUNT
	@ACCOUNT_ID int OUTPUT,
	@CUSTOMER_NO int,
	@TYPE char (1),
	@CURRENCY char (10),
	@BALANCE  decimal (18, 3)
as
--declare @ACCOUNT_ID int
begin
set @ACCOUNT_ID = (SELECT max(ACCOUNT_ID) + 1 FROM SP_ACCOUNT04A);
INSERT INTO SP_ACCOUNT04A ( ACCOUNT_ID, CUSTOMER_NO, TYPE, CURRENCY, BALANCE )
	VALUES ( @ACCOUNT_ID, @CUSTOMER_NO, @TYPE, @CURRENCY, @BALANCE );
--  return @ACCOUNT_ID;
end;

