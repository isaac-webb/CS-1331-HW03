// I worked on the homework assignment alone, using only course materials.

/**
  *
  * Defines a Rack, which is a collection of Items. Racks deal with storing
  * items, adding and removing them, and keeping track of the number of Items.
  *
  * @author iwebb6
  */

public class Rack {
    // Defines the maximum number of Items a Rack can hold
    private static final int MAX_ITEMS = 10;

    private Item[] items;
    private int count;

    /**
      * Constructor that creates an empty Rack with space for 10 Items
      */
    public Rack() {
        // Initialize the rack with space for MAX_ITEMS items and nothing in it
        items = new Item[MAX_ITEMS];
        count = 0;
    }

    /**
      * Attempts to add the given Item to the Rack, returning true if there was
      * enough room and false if the Rack was full and the Item could not be
      * added.
      *
      * @param item The Item to be added to the Rack
      * @return Whether or not adding the Item was successful
      */
    public boolean add(Item item) {
        // Add in the item only if there is space in the rack
        if (count < MAX_ITEMS) {
            items[count++] = item;
            return true;
        }

        // If this statement is executed, then adding the item failed
        return false;
    }

    /**
      * Searches the Rack for an Item with the given name and removes it from
      * the Rack if it is found. If it is found, a reference to the Item is
      * returned and the Item is removed from the Rack. If it is not, then null
      * is returned.
      *
      * @param name The name of the Item to be removed
      * @return A reference to the removed Item, or null if the Item was not
      *         found
      */
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

    // Makes sure any Items in the array are in the lowest inidicies possible
    // for more efficient traversal of the array.
    private void closeGaps() {
        for (int i = 0; i < count && i < items.length - 1; i++) {
            // If the current index is empty, replace it with the contents of
            // the next and remove the next
            if (items[i] == null) {
                items[i] = items[i + 1];
                items[i + 1] = null;
            }
        }
    }

    /**
      * Getter for the Rack's Item array
      *
      * @return The Rack's array of Items
      */
    public Item[] getItems() {
        return items;
    }

    /**
      * Getter for the Rack's count property.
      *
      * @return The number of Items the Rack contains
      */
    public int getCount() {
        return count;
    }
}
