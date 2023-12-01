public class InventoryItemFactory {
    public InventoryItem CreateItem(String type, String name, int quantity) {
        InventoryItem realItem;
        if (type.equalsIgnoreCase("product")) {
            realItem = new Product(name, quantity);
        } else if (type.equalsIgnoreCase("equipment")) {
            realItem = new Equipment(name, quantity);
        } else {
            System.out.println("Wrong item requested. Please recheck your spellings. Thank you!");
            return null;
        }

        // Create a proxy for the real item and return the proxy
        return new InventoryItemProxy(realItem);
    }
}
