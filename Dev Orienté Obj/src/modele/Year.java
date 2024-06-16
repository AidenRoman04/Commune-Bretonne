import java.util.HashMap;
/**
 * Year class
 * Represents a year in the dataset.
 * A year has a year, an inflation rate, and a HashMap of average prices per city.
 * A year can have a HashMap of average prices per city.
 * @version 1.0
 */
public class Year {

    private int year;
    private double inflationRate;
    private HashMap<String, Float> averagePricePerCity;

    /**
     * Year constructor.
     * @param year The year.
     * @param inflationRate The inflation rate.
     */
    public Year(int year, double inflationRate) {
        if (year < 0 || inflationRate < 0) {
            throw new IllegalArgumentException("Year and inflation rate cannot be negative");
        } else {
            this.year = year;
            this.inflationRate = inflationRate;
            this.averagePricePerCity = new HashMap<>();
        }
    }

    /*
     * Returns the year.
     * @return The year.
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Sets the year.
     * @param year The year.
     */
    public void setYear(int year) {
        if (year < 0) {
            throw new IllegalArgumentException("Year cannot be negative");
        } else {
            this.year = year;
        }
    }

    /**
     * Returns the inflation rate.
     * @return The inflation rate.
     */
    public double getInflationRate() {
        return this.inflationRate;
    }

    /**
     * Sets the inflation rate.
     * @param inflationRate The inflation rate.
     */
    public void setInflationRate(double inflationRate) {
        if (inflationRate < 0) {
            throw new IllegalArgumentException("Inflation rate cannot be negative");
        } else {
            this.inflationRate = inflationRate;
        }
    }

    /**
     * Returns the year as a string.
     * @return The year as a string.
     */
    @Override
    public String toString() {
        return "Year: " + this.year + ", Inflation Rate: " + this.inflationRate + ", Average Prices: " + this.toStringHashMap();
    }

    /**
     * Returns the average price of the year.
     * @return The average price of the year.
     */
    public double getAverageRate() {
        if (averagePricePerCity == null || averagePricePerCity.isEmpty()) {
            throw new IllegalArgumentException("No average price data available for this year");
        }
    
        double sum = 0;
        for (Float price : averagePricePerCity.values()) {
            sum += price;
        }
    
        return sum / averagePricePerCity.size();
    }

    /**
     * Returns the average price per city as a HashMap.
     * @return The average price per city as a HashMap.
     */
    public HashMap<String, Float> getAveragePricePerCity() {
        return this.averagePricePerCity;
    }

    /**
     * Sets the average price per city.
     * @param averagePricePerCity The average price per city.
     */
    public void setAveragePricePerCity(HashMap<String, Float> averagePricePerCity) {
        this.averagePricePerCity = averagePricePerCity;
    }

    /**
     * Adds a new average price to the HashMap.
     * @param key The key.
     * @param value The value.
     */
    public void addHashMap(String key, Float value) {
        if (key == null || key.isEmpty() || value < 0)
            throw new IllegalArgumentException("Key cannot be empty and value cannot be negative");
        else if (this.averagePricePerCity.containsKey(key))
            throw new IllegalArgumentException("Key already exists");
        else
            this.averagePricePerCity.put(key, value);
    }

    /**
     * Removes a key from the HashMap.
     * @param key The key.
     */
    public void removeHashMap(String key) {
        if (key == null || key.isEmpty())
            throw new IllegalArgumentException("Key cannot be empty");
        else if (!this.averagePricePerCity.containsKey(key))
            throw new IllegalArgumentException("Key does not exist");
        else
            this.averagePricePerCity.remove(key);
    }

    /**
     * Updates a key in the HashMap.
     * @param key The key.
     * @param value The value.
     */
    public void updateHashMap(String key, Float value) {
        if (key == null || key.isEmpty() || value < 0)
            throw new IllegalArgumentException("Key cannot be empty and value cannot be negative");
        else if (!this.averagePricePerCity.containsKey(key))
            throw new IllegalArgumentException("Key does not exist");
        else
            this.averagePricePerCity.replace(key, value);
    }

    /**
     * Returns the average price of a city.
     * @param key The key.
     * @return The average price of a city.
     */
    public float getAveragePrice(String key) {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Key cannot be empty");
        } else if (!this.averagePricePerCity.containsKey(key)) {
            throw new IllegalArgumentException("Key does not exist");
        } else {
            return this.averagePricePerCity.get(key);
        }
    }

    /**
     * Returns the average price per city as a string.
     * @return The average price per city as a string.
     */
    public String toStringHashMap() {
        return this.averagePricePerCity.toString();
    }
}