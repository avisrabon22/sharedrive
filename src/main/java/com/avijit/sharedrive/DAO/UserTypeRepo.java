package com.avijit.sharedrive.DAO;


import com.avijit.sharedrive.Model.UserTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserTypeRepo extends JpaRepository<UserTypeModel,Long> {
    Optional<UserTypeModel> findByType(String type);
    boolean existsByType(String type);
}
