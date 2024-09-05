package com.avijit.sharedrive.DAO;


import com.avijit.sharedrive.Model.UserTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepo extends JpaRepository<UserTypeModel,Long> {
    UserTypeModel findByType(String type);
}
