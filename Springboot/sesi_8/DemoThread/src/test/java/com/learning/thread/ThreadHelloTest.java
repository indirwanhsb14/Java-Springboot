package com.learning.thread;

import org.junit.Test;

public class ThreadHelloTest {
    
    public ThreadHelloTest(){

    }
    
    @Test
    public void testRun() {
        System.out.println("----------");
            for(int i=0; i<10; i++) {
            ThreadHello instance = new ThreadHello(String.valueOf(i));
            Thread t = new Thread(instance);
            t.start();
        }
    }
}
    
