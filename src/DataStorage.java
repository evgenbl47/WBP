import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataStorage {

    private static final String CATALOG_FILE = "catalog.txt";

    // Сохранение каталога товаров в файл
    public void saveCatalog(ProductCatalog catalog) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CATALOG_FILE))) {
            for (Product product : catalog.getAllProducts()) {
                writer.println(product.getName() + "," + product.getPrice() + "," + product.getRating());
            }
            System.out.println("Items catalog save to file: " + CATALOG_FILE);
        } catch (IOException e) {
            System.err.println("Err Items catalog not saved: " + e.getMessage());
        }
    }

    // Загрузка каталога товаров из файла
    public ProductCatalog loadCatalog() {
        ProductCatalog catalog = new ProductCatalog();
        try (BufferedReader reader = new BufferedReader(new FileReader(CATALOG_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0];
                    double price = Double.parseDouble(parts[1]);
                    double rating = Double.parseDouble(parts[2]);
                    Product product = new Product(name, price, rating);
                    catalog.addProduct(product);
                }
            }
            System.out.println("Items catalog has been loaded from file: " + CATALOG_FILE);
        } catch (IOException e) {
            System.err.println("Err Items catalog can't loaded: " + e.getMessage());
        }
        return catalog;
    }
}

/*
    CATALOG_FILE: Имя файла для хранения каталога.
    saveCatalog():
        Использует PrintWriter для записи в файл.
        Перебирает все товары в каталоге.
        Записывает данные каждого товара в формате "имя,цена,рейтинг" в отдельную строку.
    loadCatalog():
        Использует BufferedReader для чтения из файла.
        Читает файл построчно.
        Разделяет каждую строку на части по запятой.
        Создаёт объекты Product на основе полученных данных и добавляет их в каталог.
        Обрабатывает исключения IOException, которые могут возникнуть при работе с файлами.

 */