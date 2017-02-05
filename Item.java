// I worked on the homework assignment alone, using only course materials.

/**
  *
  * Defines an Item, more specifically an inventory item. Each item has a name,
  * price, and rating associated with it.
  *
  * @author iwebb6
  */

public class Item {
    private String name;
    private double price;
    private int rating;

    /**
      * Constructor that defines the Item's name, price, and rating. Names
      * should not be empty and prices should be nonnegative. Ratings are capped
      * at a maximum of 5 and a minimum of 1.
      *
      * @param itemName The name of the Item
      * @param itemPrice The price of the Item
      * @param itemRating The rating of the Item
      */
    public Item(String itemName, double itemPrice, int itemRating) {
        // Assign the first two parameters to local variables
        name = itemName;
        price = itemPrice;

        // Assign the rating, making sure it is a valid value and capping it if
        // necessary
        if (itemRating < 1) {
            rating = 1;
        } else if (itemRating > 5) {
            rating = 5;
        } else {
            rating = itemRating;
        }
    }

    /**
      * Getter for the Item's name property
      *
      * @return The Item's name
      */
    public String getName() {
        return name;
    }

    /**
      * Getter for the Item's price property
      *
      * @return The Item's price
      */
    public double getPrice() {
        return price;
    }

    /**
      * Getter for the Item's rating property
      *
      * @return The Item's rating
      */
    public int getRating() {
        return rating;
    }
}
