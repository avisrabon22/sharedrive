package com.avijit.sharedrive.Service;

import com.avijit.sharedrive.DAO.FileHandleRepo;
import com.avijit.sharedrive.DTO.FileDetailsRequestDto;
import com.avijit.sharedrive.Model.FileDetailsModel;
import com.avijit.sharedrive.Model.UserModel;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;

@Service
public class FileHandleService implements FileHandlingInterface{
    final private FileHandleRepo fileHandleRepo;
    public FileHandleService(FileHandleRepo fileHandleRepo) {
        this.fileHandleRepo = fileHandleRepo;

    }

    @Override
    public void uploadFile(FilePart file) {
        FileDetailsModel fileDetailsModel= new FileDetailsModel();
        UserModel userModel = new UserModel();
        String fileName = file.filename();
        fileDetailsModel.setFileName(fileName);
        fileDetailsModel.setFileExtension("exe");
        fileDetailsModel.setFileSize("1K");
         userModel.setUserName("Avijit");
        fileDetailsModel.setFileOwner(userModel);

        fileHandleRepo.save(fileDetailsModel);
    }
}
