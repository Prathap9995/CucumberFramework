package com.citi.Cucumber.AppHooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.citi.Cucumber.Resources.DriverFactory;
import com.citi.Cucumber.Utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks extends DriverFactory {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader config;
	Properties pro;
	
	@Before(order=0)
	public void getProperty() {
		config = new ConfigReader();
		pro =config.init_pro();
		
	}
	
	@Before(order=1)
	public void launchBrowser() {
		String browsername = pro.getProperty("browser");
		driverFactory = new DriverFactory();
		driverFactory.Init_Driver(browsername);
		
		
		
	}

	@After(order =0)
	public void quitBrowser() {
		driver.quit();
		
	}
	
	@After(order=1)
		public void teardown(Scenario sc) throws IOException {
		if(sc.isFailed()) {
	String screenshotname =		sc.getName().replaceAll(" ", "_");
		byte[] sourcePath =	((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(sourcePath, "image/png", screenshotname);
		}
		}
	}
	

