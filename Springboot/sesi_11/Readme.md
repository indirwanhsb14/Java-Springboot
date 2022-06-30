sesi 11
NoSQL Database, Gunakan MongoDB

Konsep Dasar : JSON vs BSONMongoDB menyimpan data dalam bentuk BSON document, lalu apa itu BSON dan adakah hubungannya dengan JSON?JSON adalah singkatan dari JavaScript Object Notation, JSON menjadi salah satu format data yang paling banyak digunakan untuk transfer data antara browser dan server.Pada dasarnya JSON hanya sebuah text yang memiliki format/syntax sebagai berikut:{"key" : "value"}Sedangkan BSON adalah singkatan dari Binary JSON, BSON memiliki beberapa keunggulan dibandingkan denganJSON diantaranya tingkat parsing yang lebih cepat dan mendukung lebih banyak tipe data native seperti :dates dan binary data.Introduction of NoSQL 

MongoDB    : BSON (binary json)
advantages : Parsing leibh cepat, mendukung tipe data native: dates, binary data

= Digunakan utk backup sinkronisasi yg banyak.


=============================================================

//Membuat Database
use database_name = membuat database

//Untuk melihat database yang sudah ada kita gunakan perintah
show dbs = database list

=============================================================

//Membuat Collection
db.createCollection("profile"); // membuat collection
show collections = list of collections

=============================================================
CRUD : Operasi CRUD (Create, Read, Update, Delete ) adalah operasi dasar di dunia database / storage.

//Create : Create berarti menambahkan data(selanjutnya kita sebut document) ke dalam collection
db.collection.insertOne(), //untuk menambahkan document tunggal/single
db.collection.insertMany(), //untuk menambahkan banyak documen

//Contoh menambahkan dokumen tunggal
db.collection.insertOne(); // tambah 1 dokumen
db.profile.insertOne({ name : "t-rex", color: "red" });
- otomatis dibuat ID

=============================================================

//Contoh menambahkan multi dokumen:
db.collection.insertMany(); // tambah banyak dokumen
db.profile.insertMany(
	[
		{ name:"tricera" },
		{ name:"brachio" }
	]
)

=============================================================

//Read : ead adalah membaca document yang ada di dalam MongoDB database
db.collection.find() // menampilkan semua data
db.profile.find()  

=============================================================

//Update : Untuk memperbaharui sebuah document kita gunakan method berikut:
	db.collection.updateOne(filter, update) , ubah satu document
	db.collection.updateMany(filter, update), ubah banyak document sekaligus sesuai filter
	db.collection.replaceOne(filter, update), ganti satu document dengan document yang barusesuai filter
	"db.collection.find({condition}); -> mencari data dengan filter"

//Untuk update
db.profile.find({ name: "t-rex" });

==============================================================

//Delete 
db.collection.deleteOne(filter), hapus satu document
db.collection.deleteMany(filter), hapus banyak document sekaligus sesuai filter

//Contoh 
db.collection.updateOne(filter, update)
db.profile.upadateOne({ color: "red" },{ $set: { name : "allo" } })

alternative : db.profile.update({ color: "red" },{ $set: { name : "allo" } })

===============================================================

db.profile.insertMany(
	[
		{ name:"tricera" },
		{ name:"brachio" }
	]
)

==================================================================

db.collection.updateMany(filter, update) -> update multiple
db.profile.updateMany({name: "t-rex"}, {$set:{color: "blue"}})

// upsert combination of insert and delete
db.profile.updateMany({name: "t-rex"}, {$set:{color: "blue"}}, {upsert: true})

==================================================================

db.collection.replaceOne(filter, update)

=================================================================

db.collection.deleteOne(filter)
db.profile.deleteOne({ name : "brachio" });

// jika banyak dokumen dengan nama yang sama,
// maka salah satu dokumen akan didelete secara random/urut
db.profile.deleteOne({ name : "t-rex" });

=================================================================


db.collection.deleteMany(filter)


//ONE TO ONE//


db.pasien.deleteMany({ name : "Foxy" })
db.penyakit.deleteMany({ penyakit : "flu" })

db.penyakit.insertOne({ _id: "sakit_0001", penyakit: "flu" });

// penyakit: "flu" -> (nama koleksi, reference value)


db.pasien.insertOne({ name : "Foxy", umur: 20, penyakit: "flu" });
var penyakit_flu = db.pasien.findOne().penyakit
db.penyakit.findOne({ penyakit : penyakit_id })

db.pasien.insertOne({ name : "Foxy", umur: 20, penyakit: "sakit_0001" });
var penyakit_id = db.pasien.findOne().penyakit
db.penyakit.findOne({ penyakit : penyakit_id })


//ONE TO MANY//


use transaksi_chandra
db.createCollection("pelanggan");
db.createCollection("transaksi"); 

// 1 pelanggan mempunyai banyak transaksi
db.pelanggan.insertOne({ _id : "PL0001", nama_pelanggan: "chandra" });

