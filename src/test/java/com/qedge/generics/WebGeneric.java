package com.qedge.generics;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;



public class WebGeneric {
	
	    public static WebDriver driver;
	    public static WebElement elementlocator(String locator, String locvalue) throws IOException {
	        switch (locator) {
	            case "id":{
	            	try {
	            		return driver.findElement(By.id(locvalue));
	            		
					} catch (NoSuchElementException e) {
						
						genReport("Locator not found " +locator);
						screenshot("Locatornotfound"+locator);
					}
	                }
	            
	            case "name":{
	            	try {
	            		return driver.findElement(By.name(locvalue));
					} catch (NoSuchElementException e) {
						genReport("Locator not found " +locator);
						 screenshot("Locatornotfound"+locator);
					}
	                }
	                
	            case "linktext":{
	            	
	            	try {
	            		return driver.findElement(By.linkText(locvalue));
	            		
					} catch (NoSuchElementException e) {
						genReport("Locator not found " +locator);
						screenshot("Locatornotfound"+locator);
					}
	                }
	            	   
	            case "xpath":{
	                return driver.findElement(By.xpath(locvalue));}
	            case "cssselector":{
	                return driver.findElement(By.cssSelector(locvalue));}
	            default:
	                return null;
	        }
	    }
	    
	    
	    public static void performAction(String locator, String locvalue,String WebAction,  String Value) throws IOException {
	        WebElement Element=elementlocator(locator, locvalue);
	        switch (WebAction) {
	            case "click":
	            	try {
	            		 Element.click();
	                     	System.out.println("performed action on " +WebAction);
	                        genReport("performed action  " +WebAction);
					} catch (Exception e) {
						// genReport("Not performed action on " +WebAction, "info");
					}
	               
	                break;
	            case "sendkeys":
	                Element.sendKeys(Value);
	                  System.out.println("enter data " +Value);
	                 genReport("enter data " +Value);
	                break;
	            case "select":
	            	Select sek=new Select(Element);
	            	sek.selectByVisibleText(Value);
	                System.out.println("select data " +Value);
	                genReport("select data" + Value);
	                break;
	            default:
	                System.out.println("Element not Found");
	   
	        }
	}
	    
	    public static boolean elementVerification(String locator, String locvalue) throws IOException{
	    	 WebElement Element=elementlocator(locator, locvalue);
	    	 boolean elementStatux=Element.isDisplayed();
	    	 return elementStatux;
	    }
	    
	    public static  void screenshot(String ScreenshotName) throws IOException{
			
	    	
	    	String d=date();
	    	String d1=d.replaceAll("\\W", "");
			//To take screenshot
			File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File destFile=new File("./Screenshot/"+ScreenshotName+d1+".jpeg");
			FileUtils.copyFile(srcFile, destFile, true);	
		}
	    
	   
	    
	    public static String propertyValue(String keyvaluepair1) throws IOException{
			FileInputStream fis=new FileInputStream("object.properties");
			Properties pro=new Properties();
			pro.load(fis);
			String usernameproperty=pro.getProperty(keyvaluepair1);
			String parts[]=usernameproperty.split(":");
			//String eleproperty=parts[0];
			String locValue=parts[1];
			System.out.println(locValue);
			return locValue;
		}
	    
	    public static String eleProperty(String keyvaluepair) throws IOException{
			FileInputStream fis=new FileInputStream("object.properties");
			Properties pro=new Properties();
			pro.load(fis);
			String usernameproperty=pro.getProperty(keyvaluepair);
			String parts[]=usernameproperty.split(":");
			String locator=parts[0];
			System.out.println(locator);
			return locator;
		}
	    
	    /* for generating logfiles in multiple formats and for printing user defined messages */
	    public static void genReport(String Message){
	    	//System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
	    	 Logger log=Logger.getLogger("projectReport");
			  PropertyConfigurator.configure("log4j.properties");
			  //System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
			  log.info(Message);
			 
	    }
	    
	    
	   /* @Test
	    public void loginFunctionality() throws IOException{
	    driver=new FirefoxDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.get("http://demo.actitime.com");
	    performAction(eleProperty("login_un"), propertyValue("login_un"),"sendkeys", "admin");
	    performAction(eleProperty("login_pwd"), propertyValue("login_pwd"), "sendkeys", "manager");
	    performAction(eleProperty("login_login"), propertyValue("login_login"), "click", "");
	    }*/
	    
	    
	    /*To return the present system date*/
	    public static String date(){
	    	Date date=new Date();
	    	 SimpleDateFormat formatter = new SimpleDateFormat("dd/M/yyyy");  
	    	 String strDate= formatter.format(date);  
	    	 System.out.println(strDate);
	    	 return strDate;
	    }
	    
	    public static WebDriver driverSetUp(String Browser){
	    	switch (Browser) {
			case "Firefox":
				driver=new FirefoxDriver();
				break;
			case "Chrome":
				
				break;
			case "Ie":
				
				break;
				
			default:
				break;
			}
			return driver;
	    }
	  
	}

