package com.sinno.ssms.service;

import com.sinno.ssms.model.dto.ChangePasswordModel;
import com.sinno.ssms.model.dto.UserDTO;
import com.sinno.ssms.model.entity.UserEntity;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserEntity findUserById(int id);

    UserEntity createUser(UserDTO userDTO);

    UserEntity updatePassword(ChangePasswordModel changePasswordModel, int userId);

    UserEntity findByUsername(String username);

    UserDetails loadUserById(int id) throws AuthenticationServiceException;

}
