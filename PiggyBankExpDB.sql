drop database if exists piggybank;

-- Create new database and connect it
create database if not exists piggybank;
use piggybank;

CREATE TABLE if not exists user
(	PersonID	CHAR(5)				NOT NULL,
	FirstName	VARCHAR(15)		NOT NULL,
    LastName	VARCHAR(15)		NOT NULL,
	WeeklyAllow	NUMERIC(6,2)			NOT NULL,
    Income	NUMERIC(7,2)		NOT NULL,
    
    PRIMARY KEY	(PersonID)	);
    
CREATE TABLE if not exists transaction 
(	TransID		CHAR(5)				NOT NULL,
	PersonID		CHAR(5)				NOT NULL,
    Category	VARCHAR(25)			NOT NULL,
    Description	VARCHAR(25)			NOT NULL,
    Cost		NUMERIC(6,2)		NOT NULL, 
    TransDate	DATE				NOT NULL,
    
    PRIMARY KEY (TransID),
    FOREIGN KEY	(PersonID) REFERENCES user(PersonID)	);
    




    
    
    
    
   