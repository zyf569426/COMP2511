
public class DiscountedItem implements LineItem {
    private LineItem item;
    private double discount;

    public DiscountedItem(LineItem item, double discount) {
        this.item = item;
        this.discount = discount;
    }

    @Override
    public double getPrice() {
        return item.getPrice() * (1 - discount / 100);
    }

    @Override
    public String toString() {
        return item.toString() + "(Discount " + discount + "%)";
    }
}
