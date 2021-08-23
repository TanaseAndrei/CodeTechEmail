package com.ucv.codetechemail.service.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Mail {
    private String to;
    private String subject;
    private String body;
}
