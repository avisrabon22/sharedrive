package com.avijit.sharedrive.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileDetailsRequestDto {
    private String fileName;
    private String fileExtension;
    private String fileSize;
    private String ownerName;
}
