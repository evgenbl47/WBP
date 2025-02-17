import java.io.FileWriter;
import java.io.IOException;
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

    public void saveOrder(String filename) {
        try (FileWriter writer = new FileWriter(filename, true)) { // true для добавления в конец файла
            writer.write("Заказ от: " + customerName + "\n");
            writer.write("Адрес доставки: " + shippingAddress + "\n");
            writer.write("Дата заказа: " + orderDate + "\n");
            writer.write("Сумма заказа: " + totalAmount + " руб.\n");
            writer.write("Товары:\n");
            for (Product product : cart.getAllProducts()) {
                writer.write(product.getName() + " - " + product.getPrice() + " руб.\n");
            }
            writer.write("=========================\n");
            System.out.println("Заказ сохранен в файл.");
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении заказа: " + e.getMessage());
        }
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