package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private Properties properties;
	private final String propertyFilePath="config/configuration.properties";
	
	public ConfigReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
		
			try {
				properties.load(reader);
				reader.close();
			}
			catch(IOException e) { 
				e.printStackTrace();
			}
		}	
		catch(FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("configuration file not found at path: "+ propertyFilePath);
		}
	}//constructor
	
	public String getBrowser(){
		String browser = properties.getProperty("browser");
		return browser;
	}
	
	public String getAppUrl() {
		String appUrl = properties.getProperty("URL");
		return appUrl;
	}
	
	public String getUserName() {
		String username = properties.getProperty("username");
		return username;
	}
	
	public String getPassword() {
		String password = properties.getProperty("password");
		return password;		
		
	}

}//class