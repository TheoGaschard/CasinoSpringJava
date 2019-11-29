package com.casino.thecasino.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.casino.thecasino.Dao.UserDAO;
import com.casino.thecasino.form.UserForm;
import com.casino.thecasino.model.User;
 
@Component
public class UserValidator implements Validator {
 
 
    @Autowired
    private UserDAO UserDAO;
 
    // The classes are supported by this validator.
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == UserForm.class;
    }
 
    @Override
    public void validate(Object target, Errors errors) {
        UserForm UserForm = (UserForm) target;
 
        // Check the fields of UserForm.
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pseudo", "NotEmpty.UserForm.pseudo");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.UserForm.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "NotEmpty.UserForm.confirmPassword");
 
 

 
        if (!errors.hasFieldErrors("userName")) {
            User dbUser = UserDAO.findUserByUserPseudo(UserForm.getPseudo());
            if (dbUser != null) {
                // Pseudo is not available.
                errors.rejectValue("userName", "Duplicate.UserForm.Pseudo");
            }
        }
 
        if (!errors.hasErrors()) {
            if (!UserForm.getConfirmPassword().equals(UserForm.getPassword())) {
                errors.rejectValue("confirmPassword", "Match.UserForm.confirmPassword");
            }
        }
    }
 
}