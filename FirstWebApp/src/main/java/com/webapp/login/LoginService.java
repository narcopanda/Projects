package com.webapp.login;

import org.springframework.stereotype.Service;

// = new LoginService()
@Service
public class LoginService {

    public boolean isUserValid(String user, String password) {
        if (user.equalsIgnoreCase("jack") && password.equals("temp")) {
            return true;

        }
        return false;
    }
}
