package com.avijit.sharedrive.Controller;

import com.avijit.sharedrive.DTO.FileDetailsRequestDto;
import com.avijit.sharedrive.Service.FileHandlingInterface;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/file")
public class FileController {
    final private FileHandlingInterface fileHandlingInterface;

    public FileController(FileHandlingInterface fileHandlingInterface) {
        this.fileHandlingInterface = fileHandlingInterface;
    }

    @PostMapping("/upload")
    public String uploadFile(  FilePart file) {
        fileHandlingInterface.uploadFile(file);

        return "File uploaded";
    }
}
