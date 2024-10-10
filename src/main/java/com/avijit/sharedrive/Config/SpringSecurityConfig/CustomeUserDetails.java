package com.avijit.sharedrive.Config.SpringSecurityConfig;

import com.avijit.sharedrive.Model.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CustomeUserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private final UserModel user;

    public CustomeUserDetails(UserModel user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new CustomeGrantedAuthority(user));
    }

    @Override
    public String getPassword() {
        return user.getUserPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

}
