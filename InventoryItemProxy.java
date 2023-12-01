public class InventoryItemProxy implements InventoryItem {
    private InventoryItem realItem;

    public InventoryItemProxy(InventoryItem realItem) {
        this.realItem = realItem;
    }

    @Override
    public String getName() {
        return realItem.getName();
    }

    @Override
    public int getQuantity() {
        return realItem.getQuantity();
    }

    @Override
    public void updateQuantity(int quantity) {
        realItem.updateQuantity(quantity);
    }
}
