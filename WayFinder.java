public class WayFinder {
    /*
        THE WAYFINDER ALGORITHM IS IN THIS CLASS (HOLY MOLY WHAT IS ALL THAT *-* )

        
        @param routes : holds a list of all the routes
        @param cities : holds a list of all the cities
        @param startCity : holds the start city
        @param endCity : holds the destination city
        @param numberOfCities/numberOfRoutes : hold the number of cities/routes
        @param finalPath : hold the fastest path to the destination
        @param routesAreChecked : a flag to know if the fastest route to each city is calculated or not.

        @method calculateDuration : calculates the fastest path to each city and saves it into the city
        @method calculatePaths : runs calculateDuration for each city then saves and returns the fastest route to the destination
        @method findTheFastestPath : calls calculatePaths and returns the result as a string
        @method displayCityData : displays each city's data, including the fastest route to it.
     */
    private Route[] routes;

    private City[] cities;
    private City startCity;
    private City endCity;

    private int numberOfCities;
    private int numberOfRoutes;

    private String finalPath;

    private boolean routesAreChecked = false;


    public WayFinder(CountryMap map){
        this.routes = map.getRoutes();
        this.numberOfCities = map.getNumberOfCities();
        this.numberOfRoutes = map.getNumberOfRoutes();

        this.startCity = map.getStartCity();
        this.endCity = map.getEndCity();
        this.cities = map.getCities();

    }


    private boolean calculateDuration(City city){
        /*
            This method checks the duration of each path for each city. (THE HOLY ALGORITHM)
         */

        if(city.getFastestPath().startsWith(startCity.getName())){ // if the path is connected to startCity
            for(int i = 0; i < numberOfRoutes; i++){
                if(routes[i].startCity().equals(city.getName()) && !city.isOut()){ // for each route starting with the current city
                    for(int j = 0; j < numberOfCities; j++){
                        if(routes[i].endCity().equals(cities[j].getName())){ // finding the destination city's object (City object with the same name)
                            if(!cities[j].isVisited()){ // if it's not visited
                                cities[j].setTime(city.getTime() + routes[i].getDuration());
                                cities[j].setVisited(true);
                                cities[j].setFastestPath(city.getFastestPath() + " -> " + cities[j].getName());
                            }
                            else{ // if it's visited 
                                if(!cities[j].isOut()){ // if the city's routes is not checked already
                                    if(cities[j].getTime() >= city.getTime() + routes[i].getDuration()){ // check if the new path would be faster or not. If yes, then:
                                        cities[j].setTime(city.getTime() + routes[i].getDuration());
                                        cities[j].setFastestPath(city.getFastestPath() + " -> " + cities[j].getName());
                                    }
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
        else{
            for(int i = 0; i < numberOfCities; i++){ // finding the city we checked the routes for and then setting it as "out"
                if(cities[i].getName().equals(city.getName())){
                    cities[i].setOut(true);
                }
            }
        }
        return true;
    }


    private City calculatePaths(){
        /*
            all the open routes for each single city
            Then returns the destination city which holds the fastest route to get to it.
         */
        
        for(int i = 0; i < numberOfCities; i++){
            if(calculateDuration(cities[i])){
                cities[i].setOut(true);
            }
            else{
                System.out.println("An error occured.");
            }
            if(cities[i].getName().equals(endCity.getName())){
                endCity = cities[i];
            }
        }
        routesAreChecked = true;
        return endCity;
    }

    
    public void findTheFastestPath(){
        // calls calculatePaths and returns the result as a string

        City fastestRoute = calculatePaths();
        finalPath = fastestRoute.getFastestPath() + "     Duration: " + fastestRoute.getTime();
    }


    public void displayCityData(){
        // displays each city's data, including the fastest route to it.

        for(City city: cities){
            System.out.println(city.getName() );
            if(routesAreChecked){ // if we have checked the time to get to each city
                System.out.println("Time: " + city.getTime() + "     Fastet Path to this city:   " + city.getFastestPath());
            }
            else System.out.println("Time: " + city.getTime());
            System.out.println("Out: " + city.isOut() + "    " + "Visited: " + city.isVisited() + "\n");
        }
        if(routesAreChecked){ // if we have checked the time to get to each city
            System.out.println("THE FASTEST ROUTE FROM \"" + startCity.getName() + "\" TO \"" + endCity.getName() + "\" : " + finalPath);
        }
    }


    public String getFinalPath(){
        return this.finalPath;
    }

}
