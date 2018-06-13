package com.webapp.jee;

public class UserValidationService {

    public boolean isUserValid(String user, String password) {
        if (user.equals("jack") && password.equals("temp")) {
            return true;

        }
        return false;
    }
}
