package br.com.alura.java.io.properties;

import java.util.Properties;

public class PropertiesModel {

	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty("login", "alura"); 				//key, value
		props.setProperty("password", "alurapass");			//key, value
		props.setProperty("address", "www.alura.com.br");	//key, value
	}

}
