package com.avijit.sharedrive.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class FileDetailsModel extends BaseModel{
    @Column(nullable = false)
    private String fileName;
    private String fileExtension;
    private String fileSize;
    @ManyToOne
    @JoinColumn(name = "file_owner_id")
    private UserModel fileOwner;
}
