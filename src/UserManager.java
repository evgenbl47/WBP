import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    private List<User> users = new ArrayList<>();
    private User currentUser = null;

    public void registerUser(Scanner scanner) {
        System.out.println("Enter user name: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Enter your adress: ");
        String adress = scanner.nextLine();

        User newUser = new User(username, password, name, adress);
        users.add(newUser);
        System.out.println("Register success!");
    }

    public void loginUser(Scanner scanner) {
        System.out.println("Enter user name: ");
        String userName = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        for (User user : users) {
            if (user.getUsername().equals(userName) && user.getPassword().equals(password)) {
                currentUser = user;
                System.out.println("Login success!");
                return;
            }

        }
        System.out.println("Err Wrong user name or password");
    }

    public void logoutUser() {
        currentUser = null;
        System.out.println("Logout success!");
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
