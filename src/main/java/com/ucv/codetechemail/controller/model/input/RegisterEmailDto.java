package com.ucv.codetechemail.controller.model.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
public class RegisterEmailDto {

    @Schema(description = "The name of the user", example = "User1")
    @NotEmpty(message = "The username should not be null or empty")
    private final String username;

    @Schema(description = "The email address where the actual email should be sent", example = "a@yahoo.com")
    @NotEmpty(message = "The email should not be empty")
    private final String to;

    @Schema(description = "The role of the user", example = "STUDENT")
    @NotEmpty(message = "The role should be specified")
    private final RoleDto role;
}
