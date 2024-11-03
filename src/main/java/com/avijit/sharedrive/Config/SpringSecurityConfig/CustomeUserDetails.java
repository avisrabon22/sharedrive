package com.avijit.sharedrive.Config.SpringSecurityConfig;

import com.avijit.sharedrive.Model.UserModel;
import com.avijit.sharedrive.Model.UserTypeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

    public class CustomeUserDetails implements UserDetails {
        private final  List<GrantedAuthority> authorities;
        private  final String username;
        private final  String password;


        public CustomeUserDetails(String username, String password, List<UserTypeModel> userTypeModels) {
              authorities = new ArrayList<>();
              for(UserTypeModel userTypeModel: userTypeModels){
                  authorities.add(new CustomeGrantedAuthority(userTypeModel)); // add user role
              }
              this.username = username;
              this.password= password;
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

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

    }
