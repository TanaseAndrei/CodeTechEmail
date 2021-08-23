package com.ucv.codetechemail.service;

import com.ucv.codetechemail.controller.exception.AppException;
import com.ucv.codetechemail.service.model.Mail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailService {

    @Value("${application.mail.from}")
    private String from;

    private final JavaMailSender javaMailSender;

    public void sendEmail(Mail mail) {
        try {
            log.info("Sending email to {}", mail.getTo());
            MimeMessage mimeMessage = createMimeMessage(mail);
            javaMailSender.send(mimeMessage);
        } catch (MailException | MessagingException mailException) {
            log.error("An error occurred while sending an email to {}", mail.getTo(), mailException);
            throw new AppException("An error occurred while sending an email to " + mail.getTo(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private MimeMessage createMimeMessage(Mail mail) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setText(mail.getBody(), true);
        mimeMessageHelper.setTo(mail.getTo());
        mimeMessageHelper.setFrom(from);
        return mimeMessageHelper.getMimeMessage();
    }
}
