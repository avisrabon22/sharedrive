package com.avijit.sharedrive.Service;

import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileHandlingInterface {
    public void uploadFile(MultipartFile file) throws IOException;

}
