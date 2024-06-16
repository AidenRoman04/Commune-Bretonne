package modele;
/**
 * Station class
 * Represents a station in a city.
 * A station has a code, a name, and a city where it is located.
 * A station can be a cargo station, a traveler station, or both.
 * A station can be in a city.
 * @version 1.0
 */
public class Station {

    private int code;
    private String name;
    private boolean isCargo;
    private boolean isTraveler;
    private City city;

    /**
     * Station constructor.
     * @param code The station code.
     * @param name The station name.
     * @param isCargo Whether the station is a cargo station.
     * @param isTraveler Whether the station is a traveler station.
     * @param city The city where the station is located.
     */
    public Station(int code, String name, boolean isCargo, boolean isTraveler, City city) {
        if (code < 0 || name == null || name.isEmpty() || city == null) {
            throw new IllegalArgumentException("Station code , name and city cannot be empty");
        } else {
            this.code = code;
            this.name = name;
            this.isCargo = isCargo;
            this.isTraveler = isTraveler;
            this.city = city;
        }
    }

    /**
     * Returns the station code.
     * @return The station code.
     */
    public int getCode() {
        return this.code;
    }

    /**
     * Sets the station code.
     * @param code The station code.
     */
    public void setCode(int code) {
        if (code < 0) {
            throw new IllegalArgumentException("Station code cannot be negative");
        } else {
            this.code = code;
        }
    }

    /**
     * Returns the station name.
     * @return The station name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the station name.
     * @param name The station name.
     */
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Station name cannot be empty");
        } else {
            this.name = name;
        }
    }

    /**
     * Returns whether the station is a cargo station.
     * @return true if the station is a cargo station, false otherwise.
     */
    public boolean isCargo() {
        return this.isCargo;
    }

    /**
     * Sets whether the station is a cargo station.
     * @param isCargo true if the station is a cargo station, false otherwise.
     */
    public void setCargo(boolean isCargo) {
        this.isCargo = isCargo;
    }

    /**
     * Returns whether the station is a traveler station.
     * @return true if the station is a traveler station, false otherwise.
     */
    public boolean isTraveler() {
        return this.isTraveler;
    }

    /**
     * Sets whether the station is a traveler station.
     * @param isTraveler true if the station is a traveler station, false otherwise.
     */
    public void setTraveler(boolean isTraveler) {
        this.isTraveler = isTraveler;
    }

    /**
     * Returns the city where the station is located.
     * @return The city where the station is located.
     */
    public City getCity() {
        return this.city;
    }

    /**
     * Sets the city where the station is located.
     * @param city The city where the station is located.
     */
    public void setCity(City city) {
        if (city == null) {
            throw new IllegalArgumentException("Station city cannot be empty");
        } else {
            this.city = city;
        }
    }

    /**
     * Checks if the station is in the specified city.
     *
     * @param city The city to check.
     * @return true if the station is in the specified city, false otherwise.
     */
    public boolean isInCity(City city) {
        return this.city.equals(city);
    }

    public boolean equals(Station station) {
        return this.code == station.code;
    }

    /**
     * Returns a string representation of the station.
     */
    @Override
    public String toString() {
        return "Station: " + this.name + ", Code: " + this.code + ", Cargo: " + this.isCargo + ", Traveler: " + this.isTraveler + ", City: " + this.city;
    }
}