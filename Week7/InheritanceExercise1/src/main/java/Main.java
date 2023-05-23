import javax.sound.sampled.Port;

public class Main {
    public static void main(String[] args) {
        Portfolio portfolio = new Portfolio("Jonathan Hop", "Blingmas");

        Gold gold = new Gold("Swiss Gold Account", 100000, 20);

        Jewelry jewelry = new Jewelry("Hope Diamond", 22103, 20);

        Vehicle vehicle = new Vehicle("Escalade", 150000, "2022", "Cadillac", "Escalade", "Perfection");

        BankAccount myBankAccount = new BankAccount("Hop Bank", 5000);

        portfolio.add(gold);
        portfolio.add(jewelry);
        portfolio.add(vehicle);
        portfolio.add(myBankAccount);

        //bankruptcy

        System.out.println(portfolio.getAssets());

        for(Asset asset : portfolio.getAssets()){
            if(asset instanceof MarketAsset){
                System.out.println(((MarketAsset) asset).getMarketValue());
            }
        }

        //System.out.printf("The value of your portfolio is: %f", portfolio.getValue());
    }
}
