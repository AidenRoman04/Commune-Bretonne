package modele;
/**
 * Airport class.
 * Represents an airport.
 * An airport has a name, an adress, and a departement.
 * An airport can be in a departement.
 * @version 1.0
 */
public class Airport {

    private String name;
    private String adress;
    private Department departement;

    /**
     * Airport constructor.
     * @param name The airport name.
     * @param adress The airport adress.
     * @param departement The airport departement.
     */
    public Airport(String name, String adress, Department departement) {
        if (name == null || name.isEmpty() || adress == null || adress.isEmpty() || departement == null) {
            throw new IllegalArgumentException("Airport name, adress and departement cannot be empty");
        } else {
            this.name = name;
            this.adress = adress;
            this.departement = departement;
        }
    }

    /**
     * Returns the airport name.
     * @return The airport name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the airport name.
     * @param name The airport name.
     */
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Airport name cannot be empty");
        } else {
            this.name = name;
        }
    }

    /**
     * Returns the airport adress.
     * @return The airport adress.
     */
    public String getAdress() {
        return adress;
    }

    /**
     * Sets the airport adress.
     * @param adress The airport adress.
     */
    public void setAdress(String adress) {
        if (adress == null || adress.isEmpty()) {
            throw new IllegalArgumentException("Airport adress cannot be empty");
        } else {
            this.adress = adress;
        }
    }

    /**
     * Returns the airport departement.
     * @return The airport departement.
     */
    public Department getDepartement() {
        return departement;
    }

    /**
     * Sets the airport departement.
     * @param departement The airport departement.
     */
    public void setDepartement(Department departement) {
        if (departement == null) {
            throw new IllegalArgumentException("Airport departement cannot be empty");
        } else {
            this.departement = departement;
        }
    }

    /**
     * Vérifie si l'aéroport est dans le département spécifié.
     *
     * @param department Le département à vérifier.
     * @return true si l'aéroport est dans le département spécifié, false sinon.
     */
    public boolean isInDepartment(Department departement) {
        if (departement == null) {
            throw new IllegalArgumentException("Department cannot be null");
        }
        return this.departement.getDepID() == departement.getDepID();
    }

    /**
     * Returns the airport name, adress and departement.
     * @return The airport name, adress and departement.
     */
    public String toString() {
        return "Airport{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", departement=" + departement +
                '}';
    }
}