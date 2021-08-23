package com.ucv.codetechemail.facade;

import com.ucv.codetechemail.controller.model.input.RegisterEmailDto;
import com.ucv.codetechemail.facade.factory.RegisterEmailTemplate;
import com.ucv.codetechemail.service.MailService;
import com.ucv.codetechemail.service.model.Mail;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.ucv.codetechemail.CodeTechEmailApplication.Facade;

@Facade
@Slf4j
@AllArgsConstructor
public class MailFacade {

    private final MailService mailService;

    public void register(RegisterEmailDto registerEmailDto) {
        String email = RegisterEmailTemplate.getEmailTemplate(registerEmailDto.getRole(), registerEmailDto.getUsername());
        mailService.sendEmail(createRegisterMail(registerEmailDto.getTo(), email));
        log.info("Sent register email to {}", registerEmailDto.getTo());
    }

    private Mail createRegisterMail(String to, String body) {
        return Mail.builder()
                .to(to)
                .subject("Welcome to CodeTech")
                .body(body)
                .build();
    }
}
