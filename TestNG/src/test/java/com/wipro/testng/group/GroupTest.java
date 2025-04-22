package com.wipro.testng.group;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GroupTest {

	@BeforeTest
	void beforeTest() {
		System.out.println("Before Test");
	}

	@Test(groups = "smoke")
	void test1() {
		System.out.println("Test 1");
	}

	@Test(groups = { "regression", "smoke" })
	void test2() {
		System.out.println("Test 2");
	}

	@Test(groups = {"regression", "sanity"})
	void test3() {
		System.out.println("Test 3");
	}

	@Test(groups = "smoke")
	void test4() {
		System.out.println("Test 4");
	}

	@Test(groups = "regression")
	void test5() {
		System.out.println("Test 5");
	}

	@AfterTest
	void afterTest() {
		System.out.println("After Test");
	}

}
