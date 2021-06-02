package com.finanza.cc_backend;

import com.finanza.cc_backend.domain.repository.UserRepository;
import com.finanza.cc_backend.domain.service.UserService;
import com.finanza.cc_backend.service.UserServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class UserServiceImplTest {
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @TestConfiguration
    static class UserServiceImplTestConfiguration{
        @Bean
        public UserService userService() { return new UserServiceImpl();
        }
    }

    // Poner test
}
