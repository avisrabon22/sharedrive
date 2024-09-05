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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false,name = "user_id")
    private UserModel fileOwner;
}
