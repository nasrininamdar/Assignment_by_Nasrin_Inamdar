package com.Login;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Home.BaseClass;

public class TC_03_LoginTest extends BaseClass {
	

	@Test
	public void forEmptyUnsuccessfulLogintest() {
		
	   	// xpath of Email id and password 
	    WebElement email = driver.findElement(By.xpath("//input[@id='username']"));
	    WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
	    
	    
        //empty credential 
	    email.sendKeys(" ");
	    pwd.sendKeys(" ");

	    //click on Login button
	    WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
	    loginButton.click();

	    
	    WebElement errormsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']//ul"));
	    
	    // apply assert for checking Login unsuccessful
	    Assert.assertTrue(errormsg .isDisplayed(), "error message is not displayed..");
	    Assert.assertEquals(errormsg .getText(), "empty credentials", "Email: This field is required.\r\n"
	    		+ "Password: This field is required");
	}


}
