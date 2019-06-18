import java.util.Scanner;

public class App {

    //Creating the Market Instance
    private static Market jimeta = new Market();
    private static Buyer newBuyer;
    private static Seller newSeller;

    public static void main(String[] args) {

        //Creating Product Instances
        Product p1 = new Product("P001", "CloseUp Toothpaste(s)", 400.00, 1000);
        Product p2 = new Product("P002", "Harambe Bowl(s)", 4000.00, 2000);
        Product p3 = new Product("P003", "HP Laptop(s)", 400000.00, 50);
        Product p4 = new Product("P004", "Miniso Handbag(s)", 9000.00, 100);
        Product p5 = new Product("P005", "Harman/Kardon Speaker(s)", 10000.00, 90);
        Product p6 = new Product("P006", "Carpet(s)", 20000.00, 40);
        Product p7 = new Product("P007", "Water Bottle(s)", 500.00, 81000);
        Product p8 = new Product("P008", "Bed Sheet(s)", 4000.00, 900);
        Product p9 = new Product("P009", "Coke(s)", 100.00, 43000);
        Product p10 = new Product("P0010", "Fanta(s)", 200.00, 400);

        //Creating Shop Instances
        Shop shop1 = new Shop("S001", "Nino&Sons", "Shop Y9, South Axis");
        Shop shop2 = new Shop("S002", "Iya Basira Global", "Shop G19, Plot 10");
        Shop shop3 = new Shop("S003", "Home Taste Meals", "Shop K77, North Axis");

        //Adding Products to Shop Inventory
        shop1.addProduct(p1);
        shop1.addProduct(p2);
        shop1.addProduct(p6);
        shop1.addProduct(p7);
        shop1.addProduct(p9);
        shop1.addProduct(p10);

        shop2.addProduct(p3);
        shop2.addProduct(p4);
        shop2.addProduct(p8);
        shop2.addProduct(p7);

        shop3.addProduct(p6);
        shop3.addProduct(p5);
        shop3.addProduct(p9);

        jimeta.addShops(shop1);
        jimeta.addShops(shop2);
        jimeta.addShops(shop3);
        
        divider();
        System.out.println("Welcome to Repo MS - The Yola Cental Market Management System");
        divider();

        int role = checkRole();

        register(role);

        login(role);
        
        run(role, newBuyer, newSeller);
    }

    public static int checkRole() {

        int count = 0;

        while(true){
            System.out.println("What kind of account would you like to create?");
            System.out.println("1. Buyer");
            System.out.print("2. Seller\n==> ");
            
            Scanner roleInput = new Scanner(System.in);
            int selection = roleInput.nextInt();
            roleInput.nextLine();

            divider();



            if(count == 5){
                System.out.println("You have exceeded your number of tries");
                leave();
            }

            if(selection == 1 || selection == 2) {
                return selection;
            }else if(selection == 0){
                leave();
            }else{
                System.out.println("Invalid input, please select 1 or 2");
                count += 1;
            }
        }

        
    }

    public static void register(int role) {
        System.out.println("Input the following details to be registered into the System");
        
        Scanner regInput = new Scanner(System.in);

        System.out.print("\nWhat is your name?\n==> ");        
        String regName = regInput.nextLine();

        System.out.print("\nWhat is your email?\n==> ");
        String regEmail = regInput.nextLine();

        System.out.print("\nWhat password would you like to use?\n==> ");
        String regPassword = regInput.nextLine();
        
        if(role == 1) {
            newBuyer = new Buyer(regName, regEmail, regPassword);
            jimeta.addBuyers(newBuyer);
        }else if(role == 2) {
            newSeller = new Seller(regName, regEmail, regPassword);
            jimeta.addSellers(newSeller);
        }
    }

