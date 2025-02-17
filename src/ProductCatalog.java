import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getName() + " add to catalog.");
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products); // Возвращаем копию списка
    }

    public void removeProduct(String productName) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(productName)) {
                products.remove(i);
                System.out.println(productName + " removed from catalog.");
                return;
            }
        }
        System.out.println("Item " + productName + " not found in catalog");
    }

    public Product findProductByName(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

}


/*
    products: Список товаров в каталоге.
    addProduct(): Добавляет товар в каталог.
    removeProduct(): Удаляет товар из каталога по имени.
    getAllProducts(): Возвращает копию списка товаров. Это важно, чтобы внешний код не мог случайно изменить наш каталог.
    findProductByName(): Ищет товар по имени и возвращает его. Если товар не найден, возвращает null.
 */