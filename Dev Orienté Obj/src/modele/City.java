package modele;

import java.util.ArrayList;

/**
 * City class
 * Represents a city in Britanny.
 * A city has a code, a name, a number of houses, a number of flats, an average
 * price, an average price per square meter, an average surface, a total
 * cultural spending, a total budget, a population, a department, a year, and a
 * list of neighbours.
 * A city can be a neighbour of another city.
 * 
 * @version 1.0
 */
public class City {

    private String cityCode;
    private String cityName;
    private int houseNumber;
    private int flatNumber;
    private float averagePrice;
    private float averageM2Price;
    private float averageSurface;
    private float totalCulturalSpending;
    private float totalBudget;
    private float population;
    private Department department;
    private Year year;
    private ArrayList<City> neighbourList;

    /**
     * City constructor.
     * 
     * @param cityCode              The city code.
     * @param cityName              The city name.
     * @param houseNumber           The number of houses.
     * @param flatNumber            The number of flats.
     * @param averagePrice          The average price.
     * @param averageM2Price        The average price per square meter.
     * @param averageSurface        The average surface.
     * @param totalCulturalSpending The total cultural spending.
     * @param totalBudget           The total budget.
     * @param population            The population.
     * @param department            The department.
     * @param year                  The year.
     * @param neighbourList         The list of neighbours.
     */
    public City(String cityCode, String cityName, int houseNumber, int flatNumber, float averagePrice,
            float averageM2Price, float averageSurface, float totalCulturalSpending, float totalBudget,
            float population, Department department, Year year, ArrayList<City> neighbourList) {
        if (cityCode == null || cityCode.isEmpty() || cityName == null || cityName.isEmpty() || houseNumber < 0
                || flatNumber < 0 || averagePrice < 0 || averageM2Price < 0 || averageSurface < 0
                || totalCulturalSpending < 0 || totalBudget < 0 || population < 0 || department == null
                || year == null || neighbourList == null) {
            throw new IllegalArgumentException(
                    "City code, name, house number, flat number, average price, average m2 price, average surface, total cultural spending, total budget, population , department and neighbourList cannot be empty");
        } else {
            this.cityCode = cityCode;
            this.cityName = cityName;
            this.houseNumber = houseNumber;
            this.flatNumber = flatNumber;
            this.averagePrice = averagePrice;
            this.averageM2Price = averageM2Price;
            this.averageSurface = averageSurface;
            this.totalCulturalSpending = totalCulturalSpending;
            this.totalBudget = totalBudget;
            this.population = population;
            this.department = department;
            this.year = year;
            this.neighbourList = neighbourList;
        }
    }

    /**
     * Returns the city code.
     * 
     * @return The city code.
     */
    public String getCityCode() {
        return this.cityCode;
    }

    /**
     * Sets the city code.
     * 
     * @param cityCode The city code.
     */
    public void setCityCode(String cityCode) {
        if (cityCode == null || cityCode.isEmpty()) {
            throw new IllegalArgumentException("City code cannot be empty");
        } else {
            this.cityCode = cityCode;
        }
    }

    /**
     * Returns the city name.
     * 
     * @return The city name.
     */
    public String getCityName() {
        return this.cityName;
    }

    /**
     * Sets the city name.
     * 
     * @param cityName The city name.
     */
    public void setCityName(String cityName) {
        if (cityName == null || cityName.isEmpty()) {
            throw new IllegalArgumentException("City name cannot be empty");
        } else {
            this.cityName = cityName;
        }
    }

    /**
     * Returns the number of houses.
     * 
     * @return The number of houses.
     */
    public int getHouseNumber() {
        return this.houseNumber;
    }

    /**
     * Sets the number of houses.
     * 
     * @param houseNumber The number of houses.
     */
    public void setHouseNumber(int houseNumber) {
        if (houseNumber < 0) {
            throw new IllegalArgumentException("House number cannot be negative");
        } else {
            this.houseNumber = houseNumber;
        }
    }

    /**
     * Returns the number of flats.
     * 
     * @return The number of flats.
     */
    public int getFlatNumber() {
        return this.flatNumber;
    }

    /**
     * Sets the number of flats.
     * 
     * @param flatNumber The number of flats.
     */
    public void setFlatNumber(int flatNumber) {
        if (flatNumber < 0) {
            throw new IllegalArgumentException("Flat number cannot be negative");
        } else {
            this.flatNumber = flatNumber;
        }
    }

    /**
     * Returns the average price.
     * 
     * @return The average price.
     */
    public float getAveragePrice() {
        return this.averagePrice;
    }

    /**
     * Sets the average price.
     * 
     * @param averagePrice The average price.
     */
    public void setAveragePrice(float averagePrice) {
        if (averagePrice < 0) {
            throw new IllegalArgumentException("Average price cannot be negative");
        } else {
            this.averagePrice = averagePrice;
        }
    }

    /**
     * Returns the average price per square meter.
     * 
     * @return The average price per square meter.
     */
    public float getAverageM2Price() {
        return this.averageM2Price;
    }

    /**
     * Sets the average price per square meter.
     * 
     * @param averageM2Price The average price per square meter.
     */
    public void setAverageM2Price(float averageM2Price) {
        if (averageM2Price < 0) {
            throw new IllegalArgumentException("Average m2 price cannot be negative");
        } else {
            this.averageM2Price = averageM2Price;
        }
    }

