package com.ucv.codetechemail.controller.swagger;

import com.ucv.codetechemail.controller.model.input.RegisterEmailDto;

public interface MailApi {

    void register(RegisterEmailDto registerEmailDto);
}
