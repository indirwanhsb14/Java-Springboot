package com.learning.sax;

import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

public class SaxEx {

	public static void main(String[] args) throws ParserConfigurationException {
		// TODO Auto-generated method stub
		MyRunner runner = new MyRunner();
		List<User> lines = runner.parseUsers();
		
		lines.forEach(System.out::println);
	}

}