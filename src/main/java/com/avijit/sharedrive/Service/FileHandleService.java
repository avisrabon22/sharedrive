package com.avijit.sharedrive.Service;

import com.avijit.sharedrive.DAO.FileHandleRepo;
import com.avijit.sharedrive.DTO.FileDetailsRequestDto;
import com.avijit.sharedrive.Model.FileDetailsModel;
import com.avijit.sharedrive.Model.UserModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileHandleService implements FileHandlingInterface{
    final private FileHandleRepo fileHandleRepo;

    @Value("${file.storage.location}")
    String storageLocation;
    public FileHandleService(FileHandleRepo fileHandleRepo) {
        this.fileHandleRepo = fileHandleRepo;

    }

    @Override
    public void uploadFile(MultipartFile file) throws IOException {
        FileDetailsModel fileDetailsModel= new FileDetailsModel();
        Path filePath = Paths.get(storageLocation,file.getOriginalFilename());

        Files.copy(file.getInputStream(),filePath);

        UserModel userModel = new UserModel();

        fileDetailsModel.setFileName(file.getOriginalFilename());
        fileDetailsModel.setFileExtension(file.getContentType());
        fileDetailsModel.setFilePath(file.toString());
        fileDetailsModel.setFileSize(file.getSize());
        userModel.setUserName("Avijit");
        fileDetailsModel.setFileOwner(userModel);

        fileHandleRepo.save(fileDetailsModel);
    }
}
