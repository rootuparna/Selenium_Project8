package com.qedge.testcases;

import java.io.IOException;

import org.testng.annotations.Test;


import com.qedge.pagefunctions.NormalPageFunctions;

public class VerifyingLoginandLogout extends NormalPageFunctions {
	@Test
	public static void loginWithValidCredentials() throws IOException{
		login();
		logout();
	}
	
	
}
