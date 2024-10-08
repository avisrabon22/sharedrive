package com.avijit.sharedrive.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequestDto {
    private String userFullName;
    private String userName;
    private String userPassword;
    private String userPhone;
    private String userAddress;
    private String userRole;
}
