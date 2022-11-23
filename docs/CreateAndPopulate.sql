DROP Table IF EXISTS 'Account';
DROP Table IF EXISTS 'AccountType';
DROP Table IF EXISTS 'Client';
DROP Table IF EXISTS 'Bank';

CREATE Table 'Bank' (
	'id' INTEGER, 
	'name' TEXT NOT NULL, 
	PRIMARY KEY ('id')
);
INSERT INTO 'Bank' ('name') VALUES ('Banca BCR');
INSERT INTO 'Bank' ('name') VALUES ('Banca BCR');

CREATE Table 'Client' (
	'id' INTEGER,
	'name' TEXT NOT NULL,
	'address' TEXT NOT NULL,
	'birth' DATE NULL DEFAULT NULL,
	'bankId' INTEGER NOT NULL,
	PRIMARY KEY ('id'),
	CONSTRAINT 'Client_Bank' FOREIGN KEY ('bankId') REFERENCES 'Bank' ('id') ON UPDATE NO ACTION ON DELETE CASCADE
);
INSERT INTO 'Client' ('name', 'address', 'bankId') VALUES ('Ionescu Ion', 'Timisoara', 1);
INSERT INTO 'Client' ('name', 'address', 'bankId') VALUES ('Marinescu Marin', 'Timisoara', 1);
INSERT INTO 'Client' ('name', 'address', 'bankId') VALUES ('Vasilescu Vasile', 'Brasov', 2);


CREATE TABLE 'AccountType' (
	'id' INTEGER,
	'name' TEXT NOT NULL,
	PRIMARY KEY ('id')
);
INSERT INTO 'AccountType' ('name') VALUES ('EUR');
INSERT INTO 'AccountType' ('name') VALUES ('RON');


CREATE TABLE 'Account' (
	'id' INTEGER,
	'code' TEXT NOT NULL,
	'amount' REAL NOT NULL DEFAULT 0,
	'clientId' INTEGER NOT NULL,
	'accountTypeId' INTEGER NOT NULL,
	PRIMARY KEY ('id'),
	CONSTRAINT 'Account_Client' FOREIGN KEY ('clientId') REFERENCES 'Client' ('id') ON UPDATE NO ACTION ON DELETE CASCADE,
	CONSTRAINT 'Account_AccountType' FOREIGN KEY ('accountTypeId') REFERENCES 'AccountType' ('id') ON UPDATE NO ACTION ON DELETE CASCADE
);

INSERT INTO 'Account' ('code', 'amount','clientId','accountTypeId') VALUES ('EUR001', 200, 1, 1);
INSERT INTO 'Account' ('code', 'amount','clientId','accountTypeId') VALUES ('RON001', 400, 1, 2);
INSERT INTO 'Account' ('code', 'amount','clientId','accountTypeId') VALUES ('RON002', 200, 2, 2);
INSERT INTO 'Account' ('code', 'amount','clientId','accountTypeId') VALUES ('EUR002', 700, 3, 1);