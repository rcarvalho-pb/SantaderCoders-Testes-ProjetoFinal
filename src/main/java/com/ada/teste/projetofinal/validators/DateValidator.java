package com.ada.teste.projetofinal.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateValidator implements ConstraintValidator<DateValidation, LocalDateTime> {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");

    @Override
    public boolean isValid(LocalDateTime value, ConstraintValidatorContext context) {
        return false;
    }
}
