package com.wipro.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/* Execution flow of before method and after method
 * @BeforeTest -> @BeforeMethod -> @Test -> @AfterMethod -> @AfterTest
 * 
 * -> @BeforeMethod and @AfterMethod is like body gaurds for @Test method
 * -> Every time @Test method will run first @BeforeMethod will execute After that @Test After that @AfterTest
 */

public class TestMethod {
	
	@BeforeTest
	void beforeTest() {
		System.out.println("Before Test");
	}
	
	@BeforeMethod
	void beforeMethod() {
		System.out.println("Before Method");
	}
	
	@Test
	void test() {
		System.out.println("Test");
	}
	
	@Test
	void test1() {
		System.out.println("Test1");
	}
	
	@Test
	void test2() {
		System.out.println("Test2");
	}
	
	@AfterMethod
	void afterMethod() {
		System.out.println("After Method");
	}
	
	@AfterTest
	void afterTest() {
		System.out.println("After Test");
	}

}

// Expected output for the above code. 
//Before Test
//Before Method
//Test
//After Method
//Before Method
//Test1
//After Method
//Before Method
//Test2
//After Method
//After Test
