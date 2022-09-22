package com.example.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password){
        boolean validUserName = (username.equalsIgnoreCase("david"));
        boolean validPassword= (password.equalsIgnoreCase("password"));
        return validPassword && validUserName;
    }

}
