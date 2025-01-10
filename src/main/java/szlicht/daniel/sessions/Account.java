package szlicht.daniel.sessions;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

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

    UserDetails asUserDetails() {
        return User.builder()
                .username(login)
                .password(password)
                .build();
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setPassword(String password) {
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
