package szlicht.daniel.sessions;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountService implements UserDetailsService {
    private Map<Integer, Account> accounts;
    private PasswordEncoder passwordEncoder;

    public AccountService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        accounts = new HashMap<>();
    }

    public void register(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        accounts.put(account.getId(), account);
    }

    public Collection<Account> getAccounts() {
        return accounts.values();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return accounts.values().stream()
                .filter(acc -> acc.getLogin().equals(username))
                .findAny()
                .orElseThrow(() -> new UsernameNotFoundException("Username not matched"))
                .asUserDetails();
    }
}
