package com.ucv.codetechemail.controller.swagger;

import com.ucv.codetechemail.controller.model.input.RegisterEmailDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;

@Api(value = "The email API used by CodeTech")
public interface MailApi {

    @ApiOperation(value = "Sends a registration email to the targeted email", httpMethod = "POST",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully sent a email address", response = void.class),
            @ApiResponse(code = 500, message = "Internal server error", response = void.class)
    })
    void register(RegisterEmailDto registerEmailDto);
}
