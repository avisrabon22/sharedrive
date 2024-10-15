package com.avijit.sharedrive.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @ManyToMany(fetch = FetchType.EAGER)
    private List<UserTypeModel> userRole = new ArrayList<>();
}
