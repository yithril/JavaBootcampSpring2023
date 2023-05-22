public class Vehicle extends Asset implements MarketAsset {
    private String year;
    private String make;
    private String model;
    private String condition;

    public Vehicle(String name, double value, String year, String make, String model, String condition) {
        super(name, value);
        this.year = year;
        this.make = make;
        this.model = model;
        this.condition = condition;
    }

    public double getMarketValue() {
        return this.getValue() * .95;
    }

    public double getValue(){
        return 10000;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
