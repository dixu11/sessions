package szlicht.daniel.sessions;

public class Account {
    private static int nextId = 1;
    private int id;
    private String login;
    private String password;

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
        id = nextId++;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setPassword(String encode) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }
}
