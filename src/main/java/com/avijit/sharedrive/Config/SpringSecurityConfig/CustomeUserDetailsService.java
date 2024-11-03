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

@Service
public class CustomeUserDetailsService implements UserDetailsService {
    private final UserRepo userRepo;

    public CustomeUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> userOptional = userRepo.findByUserName(username); // find user by username

        if (userOptional.isPresent())
        {
            return new CustomeUserDetails(
                         userOptional.get().getUserName(),
                                 userOptional.get().getUserPassword(),
                                 userOptional.get().getUserRole());
        }
        else
        {
            throw new UsernameNotFoundException("User not found");
        }

    }
}