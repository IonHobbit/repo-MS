import java.util.ArrayList;

public class Shop {

    private String shopID;
    private String name;
    private String address;
    private ArrayList<Product> products = new ArrayList<Product>();

    public Shop(String shopID, String name, String address) {
        this.shopID = shopID;
        this.name = name;
        this.address = address;
    }

    public void setShopID(String shopID) {
        this.shopID = shopID;
    }

    public String getShopID() {
        return this.shopID;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public ArrayList<Product> getProducts(){
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        int pdindex;
        pdindex = this.products.indexOf(product);
        products.remove(pdindex);
    }

    public int getProductCount(){
        return products.size();
    }
}