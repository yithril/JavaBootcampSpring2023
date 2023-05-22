public class BankAccount extends Asset {
    private double balance;

    public BankAccount(String name, double value) {
        super(name, value);
    }

    public void deposit(double money){
        this.balance += money;
    }

    public void withdraw(double money){
        this.balance -= money;
    }

    @Override
    public double getValue() {
        return this.balance;
    }
}
