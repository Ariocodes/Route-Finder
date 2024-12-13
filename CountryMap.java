public class CountryMap {
    /*
        This class is used to hold the map data.
        
        @param routes : holds a list of all the routes
        @param numberOfCities/numberOfRoutes : hold the number of cities/routes
        @param cities : holds a list of all the cities
        @param startCity : holds the start city
        @param endCity : holds the destination city
        @param file : is the fileReader object which will read the data from input file

        @method displayMapData : prints out all the map data
     */
    public Route[] routes;

    public int numberOfCities;
    public int numberOfRoutes;

    public City[] cities;
    public City startCity;
    public City endCity;

    private FileReader file;

    public CountryMap(String filepath){
        file = new FileReader();
        file.read(filepath); // reading from the file

        // Saving all the read data into variables
        this.routes = file.getRoutes();
        this.cities = file.getCityLabels();

        this.numberOfCities = file.getNumberOfCities();
        this.numberOfRoutes = file.getNumberOfRoutes();

        this.startCity = file.getStartCity();
        startCity.setVisited(true);
        startCity.setFastestPath(startCity.getName());
        for(City city: cities){
            if(city.getName().equals(startCity.getName())){
                city.setVisited(true);
            }
            city.setFastestPath(city.getName());
        }

        this.endCity = file.getEndCity();
    }

    public void displayMapData() {
        // prints out all the map data
        
        System.out.println("Number of Cities: " + numberOfCities);
        System.out.print("City Names: ");
        for(int i = 0; i<cities.length; i++){
            System.out.print(cities[i].getName() + ", ");
        }
        System.out.println();
        System.out.println("Number of Routes: " + numberOfRoutes);
        for (int i = 0; i < numberOfRoutes; i++) {
            System.out.println("Route: " + routes[i].startCity() + " to " + routes[i].endCity() + " takes " + routes[i].getDuration() + " minutes");
        }
        System.out.println("Start City: " + startCity.getName());
        System.out.println("End City: " + endCity.getName());
    }


    // Getters (No setter is needed since we are rading from a file.)

    public FileReader getFile(){
        return file;
    }

    public Route[] getRoutes() {
        return routes;
    }

    public City[] getCities() {
        return cities;
    }

    public int getNumberOfCities() {
        return numberOfCities;
    }

    public int getNumberOfRoutes() {
        return numberOfRoutes;
    }

    public City getStartCity() {
        return startCity;
    }

    public City getEndCity() {
        return endCity;
    }

}
