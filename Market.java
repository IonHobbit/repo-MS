import java.util.ArrayList;

public class Market {
    private String name;
    private String location;
    private ArrayList<Buyer> buyers;
    private ArrayList<Seller> sellers;
    private ArrayList<Shop> shops;

    Market() {
        this.name = "Jimeta Modern Market";
        this.location = "Jimeta Central";
        this.buyers = new ArrayList<Buyer>();
        this.sellers = new ArrayList<Seller>();
        this.shops = new ArrayList<Shop>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }

    public ArrayList<Buyer> getBuyers() {
        return buyers;
    }

    public ArrayList<Seller> getSellers() {
        return sellers;
    }

    public ArrayList<Shop> getShops() {
        return shops;
    }

    public void addBuyers(Buyer buyer){
        this.buyers.add(buyer);
    }

    public void addSellers(Seller seller){
        this.sellers.add(seller);
    }

    public void addShops(Shop shop){
        this.shops.add(shop);
    }


}