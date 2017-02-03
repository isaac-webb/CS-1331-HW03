// I worked on the homework assignment alone, using only course materials.

/**
 *
 * This file defines the properties and functionality of an Item in our
 * warehouse program.
 *
 * @author iwebb6
 */

public class Item {
    private String name;
    private double price;
    private int rating;

    public Item(String itemName, double itemPrice, int itemRating) {
        // Assign the first two parameters to local variables
        name = itemName;
        price = itemPrice;

        // Assign the rating, making sure it is a valid value
        if (itemRating < 1) {
            rating = 1;
        } else if (itemRating > 5) {
            rating = 5;
        } else {
            rating = itemRating;
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }
}
