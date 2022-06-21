CREATE DATABASE company;

CREATE TABLE Employee(
SSN CHAR(9) NOT NULL,
FName VARCHAR(15) NOT NULL,
MName CHAR,
LName VARCHAR(15) NOT NULL,
BDate DATE,
Address VARCHAR(30),
Sex CHAR,
Salary DECIMAL(10,2),
SuperSSN CHAR(9),
DNum INT NOT NULL,
CONSTRAINT Employee_SSN_PK PRIMARY KEY(SSN),
CONSTRAINT Employee_SuperSSN_FK FOREIGN KEY(SuperSSN) REFERENCES Employee(SSN) ON DELETE CASCADE);


CREATE TABLE Department(
DNumber INT NOT NULL,
DName VARCHAR(15) NOT NULL,
MgrSSN CHAR(9) NOT NULL,
MgrStartDate DATE,
CONSTRAINT Dept_DNumber_PK PRIMARY KEY(DNumber),
CONSTRAINT Dept_DName_Unique UNIQUE(DName),
CONSTRAINT Dept_MgrSSN_FK FOREIGN KEY(MgrSSN) REFERENCES Employee(SSN) ON DELETE CASCADE);

CREATE TABLE Dept_Locations(
DNum INT NOT NULL,
DLocation VARCHAR(15) NOT NULL,
CONSTRAINT DNumber_DLocation_PF PRIMARY KEY(DNum,DLocation),
CONSTRAINT DLoc_DNum_FK FOREIGN KEY(DNum) REFERENCES
Department(DNumber));

CREATE TABLE Project(
PNumber INT NOT NULL,
PName VARCHAR(15) NOT NULL,
PLocation VARCHAR(15),
DNum INT NOT NULL,
CONSTRAINT Project_PNumber_PK PRIMARY KEY(PNumber),
CONSTRAINT Project_PName_Unique UNIQUE(PName),
CONSTRAINT Project_DNum_FK FOREIGN KEY(DNum)REFERENCES Department(DNumber) ON DELETE CASCADE);

CREATE TABLE Works_On(
ESSN CHAR(9) NOT NULL,
PNum INT NOT NULL,
Hours DECIMAL(3,1) NOT NULL,
CONSTRAINT Works_ESSN_PNum_PK PRIMARY KEY(ESSN,PNum),
CONSTRAINT Works_ESSN_FK FOREIGN KEY(ESSN) REFERENCES Employee(SSN) ON DELETE CASCADE,
CONSTRAINT Works_PNum_FK FOREIGN KEY(PNum) REFERENCES Project(PNumber) ON DELETE CASCADE);

CREATE TABLE Dependent(
ESSN CHAR(9) NOT NULL,
Dependent_Name VARCHAR(15) NOT NULL,
Sex CHAR,
BDate DATE,
Relationship VARCHAR(8),
CONSTRAINT Dependent_ESSN_DepName_PK PRIMARY KEY(ESSN,Dependent_Name),
CONSTRAINT Dependent_ESSN_FK FOREIGN KEY(ESSN) REFERENCES
Employee(SSN));

INSERT INTO Employee VALUES('A111', 'Indirwan', 'Ihsan', 'Hasibuan', '1997-10-14','Medan', 'M', 15000000,'A111', 1);
INSERT INTO Employee VALUES('A112','Yusuf','Raja','Tamba','1987-02-29', 'Medan','M',4000000,null,2);
INSERT INTO Employee VALUES('A113','Winda',null,'Aja','1998-03-19','Jambi','F',4500000,null,3);
INSERT INTO Employee VALUES('A114','Kevin',null,'Pachira','1987-05-18','Kisaran','M',3500000,null,4);
INSERT INTO Employee VALUES('A115','Pevita',null,'Pearce','1986-06-16','Tangerang','F',3500000,'A111',1);
INSERT INTO Employee VALUES('A116','Raline',null,'Syah','1985-12-11','Jaksel','F',3500000,'A111',1);
INSERT INTO Employee VALUES('A117','Diana','Yosi','Haidar','1990-08-03','Bali','F',4500000,'A111',1);
INSERT INTO Employee VALUES('A118','Muhammad','Arif','Rojali','1992-06-05','Tangerang','M',3500000,'A111',1);
INSERT INTO Employee VALUES('A119','Muhammad','Riyadi','Pratama','1994-01-21','Jambi','M',3200000,'A111',2);
INSERT INTO Employee VALUES('A110','Andi',null,'Sasmita','1995-02-27','Bali','M',3750000,'A112',2);

