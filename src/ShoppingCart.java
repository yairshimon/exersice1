import java.util.LinkedList;
import java.util.HashMap;
import java.util.Scanner;

public class ShoppingCart {

    public static double buyProductsForUser(HashMap<Integer, Products> productsHashMap, Customers customers) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> shoppingCart = new LinkedList<>();
        double price = 0;
        int amountFromProduct;
        boolean exit = true;
        String date;
        do {
            System.out.println("Enter date");
            date = scanner.next();
            System.out.println("Cart shopping is:");
            System.out.println(productsHashMap.toString());
            System.out.println("Select the product number you are interested in, or enter the number -1 at the end of the purchase");
            int idProductForBuy = scanner.nextInt();
            if (idProductForBuy == -1) {
                exit = false;
            } else if (productsHashMap.containsKey(idProductForBuy)) {
                do {
                    System.out.println("Enter the amount you want from this product");
                    amountFromProduct = scanner.nextInt();
                } while (productsHashMap.get(idProductForBuy).getAmountProduct() < amountFromProduct);
                productsHashMap.get(idProductForBuy).setAmountProduct(-amountFromProduct);
                System.out.println("The products in your cart are:");
                shoppingCart.add(productsHashMap.get(idProductForBuy).getName() + " amount is = " + amountFromProduct);
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(i + 1 + " : " + shoppingCart.get(i));
                }
                double discountClubMember = 0.01 * (100 - productsHashMap.get(idProductForBuy).getDiscountPercentage());
                double priceProduct = productsHashMap.get(idProductForBuy).getPrice() * amountFromProduct;
                if (customers.isClubMembers()) price = price + (priceProduct * discountClubMember);
                else price = price + priceProduct;
                System.out.println("The price of your cart are:" + price);
                customers.setAmountOfPurchases();
                customers.setLastPurchaseDate(date);
            } else {
                System.out.println("NOT EXIST PRODUCT WITH ID THIS");
            }
        } while (exit);
        return price;
    }
}