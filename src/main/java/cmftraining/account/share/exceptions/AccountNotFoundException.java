package cmftraining.account.share.exceptions;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(Long id) {
        super("找不到ID为'"+ id + "'的账户!");
    }
}
