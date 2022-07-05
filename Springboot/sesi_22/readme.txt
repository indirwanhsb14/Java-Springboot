Code coverage

1. mengikuti stepbystep by https://codeshare.io/bfispring_sesi22
2. open terminal
3. cd C:\sonarqube\bin\windows-x86-64
4. dir
5. StartSonar.bat
6. open web sonarqube
7. create project -> manually->kasih nama-> locally -> klik generate-> continue-> pilih maven-> (get token)
8. open terminal in eclipse
9. copypaste(shift+insert) token sonarqube / mvn sonar:sonar
10. get url http://localhost:9191 .....
11. copy
12. open web browser -> paste

result di capture => result di web(result,code smell) and eclipse(build success, folder target, sonar)

example token when latihan: (enternya dihapus dan slash ditambah spasi)
mvn clean verify sonar:sonar \  -Dsonar.projectKey=BelajarSonar \  -Dsonar.host.url=http://localhost:9000 \  -Dsonar.login=sqp_c6ff4c7885347f9cb392447d87cef60c1f3f81d7

modify pada pom
------------------------------------------------------------------------------------------
<parent>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-parent</artifactId>
  <version>2.1.12.RELEASE</version>
  <relativePath /> <!-- lookup parent from repository -->
</parent>

<properties>
  <java.version>1.8</java.version>

  <problem-spring-web.version>0.25.0</problem-spring-web.version>
  <jacoco.version>0.8.3</jacoco.version>

  <sonar.java.coveragePlugin>jacoco</sonar.java.coveragePlugin>
  <sonar.dynamicAnalysis>reuseReports</sonar.dynamicAnalysis>
  <sonar.jacoco.reportPath>${project.basedir}/../target/jacoco.exec</sonar.jacoco.reportPath>
  <sonar.language>java</sonar.language>
</properties>

default pom sebelumnya (pada assigment 3)
------------------------------------------------------------------------------------------
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-devtools</artifactId>
  <scope>runtime</scope>
  <optional>true</optional>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-test</artifactId>
  <scope>test</scope>
</dependency>

<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <scope>runtime</scope>
</dependency>

<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
  <optional>true</optional>
</dependency>

yang di tambah di sesi 20 
------------------------------------------------------------------------------------------
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-security</artifactId>
</dependency>


yang di tambah di sesi 22
------------------------------------------------------------------------------------------
<!-- Random String generator -->
<dependency>
  <groupId>org.apache.commons</groupId>
  <artifactId>commons-lang3</artifactId>
  <version>3.9</version>
</dependency>

<!-- For Testing-->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-test</artifactId>
  <scope>test</scope>
  <exclusions>
    <exclusion>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
    </exclusion>
  </exclusions>
</dependency>

<dependency>
  <groupId>org.junit.jupiter</groupId>
  <artifactId>junit-jupiter-engine</artifactId>
  <scope>test</scope>
</dependency>

<dependency>
  <groupId>org.junit.jupiter</groupId>
  <artifactId>junit-jupiter-params</artifactId>
  <scope>test</scope>
</dependency>

<dependency>
  <groupId>org.junit.platform</groupId>
  <artifactId>junit-platform-launcher</artifactId>
  <version>1.3.2</version>
  <scope>test</scope>
</dependency>

<dependency>
  <groupId>org.junit.vintage</groupId>
  <artifactId>junit-vintage-engine</artifactId>
  <version>5.3.2</version>
  <scope>test</scope>
</dependency>

<dependency>
  <groupId>org.mockito</groupId>
  <artifactId>mockito-junit-jupiter</artifactId>
  <scope>test</scope>
</dependency>

<!-- mapper -->
<dependency>
  <groupId>org.zalando</groupId>
  <artifactId>problem-spring-web-starter</artifactId>
  <version>${problem-spring-web.version}</version>
  <type>pom</type>
</dependency>



di plugin pada pom di tambah baris berikut :
------------------------------------------------------------------------------------------
<plugin>
<groupId>org.jacoco</groupId>
<artifactId>jacoco-maven-plugin</artifactId>
<version>${jacoco.version}</version>
<configuration>
  <skip>${maven.test.skip}</skip>
  <destFile>${basedir}/target/coverage-reports/jacoco-unit.exec</destFile>
  <dataFile>${basedir}/target/coverage-reports/jacoco-unit.exec</dataFile>
  <output>file</output>
  <append>true</append>
  <excludes>
    <exclude>*MethodAccess</exclude>
  </excludes>
</configuration>
<executions>
  <execution>
    <id>jacoco-initialize</id>
    <goals>
      <goal>prepare-agent</goal>
    </goals>
    <phase>test-compile</phase>
  </execution>
  <execution>
    <id>jacoco-site</id>
    <phase>verify</phase>
    <goals>
      <goal>report</goal>
    </goals>
  </execution>
</executions>
</plugin>



reference
----