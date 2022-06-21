package com.learning.sax;

public class SaxExTest {
    public static void main(String[] args) throws ParserConfigurationException {
		// TODO Auto-generated method stub
		MyRunner runner = new MyRunner();
		List<User> lines = runner.parseUsers();
		
		lines.forEach(System.out::println);
	}

}
