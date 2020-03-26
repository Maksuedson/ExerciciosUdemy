package testejava;

import java.util.HashMap;

public class HashMap1 {
	public static void main(String[] args) {
		HashMap<String, Integer> pantry = new HashMap<>();

		pantry.put("Apples", 3);
		pantry.put("Orange", 2);

		int currentApples = pantry.get("Apples");
		pantry.put("Apples", currentApples + 4);

		System.out.println(pantry.get("Apples"));
	}
}
