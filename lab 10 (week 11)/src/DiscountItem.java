
/**
 * Discount an item using Decorator pattern.
 *
 * @author Kane Walter
 */
public class DiscountItem implements Item {
    private Item discountItem;
    private int discount;
    private String name;

    /**
     * Constructor for DiscountItem objects.
     *
     * @param name Name of discounted item.
     * @param item Discounted item.
     */
    public DiscountItem(String name, Item item, int discount) {
        this.discountItem = item;
        this.discount = discount;
        this.name = name;
    }

    /**
     * Get discounted price of part/assembly.
     *
     * @return Price of discounted item.
     */
    @Override
    public double getPrice() {
        return discountItem.getPrice() * discount / 100;
    }

    /**
     * Get details of discounted item.
     *
     * @return Details of discount part/assembly.
     */
    @Override
    public String toString() {
        return "    - " + name + " ($" + discountItem.getPrice() *
               discount / 100 + ")\n";
    }
}
