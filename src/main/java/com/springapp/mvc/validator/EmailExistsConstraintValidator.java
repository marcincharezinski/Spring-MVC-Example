package com.springapp.mvc.validator;

import com.springapp.mvc.domain.User;
import com.springapp.mvc.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailExistsConstraintValidator implements ConstraintValidator<EmailExistsConstraint, String> {

    private Log log = LogFactory.getLog(EmailExistsConstraintValidator.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(EmailExistsConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String target, ConstraintValidatorContext context) {
        User user;
        try {
            user = userRepository.findByEmail(target);
            System.out.println("users:" + user);
            if (user != null) {
                return false;
            }
        } catch (Exception e) {
            log.error(e);
        }
        return true;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
