public class Gold extends Asset implements MarketAsset {
    private double weight;

    public Gold(String name, double value, double weight) {
        super(name, value);
        this.weight = weight;
    }

    @Override
    public double getMarketValue() {
        return this.getValue() * .8;
    }

    public double getValue(){
        return this.weight * 500;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
