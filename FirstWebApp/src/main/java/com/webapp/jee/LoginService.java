package com.webapp.jee;

public class LoginService {

    public boolean isUserValid(String user, String password) {
        if (user.equalsIgnoreCase("jack") && password.equals("temp")) {
            return true;

        }
        return false;
    }
}
