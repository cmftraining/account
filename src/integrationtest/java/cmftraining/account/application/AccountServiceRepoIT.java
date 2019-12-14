package cmftraining.account.application;

import org.junit.*;
import cmftraining.account.domain.model.Account;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import cmftraining.account.share.testhelper.RepoHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * 本类中的测试方法借助Repository中的
 * 数据访问方法进行集成测试,比较方便但不够严谨,
 * 适合于冒烟测试.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AccountServiceRepoIT {

    @Autowired
    AccountService service;

    @Autowired
    RepoHelper helper;

    @Before
    public void initDb() {
        helper.clearCustomerTable();
    }

    @Test
    public void create应创建指定账户() {

        Account expected = new Account(1L, 100);

        expected.setId(
                service.create(expected).getId()
        );

        Account actual = helper.findAccountFromDbById(expected.getId());

        assertThat(actual).isEqualToComparingFieldByField(expected);

    }

    @Test
    public void findAll应查出所有账户() {

        Account zhangfei = helper.createAccountInDb(1L, 100);
        Account liubei = helper.createAccountInDb(1L,100);

        List<Account> actual = service.findAll();

        assertThat(actual).hasSize(2)
                .extracting("userId", "balance")
                .contains(
                        tuple(zhangfei.getUserId(), zhangfei.getBalance()),
                        tuple(liubei.getUserId(), liubei.getBalance())
                );
    }
}