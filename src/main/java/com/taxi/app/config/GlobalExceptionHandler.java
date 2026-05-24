package com.taxi.app.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView handleIllegalArgument(IllegalArgumentException e) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("message", e.getMessage());
        return mav;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleGeneric(Exception e) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("message", "An unexpected error occurred");
        return mav;
    }
}
