package com.google.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Answer {   
    
    public static int[] answer(int[][] minions) { 
        List<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        
        float bestTime = Float.MAX_VALUE;
        int[] firstOrder = new int[minions.length];
        for (int i = 0; i < minions.length; i++) {
            firstOrder[i] = i;
        }
        for (ArrayList<Integer> order : generateOrders(firstOrder)) {
            int[][] newMinionsList = new int[minions.length][];
            for (int i = 0; i < order.size(); i++) {
                newMinionsList[i] = minions[order.get(i)]; 
            }
            float t = getTime(newMinionsList);
            if (t < bestTime) {
                bestTime = t;
                ret.add(order);
            }
        }
        
        int[] returnA = new int[minions.length];
        int i = 0;
        for (int a : ret.get(ret.size() - 1)) {
            returnA[i++] = a;
        }
        return returnA;
    }
    
    private static ArrayList<ArrayList<Integer>> generateOrders(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
         
        for (int i = 0; i < num.length; i++) {
            ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> l : result) {
                for (int j = 0; j < l.size()+1; j++) {
                    l.add(j, num[i]);
                    ArrayList<Integer> temp = new ArrayList<Integer>(l);
                    current.add(temp);
                    l.remove(j);
                }
            }
            result = new ArrayList<ArrayList<Integer>>(current);
        }
         
        return result;
    }

    private static float getTime(int[][] minions) {
        float prob = 1;
        float time = 0;
        for (int i = 0; i < minions.length; i++) {
            time += (float)prob * minions[i][0];
            prob *= (float)(1 - (float)minions[i][1] / minions[i][2]);
        }
        
        return time;
    } 
}