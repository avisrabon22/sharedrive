package com.avijit.sharedrive.Config.SpringSecurityConfig;

import com.avijit.sharedrive.Model.UserModel;
import org.springframework.security.core.GrantedAuthority;

public class CustomeGrantedAuthority implements GrantedAuthority {
    private final UserModel userModel;

    public CustomeGrantedAuthority(UserModel userModel) {
        this.userModel = userModel;
    }

    @Override
    public String getAuthority() {
        return userModel.getUserRole().getType();
    }
}
