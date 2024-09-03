package com.avijit.sharedrive.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class SignUpController {

    @PostMapping
    public String signUpUser() {
        return "User Signed Up";
    }


}
