package com.example.ImageCreationService.controllers;

import com.example.ImageCreationService.Model.User;
import com.example.ImageCreationService.entities.NewUser;
import com.example.ImageCreationService.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

//    @Autowired
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
    @GetMapping("/login")
    public Boolean isUserValid(@RequestParam(required = true) String userName,
                               @RequestParam(required = true) String password){
        return loginService.isUserValid(userName, password);
    }

    @PutMapping("login/forgotpassword/{username}")
    public Boolean updatepassword(@PathVariable String username,
                                  @RequestBody NewUser newUserInfo){
        return loginService.updatepassword(username, newUserInfo);
    }

    @PostMapping("signup")
    public Boolean signup(@RequestBody NewUser newUserInfo){
        return loginService.signup(newUserInfo);
    }

}
