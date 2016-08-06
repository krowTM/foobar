package com.google.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Answer {   
    public static String answer(String document, String[] searchTerms) {
    	String ret = "";
    	Map<String, List<Integer>> wordsHash = new HashMap<String, List<Integer>>();
    	List<String> words = Arrays.asList(document.split("\\s+"));
    	for (String word : searchTerms) {
			if (words.contains(word)) {
				for (int i = 0; i < words.size(); i++) {
					if (words.get(i).equals(word)) {
						if (wordsHash.containsKey(word)) {
							List<Integer> add = wordsHash.get(word);
							add.add(Integer.valueOf(i));
							wordsHash.put(word, add);
						}
						else {
							List<Integer> add = new ArrayList<Integer>();
							add.add(Integer.valueOf(i));
							wordsHash.put(word, add);
						}
					}
				}
			}
		}
    	
}
