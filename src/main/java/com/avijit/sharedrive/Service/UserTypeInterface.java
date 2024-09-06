package com.avijit.sharedrive.Service;

import com.avijit.sharedrive.DTO.UserTypeRequestDto;
import com.avijit.sharedrive.DTO.UserTypeResponseDto;
import com.avijit.sharedrive.Exceptions.UserTypeExistExceptions;

public interface UserTypeInterface {
    public UserTypeResponseDto addUserType(UserTypeRequestDto userTypeRequestDto) throws UserTypeExistExceptions;
}
