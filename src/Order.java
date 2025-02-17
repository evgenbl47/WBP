import java.util.Date;

public class Order {
    private Cart cart;
    private String customerName;
    private String shippingAddress;
    private Date orderDate;
    private double totalAmount;

    public Order(Cart cart, String customerName, String shippingAddress) {
        this.cart = cart;
        this.customerName = customerName;
        this.shippingAddress = shippingAddress;
        this.orderDate = new Date();
        this.totalAmount = cart.getTotal();
    }

    public void displayOrderDetails() {
        System.out.println("\n===== Order details =====");
        System.out.println("Client name: " + customerName);
        System.out.println("Shipping adders: " + shippingAddress);
        System.out.println("Order date: " + orderDate);
        System.out.println("Total price: " + totalAmount + " руб.");
        cart.showCart(); // Показываем товары в заказе
        System.out.println("=========================");
    }
}
