package com.wipro.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass {
	
	@BeforeTest
	void beforeTest() {
		System.out.println("Before Test");
	}
	
	@BeforeMethod
	void beforeMethod() {
		System.out.println("Before Method");
	}
	
	@BeforeClass
	void beforeClass() {
		System.out.println("Before Class");
	}
	
	@AfterClass
	void afterClass() {
		System.out.println("After Class");
	}
	
	@Test
	void test() {
		System.out.println("Test");
	}
	
	@Test
	void test1() {
		System.out.println("Test1");
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
