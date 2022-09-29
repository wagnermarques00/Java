package br.com.alura.java.io.test;

import java.io.Serializable;

/**
 * Class that represents a customer of the Bytebank bank
 *
 * @author wagnermarques00
 * @version 0.1
 */

public class Customer implements Serializable {
	private static final long serialVersionUID = -8565217692179237276L;

	private String name;
	private String clientId;
	private String profession;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	@Override
	public String toString() {
		return "Customer - " + "name: " + name + ", clientId: " + clientId + ", profession: " + profession;
	}
}
