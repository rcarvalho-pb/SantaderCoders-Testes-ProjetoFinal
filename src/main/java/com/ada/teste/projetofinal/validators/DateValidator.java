package com.ada.teste.projetofinal.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateValidator implements ConstraintValidator<DateValidation, String> {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            LocalDateTime dateTime = LocalDateTime.parse(value, dtf);
//            if(dateTime.isBefore(LocalDateTime.now()) || dateTime.isEqual(LocalDateTime.now())){
//                throw new DateTimeException("Invalid date.");
//            }
        }
        catch(DateTimeException e){
            return false;
        }
        return true;
    }
}
