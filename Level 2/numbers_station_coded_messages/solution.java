package com.google.challenges;

public class Answer {

    /**
     * Will find the first sublist in the given array that adds up to a given sum.
     * @param l the given array of integers
     * @param t the given sum
     * @return an array consisting of two values, the first being the first index and the second being
     * the last index.
     */
    public static int[] answer(int[] l, int t) {
        int currentSum, len = l.length;

        //starting point for sublists
        for (int i = 0; i < len; i++) {
            currentSum = l[i];

            // try all subarrays following starting point
            for (int j = i + 1; j <= len; j++) {
                if (currentSum == t) //found an existing sublist between indexes i and j-1
                    return new int[]{i, j - 1};
                if (currentSum > t || j == len) //currentSum is bigger than given sum or reached end of array
                    break;
                currentSum = currentSum + l[j];
            }
        }
        
        //no sublist found
        return new int[]{-1,-1};
    }

}

