package com.bat.STest.DataProvider;

import org.testng.annotations.DataProvider;

import com.bat.STest.Utils.ExcelUtils;

public class LoginDataProvider {

	@DataProvider(name = "loginData")
	public static Object[][] getLoginData() {
		try {
			return new Object[][] { { ExcelUtils.getLoginData() }, };
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
