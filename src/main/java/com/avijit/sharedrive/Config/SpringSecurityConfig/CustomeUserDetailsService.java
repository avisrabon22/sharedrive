package com.avijit.sharedrive.Config.SpringSecurityConfig;

import com.avijit.sharedrive.DAO.UserRepo;
import com.avijit.sharedrive.Exceptions.NotExistException;
import com.avijit.sharedrive.Model.UserModel;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Component
public class CustomeUserDetailsService implements UserDetailsService {
    private final UserRepo userRepo;

    public CustomeUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> userOptional = userRepo.findByUserName(username); // find user by username
        if (userOptional.isPresent()) {
            UserModel userModel = userOptional.get();
            UserDetails userDetails = org.springframework.security.core.userdetails.User
                    .builder()
                    .username(userModel.getUserName())
                    .password(userModel.getUserPassword())
                    .roles()
                    .authorities(userModel.getUserRole().stream().map(r -> new CustomeGrantedAuthority(r)).toList())
                    .build();

            return userDetails;
            // return user details
        } else
            throw new NotExistException(username + " is invalid!!"); // throw exception if user not found

    }
}