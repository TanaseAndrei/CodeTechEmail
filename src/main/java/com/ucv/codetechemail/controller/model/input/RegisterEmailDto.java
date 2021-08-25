package com.ucv.codetechemail.controller.model.input;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
@ApiModel(description = "This represents the object that the api needs to get in order to know to who must be sent the email," +
        " to what email and what role does the user have")
public class RegisterEmailDto {

    @Schema(description = "The name of the user", example = "User1")
    @NotEmpty(message = "The username should not be null or empty")
    @ApiModelProperty(required = true)
    private final String username;

    @Schema(description = "The email address where the actual email should be sent", example = "a@yahoo.com")
    @NotEmpty(message = "The email should not be empty")
    @ApiModelProperty(required = true)
    private final String to;

    @Schema(description = "The role of the user", example = "STUDENT")
    @ApiModelProperty(required = true)
    private final RoleDto role;
}
