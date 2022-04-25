package com.cobra.petmanagement.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) // without this the code will make the response 200
    public ModelAndView handleNumberFormatException(Exception e){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("404notfound");
        modelAndView.addObject("exception", e);
        return modelAndView;
    }
}
