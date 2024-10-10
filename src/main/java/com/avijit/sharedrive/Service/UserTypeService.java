package com.avijit.sharedrive.Service;

import com.avijit.sharedrive.DAO.UserRepo;
import com.avijit.sharedrive.DAO.UserTypeRepo;
import com.avijit.sharedrive.DTO.UserTypeRequestDto;
import com.avijit.sharedrive.DTO.UserTypeResponseDto;
import com.avijit.sharedrive.Exceptions.UserTypeExistExceptions;
import com.avijit.sharedrive.Model.UserModel;
import com.avijit.sharedrive.Model.UserTypeModel;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserTypeService implements UserTypeInterface{
private  final UserTypeRepo userTypeRepo;
private final UserRepo userRepo;

    public UserTypeService(UserTypeRepo userTypeRepo, UserRepo userRepo) {
        this.userTypeRepo = userTypeRepo;
        this.userRepo = userRepo;
    }

//    Get the all user type from the database *********************************
    public List<UserTypeResponseDto> GetUserType(){
        List<UserTypeModel> userTypeModels = userTypeRepo.findAll();
        List<UserTypeResponseDto> userTypeResponseDtos=new ArrayList<>();
        for (UserTypeModel userTypeModel : userTypeModels) {
            UserTypeResponseDto userTypeResponseDto = new UserTypeResponseDto();
            userTypeResponseDto.setUserType(userTypeModel.getType());
            userTypeResponseDto.setId(userTypeModel.getId());
            userTypeResponseDtos.add(userTypeResponseDto);
        }
        return userTypeResponseDtos;
    }

//    Add the user type to the database *********************************
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
        userTypeResponseDto.setUserType(userTypeRequestDto.getUserType());
        userTypeResponseDto.setId(userTypeModel.getId());
        return userTypeResponseDto;
    }

//    Remove the user type from the database *********************************
    public UserTypeResponseDto UserTypeRemove(UserTypeRequestDto userTypeRequestDto) {
        UserTypeResponseDto userTypeResponseDto = new UserTypeResponseDto();
        UserTypeModel userTypeModel = userTypeRepo.findByType(userTypeRequestDto.getUserType());
        List<UserModel> userModel = userRepo.findByUserRole_Id(userTypeModel.getId());

        if(userModel.isEmpty()) {
            userTypeRepo.deleteById(userTypeModel.getId());
            userTypeResponseDto.setUserType(userTypeRequestDto.getUserType());
            userTypeResponseDto.setId(userTypeModel.getId());
            userTypeResponseDto.setMessage(userTypeModel.getType()+" User Type Removed Successfully");
        }
        else {
            throw new UserTypeExistExceptions(userTypeModel.getType()+" user type is used, please remove from user first");
        }

        return userTypeResponseDto;
    }
}
