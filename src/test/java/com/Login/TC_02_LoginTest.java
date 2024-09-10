package com.Login;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Home.BaseClass;

public class TC_02_LoginTest  extends BaseClass{

	@Test
	public void UnsuccessfulLogintest() {
		
	   	// xpath of Email id and password 
	    WebElement email = driver.findElement(By.xpath("//input[@id='username']"));
	    WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
	    
	    
	    
        //invalid credential 
	    email.sendKeys("abc@gmail.com");
	    pwd.sendKeys("1234");

	    //click on Login button
	    WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
	    loginButton.click();

	    
	    WebElement errormsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']//ul"));
	    
	    // apply assert for checking Login unsuccessful 
	    Assert.assertTrue(errormsg .isDisplayed(), "error message is not displayed..");
	    Assert.assertEquals(errormsg .getText(), "Invalid credentials", "Please enter a correct username and password. Note that both fields may be case-sensitive.");
	}

}
