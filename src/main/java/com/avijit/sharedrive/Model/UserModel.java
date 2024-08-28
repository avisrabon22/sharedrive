package com.avijit.sharedrive.Model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserModel extends BaseModel{
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userPhone;
    private String userAddress;
    private String userRole;
}
