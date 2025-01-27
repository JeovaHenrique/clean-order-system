package com.cleanordersystem.authentication;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest(classes = AuthenticationApplication.class)
class AuthenticationApplicationTest {

    @Test
    void contextLoads() {
    }

}
