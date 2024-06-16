
/**
 * ScénarioTest for the modele package.
 * 
 * @version 1.0
 * 
 * @see modele
 */

import modele.*;

import java.util.ArrayList;

import org.junit.*;

public class ScénarioTest {

    /**
     * Launches the test.
     * 
     * @param args
     */
    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("ScénarioTest");
    }

    /**
     * Test of the Station method.
     */
    @Test
    public void testStation() {
        System.out.println("Test de la méthode Station");
        Year y = new Year(2020, 0.02);
        Department d = new Department(75, "Paris", 1000000, new ArrayList<Airport>());
        City city = new City("75001", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                new ArrayList<City>());
        testCasStation(1, "Gare de Rennes", false, true, city);
        testCasStation(-1, "Gare de Rennes", false, true, city);
        testCasStation(1, "", false, true, city);
        testCasStation(1, "Gare de Rennes", false, true, null);
        System.out.println("");
    }

    /**
     * Test cases for the Station method.
     * 
     * @param code
     * @param name
     * @param isCargo
     * @param isTraveler
     * @param city
     */
    public void testCasStation(int code, String name, boolean isCargo, boolean isTraveler, City city) {
        if (code < 0 || name == null || name.isEmpty() || city == null) {
            System.out.println("Test de la méthode Station – cas exception");
            try {
                Station station = new Station(code, name, isCargo, isTraveler, city);
                System.out.println("ECHEC du test : Station créée avec des paramètres incorrects");
            } catch (IllegalArgumentException e) {
                System.out.println("Test réussi");
            }
        } else {
            System.out.println("Test de la méthode Station – cas normal");
            Station station = new Station(code, name, isCargo, isTraveler, city);
            System.out.println("Test réussi");
        }
    }

    /**
     * Test of the Department method.
     */
    @Test
    public void testDepartment() {
        System.out.println("Test de la méthode Department");
        testCasDepartment(75, "Paris", 1000000, new ArrayList<Airport>());
        testCasDepartment(-75, "Paris", 1000000, new ArrayList<Airport>());
        testCasDepartment(75, "", 1000000, new ArrayList<Airport>());
        testCasDepartment(75, "Paris", -1000000, new ArrayList<Airport>());
        testCasDepartment(75, "Paris", 1000000, null);
        System.out.println("");
    }

    /**
     * Test cases for the Department method.
     * 
     * @param depID
     * @param depName
     * @param cultInvest2019
     * @param airportList
     */
    public void testCasDepartment(int depID, String depName, double cultInvest2019, ArrayList<Airport> airportList) {
        if ((depID < 0) || (cultInvest2019 < 0) || (depName == null || depName.isEmpty()) || (airportList == null)) {
            System.out.println("Test de la méthode Department – cas exception");
            try {
                Department department = new Department(depID, depName, cultInvest2019, airportList);
                System.out.println("ECHEC du test : Department créé avec des paramètres incorrects");
            } catch (IllegalArgumentException e) {
                System.out.println("Test réussi");
            }
        } else {
            System.out.println("Test de la méthode Department – cas normal");
            Department department = new Department(depID, depName, cultInvest2019, airportList);
            System.out.println("Test réussi");
        }
    }

    /**
     * Test of the City method.
     */
    @Test
    public void testCity() {
        System.out.println("Test de la méthode City");
        Year y = new Year(2020, 0.02);
        Department d = new Department(75, "Paris", 1000000, new ArrayList<Airport>());
        City city = new City("75001", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                new ArrayList<City>());
        testCasCity("75001", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                new ArrayList<City>());
        testCasCity("", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y, new ArrayList<City>());
        testCasCity("75001", "", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y, new ArrayList<City>());
        testCasCity("75001", "Paris", -1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                new ArrayList<City>());
        testCasCity("75001", "Paris", 1500000, -150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                new ArrayList<City>());
        testCasCity("75001", "Paris", 1500000, 150, -250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                new ArrayList<City>());
        testCasCity("75001", "Paris", 1500000, 150, 250.0f, -150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                new ArrayList<City>());
        testCasCity("75001", "Paris", 1500000, 150, 250.0f, 150.0f, -45.0f, 69.0f, 258.0f, 0, d, y,
                new ArrayList<City>());
        testCasCity("75001", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, -69.0f, 258.0f, 0, d, y,
                new ArrayList<City>());
        testCasCity("75001", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, -258.0f, 0, d, y,
                new ArrayList<City>());
        testCasCity("75001", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, -1, d, y,
                new ArrayList<City>());
        testCasCity("75001", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, null, y,
                new ArrayList<City>());
        testCasCity("75001", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, null,
                new ArrayList<City>());
        testCasCity("75001", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y, null);
        System.out.println("");
    }

    /**
     * Test cases for the City method.
     * 
     * @param code
     * @param name
     * @param population
     * @param nbStation
     * @param avgIncome
     * @param avgIncomeTax
     * @param avgWealthTax
     * @param avgPropertyTax
     * @param avgBusinessTax
     * @param nbCulturalEvent
     * @param dep
     * @param y
     * @param neighborList
     */
    public void testCasCity(String code, String name, int population, int nbStation, float avgIncome,
            float avgIncomeTax,
            float avgWealthTax, float avgPropertyTax, float avgBusinessTax, int nbCulturalEvent, Department dep, Year y,
            ArrayList<City> neighborList) {
        if (code == null || code.isEmpty() || name == null || name.isEmpty() || population < 0 || nbStation < 0
                || avgIncome < 0 || avgIncomeTax < 0 || avgWealthTax < 0 || avgPropertyTax < 0 || avgBusinessTax < 0
                || nbCulturalEvent < 0 || dep == null || y == null || neighborList == null) {
            System.out.println("Test de la méthode City – cas exception");
            try {
                City city = new City(code, name, population, nbStation, avgIncome, avgIncomeTax, avgWealthTax,
                        avgPropertyTax, avgBusinessTax, nbCulturalEvent, dep, y, neighborList);
                System.out.println("ECHEC du test : City créée avec des paramètres incorrects");
            } catch (IllegalArgumentException e) {
                System.out.println("Test réussi");
            }
        } else {
            System.out.println("Test de la méthode City – cas normal");
            City city = new City(code, name, population, nbStation, avgIncome, avgIncomeTax, avgWealthTax,
                    avgPropertyTax,
                    avgBusinessTax, nbCulturalEvent, dep, y, neighborList);
            System.out.println("Test réussi");
        }
    }

    /**
     * Test of the Year method.
     */
    @Test
    public void testYear() {
        System.out.println("Test de la méthode Year");
        testCasYear(2020, 0.02);
        testCasYear(-2020, 0.02);
        testCasYear(2020, -0.02);
        System.out.println("");
    }

    /**
     * Test cases for the Year method.
     * 
     * @param year
     * @param inflationRate
     */
    public void testCasYear(int year, double inflationRate) {
        if (year < 0 || inflationRate < 0) {
            System.out.println("Test de la méthode Year – cas exception");
            try {
                Year y = new Year(year, inflationRate);
                System.out.println("ECHEC du test : Year créé avec des paramètres incorrects");
            } catch (IllegalArgumentException e) {
                System.out.println("Test réussi");
            }
        } else {
            System.out.println("Test de la méthode Year – cas normal");
            Year y = new Year(year, inflationRate);
            System.out.println("Test réussi");
        }
    }

    /**
     * Test of the Airport method.
     */
    @Test
    public void testAirport() {
        System.out.println("Test de la méthode Airport");
        Department d = new Department(75, "Paris", 1000000, new ArrayList<Airport>());
        testCasAirport("CDG", "Roissy", d);
        testCasAirport("", "Roissy", d);
        testCasAirport("CDG", "", d);
        testCasAirport("CDG", "Roissy", null);
        System.out.println("");
    }

    /**
     * Test cases for the Airport method.
     * 
     * @param code
     * @param name
     * @param dep
     */
    public void testCasAirport(String code, String name, Department dep) {
        if (code == null || code.isEmpty() || name == null || name.isEmpty() || dep == null) {
            System.out.println("Test de la méthode Airport – cas exception");
            try {
                Airport airport = new Airport(code, name, dep);
                System.out.println("ECHEC du test : Airport créé avec des paramètres incorrects");
            } catch (IllegalArgumentException e) {
                System.out.println("Test réussi");
            }
        } else {
            System.out.println("Test de la méthode Airport – cas normal");
            Airport airport = new Airport(code, name, dep);
            System.out.println("Test réussi");
        }
    }
}
