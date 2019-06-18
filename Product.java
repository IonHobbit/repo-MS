public class Product {
    
    private String productID;
    private String name;
    private Double price;
    private int stock;

    public Product(String productID, String name, Double price, int stock) {

        this.productID = productID;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductID() {
        return this.productID;
    }
   
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return this.stock;
    }
}


