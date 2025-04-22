package com.wipro.testng;

/*Execution is done based on ASCII values. 
 * It does not depends on Main method
 * 
 * -> Default test cases will run first. After that
 * 		priority test cases will run.
 * -> priority will run from lower to higher like (1,2,3...)
 * 
 * Priority:
 * -> By default it will be 0
 * -> If we assign priority as 0, then default priority value is less than 0.
 * -> priority will always as -3, -2, -1, 0, 1, 2, 3
 * -> If we don't set priority value, then it will execute based on ASCII values.
 * -> 0 - 9 -> ASCII values are 48 - 57
 * -> A - Z -> ASCII values are 65 - 90
 * -> a - z -> ASCII values are 97 - 122
 */
import org.testng.annotations.Test;

public class TestPriority {
	
	@Test(priority = 1)
	public static void method1() {
		System.out.println("method1");
	}
	
	@Test(priority = 2)
	public static void methodA() {
		System.out.println("methodA");
	}
	
	@Test
	public static void methodB() {
		System.out.println("methodB");
	}
	
	@Test(priority = -1)
	public static void methodb() {
		System.out.println("methodb");
	}


}

