
/**
 * Scénario class to display the use of the model classes.
 * 
 * @version 1.0
 * 
 * @see modele
 * @see modele.Airport
 * @see modele.City
 * @see modele.Department
 * @see modele.Station
 * @see modele.Year
 */
import java.util.ArrayList;
import java.util.HashMap;

import modele.*;

public class ScénarioUtilisation {

        public static void main(String[] args) {
                System.out.println("\tTest Scénario :");
                System.out.println("");
                System.out.println("initializing objects :");

                // create empty department for initialization
                Department emptyDepartment = new Department(0, "empty", 0, new ArrayList<Airport>());

                // create 3 airports
                Airport a1 = new Airport("CDG", "Roissy", emptyDepartment);
                Airport a2 = new Airport("ORY", "Orly", emptyDepartment);
                Airport a3 = new Airport("BVA", "Beauvais", emptyDepartment);

                // create a airport list
                ArrayList<Airport> airportList = new ArrayList<Airport>();
                airportList.add(a1);
                airportList.add(a2);
                airportList.add(a3);

                // Create a department
                Department d = new Department(75, "Paris", 1000000, airportList);

                // set the 3 airports departement
                a1.setDepartement(d);
                a2.setDepartement(d);
                a3.setDepartement(d);

                // create 3 year
                Year y = new Year(2020, 0.02);
                Year y2 = new Year(2019, 0.01);
                Year y3 = new Year(2018, 0.03);

                // Create a city
                City c1 = new City("75001", "Paris", 1500000, 150, 250.0f, 150.0f, 45.0f, 69.0f, 258.0f, 0, d, y,
                                new ArrayList<City>());
                City c2 = new City("79000", "Niort", 50000, 50, 100.0f, 50.0f, 15.0f, 29.0f, 58.0f, 0, d, y,
                                new ArrayList<City>());
                City c3 = new City("56000", "Vannes", 100000, 100, 200.0f, 100.0f, 30.0f, 58.0f, 116.0f, 0, d, y,
                                new ArrayList<City>());

                // add the 3 cities to the city list
                ArrayList<City> cityList = new ArrayList<City>();
                cityList.add(c1);
                cityList.add(c2);
                cityList.add(c3);

                // set the city list to the city
                c1.setNeighborList(cityList);
                c2.setNeighborList(cityList);
                c3.setNeighborList(cityList);

                // Create a station
                Station s = new Station(1, "Gare de Lyon", true, true, c1);
                Station s2 = new Station(2, "Gare Montparnasse", true, false, c1);
                Station s3 = new Station(3, "Gare de l'Est", true, true, c1);
                Station s4 = new Station(4, "Gare du Nord", false, true, c1);

                // add the 4 stations to the city
                ArrayList<Station> stationList = new ArrayList<Station>();
                stationList.add(s);
                stationList.add(s2);
                stationList.add(s3);
                stationList.add(s4);

                // create the years HashMap
                HashMap<Integer, Year> years = new HashMap<Integer, Year>();
                years.put(2020, y);
                years.put(2019, y2);
                years.put(2018, y3);

                System.out.println("intialisation done.");

                System.out.println("");
                System.out.println("launching tests :");

                // Display the city
                System.out.println("\tTest print city after construction :");
                System.out.println("");
                System.out.println(c1.toString());
                System.out.println("");
                System.out.println("");

                // Display the department
                System.out.println("\tTest print department after construction :");
                System.out.println("");
                System.out.println(d.toString());
                System.out.println("");
                System.out.println("");

                // Display the airport
                System.out.println("\tTest print airport after construction :");
                System.out.println("");
                System.out.println(a1.toString());
                System.out.println("");
                System.out.println("");

                // Display the station
                System.out.println("\tTest print station after construction :");
                System.out.println("");
                System.out.println(s.toString());
                System.out.println("");
                System.out.println("");

                // Display the year
                System.out.println("\tTest print year after construction :");
                System.out.println("");
                System.out.println(years.toString());
                System.out.println("");
        }
}