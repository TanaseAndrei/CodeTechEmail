package com.ucv.codetechemail.controller.model.input;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@ApiModel(description = "The object that the API needs to get in order to know to who must be sent the email," +
        " to what email and what role does the user have to find the specific template")
public class RegisterEmailDto {

    @NotEmpty(message = "The username should not be null or empty")
    @ApiModelProperty(required = true, value = "The name of the user", example = "User1")
    private final String username;

    @NotEmpty(message = "The email should not be null or empty")
    @ApiModelProperty(required = true, value = "The email address where the actual email should be sent", example = "a@yahoo.com")
    private final String to;

    @NotNull(message = "The role of the user should be specified")
    @ApiModelProperty(required = true, value = "The role of the user", example = "STUDENT")
    private final RoleDto role;
}
