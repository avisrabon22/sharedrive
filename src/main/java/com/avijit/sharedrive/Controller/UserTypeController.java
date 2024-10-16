package com.avijit.sharedrive.Controller;
import com.avijit.sharedrive.DTO.UserTypeRequestDto;
import com.avijit.sharedrive.DTO.UserTypeResponseDto;
import com.avijit.sharedrive.Exceptions.NotExistException;
import com.avijit.sharedrive.Exceptions.UserTypeExistExceptions;
import com.avijit.sharedrive.Service.UserTypeInterface;
import com.avijit.sharedrive.Service.UserTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/userType")
public class UserTypeController {
     private final UserTypeInterface userTypeService;

    public UserTypeController(UserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }

// Get the all user type from the database *********************************
@PreAuthorize("hasRole('ADMIN')")
@GetMapping("/all")
public ResponseEntity<?> getUserType(){
    return new ResponseEntity<>(userTypeService.GetUserType(),HttpStatus.OK);
}

    // Add the user type to the database *********************************
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<?> addUserType(@RequestBody UserTypeRequestDto userTypeRequestDto) throws UserTypeExistExceptions, NotExistException {
        if (userTypeRequestDto.getUserType().isEmpty())
            throw new NotExistException("Empty user type");
        UserTypeResponseDto userTypeResponseDto=userTypeService.addUserType(userTypeRequestDto);

        return new ResponseEntity<>(userTypeResponseDto,HttpStatus.OK);
    }

    //    Remove the user type from the database *********************************
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/remove")
    public ResponseEntity<?> removeUserType(@RequestBody UserTypeRequestDto userTypeRequestDto){
        UserTypeResponseDto userTypeResponseDto=userTypeService.UserTypeRemove(userTypeRequestDto);
        return new ResponseEntity<>(userTypeResponseDto,HttpStatus.OK);
    }

}
