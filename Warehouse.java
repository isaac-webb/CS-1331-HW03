// I worked on the homework assignment alone, using only course materials.

import java.util.Random;

/**
  *
  * Defines the Warehouse, which is essentially a collection of Racks and is
  * responsible for the higher level management of items, orders, and item
  * value. It primarily interacts with Racks, which handle most of the adding
  * and removing of Items.
  *
  * @author iwebb6
  */

public class Warehouse {
    private Rack[][] racks;

    /**
      * Constructor for a Warehouse which creates a 2-D array of Racks with the
      * given number of rows. Each row is then populated with 5-10 (inclusive)
      * empty Racks at random.
      *
      * @param rows The number of rows desired in this Warehouse's Rack array
      */
    public Warehouse(int rows) {
        // Create the empty 2-D array
        racks = new Rack[rows][];

        // Create a random number generator to initialize each row
        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            racks[i] = new Rack[rand.nextInt(6) + 5];

            // Insert Racks into the empty slots
            for (int j = 0; j < racks[i].length; j++) {
                racks[i][j] = new Rack();
            }
        }
    }

    /**
      * Orders an Item with the given name from this Warehouse. If the Item is
      * found, it is removed from the Rack it was found in and a reference to it
      * is returned. Otherwise, null is returned.
      *
      * @param name The name of the Item being ordered
      * @return A reference to the ordered Item, or null if it was not found
      */
    public Item order(String name) {
        // Search each rack for an Item with the given name
        for (Rack[] rackArr : racks) {
            for (Rack rack : rackArr) {
                // Attempt to remove the item, returning only if it was found
                Item removed = rack.remove(name);
                if (removed != null) {
                    return removed;
                }
            }
        }

        // Return null if the Item was not found in any Rack
        return null;
    }

    /**
      * Stores the given Item in the Warehouse. The Rack it will go in is chosen
      * at random. If the Item is stored successfully, true is returned. If the
      * chosen Rack is full, false is returned.
      *
      * @param item The Item to be stored in the Warehouse
      * @return True if the Item was stored successfully, false otherwise
      */
    public boolean store(Item item) {
        // Create the random number generator used to pick the rack
        Random rand = new Random();

        // Generate the indicies for a random Rack
        int row = rand.nextInt(racks.length);
        int col = rand.nextInt(racks[row].length);

        // Attempt to add the Item and return the result
        return racks[row][col].add(item);
    }

    /**
      * Returns the total value of all Items stored in the Warehouse. This is
      * done by going through each Rack and summing the price of all contained
      * Items.
      *
      * @return The value of all Items in the Warehouse
      */
    public double totalAssets() {
        double total = 0.0;

        // Go through each rack and add the price of each Item to the total
        for (Rack[] rackArr : racks) {
            for (Rack rack : rackArr) {
                Item[] items = rack.getItems();
                for (int i = 0; i < rack.count(); i++) {
                    total += items[i].getPrice();
                }
            }
        }

        // Return the sum of all of the prices
        return total;
    }
}
