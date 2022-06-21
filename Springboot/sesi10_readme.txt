https://codeshare.io/jvspringbfi

sesi 10;

utk jalankan xampp phpmyadmin dan adminer
1. Install xampp dan download adminer, link dibawah:
   xampp : https://www.apachefriends.org/download.html
   adminer : https://www.adminer.org/ , pilih adminer 4.8.1(php)
2. Di folder xampp buka folder PhpMyAdmin terus buka file config.inc.php atau jika mau cepat copy path dibawah.
   C:\xampp\phpMyAdmin\config.inc.php
3. Ganti file di line 19 menjadi copy atau copy code ini : $cfg['Servers'][$i]['auth_type'] = 'cookie';
4. Note: File adminer 4.8.1 di rename saja menjadi adminer biar lebih mudah.
   Note: https://github.com/pematon/adminer-custom (adminer custom much better)
5. Terus file adminer di copy ke folder htdocs, path : C:\xampp\htdocs
6. Buka Xampp Control, Start Apache dan MySQL nya.
7. Kemudian buka xampp di chrome : localhost/phpmyadmin
8. di username dibuat id : root , terus login
9. Change password username dan password, biar simpel buat username : root, pass: root
10. Kemudian buka adminer, localhost/adminer
11. Login pakai username dan pass xampp sebelumnya
12. Jika bisa selamat anda berhasil ke tahap selanjutnya


-----------
1. Create database h8_siakad / db_siakad / bfi_siakad
2. Create table tb_mahasiswa / mahasiswa
3. Create field (sesuaikan struktur table)
	> tabel mahasiswa
		id > pk (primary key), type data int  (11)big/int (21), auto increment (yg di db insialisasi primary key nya ID) (kalau di dlm coding, primary key nya nim bkn id), yg di join biasa nya id. (buat ngebantu ngambil identitas)
		nim(nomor induk mahasiswa) type data string (255) / 50 /100
		email (Unik)
		nama_mahasiswa		
		jenis_kelamin > string/varchar 50 / 2 > value data (P,L) . Perempuan/Laki laki (tidak dikecualikan)
					enum(P,L) / Perempuan/Laki-laki > jika diisi "yang lainnya" > ini tidak bisa (sudah dikecualikan)
					int (2) > 0,1 > comment 0=laki-laki, 1=perempuan
4. Insert record / insert data mahasiswa


==================================================================

Config GUI
1. Sesuai modul
2. create table > id > im > email > nama_mahasiswa > jenis_kelamin
3.Database > folder table
4. 
5. insert into tb_mahasiswa value
6. ga pakai public

contoh auto increment :
insert into tb_mahasiswa(nim, email, nama_mahasiswa, jenkel) values("123","arif@gmail.com","Laki-Laki");

yg ini di definisikan berdasarkan last id, cth 5 yg terakhir > (di dalam record/data)
insert into tb_mahasiswa(nim, email, nama_mahasiswa, jenkel) values(1,"123","arif@gmail.com","Laki-Laki");

Lebih simpel
insert into tb_mahasiswa values

===========================================
DDL
Data Definition Language(DDL)merupakan sintaks-sintaks yang berfungsi untuk melakukan manipulasi struktur dari basis data.Secara umum, DDL digunakan untuk membuat tabel dan view.Secara khusus dalam DBMS tertentu, DDL digunakan untuk membuat trigger, membuat stored procedure, juga membuat database, index, rule, schema, dan lainlain tergantung DBMS.Introduction of Database - Sesi 10 

Beberapa sintaks yang sering dijumpai dalam DDL. 
CREATE DATABASE: membuat basis data.
CREATE TABLE : membuat tabel. 
ALTER TABLE : merubah struktur suatu tabel.
DROP TABLE : menghapus suatu tabel.
CREATE INDEX : membuat suatu index dalam tabel.
DROP INDEX : menghapus suatu index dalam tabelIntroduction of Database - Sesi 10 

Jarang buat indexm biasnya Objek di generate, biar lebih simple

Challange : buat 5 table, nama table di ganti tb_pegawai atau langsung table.
	urutan:pegawai > gaji
		 pegawai > transaksi
		 transaksi > pembeli
		 transaksi > id menu

	foreign key pegawai :id_gaji
	foreign key pembeli : id_transaksi

	1.Buat db
	2.Buat table, nama:kantor
	3.Inser, Select(where, limit, join table),View, 



