
/**
 * Individual part which can be combined to form an assembly.
 *
 * @author Kane Walter
 */
public class Part implements Item {
    private String name;
    private double price;

    /**
     * Constructor for Part objects.
     *
     * @param name  Name of the part.
     * @param price Price of the part.
     */
    public Part(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Get price of an individual part.
     *
     * @return Price of part.
     *
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Get the details of the part.
     *
     * @return Details of part.
     */
    @Override
    public String toString() {
        return "    - " + name + " ($" + price + ")\n";
    }
}
