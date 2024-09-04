package com.avijit.sharedrive.Controller;

import com.avijit.sharedrive.DTO.FileDetailsResponseDto;
import com.avijit.sharedrive.Service.FileHandlingInterface;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

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

    @GetMapping("/download/{fileId}")
    public ResponseEntity<FileDetailsResponseDto> downloadFile(@PathVariable Long  fileId) throws IOException {
                          FileDetailsResponseDto fileDetailsResponseDto=fileHandlingInterface.downloadFile(fileId);

        return ResponseEntity.ok().body(fileDetailsResponseDto);
    }
}
