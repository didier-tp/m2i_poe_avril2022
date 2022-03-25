CREATE DATABASE IF NOT EXISTS BaseGestionProjet ;
use BaseGestionProjet;

DROP TABLE IF EXISTS employe;

DROP TABLE IF EXISTS Phase;
DROP TABLE IF EXISTS Projet;

CREATE TABLE employe(
	EMP_ID INTEGER auto_increment,
	firstname VARCHAR(64),
	lastname VARCHAR(64),
	PHONE_NUMBER VARCHAR(64),
	email VARCHAR(64),
	LOGIN VARCHAR(32),
	password VARCHAR(64),
	PRIMARY KEY(EMP_ID));	
	
CREATE TABLE projet(
	code INTEGER auto_increment,
	nom VARCHAR(64),
	description VARCHAR(128),
	date_debut VARCHAR(12),
	date_fin VARCHAR(12),
	montant DOUBLE,
	PRIMARY KEY(code));	
	
CREATE TABLE phase(
	code INTEGER auto_increment,
	label VARCHAR(64),
	description VARCHAR(128),
	date_debut VARCHAR(12),
	date_fin_prevue VARCHAR(12),
	date_fin_effective VARCHAR(12),
	proportion_projet DOUBLE,
	code_projet INTEGER,
	PRIMARY KEY(code));	
	
ALTER TABLE phase ADD CONSTRAINT phase_associe_a_projet_valide	
FOREIGN KEY (code_projet) REFERENCES projet(code);
	
INSERT INTO employe (EMP_ID,firstname,lastname,PHONE_NUMBER,email,LOGIN,password) 
   VALUES (1,'alain', 'Therieur' , '0102030405' , 'alain.therieur@xyz.com','login1','pwd1');
INSERT INTO employe (EMP_ID,firstname,lastname,PHONE_NUMBER,email,LOGIN,password) 
   VALUES (2,'axelle', 'Aire' , '0102030405' , 'axelle.aire@m2i.com','login2','pwd2');
INSERT INTO employe (EMP_ID,firstname,lastname,PHONE_NUMBER,email,LOGIN,password) 
   VALUES (3,'luc', 'Azerty' , '0102030405' , 'luc.azertye@m2i.com','login3','pwd3');    
   
SELECT * from employe;   