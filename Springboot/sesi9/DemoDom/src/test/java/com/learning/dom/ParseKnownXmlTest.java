package com.learning.sax;

import java.util.List;

public class ParseKnownXmlTest {
    public static void main(String[] args) {
        ParseKnownXml runner = new ParseKnownXml();
        List<User> lines = runner.parseUsers();

        lines.forEach(System.out::println);
    }
}