    public static void login(int role) {

        System.out.println("Please Login using your Registered credentials");

        int count = 0;

        while(true) {

            Scanner logInput = new Scanner(System.in);

            int buyCheck = 0;
            int sellCheck = 0;
            
            System.out.print("\nEmail: ");
            String logEmail = logInput.nextLine();
            System.out.print("\nPassword: ");
            String logPassword = logInput.nextLine();

            switch(role){

                case 1:

                    for(int i = 0; i <= jimeta.getBuyers().size()-1; i++){
                        if(logEmail.equals(jimeta.getBuyers().get(i).getEmail())){
                            jimeta.getBuyers().get(i).login(logEmail, logPassword);
                            buyCheck = 1;
                            divider();
                        }
                       
                    }

                    if(buyCheck == 0) {
                        System.out.println("Sorry No Account with \'" +  logEmail +"\' exists");
                        System.out.println("Try Again");
                        divider();
                        count++;
                        System.out.println(count);

                    }
                    break;


                case 2:

                    for(int i = 0; i <= jimeta.getSellers().size()-1; i++){
                        if(logEmail.equals(jimeta.getSellers().get(i).getEmail())){
                            jimeta.getSellers().get(i).login(logEmail, logPassword);
                            sellCheck = 1;
                            divider();

                        }
                    }

                    if(sellCheck == 0) {
                        System.out.println("Sorry No Account with \'" +  logEmail +"\' exists");
                        System.out.println("Try Again");
                        divider();
                        count++;
                    }

                    break;


            }

            if(buyCheck == 1 || sellCheck == 1) {
                break;
            }

            if(count == 5){
                System.out.println("It is clear you have no account within our System.\nBye -_-");
                leave();
            }
            
        

        }
        
    }
    
