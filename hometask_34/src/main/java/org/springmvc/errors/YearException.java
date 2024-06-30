package org.springmvc.errors;

import lombok.Data;
import lombok.Getter;

@Getter

public class YearException extends RuntimeException{

    public YearException(String message) {
        super(message);
    }
}
