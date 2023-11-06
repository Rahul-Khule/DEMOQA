package com.DemoQA.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	//create propeties object
		Properties pro;
		
		//create a constructor for the read config
		public ReadConfig() {
			File src = new File("./Configuration/Config.properties");
			 
			 try {
				FileInputStream fis = new FileInputStream(src);
				pro = new Properties();
				pro.load(fis);
			} catch (Exception e) {
				System.out.println("Exception is " + e.getMessage());
			}
		}
		
		//add diffrent methods tp read values
		public String getElemet_TextBox_URL() {
			String url = pro.getProperty("base_url_element_textbox");
			return url;
		}
		public String getFullName() {
			String fname = pro.getProperty("FullName");
			return fname;
		}
		public String getCurrentAddress() {
			String cadd = pro.getProperty("CurrentAddress");
			return cadd;
		}
		public String getPermanentAddress() {
			String padd = pro.getProperty("PermanentAddress");
			return padd;
		}
		public String getChromepath() {
			String cpath = pro.getProperty("chromepath");
			return cpath;
		}
		public String getEdgepath() {
			String epath = pro.getProperty("edgepath");
			return epath;
		}
}
