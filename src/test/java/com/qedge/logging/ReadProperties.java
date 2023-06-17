package com.qedge.logging;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadProperties {
/*public static void main(String[] args) throws IOException {
	FileInputStream fis=new FileInputStream("object.properties");
	Properties pro=new Properties();
	pro.load(fis);
	String eleproperty=pro.getProperty("login_un");
	System.out.println(eleproperty);
	String elepropertyArr[]=eleproperty.split(":");
	String property=elepropertyArr[0];
	String propertyValue=elepropertyArr[1];
	WebDriver driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("http://demo.actitime.com");
	driver.findElement(By.id(propertyValue)).sendKeys("admin");
	
}*/
	
	public static String readProperty(String keyvaluePair) throws IOException {
		FileInputStream fis=new FileInputStream("object.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String eleproperty=pro.getProperty(keyvaluePair);
		String elepropertyArr[]=eleproperty.split(":");
		String property=elepropertyArr[0];
		return property;
		
		
	}
	
	public static String propertyValue(String keyvaluePair) throws IOException {
		FileInputStream fis=new FileInputStream("object.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String eleproperty=pro.getProperty(keyvaluePair);
		String elepropertyArr[]=eleproperty.split(":");
		String property=elepropertyArr[1];
		return property;
}
	
	public static void main(String[] args) throws IOException {
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://demo.actitime.com");
		driver.findElement(By.id(propertyValue("login_un"))).sendKeys("admin");
	}
	
}

