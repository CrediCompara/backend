package com.finanza.cc_backend;

import com.finanza.cc_backend.domain.model.MortgageCredit;
import com.finanza.cc_backend.domain.repository.MortgageCreditRepository;
import com.finanza.cc_backend.domain.repository.UserRepository;
import com.finanza.cc_backend.domain.service.UserService;
import com.finanza.cc_backend.exception.ResourceNotFoundException;
import com.finanza.cc_backend.service.UserServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import org.assertj.core.api.Assertions;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class UserServiceImplTest {
    @MockBean
    private UserRepository userRepository;

    @MockBean
    private MortgageCreditRepository mortgageCreditRepository;

    @Autowired
    private UserService userService;

    @TestConfiguration
    static class UserServiceImplTestConfiguration{
        @Bean
        public UserService userService() { return new UserServiceImpl();
        }
    }

    // Poner test

    @Test
    @DisplayName("When getMortgageCreditById with Valid Id Then Returns MortgageCredit")
    public void whenGetCarWashByIdwithExistentIdThenReturnsCarWash() {
        //Arrange
        String currency = "Sol";
        Double fee_value = 0.1;
        int incomes = 10000;
        int property_value = 200000;

        MortgageCredit mortgageCredit = new MortgageCredit().setCurrency(currency).setFee_value(fee_value)
                .setIncomes(incomes). setProperty_value(property_value);

        when(mortgageCreditRepository.findById(1L)).thenReturn(Optional.ofNullable(mortgageCredit));

        //Act

        MortgageCredit mortgageCredit2 = userService.getMortgageCredit(1L);

        //Assert

        assertEquals(mortgageCredit2.getIncomes(), incomes);

    }

    @Test
    @DisplayName("When getMortgageCreditById with Invalid Id Then Returns ResourceNotFoundException")
    public void whenGetCarWashByIdwithInexistentIdThenReturnsResourceNotFoundException() {
        //Arrange

        String template = "Resource %s not found for %s with value %s";
        Long mortgageCreditID = 1L;
        String expectedMessage = String.format(template, "MortgageCredit", "Id", mortgageCreditID);

        when(mortgageCreditRepository.findById(mortgageCreditID)).thenReturn(Optional.empty());

        //Act

        Throwable exception = Assertions.catchThrowable(() -> {
            MortgageCredit mortgageCredit = userService.getMortgageCredit(mortgageCreditID);
        });

        //Assert
        Assertions.assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);

    }

}
