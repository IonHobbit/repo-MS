import java.util.ArrayList;

public class Basket {

    private String basketID;
    private ArrayList<Product> basketProducts = new ArrayList<Product>();
    private Double totalPrice = 0.0;
    private int basketCount;

    Basket() {
        this.basketID = "BA001";
    }

    public void setBasketID(String basketID){
        this.basketID = basketID;
    }

    public String getbasketID() {
        return this.basketID;
    }

    public void setBasketProducts(ArrayList<Product> basketProducts) {
        this.basketProducts = basketProducts;

    }

    public ArrayList<Product> getBasketProducts() {
        return this.basketProducts;
    }

    public void addToBasket(Product product, int quan) {
        basketProducts.add(product);
        System.out.println(quan + " " + product.getName() + " has been successfully added to your basket");
    }

    public void removeFromBasket(Product product) {

        int pdindex;
        pdindex = this.basketProducts.indexOf(product);
        basketProducts.remove(pdindex);

    }

    public Double calculateTotalPrice(){
        for(int i = 0; i <= this.basketProducts.size()-1; i++) {
            totalPrice += (this.basketProducts.get(i).getPrice() * this.basketProducts.get(i).getStock());
        }
        return totalPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setBasketCount(int basketCount) {
        this.basketCount = basketCount;
    }

    public int getBasketCount() {

        basketCount = this.basketProducts.size();
        return basketCount;
    }
}