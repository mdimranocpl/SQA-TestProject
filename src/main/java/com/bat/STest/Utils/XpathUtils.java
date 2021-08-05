package com.bat.STest.Utils;

public class XpathUtils {

	public static class LoginModiule {

		public static final String admin = "txtUsername";
		public static final String password = "/html/body/div[1]/div/div[3]/div[2]/div[2]/form/div[3]/input";
		public static final String submit = "btnLogin";
		
	}
	
	public static class AssignLeaveModiule {

		public static final String assignLeaveButton = "/html/body/div[1]/div[3]/div/div[2]/div[1]/div/div/div/fieldset/div/div/table/tbody/tr/td[1]/div/a/span";
		
		public static final String employee_name = "/html/body/div[1]/div[3]/div[1]/div[2]/form/fieldset/ol/li[1]/input[1]";
		public static final String leave_type = "/html/body/div[1]/div[3]/div[1]/div[2]/form/fieldset/ol/li[2]/select";
		
		//form date
		public static final String from_date  = "/html/body/div[1]/div[3]/div[1]/div[2]/form/fieldset/ol/li[4]/input";
		public static final String from_date_year  = "/html/body/div[3]/div/div/select[2]";
		public static final String from_date_month  = "/html/body/div[3]/div/div/select[1]";
		public static final String from_date_day  = "/html/body/div[3]/table"; //class path
		
		//to date
		public static final String to_date  = "/html/body/div[1]/div[3]/div[1]/div[2]/form/fieldset/ol/li[5]/input";
		public static final String to_date_year  = "/html/body/div[3]/div/div/select[2]";
		public static final String to_date_month  = "/html/body/div[3]/div/div/select[1]";
		public static final String to_date_day  = "ui-datepicker-calendar"; //class path
		
		public static final String duration = "/html/body/div[1]/div[3]/div[1]/div[2]/form/fieldset/ol/li[6]/select";
		public static final String comment = "/html/body/div[1]/div[3]/div[1]/div[2]/form/fieldset/ol/li[10]/textarea";
		public static final String assign_button = "/html/body/div[1]/div[3]/div[1]/div[2]/form/fieldset/p/input";
	}
}
