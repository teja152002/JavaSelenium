package com.wipro.testng;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 * Test has 3 types"
 * 1. Before Test(@BeforeTest)-> It will execute before the test begins
 * 2. Test(@Test)-> It will execute after before test
 * 3. After Test(@AfterTest) -> It will execute after the test.
 * 
 * -> It is good approach to place only one @BeforeTest and @AfterTest.
 * -> In between @BeforeTest and @AfterTest, we can place n numbers of @Test methods
 * -> Test execution flow is follows as -> @BeforeTest -> @Test -> @AfterTest
 */
public class TestType {
	
	@BeforeTest
	void beforeTest() {
		System.out.println("Before Test");
	}
	
	@Test
	void test() {
		System.out.println("Test");
	}
	
	@Test
	void test1() {
		System.out.println("Test1");
	}
	
	@AfterTest
	void afterTest() {
		System.out.println("After Test");
	}
	
	


}
