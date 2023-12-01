public class Main {
    public static void main(String[] args) {

        // Create a mediator for employee communication
        InventoryCommunicationMediator mediator = new InventoryCommunicationMediator();

        // Create inventory item factory
        InventoryItemFactory factory = new InventoryItemFactory();

        // Create inventory items using the factory
        InventoryItem product = factory.CreateItem("product", "Lays", 20);
        InventoryItem equipment = factory.CreateItem("equipment", "Chips maker", 5);

        // Create employees and associate them with the mediator
        Employee employee1 = new InventoryEmployee("Abubakr", mediator);
        Employee employee2 = new InventoryEmployee("Devashree", mediator);
        Employee manager = new InventoryEmployee("Atharva", mediator);

        // Create an inventory and add employees to it
        Inventory inventory = new Inventory(mediator);
        inventory.addEmployee("Employee 1");
        inventory.addEmployee("Employee 2");
        inventory.addEmployee("Manager");

        // Create an observer for low inventory
        InventoryObserver lowInventoryObserver = new InventoryObserver() {
            @Override
            public void update(InventoryItem item) {
                if (item.getQuantity() < 10) {
                    System.out.println("Low inventory for item: " + item.getName());
                }
            }
        };

        // Add the low inventory observer to the inventory
        inventory.addObserver(lowInventoryObserver);

        // Update inventory items and notify observers
        InventoryUpdateCommand updateCommand = new InventoryUpdateCommand(product, -20);
        updateCommand.execute();
        inventory.notifyObservers(product);

        updateCommand = new InventoryUpdateCommand(equipment, -15);
        updateCommand.execute();
        inventory.notifyObservers(equipment);

        // Simulate employee communication
        employee1.sendMessage("Hey, we need to restock Lays.");
        employee2.sendMessage("I'll check the inventory for Chips maker.");
        manager.sendMessage("Make sure to update the inventory records.");
    }
}
