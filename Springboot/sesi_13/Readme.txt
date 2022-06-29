Sesi 13 

= Hibernate =

ORM > Object Relationship Mapping
-> ORM adalah Jembatan antara OOP dengan Database Relational.
	cara (ORM) yang paling sering dipakai : pemetaan query ke dalam class (POJO) / java beans

POJO > Plain Old Java Object
-> Class pada Java yang hanya berisi Variabel dan getter setter TANPA ada method proses lainnya.

DAO > Data Access Object
-> Class Java yang berisi operasi CRUD ( Create Retrieve Update Delete)
	POJO nge mapping database menjadi Parameter DAO yang dibuat.

Database di mapping menggunakan POJO, Lalu Proses CRUD dikerjakan menggunakan DAO.

Hibernate ORM
library object-relational mapping untuk bahasa pemrograman Java, yang menyediakan kerangka kerja
(framework) untuk memetakan model object-oriented domain ke database relasional tradisional.
Hibernate ini menyediakan framework untuk Java untuk koneksi ke database relasional seperti MySQL, SQL
Server, Oracle, DB2, dan lain-lain.