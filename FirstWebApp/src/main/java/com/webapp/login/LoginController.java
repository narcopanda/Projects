package com.webapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

//    without dependency injection
//    LoginService service = new LoginService();

//    with dependency injection
    @Autowired
    LoginService service;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    @ResponseBody
    public String showLoginPage(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    @ResponseBody
    public String handleLoginRequest(@RequestParam String name, @RequestParam String password, ModelMap model){
        if(service.isUserValid(name,password)) {
            model.put("name", name);
            model.put("password", password);
            return "welcome";
        }else {
            return "login";
        }
    }
}
