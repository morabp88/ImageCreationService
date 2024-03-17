package com.example.ImageCreationService.services;

import com.example.ImageCreationService.Model.User;
import com.example.ImageCreationService.entities.NewUser;
import com.example.ImageCreationService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LoginService {


    @Autowired
    UserRepository userRepository;


    public Boolean isUserValid(String userName, String password) {
        Optional<NewUser> user = userRepository.findMyUser(userName, password);
        return user.isPresent();
    }

    public Boolean updatepassword(String username, NewUser newUserInfo) {
        System.out.println("update password"+newUserInfo);
        List<NewUser> user = userRepository.findAll();
        for (NewUser n : user) {
            if(Objects.equals(n.getUsername(), username) && !Objects.equals(n.getPassword(), newUserInfo.getPassword())){
                System.out.println("Password changed. new password:" + newUserInfo.getPassword());
                n.setPassword(newUserInfo.getPassword());
                //userRepository.save(n);
                return true;
            }
        }
        System.out.println("Password NOT changed. password:" + newUserInfo.getPassword());
        return false;
    }

    public Boolean signup(NewUser newUserInfo) {
        Optional <NewUser> user = userRepository.findByUsername(newUserInfo.getUsername());
        if (user.isPresent()) {
            return false;
        }
        else {
            //System.out.println("New user is:"+newUserInfo);
//            NewUser newUser = new NewUser();
//            newUser.setUsername(newUserInfo.getUsername());
//            newUser.setPassword(newUserInfo.getPassword());
            try {
                userRepository.save(newUserInfo);
                return true;
            }
            catch(Exception e) {
                System.out.println("Exception" + e.getMessage() );
                return false;
            }
        }
    }
}
