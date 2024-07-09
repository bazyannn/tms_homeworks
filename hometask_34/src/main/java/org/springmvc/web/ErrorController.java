package org.springmvc.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springmvc.errors.YearException;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(YearException.class)
    public String processYearError(YearException exc, Model model) {
        model.addAttribute("error", exc.getMessage());
        return "errorpage";
    }
}
