package com.avijit.sharedrive.Service;

import com.avijit.sharedrive.DAO.UserRepo;
import com.avijit.sharedrive.DAO.UserTypeRepo;
import com.avijit.sharedrive.DTO.SignUpRequestDto;
import com.avijit.sharedrive.Exceptions.NotExistException;
import com.avijit.sharedrive.Exceptions.UserExist;
import com.avijit.sharedrive.Model.UserModel;
import com.avijit.sharedrive.Model.UserTypeModel;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class SignupUserService implements UserSignUpInterface {
    private final UserRepo userRepo;
    private final UserTypeRepo userTypeRepo;
    private final PasswordEncoder passwordEncoder;

    public SignupUserService(UserRepo userRepo, UserTypeRepo userTypeRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.userTypeRepo = userTypeRepo;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void signUpUser(SignUpRequestDto signUpRequestDto) throws UserExist {
        UserModel userModel = new UserModel();
        UserModel user = userRepo.findByUserName(signUpRequestDto.getUserName());
        UserTypeModel userTypeModel = userTypeRepo.findByType(signUpRequestDto.getUserRole());

        if (user != null)
            throw new UserExist("User already exist!");

        if (userTypeModel == null)
            throw new NotExistException("User Type not found!");

        userModel.setUserName(signUpRequestDto.getUserName());
        userModel.setUserPassword(passwordEncoder.encode(signUpRequestDto.getUserPassword()));
        userModel.setUserFullName(signUpRequestDto.getUserFullName());
        userModel.setUserPhone(signUpRequestDto.getUserPhone());
        userModel.setUserAddress(signUpRequestDto.getUserAddress());
        userModel.setUserRole(userTypeModel);
        userRepo.save(userModel);
        }



}
