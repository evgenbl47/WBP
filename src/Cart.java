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

    public List<Product> getAllProducts() {
        return new ArrayList<>(products); // Возвращаем копию списка
    }
}




/*
    Передаём productName: Метод принимает название товара, который нужно удалить.
    Цикл for с индексом: Перебираем элементы списка, чтобы найти нужный товар.
    products.get(i).getName().equals(productName): Сравниваем название товара в списке с переданным названием. equals() — это правильный способ сравнивать строки в Java.
    products.remove(i): Удаляем товар из списка по индексу
    return: После удаления товара выходим из метода. Это важно, чтобы удалить только первое совпадение, если в корзине несколько одинаковых товаров.
    Сообщение "не найден": Если цикл завершился, и товар не был найден, выводим сообщение об этом.
 */