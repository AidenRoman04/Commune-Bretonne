package model.data;

/**
 * This class represents data
 */
public class Data {
    private int cityID;
    private int houseNumber;
    private int flatNumber;
    private float averagePrice;
    private float averageM2Price;
    private float averageSurface;
    private float totalCulturalSpending;
    private float totalBudget;
    private float population;
    private Year year;

    /**
     * Data constructor
     * 
     * @param cityID                the cityID
     * @param houseNumber           house number
     * @param flatNumber            flat number
     * @param averagePrice          average price
     * @param averageM2Price        average square meter price
     * @param averageSurface        average surface
     * @param totalCulturalSpending total cultural spending
     * @param totalBudget           total budget
     * @param population            population
     * @param year                  year
     */
    public Data(int cityID, int houseNumber, int flatNumber, float averagePrice, float averageM2Price,
            float averageSurface, float totalCulturalSpending, float totalBudget,
            float population, Year year) {
        this.cityID = cityID;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
        this.averagePrice = averagePrice;
        this.averageM2Price = averageM2Price;
        this.averageSurface = averageSurface;
        this.totalCulturalSpending = totalCulturalSpending;
        this.totalBudget = totalBudget;
        this.population = population;
        this.year = year;
    }

    public int getCityID() {
        return this.cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public int getHouseNumber() {
        return this.houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        if (houseNumber < 0) {
            throw new IllegalArgumentException("House number cannot be negative");
        } else {
            this.houseNumber = houseNumber;
        }
    }

    public int getFlatNumber() {
        return this.flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        if (flatNumber < 0) {
            throw new IllegalArgumentException("Flat number cannot be negative");
        } else {
            this.flatNumber = flatNumber;
        }
    }

    public float getAveragePrice() {
        return this.averagePrice;
    }

    public void setAveragePrice(float averagePrice) {
        if (averagePrice < 0) {
            throw new IllegalArgumentException("Average price cannot be negative");
        } else {
            this.averagePrice = averagePrice;
        }
    }

    public float getAverageM2Price() {
        return this.averageM2Price;
    }

    public void setAverageM2Price(float averageM2Price) {
        if (averageM2Price < 0) {
            throw new IllegalArgumentException("Average m2 price cannot be negative");
        } else {
            this.averageM2Price = averageM2Price;
        }
    }

    public float getAverageSurface() {
        return this.averageSurface;
    }

    public void setAverageSurface(float averageSurface) {
        if (averageSurface < 0) {
            throw new IllegalArgumentException("Average surface cannot be negative");
        } else {
            this.averageSurface = averageSurface;
        }
    }

    public float getTotalCulturalSpending() {
        return this.totalCulturalSpending;
    }

    public void setTotalCulturalSpending(float totalCulturalSpending) {
        if (totalCulturalSpending < 0) {
            throw new IllegalArgumentException("Total cultural spending cannot be negative");
        } else {
            this.totalCulturalSpending = totalCulturalSpending;
        }
    }

    public float getTotalBudget() {
        return this.totalBudget;
    }

    public void setTotalBudget(float totalBudget) {
        if (totalBudget < 0) {
            throw new IllegalArgumentException("Total budget cannot be negative");
        } else {
            this.totalBudget = totalBudget;
        }
    }

    public float getPopulation() {
        return this.population;
    }

    public void setPopulation(float population) {
        if (population < 0) {
            throw new IllegalArgumentException("Population cannot be negative");
        } else {
            this.population = population;
        }
    }

    public Year getYear() {
        return this.year;
    }

    public void setYear(Year year) {
        if (year == null) {
            throw new IllegalArgumentException("Year cannot be empty");
        } else {
            this.year = year;
        }
    }

    public String toString() {
        String res = "";
        res += "City ID: " + this.cityID + ",\n House Number: " + this.houseNumber;
        res += ",\n Flat Number: " + this.flatNumber + ",\n Average Price: " + this.averagePrice;
        res += ",\n Average M2 Price: " + this.averageM2Price + ",\n Average Surface: " + this.averageSurface;
        res += ",\n Total Cultural Spending: " + this.totalCulturalSpending + ",\n Total Budget: " + this.totalBudget;
        res += ",\n Population: " + this.population + ",\n Year: " + this.year.getYear();
        return res;
    }
}
