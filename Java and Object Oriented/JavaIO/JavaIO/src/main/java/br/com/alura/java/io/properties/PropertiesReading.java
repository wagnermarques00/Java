package br.com.alura.java.io.properties;

import java.io.FileReader;
import java.util.Properties;

public class PropertiesReading {

	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.load(new FileReader("conf.properties"));

		String login = props.getProperty("login");       // alura
		String password = props.getProperty("password"); // alurapass
		String address = props.getProperty("address");   // www.alura.com.br

		System.out.println(login + ", " + password + ", " + address); // alura, alurapass, www.alura.com.br
	}

}

//Notice that, once the file is read, we can use the getProperty(key) method of the Properties class to retrieve its value.
