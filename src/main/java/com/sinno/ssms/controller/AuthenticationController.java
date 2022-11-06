package com.sinno.ssms.controller;

import com.sinno.ssms.config.JwtTokenProvider;
import com.sinno.ssms.model.CustomUserDetails;
import com.sinno.ssms.model.LoginRequest;
import com.sinno.ssms.model.LoginResponse;
import com.sinno.ssms.model.dto.ChangePasswordModel;
import com.sinno.ssms.model.dto.UserDTO;
import com.sinno.ssms.model.entity.UserEntity;
import com.sinno.ssms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

import static com.sinno.ssms.mapper.UserMapper.USER_MAPPER;

@RestController
@CrossOrigin()
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public LoginResponse authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );


        SecurityContextHolder.getContext().setAuthentication(authentication);
        CustomUserDetails userInfo = (CustomUserDetails) authentication.getPrincipal();
        String jwt = tokenProvider.generateToken(userInfo);
        UserDTO userDTO = USER_MAPPER.entity2dto(userService.findByUsername(userInfo.getUsername()));
        return new LoginResponse(jwt, userInfo.getUserId(), userDTO);
    }

    @PostMapping("/change-password")
    public ResponseEntity changePassword(@RequestBody ChangePasswordModel changePasswordModel, @RequestHeader(name = "Authorization") String token) {

        Long userIdFromJWT = tokenProvider.getUserIdFromJWT(token, true);

        UserEntity userEntity = userService.updatePassword(changePasswordModel, userIdFromJWT.intValue());

        if (Objects.nonNull(userEntity)) {
            return ResponseEntity.ok("Change password success!");
        } else {
            return ResponseEntity.ok("Process error!!");
        }

    }
}
