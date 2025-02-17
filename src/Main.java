//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!\n");

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