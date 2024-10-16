package com.avijit.sharedrive.Service;
import ch.qos.logback.core.util.StringUtil;
import com.avijit.sharedrive.DAO.FileHandleRepo;
import com.avijit.sharedrive.DAO.UserRepo;
import com.avijit.sharedrive.DTO.FileDetailsRequestDto;
import com.avijit.sharedrive.DTO.FileDetailsResponseDto;
import com.avijit.sharedrive.Model.FileDetailsModel;
import com.avijit.sharedrive.Model.UserModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.Optional;

@Service
public class FileHandleService implements FileHandlingInterface{
    final private FileHandleRepo fileHandleRepo;
    final private UserRepo userRepo;
    final private Path storageLocation;

    public FileHandleService(@Value("${file.storage.location}")String storageLocation, FileHandleRepo fileHandleRepo, UserRepo userRepo) throws IOException {
        this.fileHandleRepo = fileHandleRepo;
        this.userRepo = userRepo;
        this.storageLocation = Paths.get(storageLocation)
                                    .toAbsolutePath()
                                    .normalize();
        Files.createDirectories(this.storageLocation);
    }

    @Override
    public void uploadFile(MultipartFile file) throws IOException {
        FileDetailsModel fileDetailsModel = new FileDetailsModel();
//    get the file name in simple text
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        Path filePathToSave = this.storageLocation.resolve(fileName);
//   copy the file to the target location (replacing existing file with the same name)
        Files.copy(file.getInputStream(),filePathToSave, StandardCopyOption.REPLACE_EXISTING);
//    set the file details
        Optional<UserModel> userModel;
        fileDetailsModel.setFileName(file.getOriginalFilename());
        fileDetailsModel.setFileExtension(file.getContentType());
        fileDetailsModel.setFilePath(filePathToSave.toString());
        fileDetailsModel.setFileSize(file.getSize());
//Fetch the user from the database to set the file owner
        userModel = userRepo.findByUserName("avisrabon22@gmail.com");
        if (userModel.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        UserModel user = userModel.get();
        fileDetailsModel.setFileOwner(user);
//   save the file details to the database
        fileHandleRepo.save(fileDetailsModel);
    }

    @Override
    public FileDetailsResponseDto downloadFile(Long fileId) throws MalformedURLException {
        FileDetailsModel fileDetailsModel;
            fileDetailsModel=fileHandleRepo.findById(fileId).orElse(null);

            FileDetailsResponseDto fileDetailsResponseDto = new FileDetailsResponseDto();
        assert fileDetailsModel != null;
        fileDetailsResponseDto.setFileName(fileDetailsModel.getFileName());
        fileDetailsResponseDto.setUrl(fileDetailsModel.getFilePath());
        return  fileDetailsResponseDto;
    }


}

