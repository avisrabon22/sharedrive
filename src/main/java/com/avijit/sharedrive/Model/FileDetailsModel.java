package com.avijit.sharedrive.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileDetailsModel {
    private String fileName;
    private String fileExtension;
    private String fileSize;
    private UserModel fileOwner;
}
