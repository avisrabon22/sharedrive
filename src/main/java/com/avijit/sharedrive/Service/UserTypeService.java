package com.avijit.sharedrive.Service;

import com.avijit.sharedrive.DAO.UserTypeRepo;
import com.avijit.sharedrive.DTO.UserTypeRequestDto;
import com.avijit.sharedrive.Model.UserTypeModel;
import org.springframework.stereotype.Service;

@Service
public class UserTypeService {
private  final UserTypeRepo userTypeRepo;

    public UserTypeService(UserTypeRepo userTypeRepo) {
        this.userTypeRepo = userTypeRepo;
    }

    public void addUserType(UserTypeRequestDto userTypeRequestDto) {
        UserTypeModel userTypeModel = new UserTypeModel();
        userTypeModel.setType(userTypeRequestDto.getUserType());
        userTypeRepo.save(userTypeModel);
    }

}
