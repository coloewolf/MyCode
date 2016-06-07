CREATE DATABASE testReport;

USE testReport;

CREATE TABLE Goods(
	Good_Id INT(20) PRIMARY KEY,
	Good_Name VARCHAR(255),
	Good_Price INT(255),
	Selling_Price INT(255),
	Manufacturer VARCHAR(255)
);

CREATE TABLE Users(
	UserId INT(20) PRIMARY KEY,
	NAME VARCHAR(20),
	Age INT(20),
	Sex INT(1),
	AREA VARCHAR(30),
	tel INT(20)
);
	
CREATE TABLE TradingInf(
	Trading_Id INT(20) PRIMARY KEY,
	Trading_Goods_Id INT(20),
	Trading_User_Id INT(20),
	Trading_Number INT(20)
);

ALTER TABLE TradingInf ADD CONSTRAINT TradingInf_Goods_fk FOREIGN KEY(Trading_Goods_Id) REFERENCES Goods(Good_Id); 

ALTER TABLE TradingInf ADD CONSTRAINT TradingInf_Users_fk FOREIGN KEY(Trading_User_Id) REFERENCES users(UserId);