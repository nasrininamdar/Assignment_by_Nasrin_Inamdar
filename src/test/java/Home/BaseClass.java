package Home;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	
	public static WebDriver driver;
	
	@BeforeClass
	public void setup() {
		String browser = "chrome";
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox ":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			driver = null;
			break;

		}

		// implicit wait is applicable to all webElements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
		
		// open url
				driver.get("https://app.germanyiscalling.com/");

				driver.manage().window().maximize();

	}

	@AfterClass
	public void tearDown() {
		//close the application
		driver.close();
		driver.quit();
	}
	
	
	public void capuringScreenshot(WebDriver driver, String testName) throws IOException {
	
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\DELL\\eclipse-workspace\\Assignment\\Screenshots" );
		FileUtils.copyFile(src, dest);
		
	}
	
	
	
	
	
	

}
