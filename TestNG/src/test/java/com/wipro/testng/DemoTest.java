package com.wipro.testng;

/*Execution is done based on ASCII values. 
 * It does not depends on Main method
 */
import org.testng.annotations.Test;

public class DemoTest {
	
	@Test
	public static void method1() {
		System.out.println("method1");
	}
	
	@Test
	public static void methodA() {
		System.out.println("methodA");
	}
	
	@Test
	public static void methodB() {
		System.out.println("methodB");
	}
	
	@Test
	public static void methodb() {
		System.out.println("methodb");
	}


}
