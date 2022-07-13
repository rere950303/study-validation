package com.github.rere950303.validation.dto;

import com.github.rere950303.validation.annotation.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ValidationDTO {

    @Phone
    private String phoneNum;

    private String password;

    private String passwordConfirm;
}