db.transaksi.insertMany(
	[
		{ _id : "TR0001", 
		  tanggal_transaksi : new Date(),  
          	  total_harga : 100000,
		  id_pelanggan : "PL0001"  
		},
		{ _id : "TR0002", 
		  tanggal_transaksi : new Date(),  
          	  total_harga : 199999,
		  id_pelanggan : "PL0001"  
		},
		{ _id : "TR0003", 
		  tanggal_transaksi : new Date(),  
          	  total_harga : 200000,
		  id_pelanggan : "PL0001"  
		}
	]
)

db.transaksi.find().pretty()
db.transaksi.findOne({ total_harga : 199999 })




//MANY TO MANY//


db.createCollection("detailtransaksi");
db.detailtransaksi.insertMany(
	[
		{no_trans : "TR0001", barang : "Gelas", jumlah : 3},
		{no_trans : "TR0001", barang : "Piring", jumlah : 6},
		{no_trans : "TR0001", barang : "Sendok", jumlah : 9}
	]
)

db.transaksi.aggregate({ $lookup : 
	{ 
		from : "detail_transaksi", 
		localField : "_id", 
		foreignField : "_id", 
		as : "detail" 
	} 
}) 


db.transaksi.aggregate([
	{ $lookup : 
		{ from : "detail_transaksi", 
		  localField : "_id", 
              foreignField : "no_trans", 
		  as : "detail"
		} 
	}, 
	{ $lookup : 
		{ from : "pelanggan", 
		  localField : "id_pelanggan", 
		  foreignField : "_id", 
		  as : "customer" 
		} 
	} 
])




//VALIDASI//

validasi -> pengecekan data yang dimasukkan

use barang_chandra
db.createCollection("barang", {
	validator : {
		$jsonSchema : {
			bsonType : "object",
			required : ["namabarang", "hargabarang", "jenisbarang", "description"],
			properties : {
				namaBarang : {
					bsonType : "string",
					description : "Nama Barang harus berupa karakter dan tidak boleh kosong!"
				},
				hargaBarang : {
					bsonType : "number", 
					description : "Harga Barang harus berupa number dan tidak boleh kosong!"
				},
				jenisBarang : {
					bsonType : "objectId", 
					description : "Jenis Barang harus berupa objectID dan tidak boleh kosong!"
				},
				description : {
					bsonType : "array",
					description : "Deskripsi harus berupa karakter dan tidak boleh kosong!",
					items : {
						bsonType : "object",
						required : ["merk", "ukuran", "stok"],
						properties: {
							merk : { bsonType : "string", 
					   	         	   description : "Ukuran harus berupa karakter dan tidak boleh kosong!"
							}, 
							ukuran : { bsonType : "string",
					                       description : "Ukuran harus berupa karakter dan tidak boleh kosong!"
							},
				            	stok : { bsonType : "number", 
				                           description : "Stok harus berupa angka dan tidak boleh kosong!"
				            	}
						}
			            }
	                   }
			}
		}
	}
})

=========================================================

SWAGGER

=========================================================


cara buat swagger:
1. File > new > other >
2. Tunggu download
3. Ganti versi release > krn kita pakai versi 2, jd menyesuaikan, swagger v.1,2 dan 3. (biar stabil atau support)

4.Tambahin dibawah </depedencies> atau di line 49. Script dibawah > Utk download swagger, swagger GUI tampilan, seperti postman, saat running ke server tinggal klik2.
  <dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.7.0</version>
		</dependency>
	
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.7.0</version>
		</dependency>

5.Buat contoh db di 
  Terus di resources, copy dibawah dan letak kan di application.properties
  # SERVER CONFIG
server.port=8080

#MySQL Connection
spring.datasource.url=jdbc:mysql://localhost:3306/db_hello?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

#HikariCP
spring.datasource.hikari.connection-timeout=20000
spring.datasource.hikari.minimum-idle=5
spring.datasource.hikari.maximum-pool-size=12
spring.datasource.hikari.idle-timeout=300000
spring.datasource.hikari.max-lifetime=12000
spring.datasource.hikari.auto-commit=true

#JPA CONFIGURATION
spring.jpa.database-platform=org.hibernate.dialect.MySQL5Dialect
spring.jpa.show-sql=true
spring.jpa.generate-ddl=false
spring.jpa.hibernate.ddl-auto=none

yg biasa dipakek test > src > main

6. Note: di DemoSpringHelloTests.Java di hapus yg di "import bawaan" dan di quickfix @SpringBootTest @Test.
7. Note: DI Pom.xml, klik kanan > maven > update project > centang force update > ok
8. 
@Bean . alamat wagger
postPaths 


Buat manggil controller nya :
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

cara muncul boot dashboard: windows > show view > other > boot dashboard

cara run: 
boot dashboard > klik kanan > di (re)start dulu jika belum, kemudian dari logo arah panah hijau klik kanan >
open web browser atau : http://localhost:8080/swagger-ui.html#!/hello45controller/sayHelloUsingGET
