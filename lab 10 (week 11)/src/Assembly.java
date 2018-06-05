import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a multi-part component.
 *
 * @author Kane Walter
 */
public class Assembly implements Item {
    private List<Item> assembly;
    private String name;

    /**
     * Constructor for multi-part assembly items.
     *
     * @param name Name of the assembly.
     */
    public Assembly(String name) {
        this.assembly = new ArrayList<Item>();
        this.name = name;
    }

    /**
     * Add a part to an assembly.
     *
     * @param part Part to add to assembly.
     */
    public void addPart(Item part) {
        if (!assembly.contains(part))
            assembly.add(part);
    }

    /**
     * Get price of a multi-part assembly.
     *
     * @return Price of assembly.
     */
    @Override
    public double getPrice() {
        double price = 0;

        for (Item i : assembly)
            price += i.getPrice();

        return price;
    }

    /**
     * Get details of assembled component.
     *
     * @return Details of each part in assembly.
     */
    @Override
    public String toString() {
        String tmp = "Product: " + name + "\n";
        for (Item i : assembly)
            tmp += i.toString();

        return tmp;
    }
}
