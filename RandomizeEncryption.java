package com.surus.github.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizeEncryption {
	private ArrayList<Character> d335 = new ArrayList<>();
	private HashMap<Integer, Character> t = new HashMap<>();

	public RandomizeEncryption() {

	}

	public RandomizeEncryption(ArrayList<Character> saveData) {
		d335 = saveData;
	}

	public RandomizeEncryption(Map<Integer, Character> saveData) {
		if (saveData != null && saveData.size() > 0) {
			t = (HashMap<Integer, Character>) saveData;
			for (char v : saveData.values()) {
				d335.add(v);
			}
		}
	}

	public CharSequence encrypt(CharSequence text) {
		String result = "";
		int len = text.length();
		for (int i = 0; i < len; i++) {
			int encData = random(0, len);
			char value = text.charAt(i);
			if (d335.size() > 0) {
				while (t.containsKey(encData)) {
					encData = random(0, len);
				}
			}
			result += String.valueOf(encData);
			d335.add(value);
			t.put(encData, value);
		}
		return result;
	}

	public CharSequence decrypt() {
		CharSequence decrypt = "";
		if (d335.size() > 0) {
			for (int i = 0; i < d335.size(); i++) {
				decrypt += String.valueOf(d335.get(i));
			}
		}
		return decrypt;
	}

	public CharSequence mapDecrypt(CharSequence text) {
		CharSequence decrypt = text;

		for (int k : t.keySet()) {
			decrypt = decrypt.toString().replace(String.valueOf(k), String.valueOf(t.get(k)));
		}

		return decrypt;
	}

	public void returnData() {
		d335 = new ArrayList<>();
		for (int i : t.keySet()) {
			d335.add(t.get(i));
		}
	}

	public ArrayList<Character> save() {
		return d335;
	}

	public HashMap<Integer, Character> saveMap() {
		return t;
	}

	private void reset() {
		d335 = new ArrayList<>();
	}

	private int random(int min, int max) {
		Random rand = new Random();
		return rand.nextInt((max - min) + 1);
	}
}
