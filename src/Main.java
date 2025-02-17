//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!\n");
        System.out.println("\n");
        System.out.println();

        Product shirt = new Product("Shirt", 1500.0, 4.8);
        Product jeans = new Product("Jeans", 3500.0, 4.5);
        Product socks = new Product("Socks", 13500.0, 0.5);

        Cart cart = new Cart();
        cart.addProduct(shirt);
        cart.addProduct(jeans);
        cart.addProduct(socks);

        cart.showCart();

        cart.removeProduct(socks);
        cart.removeProduct("Shirt");
        cart.removeProduct("T-Shirt");
        cart.showCart();
    }
}