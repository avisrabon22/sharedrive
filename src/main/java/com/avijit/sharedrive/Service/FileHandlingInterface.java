package com.avijit.sharedrive.Service;

import com.avijit.sharedrive.DTO.FileDetailsRequestDto;
import com.avijit.sharedrive.DTO.FileDetailsResponseDto;
import com.avijit.sharedrive.Model.FileDetailsModel;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

public interface FileHandlingInterface {
    public void uploadFile(MultipartFile file) throws IOException;

    public FileDetailsResponseDto downloadFile(Long fileId) throws MalformedURLException;
}
