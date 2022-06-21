sesi 9;
1.Buat project untuk folder nya.
2.Buka terminal, sesuaikan di folder untuk generate maven, kemudian lakukan command dibawah untuk generate maven.
  mvn archetype:generate -DgroupId=com.learning.thread -DartifactId=DemoThread -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
  note: Sesuaikan DartifactId= utk membuat nama folder yg di inginkan.
3.Setting pom.xml nya.
4.Pastikan atau sesuaikan junit nya, kemudian tambah depedency dibawah depedency junit dgn depedency dibawah ini.
  <dependency>
      <groupId>org.hamcrest</groupId>
      <artifactId>hamcrest-core</artifactId>
      <version>1.3</version>
      <scope>test</scope>
    </dependency>

5.Kemudian tambahkan script dibawah ini, diletak kan dibawah /depedencies
   <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
  </properties>

6.Lanjutkan script dibawah ini utk diletak kan di bawah properties
  <build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-jar-plugin</artifactId>
            <version>2.3.2</version>
            <configuration>
                <archive>
                    <manifest>
                        <mainClass>com.learning.challenge</mainClass> ////di sesuaikan sama nama folder
                    </manifest>
                </archive>
            </configuration>
        </plugin>
        <plugin>
	        <groupId>org.codehaus.mojo</groupId>
	        <artifactId>exec-maven-plugin</artifactId>
	        <version>1.6.0</version>
	        <configuration>
	          <mainClass>com.learning.challenge.Main</mainClass> //di sesuaikan sama nama folder
	        </configuration>
	    </plugin>
    </plugins>
  </build>

7.Kemudian buat file.xml utk data nya
8.Buat file java Main,Runner,Handler,Parser,Execution
9.

Thread = parent class
Bisa langsung di deklarasikan construct ThreadHello tanpa di deklarasikan.

Masuk folder do terminal,

perintah maven: 
mvn archetype:generate -DgroupId=com.learning.thread -DartifactId=DemoThread -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

integrasi maven vscode ke eclipse
mvn eclipse:eclipse

Import eclipse:
File - Import - General - Existing project - 

maven - clean - compile - install -test

eclipse.buildId=4.23.0.I20220308-0310
java.version=18.0.1.1
java.vendor=Oracle Corporation
BootLoader constants: OS=win32, ARCH=x86_64, WS=win32, NL=en_ID
Framework arguments:  -product org.eclipse.epp.package.java.product -product org.eclipse.epp.package.java.product
Command-line arguments:  -os win32 -ws win32 -arch x86_64 -product org.eclipse.epp.package.java.product -data file:/C:/Users/095060/eclipse-workspace/ -product org.eclipse.epp.package.java.product

org.eclipse.equinox.p2.metadata.repository
Error
Sat Jun 18 12:59:23 WIB 2022
No repository found at https://download.eclipse.org/eclipse/updates/4.23-P-builds/categories.

utk run folder app
mvn exec:java -Dexec.mainClass="com.ParsingXmlSax.module.Mail"
mvn exec:java -Dexec.mainClass="com.learning.dom.ParseKnownXMLStructure"
mvn exec:java -q

alexa :buat file xml
