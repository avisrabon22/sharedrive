package com.avijit.sharedrive.Controller;

import com.avijit.sharedrive.DTO.UserTypeRequestDto;
import com.avijit.sharedrive.DTO.UserTypeResponseDto;
import com.avijit.sharedrive.Exceptions.NotExistException;
import com.avijit.sharedrive.Exceptions.UserTypeExistExceptions;
import com.avijit.sharedrive.Service.UserTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/userType")
public class UserTypeController {
     private final UserTypeService userTypeService;

    public UserTypeController(UserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUserType(@RequestBody UserTypeRequestDto userTypeRequestDto) throws UserTypeExistExceptions, NotExistException {
        if (userTypeRequestDto.getUserType().isEmpty())
            throw new NotExistException("Empty user type");
        UserTypeResponseDto userTypeResponseDto=userTypeService.addUserType(userTypeRequestDto);

        return new ResponseEntity<>(userTypeResponseDto,HttpStatus.OK);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> removeUserType(@RequestBody UserTypeRequestDto userTypeRequestDto){
        UserTypeResponseDto userTypeResponseDto=userTypeService.UserTypeRemove(userTypeRequestDto);
        return new ResponseEntity<>(userTypeResponseDto,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getUserType(){
        return new ResponseEntity<>(userTypeService.GetUserType(),HttpStatus.OK);
    }

}
