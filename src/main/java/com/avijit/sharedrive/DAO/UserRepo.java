package com.avijit.sharedrive.DAO;

import com.avijit.sharedrive.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Long> {
    boolean existsByUserName(String userName);
}
