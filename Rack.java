// I worked on the homework assignment alone, using only course materials.

/**
 *
 * This file defines the properties and functionality of Racks in our warehouse
 * program. Racks are essentially collections of items.
 *
 * @author iwebb6
 */

public class Rack {
    private Item[] items;
    private int count;

    public Rack() {
        // Initialize the rack with space for 10 items and nothing in it
        items = new Item[10];
        count = 0;
    }

    public boolean add(Item item) {
        // Add in the item only if there is space in the rack
        if (count < 10) {
            items[count++] = item;
            return true;
        }

        return false;
    }

    public Item remove(String name) {
        // Search the array only until the number of things in it
        for (int i = 0; i < count; i++) {
            if (items[i].getName().equals(name)) {
                // Extract and delete the item
                Item item = items[i];
                items[i] = null;
                count--;

                // Close gaps in the array to make insertion easier
                closeGaps();

                // Return the removed item
                return item;
            }
        }

        // Return null only if nothing is found
        return null;
    }

    private void closeGaps() {
        // Go through the array and move everything back one index if necessary
        for (int i = 0; i < count && i < items.length - 1; i++) {
            // If the current index is empty, replace it with the contents of
            // the next and remove the next
            if (items[i] == null) {
                items[i] = items[i + 1];
                items[i + 1] = null;
            }
        }
    }

    public Item[] getItems() {
        return items;
    }

    public int getCount() {
        return count;
    }
}
