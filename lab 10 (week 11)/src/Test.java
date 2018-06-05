
/**
 * COMP2511 Lab 10 (Week 11)
 *
 * Test class for the composite pattern.
 *
 * @author Kane Walter
 *
 */
public class Test {
    public static void main(String[] args) {
        // Make some car parts
        Item one = new Part("wheell", 25);
        Item two = new Part("window", 100);
        Item three = new Part("door", 10);
        Item four = new Part("engine", 250);

        // Test toString() method by printing part details
        System.out.print(one.toString());
        System.out.print(two.toString());
        System.out.print(three.toString());
        System.out.print(four.toString());

        // Test Decorator pattern code by applying a discount to a
        // wheel
        Item five = new DiscountItem("Discount wheel", one, 10);
        System.out.println(five.toString());

        // Create an assembly
        Assembly ass = new Assembly("car");
        System.out.println("");

        // Test Composite pattern by adding parts to it (including a
        // discounted wheel)
        ass.addPart(one);
        ass.addPart(two);
        ass.addPart(three);
        ass.addPart(five);
        ass.addPart(four);

        // Print final result
        System.out.println(ass.toString());
        System.out.println("Total price: $" + ass.getPrice());
    }
}