    /**
     * Returns the average surface.
     * 
     * @return The average surface.
     */
    public float getAverageSurface() {
        return this.averageSurface;
    }

    /**
     * Sets the average surface.
     * 
     * @param averageSurface The average surface.
     */
    public void setAverageSurface(float averageSurface) {
        if (averageSurface < 0) {
            throw new IllegalArgumentException("Average surface cannot be negative");
        } else {
            this.averageSurface = averageSurface;
        }
    }

    /**
     * Returns the total cultural spending.
     * 
     * @return The total cultural spending.
     */
    public float getTotalCulturalSpending() {
        return this.totalCulturalSpending;
    }

    /**
     * Sets the total cultural spending.
     * 
     * @param totalCulturalSpending The total cultural spending.
     */
    public void setTotalCulturalSpending(float totalCulturalSpending) {
        if (totalCulturalSpending < 0) {
            throw new IllegalArgumentException("Total cultural spending cannot be negative");
        } else {
            this.totalCulturalSpending = totalCulturalSpending;
        }
    }

    /**
     * Returns the total budget.
     * 
     * @return The total budget.
     */
    public float getTotalBudget() {
        return this.totalBudget;
    }

    /**
     * Sets the total budget.
     * 
     * @param totalBudget The total budget.
     */
    public void setTotalBudget(float totalBudget) {
        if (totalBudget < 0) {
            throw new IllegalArgumentException("Total budget cannot be negative");
        } else {
            this.totalBudget = totalBudget;
        }
    }

    /**
     * Returns the population.
     * 
     * @return The population.
     */
    public float getPopulation() {
        return this.population;
    }

    /**
     * Sets the population.
     * 
     * @param population The population.
     */
    public void setPopulation(float population) {
        if (population < 0) {
            throw new IllegalArgumentException("Population cannot be negative");
        } else {
            this.population = population;
        }
    }

    /**
     * Returns the city as a string.
     * 
     * @return The city as a string.
     */
    public String toString() {
        return "City { City Code: " + cityCode + ", City Name: " + cityName + ", House Number: " + houseNumber
                + ", Flat Number: " + flatNumber + ", Average Price: " + averagePrice + ", Average M2 Price: "
                + averageM2Price + ", Average Surface: " + averageSurface + ", Total Cultural Spending: "
                + totalCulturalSpending + ", Total Budget: " + totalBudget + ", Population: " + population + " }";
    }

    /**
     * Returns the department.
     * 
     * @return The department.
     */
    public Department getDepartment() {
        return this.department;
    }

    /**
     * Sets the department.
     * 
     * @param department The department.
     */
    public void setDepartment(Department department) {
        if (department == null) {
            throw new IllegalArgumentException("Department cannot be empty");
        } else {
            this.department = department;
        }
    }

    /**
     * Returns the year.
     * 
     * @return The year.
     */
    public Year getYear() {
        return this.year;
    }

    /**
     * Sets the year.
     * 
     * @param year The year.
     */
    public void setYear(Year year) {
        if (year == null) {
            throw new IllegalArgumentException("Year cannot be empty");
        } else {
            this.year = year;
        }
    }

    /**
     * Returns the list of neighbours.
     * 
     * @return The list of neighbours.
     */
    public ArrayList<City> getNeighborList() {
        return this.neighbourList;
    }

    /**
     * Sets the list of neighbours.
     * 
     * @param neighbours The list of neighbours.
     */
    public void setNeighborList(ArrayList<City> neighbours) {
        for (City c : neighbours) {
            this.neighbourList.add(c);
        }
    }

    /**
     * Returns whether the city is a neighbour.
     * 
     * @param otherCity The other city.
     * @return true if the city is a neighbour, false otherwise.
     */
    public boolean isNeighbour(City otherCity) {
        if (otherCity == null) {
            throw new IllegalArgumentException("City cannot be empty");
        } else {
            return this.neighbourList.contains(otherCity);
        }
    }

    /**
     * Calcule le prix relatif de la ville par rapport à ses voisins.
     * 
     * @return Le prix relatif de la ville par rapport à ses voisins.
     */
    public float computeRelativePrice() {
        if (neighbourList == null || neighbourList.isEmpty()) {
            throw new IllegalArgumentException("Neighbour list cannot be empty");
        }

        float sum = 0;
        for (City neighbour : neighbourList) {
            sum += neighbour.getAveragePrice();
        }

        float averageNeighbourPrice = sum / neighbourList.size();

        return this.averagePrice / averageNeighbourPrice;
    }

    /**
     * Calcule le budget culturel par habitant.
     * 
     * @return Le budget culturel par habitant.
     */
    public float computeCultBudgetPerCapita() {
        return this.totalCulturalSpending / this.population;
    }

    /**
     * Calcule le budget culturel par habitant de la ville la plus proche.
     * 
     * @return Le budget culturel par habitant de la ville la plus proche.
     */
    public float computeNeighbourCultBudgetPerCapitaAverage() {
        if (neighbourList == null || neighbourList.isEmpty()) {
            throw new IllegalArgumentException("Neighbour list cannot be empty");
        }

        float sum = 0;
        for (City neighbour : neighbourList) {
            sum += neighbour.computeCultBudgetPerCapita();
        }

        return sum / neighbourList.size();
    }
}