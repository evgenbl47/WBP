public class Main {
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();

        Product shirt = new Product("Shirt", 1500.0, 4.8);
        Product jeans = new Product("Jeans", 3500.0, 4.5);
        Product socks = new Product("Socks", 13500.0, 0.5);

        catalog.addProduct(shirt);
        catalog.addProduct(jeans);
        catalog.addProduct(socks);

        Cart cart = new Cart();

        Product foundShirt = catalog.findProductByName("Shirt");
        if (foundShirt != null) {
            cart.addProduct(foundShirt);
        }

        Product foundJeans = catalog.findProductByName("Jeans");
        if (foundJeans != null) {
            cart.addProduct(foundJeans);
        }

        Product foundSocks = catalog.findProductByName("Socks");
        if (foundSocks != null) {
            cart.addProduct(foundSocks);
        }

        cart.showCart();
        cart.removeProduct("Socks");
        cart.showCart();

        Order order = new Order(cart, "Tom Smith", "US, New-York");
        order.displayOrderDetails();
    }
}

/*
    Класс Product: Определяет товары.
    Класс Cart: Управляет корзиной покупок, позволяя добавлять и удалять товары.
    Класс ProductCatalog: Хранит ассортимент товаров и дает возможность их добавлять, удалять и искать.
 */