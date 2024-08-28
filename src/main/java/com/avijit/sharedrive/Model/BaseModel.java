package com.avijit.sharedrive.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @GeneratedValue(generator = "uuid")
    @Id
    private String id;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;
}
