/*============================== CREATE DATABASE =======================================*/
/*======================================================================================*/

DROP DATABASE IF EXISTS QLUser;
CREATE DATABASE QLUser;
USE QLUser;

/*============================== CREATE TABLE =======================================*/
/*======================================================================================*/

-- create table 1: Department  id, FullName, Email, Password
CREATE TABLE `User`(
	UserID 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	FullName 	VARCHAR(50) UNIQUE KEY NOT NULL,
    Email 		VARCHAR(50) UNIQUE KEY NOT NULL,
    `Password`	VARCHAR(50) NOT NULL CHECK(length(`Password`) >= 6),
    `Role`		ENUM('USER', 'MANAGER')
);
CREATE TABLE Project (
projectID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
teamSize  INT NOT NULL,
idManager	TINYINT NOT NULL,
idEmployees  INT NOT NULL
);




/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/

INSERT INTO `User`  (UserID   , FullName, 			Email,				    `Password`,			`Role`		) 
VALUES
					(1,			N'Nguyen Duc Manh','nguyenducmanh@gmail.com', 'M123456',		     'MANAGER'	),
					(2,			N'Ngo Hai Ninh','ninhhaingo@gmail.com',       'Aabcdxyz',			'USER'	),
                    (3,			N'Tran Lan Anh','tranlananh@gmail.com',      'Alanhanhhh',			'USER'	),
                    (4,			N'Dam Phuong Uyen',	'phuonguyen@gmail.com',   'A09012001',		     'USER'),
                    (5,			N'Nguyen Trong Nghia','nghianguyen@gmail.com','Akhongcho',		'USER'	);
                    
 
INSERT INTO Project  (projectID   , teamSize  , 			idManager,				    idEmployees				) 
VALUES
					(1,			     3       ,            11,                                       123	),
					(2,			    2,                    22,                                     124	              ),
                    (3,			     3,                   33,                                   125),
                    (4,			    3,                     44,                                      126),
                    (5,			    3,                      55,                                     127);                   
                    
                    
                    