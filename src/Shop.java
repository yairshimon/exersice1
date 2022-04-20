import java.util.LinkedList;
import java.util.Scanner;

public class Shop {
    private LinkedList<Customers> customers;
    private LinkedList<Workers> workers;

    public Shop() {
        this.customers = new LinkedList<>();
        this.workers = new LinkedList<>();
    }

    public void createUser() {
        Scanner scanner = new Scanner(System.in);
        String firstName;
        String lastName;
        String userName;
        String password;
        boolean clubMembers;
        boolean userNameTaken;
        int customers ;
        int typeOfWorker;
        do {
        System.out.println("Do you want to create an employee or customer account? for customer press 0 for employee press 1");
        customers = scanner.nextInt();
        } while (customers != 0 && customers != 1);
        do {
            System.out.println("Enter a first name");
            firstName = scanner.next();
        } while (!noNumbers(firstName));
        do {
            System.out.println("Enter a last name");
            lastName = scanner.next();
        } while (!noNumbers(lastName));
        do {
            System.out.println("Enter a user name");
            userName = scanner.next();
            userNameTaken = this.doesUserNameExist(userName);
        } while (userNameTaken);
        do {
            System.out.println("Enter a password");
            password = scanner.next();
        } while (password.length() < 6);
        if(customers == 0) {
            System.out.println("You are club members?");
            clubMembers = scanner.hasNext();
            Customers newCustomer = new Customers(firstName, lastName, userName, password, clubMembers);
            this.customers.add(newCustomer);
        }else {
            do {
                System.out.println("What is your rank, click 1 - for a regular employee; 2 - for a manager; 3 - For a member of the management team.");
                typeOfWorker = scanner.nextInt();
            } while (typeOfWorker != 1 && typeOfWorker != 2 && typeOfWorker != 3);
            TypeWorker typeWorker = typeOfWorker == 1 ? TypeWorker.REGULAR_WORKER : TypeWorker.DIRECTOR;
            Workers newWorker = new Workers(firstName, lastName, userName, password, typeWorker);
            this.workers.add(newWorker);
        }
    }



    private boolean doesUserNameExist(String usernameToCheck) {
        boolean exits = false;
        for (Customers currentCustomer : this.customers) {
            if (currentCustomer.getUserName().equals(usernameToCheck)) {
                exits = true;
                break;
            }
        }
        return exits;
    }

   public Customers login() {
        Customers found = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username");
        String username = scanner.nextLine();
        System.out.println("Enter your password");
        String password = scanner.nextLine();
        for (Customers currentCustomer : this.customers) {
            if (currentCustomer.getUserName().equals(username) && currentCustomer.getPassword().equals(password)) {
                found = currentCustomer;
                break;
            }
        }
        return found;
    }

    public static boolean noNumbers (String string){
        for (int i = 0; i < string.length(); i++){
            if (string.charAt(i) >= 48 &&  string.charAt(i) <= 57) return false;
        }
        return true;
    }
}
