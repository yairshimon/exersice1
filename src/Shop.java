import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Shop {
    private final LinkedList<Customers> customers;
    private final LinkedList<Workers> workers;
    private final HashMap<Integer, Products> productsHashMap;

    public Shop() {
        this.customers = new LinkedList<>();
        this.workers = new LinkedList<>();
        this.productsHashMap = new HashMap<>();
    }

    public void createUser() {
        Scanner scanner = new Scanner(System.in);
        String firstName;
        String lastName;
        String userName;
        String password;
        int youClubMembers;
        boolean clubMembers = false;
        boolean userNameTaken;
        int customers;
        int typeOfWorker;
        do {
            System.out.println("Do you want to create an employee or customer account? for customer press 0 for employee press 1");
            customers = scanner.nextInt();
        } while (customers != 0 && customers != 1);
        do {
            System.out.println("Enter a first name");
            firstName = scanner.next();
        } while (noNumbers(firstName));
        do {
            System.out.println("Enter a last name");
            lastName = scanner.next();
        } while (noNumbers(lastName));
        do {
            System.out.println("Enter a user name");
            userName = scanner.next();
            userNameTaken = this.doesUserNameExist(userName);
        } while (userNameTaken);
        do {
            System.out.println("Enter a password");
            password = scanner.next();
        } while (password.length() < 6);
        do {
            System.out.println("You are club members?(enter 1 for 'true' or 0 for 'false')");
            youClubMembers = scanner.nextInt();
        } while (youClubMembers != 0 && youClubMembers != 1);
        if (youClubMembers > 0) clubMembers = true;
        if(customers == 0 ) {
            Customers newCustomer = new Customers(firstName, lastName, userName, password, clubMembers);
            this.customers.add(newCustomer);
        }else{
        do {
            System.out.println("What is your rank, click 1 - for a regular employee; 2 - for a manager; 3 - For a member of the management team.");
            typeOfWorker = scanner.nextInt();
        } while (typeOfWorker != 1 && typeOfWorker != 2 && typeOfWorker != 3);
        TypeWorker typeWorker;
        if (typeOfWorker == 1) {
            typeWorker = TypeWorker.REGULAR_WORKER;
        } else if (typeOfWorker == 2) {
            typeWorker = TypeWorker.DIRECTOR;
        } else typeWorker = TypeWorker.MEMBER_IN_BOARD;
        Workers newWorker = new Workers(firstName, lastName, userName, password, clubMembers,typeWorker);
        this.workers.add(newWorker);
    }
    }



    private boolean doesUserNameExist(String usernameToCheck) {
        boolean exits = false;
        for (Customers currentCustomer : this.customers) {
            if (currentCustomer.getUserName().equals(usernameToCheck)) {
                exits = true;
                System.out.println("Username is busy");
                break;
            }
        }
        if (!exits) {
            for (Workers currentWorker : this.workers) {
                if (currentWorker.getUserName().equals(usernameToCheck)) {
                    exits = true;
                    System.out.println("Username is busy");
                    break;
                }
            }
        }
        return exits;
    }

   public void loginCustomers() {
       Customers found = null;
       Scanner scanner = new Scanner(System.in);
       System.out.println("Enter your username");
       String username = scanner.nextLine();
       System.out.println("Enter your password");
       String password = scanner.nextLine();
       for (Customers currentCustomer : this.customers) {
           if (currentCustomer.getUserName().equals(username) && currentCustomer.getPassword().equals(password)) {
               found = currentCustomer;
               System.out.print("Hello {" + currentCustomer.getFirstName() + "} {" + currentCustomer.getLastName());
               System.out.print(currentCustomer.isClubMembers() ? "} {VIP} " : "}");
               System.out.println(" !");
               if(productsHashMap.isEmpty()) System.out.println("No products in the store yet,Come back later");
               else ShoppingCart.buyProductsForCustomer(productsHashMap,currentCustomer);
               break;
           }
       }
       if (found == null) {
           System.out.println("Wrong credentials!");
       }
   }
    public void loginWorkers() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        Workers found = null;
        System.out.println("Enter your username");
        String username = scanner.nextLine();
        System.out.println("Enter your password");
        String password = scanner.nextLine();
        for (Workers currentWorker : this.workers) {
            if (currentWorker.getUserName().equals(username) && currentWorker.getPassword().equals(password)) {
                found = currentWorker;
                System.out.print("Hello {" + currentWorker.getFirstName() + "} {" + currentWorker.getLastName() + "}");
                if (currentWorker.getTypeWorker() == TypeWorker.REGULAR_WORKER) {
                    System.out.print(" {regular worker} ");
                } else if (currentWorker.getTypeWorker() == TypeWorker.DIRECTOR) {
                    System.out.print(" {director} ");
                } else System.out.print(" {member in board} ");
                System.out.println(" !");
                do {
                    System.out.println("pressure.\n" +
                            "1 - Print a list of all customers.\n" +
                            "2 - Print the list of customers who are members of the club only.\n" +
                            "3 - Print the list of customers who have made at least one purchase.\n" +
                            "4 - Print the customer whose purchase amount is the highest.\n" +
                            "5 - Adding a new product to the store.\n" +
                            "6 - Change inventory status for a product: Update for a specific product whether it is in stock or not.\n" +
                            "7 - Making a purchase.\n" +
                            "8 - Logout: Prints the main menu again.");
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            if(customers.isEmpty()) System.out.println("NO CUSTOMERS IN SHOP");
                            else System.out.println(customers.toString());
                            break;
                        case 2:
                            boolean exitsCustomersVIP = false;
                            for (Customers currentCustomer : this.customers) {
                                if (currentCustomer.isClubMembers()) {
                                    System.out.println(currentCustomer.toString());
                                    exitsCustomersVIP = true;
                                }
                            }
                            if(!exitsCustomersVIP) System.out.println("NO CUSTOMERS VIP IN SHOP");
                            break;
                        case 3:
                            boolean inStorePurchase = false;
                                for (Customers currentCustomer : this.customers) {
                                    if (currentCustomer.getAmountOfPurchases() >= 1) {
                                        System.out.println(currentCustomer.toString());
                                        inStorePurchase = true;
                                    }
                                }
                           if(!inStorePurchase) System.out.println("No shopping was done at the delicate store");
                           break;
                        case 4:
                            if(!customers.isEmpty()) {
                                boolean InStorePurchase = false;
                                Customers customerPurchaseAmountHighest = customers.get(0);
                                for (Customers currentCustomer : this.customers) {
                                    if (currentCustomer.getSumOfPurchases() > customerPurchaseAmountHighest.getSumOfPurchases()) {
                                        customerPurchaseAmountHighest = currentCustomer;
                                        InStorePurchase = true;
                                    }
                                }
                                if (InStorePurchase) System.out.println(customerPurchaseAmountHighest.toString());
                                else System.out.println("No shopping was done at the delicate store");
                            }else System.out.println("NO CUSTOMERS IN SHOP");
                            break;
                        case 5:
                            String name;
                            String description;
                            float price;
                            int discountPercentage;
                            int amountProduct;
                            System.out.println("Enter name of product");
                            name = scanner.next();
                            System.out.println("Enter describe product");
                            description = scanner.next();
                            System.out.println("Enter price of product");
                            price = scanner.nextFloat();
                            System.out.println("Enter a discount for club members");
                            discountPercentage = scanner.nextInt();
                            do {
                                System.out.println("Enter a amount of product");
                                amountProduct = scanner.nextInt();
                            }while (amountProduct<0);
                            Products newProduct = new Products(name, description, price, discountPercentage,amountProduct);
                            int i = 0;
                            do {
                                i++;
                            } while (productsHashMap.containsKey(i));
                            productsHashMap.put(i, newProduct);
                            break;
                        case 6:
                            int productDelete;
                            if(productsHashMap.isEmpty()) System.out.println("No products in the store yet,Come back later");
                            else {
                                System.out.println(productsHashMap.toString());
                                do {
                                    System.out.println("Enter number product you want to delete from list(for exit press -1)");
                                    productDelete = scanner.nextInt();
                                } while (productsHashMap.get(productDelete) == null && productDelete != -1);
                                productsHashMap.remove(productDelete);
                            }
                            break;
                        case 7:
                            ShoppingCart.buyProductsForWorker(productsHashMap, currentWorker);
                            break;
                        case 8:
                            exit = true;
                            System.out.println("BY");
                            break;
                    } } while (!exit) ;
                    break;


        }
        }
        if (found == null) {
            System.out.println("Wrong credentials!");
        }
    }

    public static boolean noNumbers (String string){
        for (int i = 0; i < string.length(); i++){
            if (string.charAt(i) >= 48 &&  string.charAt(i) <= 57) {
                System.out.println("Enter name without numbers!!!");
                return true;
            }
        }
        return false;
    }
}
