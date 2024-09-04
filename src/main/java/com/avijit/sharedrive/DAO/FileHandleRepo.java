package com.avijit.sharedrive.DAO;

import com.avijit.sharedrive.Model.FileDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileHandleRepo extends JpaRepository<FileDetailsModel, Long> {

}
