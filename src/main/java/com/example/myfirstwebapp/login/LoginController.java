package com.example.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
//    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value="login", method= RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value="login", method= RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
        model.put("name" , name);

        // Authentication
        if(authenticationService.authenticate(name, password)){
            return "welcome";
        } else {
            model.put("errorMessage", "Invalid Credentials! Please try again");
        }
        return "login";
    }

//    @RequestMapping("login")
//    public String login(@RequestParam String name, ModelMap model) {
//        logger.debug("Request name is {}", name);
//        model.put("name", name);
//        return "login";
//    }

}
