package com.avijit.sharedrive.Service;

import com.avijit.sharedrive.DTO.SignUpRequestDto;

public interface UserSignUpInterface {
    boolean existsByUsername(String userName);
    void signUpUser(SignUpRequestDto signUpRequestDto);
}
