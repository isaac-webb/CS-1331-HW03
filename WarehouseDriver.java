import java.util.Scanner;

public class WarehouseDriver {
    private static Scanner scan = new Scanner(System.in);

    /*======= You may want to play around with these values ================= */
    private static String[] itemNames = {"apple", "eggs", "shirt", "tv",
                                         "chair", "bottle", "speaker", "camera",
                                         "tissues", "soap", "chocolate",
                                         "basketball"};

    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse(4);
        double basePrice = 4.00;
        for (int i = 0; i < itemNames.length; i++) {
            Item item;
            if (i % 4 == 3) {
                item = new Item(itemNames[i], basePrice * 2.5, 2);
            } else if (i % 6 == 0) {
                item = new Item(itemNames[i], basePrice * 4, 5);
            } else {
                item = new Item(itemNames[i], basePrice, 3);
            }
            warehouse.store(item);
        }
    /* ====================================================================== */

        System.out.println("Welcome to your Warehouse!\n"
                + "What would you like to do?\n");
        boolean run = true;
        while (run) {
            System.out.println("What would you like to do?\n");

            System.out.println(
                      "1. Store an item\n"
                    + "2. Order an item\n"
                    + "3. View the total value of your inventory\n"
                    + "4. Quit\n");

            int reply = scan.nextInt();
            scan.nextLine();

            switch (reply) {
            case 1:
                System.out.println("What is the name of the item that "
                        + "you would like to store?");
                String name = scan.nextLine();
                System.out.println("What is the price of the item that "
                        + "you would like to store?");
                double price = scan.nextDouble();
                scan.nextLine();
                System.out.println("What is the rating of the item that "
                        + "you would like to store?");
                int rating = scan.nextInt();
                scan.nextLine();

                Item item = new Item(name, price, rating);
                if (warehouse.store(item)) {
                    System.out.println("\nCongrats! You successfully stored a "
                            + name);
                } else {
                    System.out.println("\nSorry, this rack is full."
                            + " Please try another rack");
                }
                break;

            case 2:
                System.out.println("\nWhat is the name of the item that"
                        + " you would you like to order?");
                String orderName = scan.nextLine();

                Item orderItem = warehouse.order(orderName);
                if (orderItem != null) {
                    System.out.printf("\nYou just bought %s at a price of $%.2f"
                            + "\nThis item has a rating of %d\n",
                            orderItem.getName(),
                            orderItem.getPrice(),
                            orderItem.getRating());
                } else {
                    System.out.println("Sorry, we do not carry that item.");
                }

                break;

            case 3:
                System.out.printf("Your inventory is valued at: $%.2f\n\n",
                        warehouse.totalAssets());
                break;

            case 4:
            default:
                run = false;
                break;
            }
        }

    }
}