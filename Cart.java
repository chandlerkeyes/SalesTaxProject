import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by chand on 7/25/2017.
 */
public class Cart {
    ArrayList<Items> itemList = new ArrayList<Items>();
    DecimalFormat decimalFormat = new DecimalFormat("#.00");

    public void addToCart(Items userInput){
      itemList.add(userInput);
    }
    public void displayList() {
        for(Items i : itemList){
            System.out.println(i);
        }
    }

    public double getSubtotal(){
        double subtotal = 0;
        for(Items i : itemList){
            subtotal = subtotal + i.getSubTotal();
        }
        return subtotal;
    }
    public double getSalesTaxes(){
        double taxes = 0;
        for(Items i : itemList) {
            taxes = taxes + i.getTax();
        }
        return taxes;
    }
    public double total(){
        double total = getSalesTaxes() + getSubtotal();
        return total;
    }

    @Override
    public String toString() {
        return "Subtotal = " + decimalFormat.format(getSubtotal()) + "\n"
        + "Sales Tax = " + decimalFormat.format(getSalesTaxes()) + "\n"
        + "Total = " + decimalFormat.format(total());
    }
}
