package FrameWork1.Setup;

import org.openqa.selenium.WebDriver;

import AbstractComponents.AbstractTestComponents;

public class MainPage extends AbstractTestComponents {
WebDriver driver;
	public MainPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
	}
	public void GoTo()
	{
		driver.get("https://google.com");
	}
	
	public void MainPageActions()
	{
		
	}

}

