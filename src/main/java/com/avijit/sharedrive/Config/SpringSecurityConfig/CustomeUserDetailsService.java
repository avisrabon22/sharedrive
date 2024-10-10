package com.avijit.sharedrive.Config.SpringSecurityConfig;

import com.avijit.sharedrive.DAO.UserRepo;
import com.avijit.sharedrive.Model.UserModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomeUserDetailsService implements UserDetailsService {
 private final UserRepo userRepo;

    public CustomeUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepo.findByUserName(username);
        if(user==null)
            throw new UsernameNotFoundException("User is invalid!!");

        return new CustomeUserDetails(user);
    }
}
