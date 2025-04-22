package com.wipro.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClassMethod {
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}

	@Test

	public void test() {
		System.out.println("Test");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}

}

class TestNG {

	@BeforeTest
	void beforeTest() {
		System.out.println("Before Test NG");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class NG");
	}

	@Test

	public void test() {
		System.out.println("Test class NG");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class NG");
	}

	@AfterTest
	void afterTest() {
		System.out.println("After Test NG");
	}
}
