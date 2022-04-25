import java.util.HashMap;
import java.util.Scanner;

public class ShoppingCart {

    public static void buyProductsForCustomer(HashMap<Integer,Products> productsHashMap,Customers customers){
        Scanner scanner = new Scanner(System.in);
        int amountFromProduct;
        System.out.println("Cart shopping is:");
        System.out.println(productsHashMap.toString());
        System.out.println("Select the product number you are interested in, or enter the number -1 at the end of the purchase");
        int idProductForBuy = scanner.nextInt();
        if(idProductForBuy == -1){
            System.out.println("BY");
        }else if(productsHashMap.containsKey(idProductForBuy)){
            do {
                System.out.println("Enter the amount you want from this product");
                amountFromProduct = scanner.nextInt();
            } while (amountFromProduct < 0);
            System.out.println("The contents of your cart are:");
            System.out.println(productsHashMap.get(idProductForBuy).getName() + " amount is = " + amountFromProduct);
            double discount =0.01 * (100 - productsHashMap.get(idProductForBuy).getDiscountPercentage()) ;
            double price = productsHashMap.get(idProductForBuy).getPrice() * amountFromProduct;
            if(customers.isClubMembers()){
                System.out.println("The price of your cart are:" + price * discount );
                customers.setSumOfPurchases(price * discount);

            } else  {
                System.out.println("The price of your cart are:" + price);
                customers.setSumOfPurchases(price);
            }
            customers.setAmountOfPurchases();
            buyProductsForCustomer(productsHashMap,customers);
        }else {
            System.out.println("NOT EXIST PRODUCT WITH ID THIS");
        }
    }
    public static void buyProductsForWorker(HashMap<Integer,Products> productsHashMap,TypeWorker typeWorker){
        Scanner scanner = new Scanner(System.in);
        int amountFromProduct;
        System.out.println("Cart shopping is:");
        System.out.println(productsHashMap.toString());
        System.out.println("Select the product number you are interested in, or enter the number -1 at the end of the purchase");
        int idProductForBuy = scanner.nextInt();
        if(idProductForBuy == -1){
            System.out.println("BY");
        }else if(productsHashMap.containsKey(idProductForBuy)){
            do {
                System.out.println("Enter the amount you want from this product");
                amountFromProduct = scanner.nextInt();
            } while (amountFromProduct < 0);
            System.out.println("The contents of your cart are:");
            System.out.println(productsHashMap.get(idProductForBuy).getName() + " amount is = " + amountFromProduct);
            double discount =0.01 * (100 - productsHashMap.get(idProductForBuy).getDiscountPercentage()) ;
            if(typeWorker == TypeWorker.REGULAR_WORKER) System.out.println("The price of your cart are:" + productsHashMap.get(idProductForBuy).getPrice() * amountFromProduct * discount * 0.90 );
            else if (typeWorker == TypeWorker.DIRECTOR) System.out.println("The price of your cart are:" + productsHashMap.get(idProductForBuy) .getPrice() * amountFromProduct * discount * 0.80);
            else System.out.println("The price of your cart are:" + productsHashMap.get(idProductForBuy) .getPrice() * amountFromProduct * discount * 0.70);
            buyProductsForWorker(productsHashMap,typeWorker);
        }else {
            System.out.println("NOT EXIST PRODUCT WITH ID THIS");
        }
    }
}
