package com.taxi.app.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Global exception handler that catches unhandled exceptions
 * and renders the error page with a user-friendly message.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /** Handle business-logic errors (e.g. invalid booking data). */
    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView handleIllegalArgument(IllegalArgumentException e) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("message", e.getMessage());
        return mav;
    }

    /** Catch-all for any unhandled exception. */
    @ExceptionHandler(Exception.class)
    public ModelAndView handleGeneric(Exception e) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("message", "An unexpected error occurred");
        return mav;
    }
}
