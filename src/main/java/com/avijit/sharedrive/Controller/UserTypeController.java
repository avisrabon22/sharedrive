package com.avijit.sharedrive.Controller;

import com.avijit.sharedrive.DTO.UserTypeRequestDto;
import com.avijit.sharedrive.Model.UserTypeModel;
import com.avijit.sharedrive.Service.UserTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/userType")
public class UserTypeController {
     private final UserTypeService userTypeService;

    public UserTypeController(UserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUserType(@RequestBody UserTypeRequestDto userTypeRequestDto) {
        userTypeService.addUserType(userTypeRequestDto);
        return ResponseEntity.ok().body("User Type Added Successfully");
    }
}
