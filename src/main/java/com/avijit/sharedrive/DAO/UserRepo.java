package com.avijit.sharedrive.DAO;

import com.avijit.sharedrive.Model.UserModel;
import com.avijit.sharedrive.Model.UserTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Long> {
    UserModel findByUserName(String userName);
    List<UserModel> findByUserRole_Id(Long userTypeId);
}
