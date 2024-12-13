public class City {
    /*
        This class holds the information of a city

        @param name : the name of the city
        @param visited : it's a tag which is needed for Dijkstra's algorithm
        @param time : the time it takes to get to this city from the start city
        @param out : to know if all the routes of the city are checked or not (also used for Dijkstra's algorithm)
        @param fastestPath : the path to get to this city, starting from the startCity
     */
    private String name;
    private boolean visited;
    private int time;
    private boolean out;
    private String fastestPath = "";

    public City(String name){
        this.name = name;
        visited = false;
        time = 0;
        out = false;
    }

    public String getFastestPath(){
        return this.fastestPath;
    }
    public void setFastestPath(String currentPath){
        this.fastestPath = currentPath;
    }

    public boolean isOut(){
        return out;
    }
    public void setOut(boolean out){
        this.out = out;
    }

    public String getName() {
        return name;
    }

    public boolean isVisited() {
        return visited;
    }
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getTime() {
        return time;
    }
    public void setTime(int time){
        this.time = time;
    }
    
}
