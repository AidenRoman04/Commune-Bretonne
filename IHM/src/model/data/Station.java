package model.data;

/**
 * This class represents a train station
 */
public class Station {

    private int cityID;
    private int code;
    private String name;
    private boolean isCargo;
    private boolean isTraveler;

    /**
     * Station constructor
     * 
     * @param cityID     cityID
     * @param code       station code
     * @param name       station name
     * @param isCargo    true if the station welcomes cargo trains, false if not
     * @param isTraveler true if the station welcomes passenger trains, false if not
     */
    public Station(int cityID, int code, String name, boolean isCargo, boolean isTraveler) {
        if (cityID < 0 || code < 0 || name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Station code, cityID and name cannot be empty");
        } else {
            this.cityID = cityID;
            this.code = code;
            this.name = name;
            this.isCargo = isCargo;
            this.isTraveler = isTraveler;
        }
    }

    public int getCityID() {
        return this.cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        if (code < 0) {
            throw new IllegalArgumentException("Station code cannot be negative");
        } else {
            this.code = code;
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Station name cannot be empty");
        } else {
            this.name = name;
        }
    }

    public boolean isCargo() {
        return this.isCargo;
    }

    public void setCargo(boolean isCargo) {
        this.isCargo = isCargo;
    }

    public boolean isTraveler() {
        return this.isTraveler;
    }

    public void setTraveler(boolean isTraveler) {
        this.isTraveler = isTraveler;
    }

    public String toString() {
        return "\nCode : " + this.code + "\nName : " + this.name + "\nisCargo : " + this.isCargo + "\nisTraveler : "
                + this.isTraveler;
    }
}