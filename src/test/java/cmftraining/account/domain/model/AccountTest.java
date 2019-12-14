package cmftraining.account.domain.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;


public class AccountTest {

    @Test
    public void toString应将账户信息转换成字符串() {
        Account account = new Account();
        account.setId(100L);
        account.setUserId(1L);
        account.setBalance(100);

        assertThat(account.toString())
                .isEqualTo( "Account{id=100, userId='1', balance='100'}" );


    }

}