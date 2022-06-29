<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-core</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-web</artifactId>
		</dependency>
=========================
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>

From Arif to Everyone 09:05 AM
spring.security.user.name=user
spring.security.user.password=@123

From Arif to Everyone 09:10 AM
2.1.12.RELEASE
<properties>
		<java.version>1.8</java.version>
		<problem-spring-web.version>0.25.0</problem-spring-web.version>
	</properties>

================================

@RunWith(SpringRunner.class)
public class ProductServiceTest {

	@InjectMocks
	private ProductService productService = new ProductServiceImpl();

	@Mock
	private ProductRepository productRepository;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(productService, "productRepository", productRepository);
	}
}

=====================================

@Test
	public void testFindAll() {

		final List<Product> datas = TestObjectFactory.createProductList(10);
		Mockito.when(productRepository.findAll()).thenReturn(datas);

		final List<Product> actual = productService.findAllProduct();
		MatcherAssert.assertThat(actual.size(), Matchers.equalTo(datas.size()));
	}

==================================

Product product = productRepository.findById(id).orElse(new Product());
		return product;
Product product = productRepository.findById(id).orElse(new Product());
		productRepository.delete(product);

===========================================

@Test
	public void testProductById() throws Exception {

		final Long id = new Random().nextLong();
		final Product product = TestObjectFactory.createProduct();
		Mockito.when(productRepository.findById(id)).thenReturn(Optional.of(product));

		final Product actual = productService.findProductById(id);
		MatcherAssert.assertThat(actual.getId(), Matchers.equalTo(product.getId()));
		MatcherAssert.assertThat(actual.getName(), Matchers.equalTo(product.getName()));
		MatcherAssert.assertThat(actual.getHargaBeli(), Matchers.equalTo(product.getHargaBeli()));
		MatcherAssert.assertThat(actual.getHargaJual(), Matchers.equalTo(product.getHargaJual()));
	}

=====================================

Product product = productRepository.findById(id).orElse(new Product());
		return product;
Product product = productRepository.findById(id).orElse(new Product());
		productRepository.delete(product);
