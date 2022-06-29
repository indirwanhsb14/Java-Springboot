

firebase
----

modify pom
------------------------------------------------------------
<parent>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-parent</artifactId>
  <version>2.7.1</version>
  <relativePath/> <!-- lookup parent from repository -->
</parent>

<properties>
  <java.version>1.8</java.version>
</properties>

<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
  <optional>true</optional>
</dependency>

<dependency>
    <groupId>com.google.firebase</groupId>
    <artifactId>firebase-admin</artifactId>
    <version>7.0.0</version>
</dependency>  



taruh file firebase di > src/main/resources/firebase-service-account.json
------------------------------------------------------------
ganti nama firebase menjadi > firebase-service-account.json



modify controller default BelajarSpringNotifApplication.java
------------------------------------------------------------
@SpringBootApplication
public class BelajarSpringNotifApplication {

	@Bean
	FirebaseMessaging firebaseMessaging() throws IOException {
		GoogleCredentials googleCredentials = GoogleCredentials
				.fromStream(new ClassPathResource("firebase-service-account.json").getInputStream());
		FirebaseOptions firebaseOptions = FirebaseOptions.builder().setCredentials(googleCredentials).build();
		FirebaseApp app = FirebaseApp.initializeApp(firebaseOptions, "my-app");
		return FirebaseMessaging.getInstance(app);
	}

	public static void main(String[] args) {
		SpringApplication.run(BelajarSpringNotifApplication.class, args);
	}
}


create controller NoteController.java
------------------------------------------------------------
@Controller
public class NoteController {

    private final FirebaseMessagingService firebaseService;

    public NoteController(FirebaseMessagingService firebaseService) {
        this.firebaseService = firebaseService;
    }

    @RequestMapping("/send-notification")
    @ResponseBody
    public String sendNotification(@RequestBody Note note,
                                   @RequestParam String topic) throws FirebaseMessagingException {
        return firebaseService.sendNotification(note, topic);
    }
}


create pojo Note.java
------------------------------------------------------------
@Data
public class Note {
    
	private String subject;
    private String content;
    private Map<String, String> data;
    private String image;
    
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Map<String, String> getData() {
		return data;
	}
	public void setData(Map<String, String> data) {
		this.data = data;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}          
}


create service FirebaseMessagingService.java
------------------------------------------------------------
@Service
public class FirebaseMessagingService {

    private final FirebaseMessaging firebaseMessaging;

    public FirebaseMessagingService(FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
    }


    public String sendNotification(Note note, String topic) throws FirebaseMessagingException {

        Notification notification = Notification
                .builder()
                .setTitle(note.getSubject())
                .setBody(note.getContent())
                .setImage(note.getImage())
                .build();

        Message message = Message
                .builder()
                .setTopic(topic)
                .setNotification(notification)
                .putAllData(note.getData())
                .build();

        return firebaseMessaging.send(message);
    }

}


cara menggunakan fcm > buka postman
------------------------------------------------------------
- pilih get
- masukan url > http://localhost:8080/send-notification?topic=gold (sesuaikan)
- topic=gold >>> topic adalah parameter, gold adalah value parameter
- pilih body > buka tab raw (ganti menjadi json) > masukan isi body seperti berikut (sesuaikan isi data nya)
	{
    "subject": "some subject",
    "content": "Some long content",
    "image": "https://upload.wikimedia.org/wikipedia/en/9/95/Test_image.jpg",
    "data": {
      "key1": "Value 1",
      "key2": "Value 2",
      "key3": "Value 3",
      "key4": "Value 4"
    }
}

