package cmftraining.account.share.testhelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import cmftraining.account.domain.model.Account;
import cmftraining.account.domain.model.AccountRepository;

import static org.assertj.core.api.Assertions.fail;

@Component
public class RepoHelper {

    @Autowired
    AccountRepository repository;

    public Account createAccountInDb(Long userId, int balance) {
        Account expected = new Account(userId, balance);

        expected.setId(
                repository.save(expected).getId()
        );
        return expected;
    }

    public Account findAccountFromDbById(Long id) {
        return repository.findById(id)
                .orElseGet(()-> fail("找不到ID为 '" + id + "' 的客户!"));
    }

    public void clearCustomerTable() {
        repository.deleteAll();
    }
}
