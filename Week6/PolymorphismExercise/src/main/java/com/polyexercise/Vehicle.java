package com.polyexercise;

public class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    @Override
    public double getValue(){
        double carValue;

        if(this.year >= 0 && this.year <= 3){
            carValue = this.getOriginalCost() * .97;
        }
        else if(this.year >= 4 && this.year <= 6){
            carValue = this.getOriginalCost() * .94;
        }
        else if(this.year >= 7 && this.year <= 10){
            carValue = this.getOriginalCost() * .92;
        }
        else{
            carValue = 1000;
        }

        if(this.odometer >= 100000 && (this.makeModel.contains("Honda") || this.makeModel.contains("Toyota") )){
            carValue *= .75;
        }

        return carValue;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
}
