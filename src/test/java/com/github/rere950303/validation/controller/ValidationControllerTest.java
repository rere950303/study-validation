package com.github.rere950303.validation.controller;

import com.github.rere950303.validation.advice.ControllerAdvice;
import com.github.rere950303.validation.dto.ValidationDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.github.rere950303.validation.utils.ApiTestUtils.getJson;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ValidationControllerTest {

    MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(new ValidationController())
                .setControllerAdvice(new ControllerAdvice())
                .alwaysDo(print())
                .build();
    }

    @Test
    public void validation_phoneNumFormatNotMatch() throws Exception {
        String json = getJson(ValidationDTO.builder().phoneNum("1234").password("123").passwordConfirm("123").build());

        mockMvc.perform(get("/validation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void validation_passwordNotMatch() throws Exception {
        String json = getJson(ValidationDTO.builder().phoneNum("010-2815-2145").password("123").passwordConfirm("321").build());

        mockMvc.perform(get("/validation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void validation_isOk() throws Exception {
        String json = getJson(ValidationDTO.builder().phoneNum("010-2815-2145").password("123").passwordConfirm("123").build());

        mockMvc.perform(get("/validation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }
}