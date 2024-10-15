package com.avijit.sharedrive.Config.SpringSecurityConfig;

import com.avijit.sharedrive.Model.UserModel;
import com.avijit.sharedrive.Model.UserTypeModel;
import org.springframework.security.core.GrantedAuthority;

public class CustomeGrantedAuthority implements GrantedAuthority {
    private final String userType;

    public CustomeGrantedAuthority(UserTypeModel userTypeModel) {
        this.userType = userTypeModel.getType();
    }

    @Override
    public String getAuthority() {
        return this.userType;
    }
}
