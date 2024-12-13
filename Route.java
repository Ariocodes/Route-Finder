class Route{
    private String startCity;
    private String endCity;
    private int duration;

    public Route(String startCity, String endCity, int duration){
        this.startCity = startCity;
        this.endCity = endCity;
        this.duration = duration;
    }

    public String startCity() {
        return this.startCity;
    }
    public String endCity() {
        return this.endCity;
    }
    public int getDuration() {
        return this.duration;
    }
    
}