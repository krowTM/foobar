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
    	
    	int score = Integer.MAX_VALUE;
    	int min = 0, max = 0, first = 0, last = 0;
    	for (String word : searchTerms) {
    		if (!wordsHash.containsKey(word)) continue;
    		for (int position : wordsHash.get(word)) {
    			first = position;
            	last = position;
            	List<Integer> resWords = new ArrayList<Integer>();
            	resWords.add(position);
    			for (String word2 : searchTerms) {
    				if (word.equals(word2)) continue;
    				int distance = Integer.MAX_VALUE;
    				int newPos = 0;
    				for (int other_position : wordsHash.get(word2)) {
    					if (Math.abs(position - other_position) < distance) {
    						distance = Math.abs(position - other_position);
    						newPos = other_position;
    					}
    				}
    				resWords.add(newPos);
    			}
    			first = Collections.min(resWords);
				last = Collections.max(resWords);
    			if (last - first < score) {
        			score = last - first;
        			min = first;
        			max = last;
        		}
    		}
    	}
    	
    	for (String s : words.subList(min, max + 1)) {
    		ret += s + " ";
    	}
    	
    	return ret.trim();
    }
}