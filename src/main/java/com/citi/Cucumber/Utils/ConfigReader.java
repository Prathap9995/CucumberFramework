package com.citi.Cucumber.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties pro;
	
	public Properties init_pro() {
	
	pro = new Properties();
	FileInputStream file;
	try {
		file = new FileInputStream("src\\main\\java\\com\\citi\\Cucumber\\Resources\\Data.properties");
		pro.load(file);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return pro;
	}
	
	

}
