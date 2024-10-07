package com.avijit.sharedrive.Service;

import com.avijit.sharedrive.DTO.SignUpRequestDto;
import com.avijit.sharedrive.Exceptions.UserExist;

public interface UserSignUpInterface {
    void signUpUser(SignUpRequestDto signUpRequestDto) throws UserExist;
}
