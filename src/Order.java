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

/*
    cart: Ссылка на корзину, из которой формируется заказ.
    customerName: Имя клиента.
    shippingAddress: Адрес доставки.
    orderDate: Дата и время создания заказа (используем java.util.Date).
    totalAmount: Общая сумма заказа (получается из корзины).
    Конструктор: Принимает корзину, имя и адрес, устанавливает дату и сумму.
    displayOrderDetails(): Выводит информацию о заказе в консоль.
 */