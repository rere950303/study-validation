package com.github.rere950303.validation.validator;

import com.github.rere950303.validation.dto.ValidationDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PasswordValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return ValidationDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationDTO dto = (ValidationDTO) target;

        if (!dto.getPassword().equals(dto.getPasswordConfirm())) {
            errors.reject("passwordMatch", "비밀번호가 일치하지 않습니다.");
        }
    }
}