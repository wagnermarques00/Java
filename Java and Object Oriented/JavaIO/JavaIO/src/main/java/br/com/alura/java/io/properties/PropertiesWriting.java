package br.com.alura.java.io.properties;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesWriting {

	public static void main(String[] args) throws IOException {
		Properties props = new Properties();
		props.setProperty("login", "alura"); 				//key, value
		props.setProperty("password", "alurapass");			//key, value
		props.setProperty("address", "www.alura.com.br");	//key, value

		props.store(new FileWriter("conf.properties"), "any comment");
	}

}

/*
 * This will create a file (conf.properties) with the information bellow:
 * #any comment
 * #Wed Sep 28 17:55:45 BRT 2022
 * password=alurapass
 * address=www.alura.com.br
 * login=alura
 */