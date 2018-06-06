/**
 * Item on an invoice.
 */
public interface LineItem {
    double getPrice();
    @Override
    String toString();
}
