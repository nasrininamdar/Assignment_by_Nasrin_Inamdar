package com.Login;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Home.BaseClass;

public class TC_01_LoginTest extends BaseClass {
	
	

	    @Test
	    public void SuccessfulLogintest() {
	    	
	    	
	    	
	    	// xpath of Email id and password 
	      
	        WebElement email = driver.findElement(By.xpath("//input[@id='username']"));
	        WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
	        
	        
	        //valid credential 
	        email.sendKeys("inamdar24nasrin@gmail.com");
	        pwd.sendKeys("Nasrin@123");

	        //click on Login button
	        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
	        loginBtn .click();

	       // apply assert for checking Login successful or not
	        String expUrl = "https://app.germanyiscalling.com/cv/upload/"; 
	        Assert.assertEquals(driver.getCurrentUrl(), expUrl, "Login was not successfull.");
	   

	  

}}


