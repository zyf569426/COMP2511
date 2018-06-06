
import java.util.ArrayList;
import java.util.List;

public class Bundle implements LineItem {
    List<LineItem> items;

    public Bundle() {
        items = new ArrayList<LineItem>();
    }

    public void add(LineItem item) {
        items.add(item);
    }

    @Override
    public double getPrice() {
        double price = 0;

        for (LineItem i : items)
            price += i.getPrice();

        return price;
    }

    @Override
    public String toString() {
        String description = "Bundle: ";
        for (int i = 0; i < items.size(); i++) {
            if (i > 0)
                description += ", ";
            description += items.get(i).toString();
        }

        return description;
    }
}
