import java.util.ArrayList;

public class Portfolio {
    private String owner;
    private String name;
    private ArrayList<Asset> assets;

    public Portfolio(String owner, String name) {
        this.owner = owner;
        this.name = name;
        this.assets = new ArrayList<>();
    }

    public ArrayList<Asset> getAssets(){
        return this.assets;
    }

    public void add(Asset asset){
        this.assets.add(asset);
    }

    public double getValue(){
        double assetValueSum = 0;

        for(Asset asset : this.assets){
            assetValueSum += asset.getValue();
        }

        return assetValueSum;
    }
}
