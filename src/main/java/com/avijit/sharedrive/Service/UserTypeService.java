package com.avijit.sharedrive.Service;

import com.avijit.sharedrive.DAO.UserTypeRepo;
import com.avijit.sharedrive.DTO.UserTypeRequestDto;
import com.avijit.sharedrive.DTO.UserTypeResponseDto;
import com.avijit.sharedrive.Exceptions.UserTypeExistExceptions;
import com.avijit.sharedrive.Model.UserTypeModel;
import org.springframework.stereotype.Service;

@Service
public class UserTypeService implements UserTypeInterface{
private  final UserTypeRepo userTypeRepo;

    public UserTypeService(UserTypeRepo userTypeRepo) {
        this.userTypeRepo = userTypeRepo;
    }

    public UserTypeResponseDto addUserType(UserTypeRequestDto userTypeRequestDto) throws UserTypeExistExceptions {
        UserTypeModel userTypeModel = new UserTypeModel();
        UserTypeResponseDto userTypeResponseDto = new UserTypeResponseDto();

        boolean userTypeExist = userTypeRepo.existsByType(userTypeRequestDto.getUserType());

        if (userTypeExist){
            throw new UserTypeExistExceptions("User Type Already Exist");
        }

        userTypeModel.setType(userTypeRequestDto.getUserType());
        userTypeRepo.save(userTypeModel);
        userTypeResponseDto.setMessage("User Type Added Successfully");
        return userTypeResponseDto;
    }

}
