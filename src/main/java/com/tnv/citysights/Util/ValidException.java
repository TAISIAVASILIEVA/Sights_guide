package com.tnv.citysights.Util;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;

import javax.validation.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

public class ValidException extends ValidationException {

    private final BindingResult bindingResult;

    public ValidException(BindingResult bindingResult){
        this.bindingResult = bindingResult;
    }

    private List<String> getValidationMessages(){
        return bindingResult.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
    }

    public String getResponseMessage(){
        return String.join("\n", getValidationMessages());
    }
}
