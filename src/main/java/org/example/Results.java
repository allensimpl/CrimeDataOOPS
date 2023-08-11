package org.example;

import java.util.HashMap;

public class Results {
    HashMap<Integer,Integer> yearCounts;
    HashMap<String,Integer> monthCounts;
    String maxNeighbourhoodName;

    int maxNeighbourhoodValue;
    String minNeighbourhoodName;
    int minNeighbourhoodValue;


    String maxCrimeName;
    int maxCrimeValue;
    String minCrimeName;
    int minCrimeValue;

    public Results(){
        this.yearCounts = new HashMap<>();
        this.monthCounts = new HashMap<>();
        this.maxNeighbourhoodValue = Integer.MIN_VALUE;
        this.maxNeighbourhoodName = null;
        this.minNeighbourhoodValue = Integer.MAX_VALUE;
        this.minNeighbourhoodName = null;
        this.maxCrimeValue = Integer.MIN_VALUE;
        this.maxCrimeName = null;
        this.minCrimeValue = Integer.MAX_VALUE;
        this.minCrimeName = null;

    }

    public HashMap<Integer, Integer> getYearCounts() {
        return yearCounts;
    }

    public void setYearCounts(HashMap<Integer, Integer> yearCounts) {
        this.yearCounts = yearCounts;
    }

    public HashMap<String, Integer> getMonthCounts() {
        return monthCounts;
    }

    public void setMonthCounts(HashMap<String, Integer> monthCounts) {
        this.monthCounts = monthCounts;
    }

    public String getMaxNeighbourhoodName() {
        return maxNeighbourhoodName;
    }

    public void setMaxNeighbourhoodName(String maxNeighbourhoodName) {
        this.maxNeighbourhoodName = maxNeighbourhoodName;
    }

    public int getMaxNeighbourhoodValue() {
        return maxNeighbourhoodValue;
    }

    public void setMaxNeighbourhoodValue(int maxNeighbourhoodValue) {
        this.maxNeighbourhoodValue = maxNeighbourhoodValue;
    }

    public String getMinNeighbourhoodName() {
        return minNeighbourhoodName;
    }

    public void setMinNeighbourhoodName(String minNeighbourhoodName) {
        this.minNeighbourhoodName = minNeighbourhoodName;
    }

    public int getMinNeighbourhoodValue() {
        return minNeighbourhoodValue;
    }

    public void setMinNeighbourhoodValue(int minNeighbourhoodValue) {
        this.minNeighbourhoodValue = minNeighbourhoodValue;
    }

    public String getMaxCrimeName() {
        return maxCrimeName;
    }

    public void setMaxCrimeName(String maxCrimeName) {
        this.maxCrimeName = maxCrimeName;
    }

    public int getMaxCrimeValue() {
        return maxCrimeValue;
    }

    public void setMaxCrimeValue(int maxCrimeValue) {
        this.maxCrimeValue = maxCrimeValue;
    }

    public String getMinCrimeName() {
        return minCrimeName;
    }

    public void setMinCrimeName(String minCrimeName) {
        this.minCrimeName = minCrimeName;
    }

    public int getMinCrimeValue() {
        return minCrimeValue;
    }

    public void setMinCrimeValue(int minCrimeValue) {
        this.minCrimeValue = minCrimeValue;
    }
}
