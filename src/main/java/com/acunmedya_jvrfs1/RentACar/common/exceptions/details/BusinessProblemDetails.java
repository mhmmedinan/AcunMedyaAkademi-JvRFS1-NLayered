package com.acunmedya_jvrfs1.RentACar.common.exceptions.details;

import org.springframework.http.HttpStatus;

public class BusinessProblemDetails extends ProblemDetails{
    public BusinessProblemDetails(){
        setTitle("Business Rule Violation");
        setType("http://acunmedya.com/exceptions/business");
        setStatus(HttpStatus.BAD_REQUEST.toString());
    }
}
