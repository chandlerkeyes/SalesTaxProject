import java.util.Scanner;

/**
 * Created by chand on 7/24/2017.
 */
public class SalesTaxReciept {

    public static void main(String[] args) {
        Cart cart = new Cart();
        Scanner keyboard = new Scanner(System.in);
        int quantity;
        double price;
        String name, isExempt, isImported, yOrN;
        do {
            quantity = Validator.getInt(keyboard,"Enter Quantity: ", 1, 100 );
            price = Validator.getDouble(keyboard,"Enter Price: ", 0, Double.MAX_VALUE);
            System.out.println("Enter Product Name: ");
            name = keyboard.nextLine();
            System.out.println("Is the product exempt: food, book, or medical (y/n): ");
            isExempt = keyboard.nextLine();
            Validator.yOrNValid(isExempt);
            System.out.println("Is the product imported? (y/n): ");
            isImported = keyboard.nextLine();
            Validator.yOrNValid(isImported);

            Items item = null;
            if (isExempt.equalsIgnoreCase("y")) {
                item = new ExemptGoods(price, name, quantity, isImported);

            } else if (isExempt.equalsIgnoreCase("n")) {
                item = new NonExemptGoods(price, name, quantity, isImported);
            }
            cart.addToCart(item);
            System.out.println("Add another item? (y/n)");
            yOrN = keyboard.nextLine();
            yOrN = Validator.yOrNValid(yOrN);
        }while(yOrN.equalsIgnoreCase("y"));
        cart.displayList();
        System.out.println(cart);
        System.out.println("\n Thanks for shopping with us!");
    }
}


