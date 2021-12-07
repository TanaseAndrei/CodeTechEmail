package com.ucv.codetechemail.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ucv.codetechemail.controller.exception.converter.AppExceptionConverter;
import com.ucv.codetechemail.controller.model.input.RegisterEmailDto;
import com.ucv.codetechemail.controller.model.input.RoleDto;
import com.ucv.codetechemail.facade.MailFacade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MailController.class)
@ExtendWith(SpringExtension.class)
class MailControllerTest {

    @MockBean
    MailFacade mailFacade;

    @MockBean
    AppExceptionConverter appExceptionConverter;

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("When endpoint is called, should send a register email")
    void testRegisterValidMail() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        RegisterEmailDto email = createRegisterDto("Andrei", "aaa@yahoo.com", RoleDto.STUDENT);

        mockMvc.perform(
                        post("/mail/register")
                                .content(objectMapper.writeValueAsString(email))
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE)
                )
                .andExpect(status().isOk());

        verify(mailFacade, times(1)).register(any());
    }

    private RegisterEmailDto createRegisterDto(String username, String to, RoleDto roleDto) {
        return new RegisterEmailDto(username, to, roleDto);
    }

}
