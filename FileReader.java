import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    /*
        This class is used to read from file and save the data.

        @param numberOfCities/numberOfRoutes : hold the number of cities/routes
        @param routes : holds a list of all the routes
        @param cityNames : a temporary list to hold city names
        @param cities : holds a list of all the cities
        @param startCity : holds the start city
        @param endCity : holds the destination city

        @method read : reads the input from the given file path
     */
    private int numberOfCities;
    private int numberOfRoutes;
    private Route[] routes;


    private String[] cityNames;
    private City[] cities;
    private City startCity;
    private City endCity;


    public void read(String filePath) {
        // reads the input from the given file path
        
        try (Scanner scanner = new Scanner(new File(filePath))) {
            
            numberOfCities = Integer.parseInt(scanner.nextLine().trim());
            cityNames = scanner.nextLine().trim().split(" ");
            cities = new City[numberOfCities];
            for(int i = 0; i < cityNames.length; i++){
                cities[i] = new City(cityNames[i]);
            }

            numberOfRoutes = Integer.parseInt(scanner.nextLine().trim()) * 2;
            routes = new Route[numberOfRoutes];
            // routes = new String[numberOfRoutes][3];
            for (int i = 0; i < numberOfRoutes; i++) {
                String[] routeData = scanner.nextLine().trim().split(" ");
                if (routeData.length == 3) {
                    routes[i] = new Route(routeData[0], routeData[1], Integer.parseInt(routeData[2]));

                    // adding the opposite direction with the same duration
                    routes[++i] = new Route(routeData[1], routeData[0], Integer.parseInt(routeData[2]));

                } else {
                    System.err.println("Invalid route format at line " + i);
                    System.exit(1);
                }
            }

            // Read starting and ending cities
            String[] startEndCities = scanner.nextLine().trim().split(" ");
            if (startEndCities.length == 2) {
                startCity = new City(startEndCities[0]);
                endCity = new City(startEndCities[1]);
            } else {
                System.err.println("Invalid start and end city format.");
                System.exit(1);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            System.exit(1);
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format: " + e.getMessage());
            System.exit(1);
        }
        System.out.println("File read successful!");
    }

    // Getters (No setter is needed since we are rading from a file.)
    public int getNumberOfCities() {
        return numberOfCities;
    }

    public City[] getCityLabels() {
        return cities;
    }

    public int getNumberOfRoutes() {
        return numberOfRoutes;
    }

    public Route[] getRoutes() {
        return routes;
    }

    public City getStartCity() {
        return startCity;
    }

    public City getEndCity() {
        return endCity;
    }
    
    
}