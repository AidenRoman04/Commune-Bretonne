
/**
 * ScénarioTest for the modele package.
 * 
 * @version 1.0
 * 
 * @see modele
 */

import modele.*;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

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
                System.out.println("Test du Constructeur Station");
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
                        return;
                }
                System.out.println("Test de la méthode Station – cas normal");
                Station station = new Station(code, name, isCargo, isTraveler, city);
                System.out.println("Test réussi");
        }

        /**
         * Test of the Department method.
         */
        @Test
        public void testDepartment() {
                System.out.println("Test du Constructeur Department");
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
        public void testCasDepartment(int depID, String depName, double cultInvest2019,
                        ArrayList<Airport> airportList) {
                if ((depID < 0) || (cultInvest2019 < 0) || (depName == null || depName.isEmpty())
                                || (airportList == null)) {
                        System.out.println("Test de la méthode Department – cas exception");
                        try {
                                Department department = new Department(depID, depName, cultInvest2019, airportList);
                                System.out.println("ECHEC du test : Department créé avec des paramètres incorrects");
                        } catch (IllegalArgumentException e) {
                                System.out.println("Test réussi");
                        }
                        return;
                }
                System.out.println("Test de la méthode Department – cas normal");
                Department department = new Department(depID, depName, cultInvest2019, airportList);
                System.out.println("Test réussi");
        }

        /**
         * Test of the City method.
         */
        @Test
        public void testCity() {
                System.out.println("Test du Constructeur City");
                Year y = new Year(2020, 0.02);
                Department d = new Department(75, "Paris", 1000000, new ArrayList<Airport>());
                City city = new City("75001", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());
                testCasCity("75001", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());
                testCasCity("", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());
                testCasCity("75001", "", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());
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
                        float avgWealthTax, float avgPropertyTax, float avgBusinessTax, int nbCulturalEvent,
                        Department dep, Year y,
                        ArrayList<City> neighborList) {
                if (code == null || code.isEmpty() || name == null || name.isEmpty() || population < 0 || nbStation < 0
                                || avgIncome < 0 || avgIncomeTax < 0 || avgWealthTax < 0 || avgPropertyTax < 0
                                || avgBusinessTax < 0
                                || nbCulturalEvent < 0 || dep == null || y == null || neighborList == null) {
                        System.out.println("Test de la méthode City – cas exception");
                        try {
                                City city = new City(code, name, population, nbStation, avgIncome, avgIncomeTax,
                                                avgWealthTax,
                                                avgPropertyTax, avgBusinessTax, nbCulturalEvent, dep, y, neighborList);
                                System.out.println("ECHEC du test : City créée avec des paramètres incorrects");
                        } catch (IllegalArgumentException e) {
                                System.out.println("Test réussi");
                        }
                        return;
                }
                System.out.println("Test de la méthode City – cas normal");
                City city = new City(code, name, population, nbStation, avgIncome, avgIncomeTax, avgWealthTax,
                                avgPropertyTax,
                                avgBusinessTax, nbCulturalEvent, dep, y, neighborList);
                System.out.println("Test réussi");
        }

        /**
         * Test of the Year method.
         */
        @Test
        public void testYear() {
                System.out.println("Test du Constructeur Year");
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
                        return;
                }
                System.out.println("Test de la méthode Year – cas normal");
                Year y = new Year(year, inflationRate);
                System.out.println("Test réussi");
        }

        /**
         * Test of the Airport method.
         */
        @Test
        public void testAirport() {
                System.out.println("Test du Constructeur Airport");
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
                        return;
                }
                System.out.println("Test de la méthode Airport – cas normal");
                Airport airport = new Airport(code, name, dep);
                System.out.println("Test réussi");
        }

        @Test
        public void testIsNeighbour() {
                Department d = new Department(75, "Paris", 1000000, new ArrayList<Airport>());
                Year y = new Year(2020, 0.02);
                City city1 = new City("75001", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());
                City city2 = new City("75002", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());
                City city3 = new City("75003", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());
                City city4 = new City("75004", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());
                City city5 = new City("75005", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());
                City city6 = new City("75006", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());
                City city7 = new City("75007", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());
                City city8 = new City("75008", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());
                City city9 = new City("75009", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());

                ArrayList<City> neighborList = new ArrayList<City>();
                neighborList.add(city2);
                neighborList.add(city3);
                neighborList.add(city4);
                neighborList.add(city5);
                neighborList.add(city6);
                neighborList.add(city7);
                neighborList.add(city8);
                neighborList.add(city9);

                city1.setNeighborList(neighborList);

                testCasIsNeighbour(city1, city2, true);
                testCasIsNeighbour(city1, city3, true);
                testCasIsNeighbour(city1, city4, true);
                testCasIsNeighbour(city1, city5, true);
                testCasIsNeighbour(city1, city6, true);
                testCasIsNeighbour(city1, city7, true);
                testCasIsNeighbour(city1, city8, true);
                testCasIsNeighbour(city1, city9, true);

                testCasIsNeighbour(city1, city1, false);
                System.out.println("");

        }

        public void testCasIsNeighbour(City city1, City city2, boolean expected) {
                System.out.println("Test de la méthode isNeighbour");
                boolean result = city1.isNeighbour(city2);
                assertEquals(expected, result);
                System.out.println("Test réussi");
        }

        /**
         * test computeRelativePrice, computeCultBudgetPerCapita,
         * computeNeighbourCultBudgetPerCapitaAverage
         */
        @Test
        public void testCalculate() {
                System.out.println("Test de la méthode calculate");
                Department d = new Department(75, "Paris", 1000000, new ArrayList<Airport>());
                Year y = new Year(2020, 0.02);
                City city1 = new City("75001", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());
                City city2 = new City("75002", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());
                City city3 = new City("75003", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());
                City city4 = new City("75004", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());
                City city5 = new City("75005", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());
                City city6 = new City("75006", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());
                City city7 = new City("75007", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());
                City city8 = new City("75008", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());
                City city9 = new City("75009", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());

                ArrayList<City> neighborList = new ArrayList<City>();
                neighborList.add(city2);
                neighborList.add(city3);
                neighborList.add(city4);
                neighborList.add(city5);
                neighborList.add(city6);
                neighborList.add(city7);
                neighborList.add(city8);
                neighborList.add(city9);

                city1.setNeighborList(neighborList);

                testCasCalculate(city1, 1.0);

                System.out.println("");
        }

        public void testCasCalculate(City city, double expected) {
                System.out.println("Test de la méthode calculate");
                double result = 0;

                result = city.computeRelativePrice();

                assertEquals(expected, result, 0.01);
                System.out.println("Test réussi");
        }

        /**
         * Test isTraveler
         */
        @Test
        public void testIsTraveler() {
                System.out.println("Test de la méthode isTraveler");
                Department d = new Department(75, "Paris", 1000000, new ArrayList<Airport>());
                Year y = new Year(2020, 0.02);
                City city1 = new City("75001", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());
                City city2 = new City("75002", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());
                City city3 = new City("75003", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());
                City city4 = new City("75004", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());

                Station s1 = new Station(1, "Gare de Lyon", false, true, city1);
                Station s2 = new Station(2, "Gare Montparnasse", true, false, city1);
                Station s3 = new Station(3, "Gare de l'Est", true, true, city1);
                Station s4 = new Station(4, "Gare du Nord", false, true, city1);

                testCasIsTraveler(s1, true);
                testCasIsTraveler(s2, false);
                testCasIsTraveler(s3, true);
                testCasIsTraveler(s4, true);
                System.out.println("");

        }

        public void testCasIsTraveler(Station station, boolean expected) {
                System.out.println("Test de la méthode isTraveler");
                boolean result = station.isTraveler();
                assertEquals(expected, result);
                System.out.println("Test réussi");
        }

        /**
         * Test isCargo
         */
        @Test
        public void testIsCargo() {
                System.out.println("Test de la méthode isCargo");
                Department d = new Department(75, "Paris", 1000000, new ArrayList<Airport>());
                Year y = new Year(2020, 0.02);
                City city1 = new City("75001", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());
                City city2 = new City("75002", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());
                City city3 = new City("75003", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());
                City city4 = new City("75004", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());

                Station s1 = new Station(1, "Gare de Lyon", false, true, city1);
                Station s2 = new Station(2, "Gare Montparnasse", true, false, city1);
                Station s3 = new Station(3, "Gare de l'Est", true, true, city1);
                Station s4 = new Station(4, "Gare du Nord", false, true, city1);

                testCasIsCargo(s1, false);
                testCasIsCargo(s2, true);
                testCasIsCargo(s3, true);
                testCasIsCargo(s4, false);
                System.out.println("");

        }

        public void testCasIsCargo(Station station, boolean expected) {
                System.out.println("Test de la méthode isCargo");
                if (expected == station.isCargo()) {
                        System.out.println("Test réussi");
                } else {
                        System.out.println("ECHEC du test");

                }
        }

        /**
         * Test of the isInDepartment method for station.
         */
        @Test
        public void testIsInCity() {
                System.out.println("Test de la méthode isInCity");
                Department d = new Department(75, "Paris", 1000000, new ArrayList<Airport>());
                Year y = new Year(2020, 0.02);
                City city1 = new City("75001", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());
                City city2 = new City("75002", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());
                City city3 = new City("75003", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());
                City city4 = new City("75004", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());

                Station s1 = new Station(1, "Gare de Lyon", false, true, city1);
                Station s2 = new Station(2, "Gare Montparnasse", true, false, city1);
                Station s3 = new Station(3, "Gare de l'Est", true, true, city1);
                Station s4 = new Station(4, "Gare du Nord", false, true, city1);

                testCasIsInCity(s1, city1, true);
                testCasIsInCity(s2, city2, false);
                testCasIsInCity(s3, city3, false);
                testCasIsInCity(s4, city4, false);

                System.out.println("");
        }

        public void testCasIsInCity(Station station, City city, boolean expected) {
                System.out.println("Test de la méthode isInCity");
                boolean result = station.isInCity(city);
                assertEquals(expected, result);
                System.out.println("Test réussi");
        }

        public void testCasHasAirport(Airport airport, Department dep, boolean expected) {
                if (dep.hasAirport(airport) == expected) {
                        System.out.println("hasAirport : OK");
                } else {
                        System.out.println("hasAirport : Error");
                }
        }

        @Test
        public void testHasAirport() {
                ArrayList<Airport> airportList = new ArrayList<Airport>();
                Department dep = new Department(1, "test", 5, airportList);

                Airport airport = new Airport("airport1", "Somewhere", dep);
                dep.addAirport(airport);
                System.out.println("-----Test hasAirport-----");
                testCasHasAirport(airport, dep, true);
                Airport airport2 = new Airport("airport2", "Somewhere", dep);
                testCasHasAirport(airport2, dep, false);

        }

        public void testCasGetNumberOfAirports(Department dep, int expected) {
                if (dep.getNumberOfAirports() == expected) {
                        System.out.println("NumberOfAirports : OK");
                } else {
                        System.out.println("NumberOfAirports : Error");
                }
        }

        @Test
        public void testGetNumberOfAirports() {
                ArrayList<Airport> airportList = new ArrayList<Airport>();
                Department dep = new Department(1, "test", 5, airportList);
                System.out.println("-----Test getNumberOfAirports-----");
                testCasGetNumberOfAirports(dep, 0);
                Airport airport = new Airport("airport1", "Somewhere", dep);
                dep.addAirport(airport);
                testCasGetNumberOfAirports(dep, 1);
                Airport airport2 = new Airport("airport2", "Somewhere", dep);
                dep.addAirport(airport2);
                testCasGetNumberOfAirports(dep, 2);
        }

        public void testCasRemoveAirport(Airport airport, Department dep, ArrayList<Airport> expected) {
                dep.removeAirport(airport);
                if (dep.getAirportList().equals(expected)) {
                        System.out.println("RemoveAirport : OK");
                } else {
                        System.out.println("RemoveAirport : Error");
                }
        }

        @Test
        public void testRemoveAirport() {
                ArrayList<Airport> airportList = new ArrayList<Airport>();
                Department dep = new Department(1, "test", 5, airportList);

                Airport airport = new Airport("airport1", "Somewhere", dep);
                dep.addAirport(airport);
                System.out.println("-----Test removeAirport-----");
                testCasRemoveAirport(airport, dep, new ArrayList<Airport>());
                dep.addAirport(airport);
                Airport airport2 = new Airport("airport2", "Somewhere", dep);
                dep.addAirport(airport2);
                testCasRemoveAirport(airport, dep, new ArrayList<Airport>() {
                        {
                                add(airport2);
                        }
                });
        }

        public void testCasAddAirport(Airport airport, Department dep, ArrayList<Airport> expected) {
                dep.addAirport(airport);
                if (dep.getAirportList().equals(expected)) {
                        System.out.println("OK");
                } else {
                        System.out.println("Error");
                }
        }

        @Test
        public void testAddAirport() {
                ArrayList<Airport> airportList = new ArrayList<Airport>();
                Department dep = new Department(1, "test", 5, airportList);

                Airport airport = new Airport("airport1", "Somewhere", dep);
                System.out.println("-----Test addAirport-----");
                testCasAddAirport(airport, dep, new ArrayList<Airport>() {
                        {
                                add(airport);
                        }
                });
                Airport airport2 = new Airport("airport2", "Somewhere", dep);
                testCasAddAirport(airport2, dep, new ArrayList<Airport>() {
                        {
                                add(airport);
                                add(airport2);
                        }
                });
        }

}
