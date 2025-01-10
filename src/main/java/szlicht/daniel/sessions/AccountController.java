package szlicht.daniel.sessions;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    void register(@RequestBody Account account) {
        accountService.register(account);
    }

    @GetMapping
    Collection<Account> listAccounts() {
        return accountService.getAccounts();
    }
}
