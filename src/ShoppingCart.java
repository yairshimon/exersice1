import java.util.HashMap;
import java.util.Scanner;

public class ShoppingCart {
    public static void buyProducts(HashMap<Integer,Products> productsHashMap){
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
            System.out.println("The price of your cart are:" + productsHashMap.get(idProductForBuy).getPrice() * amountFromProduct);
            buyProducts(productsHashMap);
        }else {
            System.out.println("NOT EXIST PRODUCT WITH ID THIS");
        }
    }
}
