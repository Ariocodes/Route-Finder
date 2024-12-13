public class Main {
    public static void main(String[] args){

        String inputFile;

        // getting the input file path
        if(args.length > 0){
            inputFile = args[0];
        }
        else inputFile = "input.txt";


        // creating the map using the input file
        CountryMap theMap = new CountryMap(inputFile);
        // theMap.displayMapData();


        // giving the map data to the finder class
        WayFinder finder = new WayFinder(theMap);


        // finding the fastest route from start point to the destination
        finder.findTheFastestPath();
        finder.displayCityData();
        
    }
}
