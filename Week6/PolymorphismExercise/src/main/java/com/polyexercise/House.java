package com.polyexercise;

public class House extends Asset {
    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

    public House(String description, String dateAcquired, double originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    @Override
    public double getValue(){
        switch(this.condition){
            case 1 -> { return (this.squareFoot * 180) + (this.lotSize * .25); }
            case 2 -> { return (this.squareFoot * 130) + (this.lotSize * .25); }
            case 3 -> { return (this.squareFoot * 90) + (this.lotSize * .25); }
            case 4 -> { return (this.squareFoot * 80) + (this.lotSize * .25); }
            default -> { return 0;}
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }
}
