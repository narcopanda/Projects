package com.webapp.springmvc;

import com.webapp.jee.LoginService;
import com.webapp.jee.LoginServlet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    LoginService service = new LoginService();

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
