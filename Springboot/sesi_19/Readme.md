Sesi-19

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