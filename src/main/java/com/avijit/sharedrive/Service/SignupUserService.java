package com.avijit.sharedrive.Service;

import com.avijit.sharedrive.DAO.UserRepo;
import com.avijit.sharedrive.DTO.SignUpRequestDto;
import com.avijit.sharedrive.Model.UserModel;
import com.avijit.sharedrive.Model.UserTypeModel;
import org.springframework.stereotype.Service;

@Service
public class SignupUserService implements UserSignUpInterface{
    private  final UserRepo userRepo;

    public SignupUserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public boolean existsByUsername(String userName) {
        return false;
    }

    @Override
    public void signUpUser(SignUpRequestDto signUpRequestDto) {
        UserModel userModel = new UserModel();
        userModel.setUserName(signUpRequestDto.getUserName());
        userModel.setUserPassword(signUpRequestDto.getUserPassword());
        userModel.setUserPhone(signUpRequestDto.getUserPhone());
        userModel.setUserAddress(signUpRequestDto.getUserAddress());
        UserTypeModel userTypeModel = new UserTypeModel();
        userTypeModel.setType(signUpRequestDto.getUserRole());
        userModel.setUserRole(userTypeModel);
        userRepo.save(userModel);
    }
}
