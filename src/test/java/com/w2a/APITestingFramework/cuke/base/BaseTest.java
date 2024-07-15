package com.w2a.APITestingFramework.cuke.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BaseTest {
	
	
	public static Properties config = new Properties();
	public static FileInputStream fis;
	
	public static String client_id;
	public static String secret;
	
	public static Response response;
	
	
	public static void init() {
		
		try {
			fis = new FileInputStream("./src/test/resources/properties/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			config.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		RestAssured.baseURI=config.getProperty("baseURI");
		
		client_id = config.getProperty("paypalClientID");
		secret = config.getProperty("paypalSecret");
		
	}
	
	
	
	

}
