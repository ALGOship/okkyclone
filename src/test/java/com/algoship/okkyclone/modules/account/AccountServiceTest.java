<<<<<<< HEAD
package com.algoship.okkyclone.modules.account;public class AccountServiceTest {
=======
<<<<<<< HEAD
package com.algoship.okkyclone.modules.account;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    AccountRepository accountRepository;

    @DisplayName("회원 가입 처리 - 입력값 오류")
    @Test
    public void signUpSubmit_test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/user/sign-up") // POST 요청
                .param("userId", "test123")
                .param("nickname", "user")
                .param("name", "tester##")
                .param("email", "test123email.com")
                .param("password", "12345678")
                .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(view().name("sign-up"))
                .andExpect(unauthenticated());
    }

=======
package com.algoship.okkyclone.modules.account;public class AccountServiceTest {
>>>>>>> 12ad2d5 (CLEANUP: 회원 가입 동작 개선, 메인 화면 유닛테스트 코드 추가)
>>>>>>> 245fdd4 (FEATURE: 회원 가입 실패 테스트 코드 추가, springboot security test gradle에 추가)
}
