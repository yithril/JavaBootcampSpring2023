public abstract class Asset {
    private String name;
    private double value;

    public Asset(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public abstract double getValue();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
