package model.data;

/**
 * This class represents an airport
 */
public class Airport {

    private String name;
    private String adress;
    private int department;

    /**
     * Airport constructor
     * @param name name of the airport
     * @param adress adress
     * @param department department id
     */
    public Airport(String name, String adress, int department) {
        if (name == null || name.isEmpty() || adress == null || adress.isEmpty() || department == 0) {
            throw new IllegalArgumentException("Airport name, adress and departement cannot be empty");
        } else {
            this.name = name;
            this.adress = adress;
            this.department = department;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Airport name cannot be empty");
        } else {
            this.name = name;
        }
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        if (adress == null || adress.isEmpty()) {
            throw new IllegalArgumentException("Airport adress cannot be empty");
        } else {
            this.adress = adress;
        }
    }
    public int getDepartment(){
        return this.department;
    }
    public void setDepartment(int department){
        if((department == 22) || (department == 29) || (department == 35) || (department == 56)){
            this.department = department;
        }else{
            throw new IllegalArgumentException("Invalid department");
        }
    }
    public String toString(){
        return "Airport name : " + this.name + " adress : " + this.adress + " dep : " + this.department;
    }
}