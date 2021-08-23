package com.ucv.codetechemail.controller.model.input;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisterEmailDto {
    private final String username;
    private final String to;
    private final RoleDto role;
}
