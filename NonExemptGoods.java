import java.text.DecimalFormat;

/**
 * Created by chand on 7/24/2017.
 */
public class NonExemptGoods implements Items{
    DecimalFormat decimalFormat = new DecimalFormat("#.00");
    private final double TAX = 0.1;
    private final double IMPORTED = 0.05;
    private double tax, price;
    private int quanity;
    private String isImported, imported, name;

    public NonExemptGoods(double price, String name, int quanity, String isImported) {
        this.price = price;
        this.name = name;
        this.quanity = quanity;
        this.isImported = isImported;
    }
    @Override
    public double getTax() {
        if(isImported.equalsIgnoreCase("y")){
            tax = ((TAX + IMPORTED) * price);
        }
        else {
            tax = (TAX * price);
        }
        return tax * quanity;
    }
    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getSubTotal() {
        return getPrice() * getQuanity();
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
