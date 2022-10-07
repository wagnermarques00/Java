package br.com.alura.collections.test;

import java.util.HashMap;
import java.util.Map;

public class TestingForEachMap {

	public static void main(String[] args) {
		Map<Integer, String> espadas = new HashMap<>();

		espadas.put(0, "Yammy Llargo");
		espadas.put(1, "Coyote Starrk & Lilynette Gingerbuck");
		espadas.put(2, "Baraggan Louisenbairn");
		espadas.put(3, "Tier Harribel (after was Nelliel Tu Odelschwanck)");
		espadas.put(4, "Ulquiorra Cifer");
		espadas.put(5, "Nnoitra Gilga");
		espadas.put(6, "Grimmjow Jaegerjaquez -> Luppi Antenor -> Grimmjow Jaegerjaquez");
		espadas.put(7, "Zommari Rureaux");
		espadas.put(8, "Szayelaporro Granz");
		espadas.put(9, "Aaroniero Arruruerie");

		System.out.println("Espadas rank with forEach");
		espadas.keySet().forEach(espadaRank -> {
			System.out.println(espadaRank + " -> " + espadas.get(espadaRank));
			/*
			 * 0 -> Yammy Llargo
			 * 1 -> Coyote Starrk & Lilynette Gingerbuck
			 * 2 -> Baraggan Louisenbairn
			 * 3 -> Tier Harribel (after was Nelliel Tu Odelschwanck)
			 * 4 -> Ulquiorra Cifer
			 * 5 -> Nnoitra Gilga
			 * 6 -> Grimmjow Jaegerjaquez -> Luppi Antenor -> Grimmjow Jaegerjaquez
			 * 7 -> Zommari Rureaux
			 * 8 -> Szayelaporro Granz
			 * 9 -> Aaroniero Arruruerie
			 */
		});

	}

}
