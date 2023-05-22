import java.time.LocalDate;

public class SalesContract extends Contract {
    private final double salesTax = .05;
    private final double recordingFee = 100;
    private boolean isFinanced;

    public SalesContract(LocalDate date, String customerName, String customerEmail, Vehicle vehicle, boolean isFinanced) {
        super(date, customerName, customerEmail, vehicle);
        this.isFinanced = isFinanced;
    }

    public double getProcessingFee(){
        if(getVehicle().getPrice() < 10000){
            return 295;
        }
        else{
            return 495;
        }
    }

    public double getSalesTax(){
        return (getVehicle().getPrice() / 100) * salesTax;
    }

    //base price of the car, the processing fee, recording fee, apply sales tax and that's the total price
    @Override
    public double getTotalPrice() {
        return getVehicle().getPrice() + getSalesTax() + recordingFee + getProcessingFee();
    }

    @Override
    public double getMonthlyPayment() {
        //if they don't finance, there is no monthly payment
        if(isFinanced){
            double interestRate;
            int months;

            if(getVehicle().getPrice() >= 10000){
                months = 48;
                interestRate = 4.25;
            }
            else{
                months = 24;
                interestRate = 5.25;
            }

            //use our equation to figure out their monthy payment

            //return the monthly payment
            return calculatePayment(getTotalPrice(), months, interestRate);
        }
        else{
            return 0;
        }
    }

    private double calculatePayment(double totalCost, int numberOfPayments, double rate)
    {
        double interestRate = rate / 12;
        double monthlyPayment = totalCost * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
        monthlyPayment = Math.round(monthlyPayment * 100);
        monthlyPayment /= 100;
        return monthlyPayment;
    }
}
