package com.avijit.sharedrive.Service;

import com.avijit.sharedrive.DTO.UserTypeRequestDto;
import com.avijit.sharedrive.DTO.UserTypeResponseDto;
import com.avijit.sharedrive.Exceptions.UserTypeExistExceptions;

import java.util.List;

public interface UserTypeInterface {
    UserTypeResponseDto addUserType(UserTypeRequestDto userTypeRequestDto) throws UserTypeExistExceptions;
    List<UserTypeResponseDto> GetUserType();
    UserTypeResponseDto UserTypeRemove(UserTypeRequestDto userTypeRequestDto);
}
