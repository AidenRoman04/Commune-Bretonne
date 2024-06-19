package model.data;

import java.util.HashMap;

/**
 * This class represents a year
 */
public class Year {

    private int year;
    private double inflationRate;
    private HashMap<String, Float> averagePricePerCity;

    /**
     * Year constructor
     * @param year year
     * @param inflationRate inflation rate of the year
     */
    public Year(int year, double inflationRate) {
        if (year < 0 || inflationRate < 0) {
            throw new IllegalArgumentException("Year and inflation rate cannot be negative");
        } else {
            this.year = year;
            this.inflationRate = inflationRate;
        }
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        if (year < 0) {
            throw new IllegalArgumentException("Year cannot be negative");
        } else {
            this.year = year;
        }
    }

    public double getInflationRate() {
        return this.inflationRate;
    }

    public void setInflationRate(double inflationRate) {
        if (inflationRate < 0) {
            throw new IllegalArgumentException("Inflation rate cannot be negative");
        } else {
            this.inflationRate = inflationRate;
        }
    }

    public String toString() {
        return "Year: " + this.year + ", Inflation Rate: " + this.inflationRate;
    }

    public double getAverageRate() {
        System.out.println("Ecrire la méthode getAverageRate()");
        return 0.0;
    }

    public HashMap<String, Float> getAveragePricePerCity() {
        return this.averagePricePerCity;
    }

    public void setAveragePricePerCity(HashMap<String, Float> averagePricePerCity) {
        this.averagePricePerCity = averagePricePerCity;
    }

    public void addHashMap(String key, Float value) {
        if (key == null || key.isEmpty() || value < 0)
            throw new IllegalArgumentException("Key cannot be empty and value cannot be negative");
        else if (this.averagePricePerCity.containsKey(key))
            throw new IllegalArgumentException("Key already exists");
        else
            this.averagePricePerCity.put(key, value);
    }

    public void removeHashMap(String key) {
        if (key == null || key.isEmpty())
            throw new IllegalArgumentException("Key cannot be empty");
        else if (!this.averagePricePerCity.containsKey(key))
            throw new IllegalArgumentException("Key does not exist");
        else
            this.averagePricePerCity.remove(key);
    }

    public void updateHashMap(String key, Float value) {
        if (key == null || key.isEmpty() || value < 0)
            throw new IllegalArgumentException("Key cannot be empty and value cannot be negative");
        else if (!this.averagePricePerCity.containsKey(key))
            throw new IllegalArgumentException("Key does not exist");
        else
            this.averagePricePerCity.replace(key, value);
    }
}