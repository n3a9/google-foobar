package com.google.challenges; 

public class Answer {   

    public static int answer(int[] l) { 
        int result = 0;
        int countX, countZ;
        
        if (l.length < 3) {
            return 0;
        }
        
        for (int i = 1; i < l.length - 1; i++) {
            countX = 0;
            countZ = 0;
            
            for (int j = 0; j < i; j++) {
                if (l[i] % l[j] == 0) {
                    countX++;
                }
            }
            for (int k = i + 1; k < l.length; k++) {
                if (l[k] % l[i] == 0)
                    countZ++;
            }
            
            result += countX * countZ;
        }
        
        return result;
    } 
}