INSERT INTO Department VALUES(1,'HRD','A111','2004-01-20');
INSERT INTO Department VALUES(2,'FINANCE','A112','2003-03-17');
INSERT INTO Department VALUES(3,'HUMAS','A113','2006-05-28');
INSERT INTO Department VALUES(4,'PRODUKSI','A114','2005-02-10');

INSERT INTO Dept_Locations VALUES(1,'Office Tower');
INSERT INTO Dept_Locations VALUES(3,'KCU');
INSERT INTO Dept_Locations VALUES(2,'Office Tower');
INSERT INTO Dept_Locations VALUES(4,'KCP');


INSERT INTO Project VALUES(1,'Database','Jakarta',1);
INSERT INTO Project VALUES(2,'Springboot','Jakarta',2);
INSERT INTO Project VALUES(3,'FrondEnd','Bekasi',2);
INSERT INTO Project VALUES(4,'BackEnd','Tangerang',2);
INSERT INTO Project VALUES(5,'QATest','Depok',3);
INSERT INTO Project VALUES(6,'Code','Bali',3);
INSERT INTO Project VALUES(7,'Break','Tangerang',4);
INSERT INTO Project VALUES(8,'Deep','Depok',4);

INSERT INTO Works_On VALUES('A111',1,90);
INSERT INTO Works_On VALUES('A111',2,98);
INSERT INTO Works_On VALUES('A112',2,55);
INSERT INTO Works_On VALUES('A112',3,78);
INSERT INTO Works_On VALUES('A113',3,53);
INSERT INTO Works_On VALUES('A113',4,77);
INSERT INTO Works_On VALUES('A114',4,77);
INSERT INTO Works_On VALUES('A114',5,98);
INSERT INTO Works_On VALUES('A114',7,85);
INSERT INTO Works_On VALUES('A114',8,68);
INSERT INTO Works_On VALUES('A115',5,57);
INSERT INTO Works_On VALUES('A115',6,87);
INSERT INTO Works_On VALUES('A116',7,45);
INSERT INTO Works_On VALUES('A116',6,87);
INSERT INTO Works_On VALUES('A117',7,40);
INSERT INTO Works_On VALUES('A117',8,88);
INSERT INTO Works_On VALUES('A118',1,78);
INSERT INTO Works_On VALUES('A118',8,87);
INSERT INTO Works_On VALUES('A119',1,88);
INSERT INTO Works_On VALUES('A119',2,65);
INSERT INTO Works_On VALUES('A110',2,34);
INSERT INTO Works_On VALUES('A110',3,78);

INSERT INTO Dependent VALUES('A111','Beni','M','2005-09-20','DAUGHTER');
INSERT INTO Dependent VALUES('A111','Beti','F','2007-12-01','SON');
INSERT INTO Dependent VALUES('A112','Wandi','M','1990-10-19','HUSBAND');
INSERT INTO Dependent VALUES('A112','Roy','M','2007-11-21','SON');
INSERT INTO Dependent VALUES('A113','Roby','M','1980-08-20','HUSBAND');
INSERT INTO Dependent VALUES('A113','Devy','F','01-Jan-2006','DAUGHTER');
INSERT INTO Dependent VALUES('A114','Susan','F','05-Sep-1987','WIFE');
INSERT INTO Dependent VALUES('A114','Ratih','F','10-Feb-2007','DAUGHTER');
INSERT INTO Dependent VALUES('A111','Dina','F','13-Jan-1987','WIFE');
INSERT INTO Dependent VALUES('A115','Riko','M','21-Mar-2006','SON');
INSERT INTO Dependent VALUES('A114','Rini','F','15-Aug-1987','WIFE');
INSERT INTO Dependent VALUES('A115','Tika','F','17-Dec-2005','DAUGHTER');
INSERT INTO Dependent VALUES('A112','Amel','F','08-Dec-1988','WIFE');
INSERT INTO Dependent VALUES('A116','Dito','M','05-Dec-2006','SON');
INSERT INTO Dependent VALUES('A117','Nindy','F','25-Jan-1987','WIFE');


