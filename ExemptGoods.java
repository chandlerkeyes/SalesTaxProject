import java.text.DecimalFormat;

/**
 * Created by chand on 7/24/2017.
 */
public class ExemptGoods implements Items {
    DecimalFormat decimalFormat = new DecimalFormat("#.00");
    private final double TAX = 0;
    private final double IMPORTED = 0.05;
    private double price, tax;
    private int quanity;
    private String isImported, imported, name;

    public ExemptGoods(double price, String name, int quanity, String isImported) {
        this.price = price;
        this.name = name;
        this.quanity = quanity;
        this.isImported = isImported;
    }
    @Override
    public double getPrice() {
        return price * quanity;
    }

    @Override
    public double getSubTotal() {
        return getPrice() * getQuanity();
    }


    @Override
    public double getTax() {
        if(isImported.equalsIgnoreCase("y")){
            tax = (IMPORTED * price);
        }
        else {
            tax = TAX;
        }
        return tax * quanity;
    }

    public String getName() {
        return name;
    }

    public int getQuanity() {
        return quanity;
    }

    public String getImported() {
        if (isImported.equalsIgnoreCase("y")) {
            this.imported = "Imported";
        }
        else {
            this.imported = "";
        }
        return imported;
    }


    @Override
    public String toString() {
        return getQuanity() + " " + getImported() + " " +  getName() + " "
                + decimalFormat.format(getPrice());
    }
}
