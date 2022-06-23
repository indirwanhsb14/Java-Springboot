Spring Version 2.7.0
Java 17
dependency -> Spring Boot DevTools, Spring Web, Spring Data JPA, MySQL Driver

application.properties
---
#MySQL Connection
spring.datasource.url=jdbc:mysql://localhost:3306/db_users?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root

# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.MySQL5InnoDBDialect
# To beautify or pretty print the SQL
spring.jpa.properties.hibernate.format_sql=true


# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto=update
# The simplest way to dump the queries
spring.jpa.show-sql=true

# he first line logs the SQL queries, and the second statement logs
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE

# Logging JdbcTemplate Queries
logging.level.org.springframework.jdbc.core.JdbcTemplate=DEBUG
logging.level.org.springframework.jdbc.core.StatementCreatorUtils=TRACE

com.example.spring.controller
-----

BelajarApiController.java : 
---
@RestController
@RequestMapping(value = "/belajar-api/v1")
public class BelajarApiController {
	
	@GetMapping(value = "/get")
	public String belajarApi() {
		return "Mari Belajar API Java Spring Boot";
	}

}


UserController.java :
----
@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	UserService userService;

	@CrossOrigin
	@GetMapping("/users")
	public List<User> list() {
		return userService.listAllUser();
	}

	@CrossOrigin
	@GetMapping("/users/{id}")
	public ResponseEntity<User> users(@PathVariable Integer id) {
		try {
			User user = userService.getUser(id);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin
	@PostMapping("/users")
	public void users(@RequestBody User user) {
		userService.saveUser(user);
	}

	@CrossOrigin
	@PutMapping("/users/{id}")
	public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id) {
		try {
			User existUser = userService.getUser(id);
			if (existUser.getId() != id) {
				return new ResponseEntity<>("ID Tidak Ada !!",HttpStatus.OK);
			}
			user.setId(id);
			userService.saveUser(user);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin
	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable Integer id) {
		userService.deleteUser(id);
	}

}


com.example.spring.model
---
User.java
---
@Entity
@Table(name = "users")
public class User {
	private int id;
	private String firstName;
	private String lastName;
	
	public User() {
		
	}
	
	public User(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}

com.example.spring.repository
---
UserRepository.java
---
public interface UserRepository extends JpaRepository<User, Integer> {
	
}

com.example.spring.service
----
UserService.java
---
@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> listAllUser() {
		return userRepository.findAll();
	}

	public void saveUser(User user) {
		userRepository.save(user);
	}

	public User getUser(Integer id) {
		return userRepository.findById(id).get();
	}

	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}

}