1. Tampilkan dependent_name dan relationship dengan employee yang namanya diawali huruf R ?
= SELECT dependent_name, relationship FROM dependent JOIN employee ON employee.fname = dependent.dependent_name WHERE fname LIKE 'r%';
select
========================
d.dependent_name, e.fname from dependent as d

inner join employee as e on d.essn = e.ssn

where e.fname LIKE 'r%';


2. Banyaknya employee yang mengerjakan project PNum = 1 ?
= SELECT e.fname, w.pnum AS "TOTAL PROJECT" FROM works_on w JOIN employee e ON e.ssn = w.essn WHERE w.pnum = 1;

3.
= SELECT COUNT(ssn) FROM employee WHERE salary > 3500000;

4.
= SELECT COUNT(pnumber) FROM project WHERE dnum = 2;

5. 

SELECT SUM(e.salary), AVG(e.salary), d.dname AS "DEPARTMENT" FROM department d JOIN employee e ON d.dnumber = e.dnum GROUP BY d.dname;  

6.

SELECT COUNT(e.ssn), d.dname AS "DEPARTMENT" FROM department d JOIN employee e ON d.dnumber = e.dnum GROUP BY d.dname ORDER BY COUNT(e.ssn) ASC;  

7.

SELECT COUNT(hours), p.pname AS "PROJECT" FROM works_on w JOIN project p ON p.pnumber = w.pnum GROUP BY p.pname; 

8.

SELECT SUM(w.hours) AS "TOTAL KERJA", e.fname AS "NAMA" FROM works_on w JOIN employee e ON e.ssn = w.essn GROUP BY e.ssn HAVING SUM(w.hours) > 140 ORDER BY SUM(w.hours) DESC; 

9.

SELECT e.fname, CASE WHEN SUM(w.hours) >= 200 THEN '50%' WHEN SUM(w.hours) >= 150 THEN '20%' ELSE '10%' END BONUS FROM works_on w JOIN employee e ON w.essn = e.ssn GROUP BY w.essn, e.fname;

10.

SELECT COUNT(p.pnumber) AS "TOTAL PROJECT", e.fname AS "NAMA" FROM project p JOIN employee e ON e.dnum = p.dnum GROUP BY e.ssn ORDER BY COUNT(p.pnumber) DESC; 

11.


SELECT COUNT(p.pnumber) AS "TOTAL PROJECT", e.fname AS "NAMA" FROM project p JOIN employee e ON e.dnum = p.dnum GROUP BY e.ssn HAVING COUNT(p.pnumber) > 4 ORDER BY COUNT(p.pnumber) DESC; 

12.

SELECT AVG(w.hours) AS "TOTAL KERJA", e.fname AS "NAMA", COUNT(p.pnumber) FROM works_on w JOIN employee e ON e.ssn = w.essn JOIN project p ON e.dnum = p.dnum GROUP BY e.ssn HAVING AVG(w.hours) > 70 AND COUNT(p.pnumber) > 2 ORDER BY AVG(w.hours) DESC;  

13.


SELECT COUNT(relationship), relationship AS "TOTAL DEPENDANT" FROM dependent GROUP BY relationship;
 
14.

SELECT AGE(mgrstartdate) FROM department;  

15.

SELECT p.plocation, COUNT(p.plocation) FROM project p JOIN department d ON p.dnum = d.dnumber GROUP BY p.plocation HAVING COUNT(p.plocation) >= 2;