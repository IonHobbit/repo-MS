import java.util.ArrayList;

class Trader{

    private String name;
    private String email;
    private String password;

    Trader() {}

    Trader(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void login(String email, String password) {

        if(password.equals(this.password)) {
            System.out.println("Welcome " + this.name);
        }else{
            System.out.println("Your Email or Password is incorrect, Please Try again Later");
        }
        
    }

    public void logout() {

        System.out.println("Good Bye " + this.name + ", Come back Again soon");

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

}

class Buyer extends Trader {

    private String buyerID;
    private Basket basket;

    Buyer(String name, String email, String password){
        super(name, email, password);
        this.buyerID = "B0012";
        basket = new Basket();
    }

    public void setBuyerID(String buyerID) {
        this.buyerID = buyerID;
    }

    public String getBuyerId() {
        return this.buyerID;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Basket getBasket(){
        return basket;
    }

    public void buy() {
        this.makePayment();
    }

    public void makePayment() {

        System.out.println("Payment of $" + basket.getTotalPrice() + " Successful");

    }

}

class Seller extends Trader {

    private String sellerID;
    private ArrayList<Shop> shops = new ArrayList<Shop>();

    Seller(String name, String email, String password){
        super(name, email, password);
        this.sellerID = "S0001";
    }

    public void setSellerID(String sellerID) {
        this.sellerID = sellerID;
    }

    public String getSellerId() {
        return this.sellerID;
    }

    public ArrayList<Shop> getShops() {
        return shops;
    }

    public void closeShop(Shop shop) {
        int shopindex;
        shopindex = this.shops.indexOf(shop);
        shops.remove(shopindex);
    }

    public void payRent(Shop shop) {
        this.shops.add(shop);

    }

}