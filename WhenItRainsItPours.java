package com.google.challenges;

public class Answer 
{   
    public static int answer(int[] heights) 
    { 
        int ret = 0;
        int currentMax = heights[0];
        int currentMaxPos = 0;
        int i = 1;
        while (i < heights.length) {
            if (heights[i] >= currentMax) {
                for (int j = currentMaxPos; j < i; j++) {
                    ret += Math.min(currentMax, heights[i]) - heights[j]; 
                }
                currentMaxPos = i;
                currentMax = heights[i];
            }
            i++;
        }
        
        currentMax = heights[heights.length - 1];
        currentMaxPos = heights.length - 1;
        i = heights.length - 2;
        while (i >= 0) {
            if (heights[i] > currentMax) {
                for (int j = currentMaxPos; j > i; j--) {
                    ret += Math.min(currentMax, heights[i]) - heights[j]; 
                }
                currentMaxPos = i;
                currentMax = heights[i];
            }
            i--;
        }
        
        return ret;
    } 
}