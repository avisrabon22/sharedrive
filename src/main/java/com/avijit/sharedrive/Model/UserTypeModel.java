package com.avijit.sharedrive.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserTypeModel extends BaseModel {
    @Column(nullable = false,unique = true)
    private String type;
}
