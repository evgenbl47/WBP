import java.util.List;
import java.util.Scanner;

public class CatalogManager {
    private ProductCatalog catalog = new ProductCatalog();
    private Cart cart = new Cart();

    public void loadCatalog() {
        DataStorage dataStorage = new DataStorage();
        catalog = dataStorage.loadCatalog();

        if (catalog.getAllProducts().isEmpty()) {
            System.out.println("Catalog not found. Creating new Catalog");
            createDefaultCatalog();
        }
    }

    private void createDefaultCatalog() {
        Product shirt = new Product("Футболка", 1500.0, 4.8);
        Product jeans = new Product("Джинсы", 3500.0, 4.5);
        Product hat = new Product("Кепка", 800.0, 4.2);
        catalog.addProduct(shirt);
        catalog.addProduct(jeans);
        catalog.addProduct(hat);
    }

    public void showCatalog() {
        System.out.println("\n===== Каталог товаров =====");
        List<Product> products = catalog.getAllProducts();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println((i + 1) + ". " + product.getName() + " - " +
                    product.getPrice() + " .rub (Raiting: " + product.getRating() + ")");
        }
        System.out.println("==========================");
    }

    public void addProductToCart(Scanner scanner) {
        System.out.println("Enter product number for to add product to cart: ");
        String productNumberStr = scanner.nextLine();
        try {
            int productNumber = Integer.parseInt(productNumberStr);
            if (productNumber > 0 && productNumber <= catalog.getAllProducts().size()) {
                Product product = catalog.getAllProducts().get(productNumber - 1);
                cart.addProduct(product);
            } else {
                System.out.println("Wrong number of product");
            }
        } catch (NumberFormatException e) {
            System.out.println("Wrong format of product name.");
        }
    }

    public void removeProductFromCart(Scanner scanner) {
        System.out.println("Enter product name for remove from cart: ");
        String productName = scanner.nextLine();
        cart.removeProduct(productName);
    }

    public void viewCart() {
        cart.showCart();
    }

    public void checkOut(Scanner scanner) {
        System.out.println("Enter your name: ");
        String customerName = scanner.nextLine();
        System.out.println("Enter shipping address: ");
        String shippingAdress = scanner.nextLine();

        Order order = new Order(cart, customerName, shippingAdress);
        order.displayOrderDetails();
        order.saveOrder("orders.txt");

        cart = new Cart();
    }
}






