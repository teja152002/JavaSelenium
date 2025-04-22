package com.selenium.dynamicxpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicXpath {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		/*
		 * Ancestor -> Parent -> Child -> Descendant
		 * 
		 * GrandFather -> Parent -> Child -> Kid
		 * 
		 * GrandFather -> For Me, He is Ancestor
		 * 				Parent -> For Me, He is Parent
		 * 						Child 1 -> For Me , He is Preceding Sibling
		 * 						Child 2 -> Me
		 * 						Child 3 -> For Me, He is Following Sibling
		 * 								Kid 1 -> For Me, He is Descendant
		 *								Kid 2 ->
		 *
		 */

		String email = driver.findElement(By.xpath("//input[@id='email']/preceding-sibling::label[1]")).getText();
		System.out.println(email);
		
		String phno = driver.findElement(By.xpath("//input[@id='email']/following-sibling::label[1]")).getText();
		System.out.println(phno);
		
		String address = driver.findElement(By.xpath("//input[@id='email']/parent::div/following-sibling::div[1]/child::label")).getText();
		System.out.println(address);
	}

}

/*
 * Axis Name Description ancestor Shows all the ancestors (parent, grandparent,
 * etc.,) related to the context (current) node. ancestor-or-self Shows the
 * context (current) node and all the ancestors. attribute Shows all the
 * atributes of the context (current) node. child Shows all the children of the
 * context (current) node. descendant Specifies all descendants (children,
 * grandchildren, etc.) of the context (current) node. descendant-or-self
 * Specifies all descendants (children, grandchildren, etc.) of the context
 * (current) node and the current node itself. following Specifies all the nodes
 * that appear after the context (current) node. following-sibling Specifies all
 * siblings after the context (current) node. namespace Specifies all the
 * namespace nodes of the context (current) node. parent Specifies the parent of
 * the context (current) node. preceding Specifies all the nodes that appear
 * before the context (current) node in the HTML DOM structure. This does not
 * specify ancestor, attribute, and namespace. preceding-sibling Specifies all
 * the sibling nodes that appear before the context (current) node in the HTML
 * DOM structure. This does not specify descendent, attribute and namespace.
 * self Specifies the context (current) node.
 */