package com.acunmedya_jvrfs1.RentACar.common.exceptions.details;

import org.springframework.http.HttpStatus;

public class InternalServerProblemDetails extends ProblemDetails{
    public InternalServerProblemDetails(){
        setTitle("Internal Server Error");
        setType("http://acunmedya.com/exceptions/internal");
        setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
    }
}
