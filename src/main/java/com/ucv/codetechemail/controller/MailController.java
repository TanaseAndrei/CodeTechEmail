package com.ucv.codetechemail.controller;

import com.ucv.codetechemail.controller.model.input.RegisterEmailDto;
import com.ucv.codetechemail.controller.swagger.MailApi;
import com.ucv.codetechemail.facade.MailFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@AllArgsConstructor
public class MailController implements MailApi {

    private final MailFacade mailFacade;

    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void register(@RequestBody RegisterEmailDto registerEmailDto) {
        mailFacade.register(registerEmailDto);
    }
}
