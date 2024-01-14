package com.acco.main;

import com.acco.main.matching.Comparaison.fonctionDeComparaison;
import com.acco.main.matching.Comparaison.fonctionLogique;
import com.acco.main.matching.choixAttr.choixAttribut;
import com.acco.main.matching.choixAttr.manuel;
import com.acco.main.matching.matching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		choixAttribut choixManuel = new manuel();

		fonctionDeComparaison FonctionLogique = new fonctionLogique();

		matching entityMatching = new matching(choixManuel, FonctionLogique);

		List<List<HashMap<String, Object>>> testData = new ArrayList<>();

		List<HashMap<String, Object>> record1 = new ArrayList<>();
		record1.add(createAttribute("nom", "Salma"));
		record1.add(createAttribute("age", 25));
		testData.add(record1);

		List<HashMap<String, Object>> record2 = new ArrayList<>();
		record2.add(createAttribute("nom", "Nouhaila"));
		record2.add(createAttribute("age", 30));
		testData.add(record2);

		List<HashMap<String, Object>> record3 = new ArrayList<>();
		record3.add(createAttribute("nom", "Salma"));
		record3.add(createAttribute("age", 25));
		testData.add(record3);

		List<List<HashMap<String, Object>>> results = Collections.singletonList(entityMatching.processMatching(testData));

		System.out.println("Résultats de la résolution d'entité :");
		for (List<HashMap<String, Object>> result : results) {
			System.out.println(result);
		}
	}

	private static HashMap<String, Object> createAttribute(String key, Object value) {
		HashMap<String, Object> attribute = new HashMap<>();
		attribute.put(key, value);
		return attribute;
	}
}
