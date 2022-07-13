package com.github.rere950303.validation.controller;

import com.github.rere950303.validation.dto.ValidationDTO;
import com.github.rere950303.validation.validator.PasswordValidator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ValidationController {

    @GetMapping("/validation")
    public String validation(@RequestBody @Valid ValidationDTO dto) {
        return "ok";
    }

    @InitBinder
    public void init(WebDataBinder dataBinder) {
        dataBinder.addValidators(new PasswordValidator());
    }
}