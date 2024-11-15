package TestComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.google.common.io.Files;

import FrameWork1.Setup.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	public MainPage mainPage;
	public  WebDriver Initilizer() throws Exception {
		Properties prop= new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"//src//main//java//Resources//GlobalData.properties");
		prop.load(fis);
		String BrowserName = prop.getProperty("browser");
		
		if (BrowserName.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		if (BrowserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		return driver;
		
	}
@BeforeTest
public MainPage LaunchApplication() throws Exception
{
	driver=Initilizer();
	mainPage=new MainPage(driver);
	mainPage.GoTo();
	return mainPage;
}
@AfterTest
public void TearDown()
{
	driver.close();
}
public String TakeScreenShot(String TestCaseName, WebDriver driver) throws IOException
{
	TakesScreenshot ts = ((TakesScreenshot)driver);
	File src = ts.getScreenshotAs(OutputType.FILE);
	File FilePath = new File(System.getProperty("user.dir")+"//ScreenShots//"+TestCaseName+".png");
	Files.copy(src, FilePath);
	return System.getProperty("user.dir")+"//ScreenShots//"+TestCaseName+".png";
	
}
}
