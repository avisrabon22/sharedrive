package com.avijit.sharedrive.Controller;

import com.avijit.sharedrive.DTO.SignUpRequestDto;
import com.avijit.sharedrive.Exceptions.UserExist;
import com.avijit.sharedrive.Service.UserSignUpInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/public")
public class SignUpController {
    private final UserSignUpInterface userSignUpInterface;

    public SignUpController(UserSignUpInterface userSignUpInterface) {
        this.userSignUpInterface = userSignUpInterface;
    }


    @PostMapping("/signup")
    public ResponseEntity<?> signUpUser(@RequestBody SignUpRequestDto signUpRequestDto) throws UserExist {
        userSignUpInterface.signUpUser(signUpRequestDto);

        return new ResponseEntity<>("User Signed Up Successfully", HttpStatus.OK);
    }
}
