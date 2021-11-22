package com.citi.Cucumber.Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public WebDriver Init_Driver(String browser) {

		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver.exe");
			tlDriver.set(new ChromeDriver());
		}
		else {
			System.out.println("Check for browser: "+browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
		
	}
}
