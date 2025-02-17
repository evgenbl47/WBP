import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Создаем экземпляр DataStorage
        DataStorage dataStorage = new DataStorage();

        // Загружаем каталог товаров
        ProductCatalog catalog = dataStorage.loadCatalog();

        // Если каталог пустой, создаем новый и заполняем его
        if (catalog.getAllProducts().isEmpty()) {
            System.out.println("Каталог товаров не найден. Создаем новый каталог.");
            catalog = createDefaultCatalog();
        }

        // Создаем корзину
        Cart cart = new Cart();

        // Создаем Scanner для ввода пользователя
        Scanner scanner = new Scanner(System.in);

        // Главный цикл программы
        while (true) {
            displayMenu();
            System.out.print("Выберите действие: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    showCatalog(catalog);
                    break;
                case "2":
                    addProductToCart(catalog, cart, scanner);
                    break;
                case "3":
                    removeProductFromCart(cart, scanner);
                    break;
                case "4":
                    viewCart(cart);
                    break;
                case "5":
                    checkout(cart, scanner);
                    break;
                case "0":
                    // Сохраняем каталог перед выходом
                    dataStorage.saveCatalog(catalog);
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }

    // Метод для создания каталога по умолчанию
    private static ProductCatalog createDefaultCatalog() {
        ProductCatalog catalog = new ProductCatalog();
        Product shirt = new Product("Футболка", 1500.0, 4.8);
        Product jeans = new Product("Джинсы", 3500.0, 4.5);
        Product hat = new Product("Кепка", 800.0, 4.2);
        catalog.addProduct(shirt);
        catalog.addProduct(jeans);
        catalog.addProduct(hat);
        return catalog;
    }

    // Метод для отображения меню
    private static void displayMenu() {
        System.out.println("\n===== Wildberries (Консоль) =====");
        System.out.println("1. Показать каталог товаров");
        System.out.println("2. Добавить товар в корзину");
        System.out.println("3. Удалить товар из корзины");
        System.out.println("4. Показать корзину");
        System.out.println("5. Оформить заказ");
        System.out.println("0. Выход");
        System.out.println("==================================");
    }

    // Метод для отображения каталога
    private static void showCatalog(ProductCatalog catalog) {
        System.out.println("\n===== Каталог товаров =====");
        for (Product product : catalog.getAllProducts()) {
            System.out.println(product.getName() + " - " + product.getPrice() + " руб.");
        }
        System.out.println("==========================");
    }

    // Метод для добавления товара в корзину
    private static void addProductToCart(ProductCatalog catalog, Cart cart, Scanner scanner) {
        System.out.print("Введите название товара для добавления в корзину: ");
        String productName = scanner.nextLine();
        Product product = catalog.findProductByName(productName);
        if (product != null) {
            cart.addProduct(product);
        } else {
            System.out.println("Товар не найден в каталоге.");
        }
    }

    // Метод для удаления товара из корзины
    private static void removeProductFromCart(Cart cart, Scanner scanner) {
        System.out.print("Введите название товара для удаления из корзины: ");
        String productName = scanner.nextLine();
        cart.removeProduct(productName);
    }

    // Метод для просмотра корзины
    private static void viewCart(Cart cart) {
        cart.showCart();
    }

    // Метод для оформления заказа
    private static void checkout(Cart cart, Scanner scanner) {
        System.out.print("Введите ваше имя: ");
        String customerName = scanner.nextLine();
        System.out.print("Введите адрес доставки: ");
        String shippingAddress = scanner.nextLine();

        Order order = new Order(cart, customerName, shippingAddress);
        order.displayOrderDetails();
        order.saveOrder("orders.txt");

        // Очищаем корзину после оформления заказа
        cart = new Cart();
    }
}