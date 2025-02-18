import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static UserManager userManager = new UserManager();
    private static CatalogManager catalogManager = new CatalogManager();

    public static void main(String[] args) {
        catalogManager.loadCatalog();


        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (userManager.getCurrentUser() == null) {
                displayGuestMenu();
            } else {
                displayUserMenu();
            }

            System.out.println("Choice action: ");
            String choise = scanner.nextLine();

            if (userManager.getCurrentUser() == null) {
                handleGuestActions(choise, scanner);
            } else {
                handleUserActions(choise, scanner);
            }
        }
    }


    // Меню для неавторизованных пользователей
    private static void displayGuestMenu() {
        System.out.println("\n===== Wildberries (Консоль) =====");
        System.out.println("1. Регистрация");
        System.out.println("2. Вход");
        System.out.println("0. Выход");
        System.out.println("==================================");
    }

    // Меню для авторизованных пользователей
    private static void displayUserMenu() {
        System.out.println("\n===== Wildberries (Консоль) =====");
        System.out.println("1. Показать каталог товаров");
        System.out.println("2. Добавить товар в корзину");
        System.out.println("3. Удалить товар из корзины");
        System.out.println("4. Показать корзину");
        System.out.println("5. Оформить заказ");
        System.out.println("6. Личный кабинет");
        System.out.println("0. Выход из аккаунта");
        System.out.println("==================================");
    }

    private static void handleGuestActions(String choise, Scanner scanner) {
        switch (choise) {
            case "1":
                userManager.registerUser(scanner);
                break;
            case "2":
                userManager.loginUser(scanner);
                break;
            case "0":
                System.out.println("Exit program.");
                System.exit(0);
                break;
            default:
                System.out.println("Wrong choose, try again");
        }
    }

    private static void handleUserActions(String choise, Scanner scanner) {
        switch (choise) {
            case "1":
                catalogManager.showCatalog();
                break;
            case "2":
                catalogManager.addProductToCart(scanner);
                break;
            case "3":
                catalogManager.removeProductFromCart(scanner);
                break;
            case "4":
                catalogManager.viewCart();
                break;
            case "5":
                catalogManager.checkOut(scanner);
                break;
            case "6":
                System.out.println("Personal account: " + userManager.getCurrentUser());
                break;
            case "0":
                userManager.logoutUser();
                break;
            default:
                System.out.println("Wrong choose, try again.");
        }
    }
}