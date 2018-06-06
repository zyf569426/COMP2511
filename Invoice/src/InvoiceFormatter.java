
public interface InvoiceFormatter {
    String formatHeader();
    String formatLineItem(LineItem item);
    String formatFooter();
}
