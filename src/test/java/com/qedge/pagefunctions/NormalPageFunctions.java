package com.qedge.pagefunctions;



import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.qedge.generics.WebGeneric;

public class NormalPageFunctions extends WebGeneric {
public static void login() throws IOException{
	driver=driverSetUp("Firefox");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.get("http://demo.actitime.com");
	performAction(eleProperty("login_un"), propertyValue("login_un"),"sendkeys", "admin");
    performAction(eleProperty("login_pwd"), propertyValue("login_pwd"), "sendkeys", "manager");
    performAction(eleProperty("login_login"), propertyValue("login_login"), "click", "");
}

public static void logout(){
	
} 

public static void search(){
	
}

public static void createAccount(){
	
}
}
