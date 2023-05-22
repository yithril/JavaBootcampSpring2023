public class CreditCard extends Asset {
    private double balance;

    public CreditCard(String name, double value) {
        super(name, value);
    }

    public void charge(double amount){
        this.balance += amount;
    }

    public void pay(double amount){
        this.balance -= amount;
    }

    @Override
    public double getValue() {
        return this.balance;
    }
}
