package com.springapp.mvc.validator;


import javax.validation.Constraint;
import java.lang.annotation.*;


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmailExistsConstraintValidator.class)

public @interface EmailExistsConstraint {
    String message() default "Email already exists";

    Class[] groups() default {};

    Class[] payload() default {};
}
