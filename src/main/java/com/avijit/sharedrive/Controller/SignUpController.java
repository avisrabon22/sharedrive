package com.avijit.sharedrive.Controller;

import com.avijit.sharedrive.DTO.SignUpRequestDto;
import com.avijit.sharedrive.Service.UserSignUpInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
public class SignUpController {
    private final UserSignUpInterface userSignUpInterface;
    private ResponseEntity<String> userSignedUp;

    public SignUpController(UserSignUpInterface userSignUpInterface) {
        this.userSignUpInterface = userSignUpInterface;
    }

    @PostMapping()
    public ResponseEntity<String> signUpUser(@RequestBody SignUpRequestDto signUpRequestDto){
        userSignUpInterface.signUpUser(signUpRequestDto);

        return userSignedUp;
    }
}
