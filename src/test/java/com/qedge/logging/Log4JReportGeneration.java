package com.qedge.logging;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Log4JReportGeneration {
/*public static void main(String[] args) {
	Logger  log=Logger.getLogger("Regression");
	PropertyConfigurator.configure("log4j.properties");
	WebDriver driver=new FirefoxDriver();
	log.info("Browser is launched successfully");
	driver.get("http://demo.actitime.com");
	log.info("url passed successfully");
	log.warn("sample");
}*/
	
	public static void genReport(String message) {
		Logger  log=Logger.getLogger("Regression");
		PropertyConfigurator.configure("log4j.properties");
		log.info(message);
		
}
	
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		genReport("browser launched successfully");
	}
}
