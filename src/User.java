public class User {
    private String userName;
    private String password;
    private String name;
    private String adress;

    public User(String userName, String password, String name, String adress) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.adress = adress;
    }

    public String getUsername() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    @Override
    public String toString() {
        return "User[" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ']';
    }
}
