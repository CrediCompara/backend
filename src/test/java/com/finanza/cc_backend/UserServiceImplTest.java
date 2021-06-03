package com.finanza.cc_backend;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finanza.cc_backend.controller.UserController;
import com.finanza.cc_backend.domain.model.User;
import com.finanza.cc_backend.domain.repository.UserRepository;
import com.finanza.cc_backend.domain.service.UserService;
import com.finanza.cc_backend.exception.ResourceNotFoundException;
import com.finanza.cc_backend.service.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import static org.mockito.Mockito.when;


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

    @Test
    @DisplayName("When createUser but the username already exists")
    public void whenCreateUserButTheUsernameAlreadyExists(){
        String userName = "testUserName";
        String email = "test@gmail.com";
        String name = "TestName";
        String lastname = "TestLastName";
        String password = "TestPassword";
        String phone = "TestNumberPhone";
        User user = new User().setId(1L).setEmail(email).setUsername(userName).setFirst_name(name)
                .setLast_name(lastname).setPassword(password).setPhone(phone);
        Mockito.when(userRepository.findCustomerByUsername(user.getUsername()))
                .thenReturn(Optional.of(user));
        String expectedMessage = "This username is begin used by another user";

       User userTest = new User();
        userTest.setUsername(userName);
       Throwable exception = catchThrowable(()-> {
           User result = userService.createUser(userTest);
       });
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);

    }
    @Test
    @DisplayName("When createUser but the email already exists")
    public void whenCreateUserButTheEmailAlreadyExists(){
        String userName = "testUserName";
        String email = "test@gmail.com";
        String name = "TestName";
        String lastname = "TestLastName";
        String password = "TestPassword";
        String phone = "TestNumberPhone";
        User user = new User().setId(1L).setEmail(email).setUsername(userName).setFirst_name(name)
                .setLast_name(lastname).setPassword(password).setPhone(phone);
        Mockito.when(userRepository.findCustomerByEmail(user.getEmail()))
                .thenReturn(Optional.of(user));
        String expectedMessage = "This email is begin used by another user";

        User userTest = new User();
        userTest.setEmail(email);
        Throwable exception = catchThrowable(()-> {
            User result = userService.createUser(userTest);
        });
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }
    @Test
    @DisplayName("When createUser but the phone already exists")
    public void whenCreateUserButThePhoneAlreadyExists(){
        String userName = "testUserName";
        String email = "test@gmail.com";
        String name = "TestName";
        String lastname = "TestLastName";
        String password = "TestPassword";
        String phone = "TestNumberPhone";
        User user = new User().setId(1L).setEmail(email).setUsername(userName).setFirst_name(name)
                .setLast_name(lastname).setPassword(password).setPhone(phone);
        Mockito.when(userRepository.findCustomerByPhone(user.getPhone()))
                .thenReturn(Optional.of(user));
        String expectedMessage = "This phone number is begin used by another user";

        User userTest = new User();
        userTest.setPhone(phone);
        Throwable exception = catchThrowable(()-> {
            User result = userService.createUser(userTest);
        });
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);

    }
}
    
