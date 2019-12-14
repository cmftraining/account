package cmftraining.account.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cmftraining.account.domain.model.Account;
import cmftraining.account.domain.model.AccountRepository;

@Service
public class AccountService {
    @Autowired
    AccountRepository repository;

    public Account create(Account account) {
        return repository.save(account);
    }

    public List<Account> findAll() {
        return repository.findAll();
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
