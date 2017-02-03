// I worked on the homework assignment alone, using only course materials.

import java.util.Random;

/**
 *
 * This file defines the properties and functionality of the Warehouse in our
 * warehouse program. Warehouses are essentially collections of Racks and are
 * responsible for the higher level management of items, orders, and item value.
 *
 * @author iwebb6
 */

public class Warehouse {
    private Rack[][] racks;

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

        return null;
    }

    public boolean store(Item item) {
        // Create the random number generator used to pick the rack
        Random rand = new Random();

        // Generate the indicies for a random Rack
        int row = rand.nextInt(racks.length);
        int col = rand.nextInt(racks[row].length);

        return racks[row][col].add(item);
    }

    public double totalAssets() {
        double total = 0.0;

        // Go through each rack and sum all of the items' prices
        for (Rack[] rackArr : racks) {
            for (Rack rack : rackArr) {
                Item[] items = rack.getItems();
                for (int i = 0; i < rack.getCount(); i++) {
                    total += items[i].getPrice();
                }
            }
        }

        return total;
    }
}
