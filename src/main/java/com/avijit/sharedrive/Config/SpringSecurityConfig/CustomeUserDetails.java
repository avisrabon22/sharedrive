package com.avijit.sharedrive.Config.SpringSecurityConfig;

import com.avijit.sharedrive.Model.UserModel;
import com.avijit.sharedrive.Model.UserTypeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CustomeUserDetails implements org.springframework.security.core.userdetails.UserDetails {
    private final List<GrantedAuthority> authorities;
    private final String username;
    private final String password;


    public CustomeUserDetails(UserModel user) {
          authorities = new ArrayList<>();
          for(UserTypeModel userTypeModel: user.getUserRole()){
              authorities.add(new CustomeGrantedAuthority(userTypeModel)); // add user role
          }
          this.username = user.getUserName();
            this.password = user.getUserPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

}
