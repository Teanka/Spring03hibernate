package pl.coderslab.app;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class AgeValidator implements ConstraintValidator<Age, LocalDate> {

    @Override
    public void initialize(Age age) {
    }

    @Override
    public boolean isValid(LocalDate birthDate, ConstraintValidatorContext constraintValidatorContext) {
        if(birthDate==null){
            return false;
        }
        int age = Period.between(birthDate, LocalDate.now()).getYears();
        return age >= 18;
    }
}
