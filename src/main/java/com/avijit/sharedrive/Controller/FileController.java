package com.avijit.sharedrive.Controller;

import com.avijit.sharedrive.DTO.FileDetailsRequestDto;
import com.avijit.sharedrive.Service.FileHandlingInterface;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        fileHandlingInterface.uploadFile(file);

        return "File uploaded";
    }
}
