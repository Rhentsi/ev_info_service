package com.ev_info_service_backend.ev_info_service_backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CarNotFoundException extends Exception{
    public CarNotFoundException(String message) {
        super(message);
    }
}

