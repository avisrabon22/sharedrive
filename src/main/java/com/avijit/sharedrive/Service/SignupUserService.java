package com.avijit.sharedrive.Service;

import com.avijit.sharedrive.DAO.UserRepo;
import com.avijit.sharedrive.DTO.SignUpRequestDto;
import com.avijit.sharedrive.Exceptions.UserExist;
import com.avijit.sharedrive.Model.UserModel;
import com.avijit.sharedrive.Model.UserTypeModel;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class SignupUserService implements UserSignUpInterface {
    private final UserRepo userRepo;
    private final DataSource dataSource;
    private final PasswordEncoder passwordEncoder;

    public SignupUserService(UserRepo userRepo, DataSource dataSource, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.dataSource = dataSource;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void signUpUser(SignUpRequestDto signUpRequestDto) throws UserExist {
        UserModel userModel = new UserModel();
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        if (jdbcUserDetailsManager.userExists(signUpRequestDto.getUserName()))
            throw new UserExist("User already exist!");

        UserDetails user = User
                .withUsername(signUpRequestDto.getUserName())
                .password(passwordEncoder.encode(signUpRequestDto.getUserPassword()))
                .roles(signUpRequestDto.getUserRole())
                .build();

        jdbcUserDetailsManager.createUser(user);
    }



}
