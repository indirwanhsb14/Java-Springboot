package com.learning.thread;

import org.junit.Test;

public class ThreadWorldTest {
    
    public ThreadWorldTest(){

    }

    @Test
	public void testRun() {
		System.out.println("----------");
		for(int i=0; i<10; i++) {
			int tes = i * i * i;
			ThreadWorld instance = new ThreadWorld(String.valueOf(tes));
			Thread t = new Thread(instance);
			t.start();
		}
	}
}
