import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shop shop = new Shop();
        int userChoice;

        boolean exitFromSystem = true;
        do {
            System.out.println("1 - Create a new account\n" +
                    "2 - Login to an existing account\n" +
                    "3 - Exit");
            userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1:
                    shop.createUser();
                    break;
                case 2:
                    System.out.println("Do you want to create an employee or customer account? for customer press 0 for employee press 1");
                    int choice = scanner.nextInt();
                    if (choice == 0) shop.loginCustomers();
                    else shop.loginWorkers();
                    break;
                case 3:
                    exitFromSystem = false;
                    break;
                default:
                    System.out.println("Enter number between 1-3");
                    break;
            }
        }while (exitFromSystem);
    }

}
