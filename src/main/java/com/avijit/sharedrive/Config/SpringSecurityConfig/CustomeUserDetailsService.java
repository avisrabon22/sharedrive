package com.avijit.sharedrive.Config.SpringSecurityConfig;

import com.avijit.sharedrive.DAO.UserRepo;
import com.avijit.sharedrive.Exceptions.NotExistException;
import com.avijit.sharedrive.Model.UserModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Component
public class CustomeUserDetailsService implements UserDetailsService {
 private final UserRepo userRepo;

    public CustomeUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepo.findByUserName(username); // find user by username
        if(user != null) {
            return new CustomeUserDetails(user); // return user details
        }

        throw new NotExistException(username+" is invalid!!"); // throw exception if user not found
    }
}
