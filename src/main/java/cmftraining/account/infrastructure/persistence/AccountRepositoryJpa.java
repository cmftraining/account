package cmftraining.account.infrastructure.persistence;
import cmftraining.account.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import cmftraining.account.domain.model.AccountRepository;

public interface AccountRepositoryJpa
        extends JpaRepository<Account, Long>, AccountRepository {
}
