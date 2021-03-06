package com.ucv.codetechemail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@SpringBootApplication
public class CodeTechEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeTechEmailApplication.class, args);
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE})
    @Component
    public @interface Facade {}
}
