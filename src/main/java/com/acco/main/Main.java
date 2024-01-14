package com.acco.main;

import java.util.*;

import java.util.HashMap;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		ManualAlignement manualAlignment = new ManualAlignement("C:\\Users\\Asus\\Desktop\\data1.csv");
		manualAlignment.readFile();
		List<HashMap<String, List<String>>> manualResult = manualAlignment.align();

		for (HashMap<String, List<String>> fieldMap : manualResult) {
			for (HashMap.Entry<String, List<String>> entry : fieldMap.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}
	}
}

