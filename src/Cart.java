import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getName() + " add to cart");
    }

    public void removeProduct(Product product) {
        if (products.contains(product)) {
            products.remove(product);
            System.out.println(product.getName() + " remove from cart.");
        } else {
            System.out.println("Item: " + product.getName() + " not found in cart.");
        }
    }

    public void removeProduct(String productName) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(productName)) {
                products.remove(i);
                System.out.println(productName + " remove from cart.");
                return;
            }
        }
        System.out.println("Item: " + productName + " not found in cart.");
    }

    public double getTotal() {
        /*
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
         */

                // 1. Создаём поток из списка продуктов
        return products.stream()
                // 2. Преобразуем каждый товар в его цену
                .mapToDouble(Product::getPrice)
                // 3. Суммируем все полученные значения
                .sum();
    }

    public void showCart() {
        System.out.println("\nShopping cart contents:");
        for (Product p : products) {
            System.out.println(p.getName() + " - " + p.getPrice() + " rub.");
        }
        System.out.println("Итого: " + getTotal() + " руб.\n");
    }
}
