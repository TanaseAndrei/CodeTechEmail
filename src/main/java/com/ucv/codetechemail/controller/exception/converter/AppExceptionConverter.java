package com.ucv.codetechemail.controller.exception.converter;

import com.ucv.codetechemail.controller.exception.AppException;
import com.ucv.codetechemail.controller.exception.dto.AppExceptionDto;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@NoArgsConstructor
@Component
public class AppExceptionConverter {

    private static final String VALIDATION_EXCEPTION_MESSAGE = "There are fields that are not valid";

    public AppExceptionDto exceptionToDto(AppException appException) {
        AppExceptionDto appExceptionDto = new AppExceptionDto();
        appExceptionDto.setHttpCode(appException.getHttpStatus().value());
        appExceptionDto.setMessage(appException.getMessage());
        appExceptionDto.setThrownTime(LocalDateTime.now());
        return appExceptionDto;
    }
}
