package cmftraining.account.presentation.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import cmftraining.account.domain.model.Account;
import cmftraining.account.share.testhelper.RepoHelper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static cmftraining.account.share.testhelper.Utils.asJsonString;
import static cmftraining.account.share.testhelper.Utils.assertJson;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerRepoIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RepoHelper helper;

    @Before
    public void initDb() {
        helper.clearCustomerTable();
    }

    @Test
    public void create应创建账户() throws Exception {

        Account expected = new Account(1L, 100);

        Long createdId = Long.valueOf(
                mockMvc.perform(
                        post("/api/accounts")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(asJsonString(expected)))
                        .andDo(print())
                        .andReturn()
                        .getResponse()
                        .getContentAsString()
        );

        Account actual = helper.findAccountFromDbById(createdId);

        assertThat(actual).isEqualToComparingOnlyGivenFields(
                expected
                , "userId"
                , "balance");
    }

    @Test
    public void findAll应查出所有账户() throws Exception {

        Account account1 = helper.createAccountInDb(1L, 100);
        Account account2 = helper.createAccountInDb(1L, 100);

        String expected = asJsonString(new Account[]{account1, account2});

        String actual = mockMvc
                .perform(get("/api/accounts"))
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertJson(actual, expected);
    }
}