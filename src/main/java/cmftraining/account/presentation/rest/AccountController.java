package cmftraining.account.presentation.rest;

import cmftraining.account.application.AccountService;
import cmftraining.account.domain.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    AccountService service;

    @PostMapping("/api/accounts")
    public Long create(@RequestBody Account account) {
        return service.create(account).getId();
    }

    @GetMapping("/api/accounts")
    public List<Account> findAll() {
        return service.findAll();
    }

}