    public static void run(int role, Buyer newBuyer, Seller newSeller) {
        
        Scanner runInput = new Scanner(System.in);

        switch(role) {

            //Buyer actions
            
            case 1:

                //Variable to store the array index of Buyer
                int buyerindex = jimeta.getBuyers().indexOf(newBuyer);

                while(true) {
                    System.out.println("Possible Operations");
                    divider();
                    System.out.println("1. See Available Shops");
                    System.out.println("2. Check Basket");
                    System.out.println("3. Check Out");
                    System.out.print("4. Log Out\n==> ");
                    
                    int response = runInput.nextInt();

                    switch(response) {

                        //Displays Shops that are in the Market

                        case 1:
                            while(true) {

                                System.out.println("Choose a Shop");
                                divider();
                                for(int i = 0; i <= jimeta.getShops().size()-1; i++) {
                                    System.out.println(i+1 + ". " + jimeta.getShops().get(i).getName());
                                }
                                System.out.print("==> ");

                                int shopResponse = runInput.nextInt();

                                //Add Products to Basket

                                while(true) {

                                    System.out.println("Welcome to " + jimeta.getShops().get(shopResponse-1).getName());
                                    System.out.println("These are the available Products:");

                                    divider();

                                    for(int i = 0; i<= jimeta.getShops().get(shopResponse-1).getProducts().size()-1; i++) {
                                        System.out.println(i+1 + ". " +jimeta.getShops().get(shopResponse-1).getProducts().get(i).getName());
                                    }
                                    System.out.println("0. Exit Shop");

                                    divider();

                                    System.out.print("\nWhat would you like to add to your Basket: ");

                                    int productResponse = runInput.nextInt();

                                    if(productResponse >= 1 && productResponse <= jimeta.getShops().get(shopResponse-1).getProducts().size()) {
                                        System.out.print("\nHow many would you like: ");

                                        int amountResponse = runInput.nextInt();

                                        jimeta.getShops().get(shopResponse-1).getProducts().get(productResponse-1).setStock(amountResponse);                                      
                                        jimeta.getBuyers().get(buyerindex).getBasket().addToBasket(jimeta.getShops().get(shopResponse-1).getProducts().get(productResponse-1), amountResponse);
                                        divider();
                                    }else if(productResponse == 0) {
                                        break;
                                    }else{
                                        System.out.println("Invalid Response! Select a Product Index from the list");
                                        divider();
                                    }

                                }
                                
                                System.out.print("Would you like to go to another Shop?(y/n): ");

                                Scanner loopcheck = new Scanner(System.in);

                                String checkResponse = loopcheck.nextLine();

                                if(checkResponse.equals("n")){
                                    divider();
                                    break;
                                }

                                divider();


                            }
                            break;
                        
                        case 2:
                            if(jimeta.getBuyers().get(buyerindex).getBasket().getBasketProducts().size() == 0) {
                                System.out.println("Your basket is empty.");
                                System.out.println("Enter 1 to do some Shopping");
                                divider();
                            }else{
                                for(int i =0; i <= jimeta.getBuyers().get(buyerindex).getBasket().getBasketProducts().size()-1; i++) {
                                    System.out.println("Product - " + jimeta.getBuyers().get(buyerindex).getBasket().getBasketProducts().get(i).getName() + " || Quantity - " + jimeta.getBuyers().get(buyerindex).getBasket().getBasketProducts().get(i).getStock() + " || Price - " + jimeta.getBuyers().get(buyerindex).getBasket().getBasketProducts().get(i).getPrice()*jimeta.getBuyers().get(buyerindex).getBasket().getBasketProducts().get(i).getStock());
                                    
                                }
                            }
                            break;
                            

                        case 3:
                            System.out.println("Total Price - " + jimeta.getBuyers().get(buyerindex).getBasket().calculateTotalPrice());
                            System.out.print("Proceed to pay and Checkout?(y/n): ");

                            Scanner payInput = new Scanner(System.in);

                            String checkPay = payInput.nextLine();

                            System.out.println("Total Price - " + jimeta.getBuyers().get(buyerindex).getBasket().getTotalPrice());
                            if(checkPay.equals("y")){
                                jimeta.getBuyers().get(buyerindex).buy();
                                leave();
                            }else if(checkPay.equals("n")){
                                System.out.println("Select some other Options");
                            }

                            break;   
                        
                        case 4:
                            leave();

                    }
                }

            //Seller actions
            case 2:

                //Variable to store the array index of Buyer
                int sellerindex = jimeta.getSellers().indexOf(newSeller);

                while(true) {
                    System.out.println("Possible Operations");
                    divider();
                    System.out.println("1. View Owned Shops");
                    System.out.println("2. Acquire Shop");
                    System.out.print("3. Log Out");
                    divider();
                    System.out.print("==> ");

                    int response = runInput.nextInt();

                    //Displays Shops Owned by Seller
                    switch(response) {
                        case 1:
                            while(true) {

                                if(jimeta.getSellers().get(sellerindex).getShops().size() == 0) {
                                    System.out.println("You have no Shops in our system\nGo back to acquire a Shop");
                                    divider();
                                }else{
                                    System.out.println("Choose a Shop");
                                    divider();
                                    for(int i = 0; i <= jimeta.getSellers().get(sellerindex).getShops().size()-1; i++) {
                                        System.out.println(i+1 + ". Name: \'" + jimeta.getSellers().get(sellerindex).getShops().get(i).getName() + "\' | Address: \'" + jimeta.getSellers().get(sellerindex).getShops().get(i).getAddress() + "\' | Indivdual Product Count: " + jimeta.getSellers().get(sellerindex).getShops().get(i).getProductCount());
                                    }

                                }
                                System.out.println("0. Go Back");
                                divider();  
                                System.out.print("==> ");     
                                                  

                                int sellerResponse = runInput.nextInt();

                                if(sellerResponse == 0){
                                    break;
                                }

                                //View Products in Store

                                while(true) {

                                    System.out.println(jimeta.getSellers().get(sellerindex).getShops().get(sellerResponse-1).getName());

                                    divider();

                                    System.out.println("Product List:");
                                    if(jimeta.getSellers().get(sellerindex).getShops().get(sellerResponse-1).getProducts().size() == 0) {
                                        System.out.println("Your Shop currently has no Products");
                                    }

                                    for(int i = 0; i<= jimeta.getSellers().get(sellerindex).getShops().get(sellerResponse-1).getProducts().size()-1; i++) {
                                        System.out.println(i+1 + ". " +jimeta.getSellers().get(sellerindex).getShops().get(sellerResponse-1).getProducts().get(i).getName());
                                    }

                                    divider();

                                    System.out.println("1. Add Products to Shop");
                                    System.out.println("2. Remove Products from Shop");
                                    System.out.println("3. Close Down Shop");
                                    System.out.println("0. Exit Shop");
                                    divider();

                                    System.out.print("==> ");
                                    
                                    int shopResponse = runInput.nextInt();

                                    //Add Product to Shop                                    
                                    if(shopResponse == 1) {
                                        divider();
                                        System.out.println("Product Addition Interface");
                                        System.out.println("Fill out the followiing to add a Product to your inventory");
                                        divider();
                                        while(true){
                                            
                                            Scanner addInput = new Scanner(System.in);
                                            
                                            System.out.print("\nProduct ID:");
                                            String productID = addInput.nextLine();

                                            System.out.print("\nProduct Name:");
                                            String productName = addInput.nextLine();

                                            System.out.print("\nProduct Price:");
                                            Double productPrice = addInput.nextDouble();

                                            System.out.print("\nQuantity:");
                                            int productQuantity = addInput.nextInt();

                                            Product newProduct = new Product(productID, productName, productPrice, productQuantity);
                                            jimeta.getSellers().get(sellerindex).getShops().get(sellerResponse-1).addProduct(newProduct);

                                            addInput.nextLine();
                                            System.out.print("Would you like to add another Product?(y/n)\n==> ");

                                            String addCheck = addInput.nextLine();

                                            if(addCheck.equals("n")){
                                                break;
                                            }
                                        }



                                    }
                                    //Remove Product from Shop
                                    else if(shopResponse == 2) {
                                        divider();
                                        System.out.println("Product Removal Interface");
                                        divider();
                                        while(true){

                                            if(jimeta.getSellers().get(sellerindex).getShops().get(sellerResponse-1).getProducts().size() == 0) {
                                                System.out.println("There are no proucts to remove");
                                                break;
                                            }

                                            System.out.print("\nSelect Product Index for Removal: ");
                                            int productResponse = runInput.nextInt();

                                            if(productResponse >= 1 && productResponse <= jimeta.getSellers().get(sellerindex).getShops().get(sellerResponse-1).getProducts().size()) {
                                                System.out.println(jimeta.getSellers().get(sellerindex).getShops().get(sellerResponse-1).getProducts().get(productResponse-1).getName() + " removed successfully");
                                                jimeta.getSellers().get(sellerindex).getShops().get(sellerResponse-1).removeProduct(jimeta.getSellers().get(sellerindex).getShops().get(sellerResponse-1).getProducts().get(productResponse-1));
                                                runInput.nextLine();
                                                System.out.print("Would you like to remove another Product?(y/n)\n==> ");
                                                
                                                String check = runInput.nextLine();

                                                if(check.equals("n")){
                                                    break;
                                                }
                                            }else{
                                                System.out.println("There are no more products to remove");
                                                break;
                                            }

                                            
                                        }

                                    }
                                    //Delete Shop
                                    else if(shopResponse == 3) {
                                        divider();
                                        System.out.println("Shop Deletion Interface");
                                        runInput.nextLine();
                                        System.out.println("Are you sure, you want to close down \'" + jimeta.getSellers().get(sellerindex).getShops().get(sellerResponse-1).getName() + "\'?(y/n)");     
                                        System.out.print("BEWARE! This action is irreversible!\n==> ");
                                        String check = runInput.nextLine();

                                        if(check.equals("y")){
                                            System.out.println(jimeta.getSellers().get(sellerindex).getShops().get(sellerResponse-1).getName() + " has been deleted");
                                            int shopindex = jimeta.getSellers().get(sellerindex).getShops().indexOf(jimeta.getSellers().get(sellerindex).getShops().get(sellerResponse-1));
                                            jimeta.getShops().remove(shopindex);
                                            jimeta.getSellers().get(sellerindex).closeShop(jimeta.getSellers().get(sellerindex).getShops().get(sellerResponse-1));
                                            break;
                                        }

                                        

                                    }else if(shopResponse == 0) {
                                        break;
                                    }else{
                                        System.out.println("Invalid Response! Select an Option from the list");
                                        divider();
                                    }
                                    

                                }


                            }
                            
                            break;
                        case 2:
                            while(true) {
                                divider();
                                System.out.println("Shop Creation Portal");
                                System.out.println("Fill out the following details to create your Shop");
                                divider();

                                runInput.nextLine();

                                System.out.print("Shop ID: ");
                                String shopID = runInput.nextLine();
                                System.out.print("Shop Name: ");
                                String shopName = runInput.nextLine();
                                System.out.print("Shop Address: ");
                                String shopAddress = runInput.nextLine();
                                
                                Shop newShop = new Shop(shopID, shopName, shopAddress);

                                jimeta.addShops(newShop);
                                jimeta.getSellers().get(sellerindex).payRent(newShop);

                                System.out.println("Your new Shop, " + newShop.getName() + " has been created at " + newShop.getAddress());

                                System.out.print("Would you like Create another Shop?(y/n)\n==> ");
                                
                                String check = runInput.nextLine();

                                if(check.equals("n")){
                                    break;
                                }

                            }
                            break;

                        case 3: 
                            leave();
                            
                    }
                }  
        }
        
        
    }

    public static void leave() {
        System.out.println("You're now Exiting " + jimeta.getName());
        System.out.println("Thank You for Coming!!");
        System.exit(0);
    }

    public static void divider() {
        System.out.println("\n*********************************\n");
    }

}