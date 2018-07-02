package com.google.challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Answer {
    
    public static int answer(int[] dimensions, int[] your_position, int[] guard_position, int distance) {
        Map<Double, Double> hitYourself = getAngles(dimensions, your_position, your_position, distance);
        Map<Double, Double> hitGuard = getAngles(dimensions, your_position, guard_position, distance);
        int solutions = 0;
        
        for (Double key : hitGuard.keySet()) {
            if (hitYourself.containsKey(key)) {
                if (hitGuard.get(key) < hitYourself.get(key)) {
                    solutions++;
                }
            }
            else {
                solutions++;
            }
        }
        return solutions;
    }
    
    public static Double distance(int[] p1, int[] p2) {
        return Math.sqrt(((p2[0] - p1[0]) * (p2[0] - p1[0])) + ((p2[1] - p1[1]) * (p2[1] - p1[1])));
    }
    
    public static Double angle(int[] p1, int[] p2) {
        return Math.atan2(p2[0] - p1[0], p2[1] - p1[1]);
    }
    
    public static ArrayList<int[]> cartesianProduct(ArrayList<ArrayList<Integer>> series) {
        ArrayList<int[]> points = new ArrayList<>();
        
        for (int i = 0; i < series.get(0).size(); i++) {
            for (int j = 0; j < series.get(1).size(); j++) {
                int[] temp = {series.get(0).get(i), series.get(1).get(j)};
                points.add(temp);
            }
        }
        return points;
    }
    
    public static ArrayList<Integer> generateSeries(int[] dimensions, int[] your_position, int[] guard_position, int distance, int i) {
        int minimum = your_position[i] - distance;
        int maximum = your_position[i] + distance;
        
        int[] segment = {dimensions[i] - guard_position[i], guard_position[i]};
        ArrayList<Integer> series = new ArrayList<>();
        
        int current = guard_position[i];
        int segmentIndex = 0;
        while (current <= maximum) {
            series.add(current);
            current += 2 * segment[segmentIndex];
            if (segmentIndex == 1) segmentIndex = 0;
            else segmentIndex = 1;
        }
        
        current = guard_position[i];
        segmentIndex = 1;
        while (current >= minimum) {
            series.add(current);
            current -= 2 * segment[segmentIndex];
            if (segmentIndex == 1) segmentIndex = 0;
            else segmentIndex = 1;
        }
        
        return series;
    }
    
    public static ArrayList<ArrayList<Integer>> generateAllSeries(int[] dimensions, int[] your_position, int[] guard_position, int distance) {
        ArrayList<ArrayList<Integer>> series = new ArrayList<>();
        
        for (int i = 0; i < 2; i++) {
            series.add(generateSeries(dimensions, your_position, guard_position, distance, i));
        }
        
        return series;
    }
    
    public static Map<Double, Double> getAngles(int[] dimensions, int[] your_position, int[] guard_position, int distance) {
        Map<Double, Double> polarMap = new HashMap<>();
        
        for(int[] point : cartesianProduct(generateAllSeries(dimensions, your_position, guard_position, distance))) {
            Double r = distance(point, your_position);
            Double angle = angle(point, your_position);
            
            if ((point[0] != your_position[0] || point[1] != your_position[1]) && (r <= distance)) {
                if (!polarMap.containsKey(angle)) {
                    polarMap.put(angle, r);
                }
                else {
                    polarMap.put(angle, Math.min(polarMap.get(angle), r));
                }
            }
        }
        
        return polarMap;
    }
}
