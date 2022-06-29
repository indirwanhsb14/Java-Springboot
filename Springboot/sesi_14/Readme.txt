Sesi 14

MVC -> Model, View, Controller

 Model 	-> Mempresentasikan data dan logika bisnis, biasanya berhubungan dengan basis data.
 View		-> Menampilkan data atau mengatur tampilan ke pengguna.
 Controller	-> Menghubungkan antara view dengan mode.

Servlet
- penghubung client dan server
- servlet container berada di dalam web server

Aplikasi model umumnya memilik 2, yaitu: 
-> Servlet Controller yang menyediakan akses tunggal terhadap keseluruhan aplikasi.  Controller ini bertanggung jawab menyediakan manajemen terpusat terhadap alur  
   aplikasi dan juga service lain seperti penanganan security dan user management.
-> Controller servlet umumnya menggunakan konfigurasi XML untuk menentukan alur aplikasi danpemrosesan perintah. Hal itu juga membuat helper components  terasosiasikan  dengan user action dan dibuat/dipanggil untuk menangani actions  yang terjadi, memanggil komponen Model sebagaimana diperlukan. Hal ini  berfungsi untuk memisahkan antara controller servlet dari model.

Servlet -> menjadi penghubung client dan server dan berada di dalam web server.

Ada 4 poin yang harus di perhatikan dalam membangun servlet :
1. Kode program adalah kode Java biasa. Ada API baru, tapi tidak ada sintaks yang  baru.
2. Memiliki pernyataan import yang tidak familiar.
3. Turunan kelas dari kelas HTTPServlet. Servlet menyediakan berbagai macam fitur  untuk menangani HTTP.
4. Servlet memiliki method yang berbeda untuk menangani berbagai jenis perintah HTTP.

> Alur kerja servlet : client -> http req -> servlet container -> server -> response (HTML).

=JavaBean=

-> Memiliki konstruktor tanpa argument (default  constructor).
-> Memiliki atribut yang didefinisikan sebagai private.
-> Nilai variable di objek bean harus diakses melalui method getXxx dan SetXxx

keuntungan dari Java Bean :
1. Dengan menggunakan bean, halaman JSP dapat memanipulasi objek hanya  dengan menggunakan sintaks XML
2. Pada konstruksi JSP dan Java Bean, berbagi (sharing) obyek di antara  berbagai halaman atau request akan lebih mudah daripada menggunakan kode  Java Eksplisit
3. Konstruksi JSP dan Java Bean menyederhanakan proses request pada saat  membaca parameter, mengubah parameter dari string, dan menempatkan hasil  perubahan tersebut di dalam objek


JSP (Java Server Page) adalah suatu teknologi web berbasis bahsa pemrograman java dan berjalan di Platform Java, serta merupakan bagian teknologi J2EE (Java 2 Enterprise edition). JSP memiliki sifat-sifat sebagai berikut : 
1. Portable karena dibuat dengan teknologi java 
2. Manajemen memory 
3. Memiliki akses ke API Java yang lengkap seperti JDBC dan Java Mail 
4. Dapat menggunakan komponen yang portable dan reusable (JavaBean) 
5. Memiliki kinerja tinggi terhadap banyak request atau proses sekaligus dalam waktu  yang sama 
6. Mudah dalam deployment dan maintenance 

Keuntungan memakai JSP
1.Memisahkan presentasi static dan isi yang dinamik 
2.Menekankan komponen reusable 
3.Memudahkan pembuatan aplikasi dengan tag 
4.Berbasis pemrograman bahasa java 
5.Bagian dari platform Java 6.Terintegrasi dalam J2EE


=Spring Boot=

Spring boot
-> Spring merupakan framework Java yang mempermudah para programmer dalam membuat sebuah aplikasi Java dengan menerapkan salah satunya adalah design-patern : dependency-injection.

- Group Id -> nama organisasi / projek group
- Artifact -> nama projek
- Dependencies -> module yang dibutuhkan

- Source packages -> lokasi code, pembuatan controller, service, repositor, dll disini
- Test packages -> unit test
- Other source -> file-file html, css, js, img
- application.properties -> konfigurasi aplikasi
- webapp/WEB-INF/ -> tempat file html
