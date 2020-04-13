package ctsNaukriProject.libraries;
import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

/**
 * @author Pavan_Lanke
 *Class created to configure properties and access the paths of Browsers,ExcelSheet,and URL of Website
 */
public class ConfigReader {
	Properties pro;
	/**
	 * Method to Load properties
	 */
	public ConfigReader() {

		try {
			File src=new File("./Configuration/Config.property");

			FileInputStream fis=new FileInputStream(src);

			pro=new Properties();

			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is" + e.getMessage());
		}

	}
	public String getExcelExcess() {
		String path=pro.getProperty("ExcelData");
		return path;
	}
	/**
	 * Method to get path of chromeDriver
	 */
	public String getchromepath() {
		String path=pro.getProperty("chromeDriver");
		return path;
	}
	/**
	 * Method to get path of firefoxDriver
	 */
	public String firefoxpath() {
		String path=pro.getProperty("firefoxDriver");
		return path;
	}
	/**
	 * Method to get path of Excel file 
	 */
	public String TestData() {
		String path=pro.getProperty("ExelData");
		return path;
	}
	/**
	 * Method to get Website URL
	 */

	public String getApplicationURL() {
		return pro.getProperty("URL");
	}

}

