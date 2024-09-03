package com.avijit.sharedrive.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class FileDetailsModel extends BaseModel{
    @Column(nullable = false)
    private String fileName;
    @Column(nullable = false)
    private String filePath;
    private String fileExtension;
    private Long fileSize;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private UserModel fileOwner;
}
