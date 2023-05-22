public class Jewelry extends Asset implements MarketAsset {
    private double karat;
    public Jewelry(String name, double value, double karat) {
        super(name, value);
        this.karat = karat;
    }

    public double getMarketValue() {
        return this.getValue() * .9;
    }

    public double getValue() {
        return this.karat * 100;
    }

    public double getKarat() {
        return karat;
    }

    public void setKarat(double karat) {
        this.karat = karat;
    }
}
