package com.avijit.sharedrive.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserModel extends BaseModel{
    @Column(nullable = false)
    private String userFullName;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String userPassword;
    @Column(nullable = false)
    private String userPhone;
    private String userAddress;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false,name = "user_type_id")
    private UserTypeModel userRole;
}
