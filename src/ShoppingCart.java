import java.util.LinkedList;
import java.util.HashMap;
import java.util.Scanner;

public class ShoppingCart {

    public static void buyProductsForCustomer(HashMap<Integer,Products> productsHashMap,Customers customers){
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> shoppingCart = new LinkedList<>();
        double price = 0 ;
        int exit = 0;
        int amountFromProduct;
        do {
            System.out.println("Cart shopping is:");
            System.out.println(productsHashMap.toString());
            System.out.println("Select the product number you are interested in, or enter the number -1 at the end of the purchase");
            int idProductForBuy = scanner.nextInt();
            if (idProductForBuy == -1) {
                System.out.println("BY");
                exit = 1;
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
                if(customers.isClubMembers()) price =price + (priceProduct * discountClubMember);
                else price = price + priceProduct;
                System.out.println("The price of your cart are:" + price);
                customers.setAmountOfPurchases();
                customers.setSumOfPurchases(price);
            } else {
                System.out.println("NOT EXIST PRODUCT WITH ID THIS");
                buyProductsForCustomer(productsHashMap, customers);
            }
        }while (exit == 0);
    }
    public static void buyProductsForWorker(HashMap<Integer,Products> productsHashMap,Workers worker){
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> shoppingCart = new  LinkedList<>();
        int amountFromProduct;
        int exit = 0;
        double price = 0;
        do{
        System.out.println("Cart shopping is:");
        System.out.println(productsHashMap.toString());
        System.out.println("Select the product number you are interested in, or enter the number -1 at the end of the purchase");
        int idProductForBuy = scanner.nextInt();
        if(idProductForBuy == -1){
            if(shoppingCart.isEmpty()) System.out.println("BY");
            else {
                if(worker.getTypeWorker() == TypeWorker.REGULAR_WORKER) price *= 0.90;
                else if (worker.getTypeWorker() == TypeWorker.DIRECTOR) price *= 0.80;
                else price *= 0.70;
                System.out.println("The final price of your cart are:" + price );
                worker.setAmountOfPurchases();
            }
            exit = 1;
        }else if(productsHashMap.containsKey(idProductForBuy)){
            do {
                System.out.println("Enter the amount you want from this product");
                amountFromProduct = scanner.nextInt();
            } while (productsHashMap.get(idProductForBuy).getAmountProduct() < amountFromProduct);
            productsHashMap.get(idProductForBuy).setAmountProduct(-amountFromProduct);
            double priceProduct = productsHashMap.get(idProductForBuy).getPrice() * amountFromProduct;
            double discountClubMember =0.01 * (100 - productsHashMap.get(idProductForBuy).getDiscountPercentage()) ;
            if(worker.isClubMembers()) priceProduct = priceProduct * discountClubMember;
            price = price + priceProduct;
            System.out.println("The products in your cart are:");
            shoppingCart.add(productsHashMap.get(idProductForBuy).getName() + " amount is = " + amountFromProduct);
            for(int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(i+1 + " : " + shoppingCart.get(i));
            }
            System.out.println("The price of your cart is (without employee discount, employee discount will be made at the end of the purchase)" + price );
        }else {
            System.out.println("NOT EXIST PRODUCT WITH ID THIS");
        }
    }while (exit == 0);

    }
}
