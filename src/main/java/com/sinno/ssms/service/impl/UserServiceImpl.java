package com.sinno.ssms.service.impl;

import com.sinno.ssms.mapper.UserMapper;
import com.sinno.ssms.model.CustomUserDetails;
import com.sinno.ssms.model.dto.ChangePasswordModel;
import com.sinno.ssms.model.dto.UserDTO;
import com.sinno.ssms.model.entity.UserEntity;
import com.sinno.ssms.repository.UserRepository;
import com.sinno.ssms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.sinno.ssms.mapper.UserMapper.USER_MAPPER;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserEntity findUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public UserEntity createUser(UserDTO userDTO) {
        return userRepository.save(USER_MAPPER.dto2entity(userDTO));
    }

    @Override
    public UserEntity updatePassword(ChangePasswordModel changePasswordModel, int userId) {
        if (changePasswordModel.getId() != userId) {
            throw new BadCredentialsException("You can not change password of another userEntity!");
        }
        UserEntity userEntity = findUserById(changePasswordModel.getId());
        if (Objects.isNull(userEntity)) {
            throw new AuthenticationCredentialsNotFoundException("UserEntity with id " + changePasswordModel.getId() + " not found!");
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String encodePassword = bCryptPasswordEncoder.encode(changePasswordModel.getNewPassword());
        userEntity.setPassword(encodePassword);
        userRepository.save(userEntity);
        return userEntity;

    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(userEntity);
    }

    @Override
    public UserDetails loadUserById(int id) throws AuthenticationServiceException {
        UserEntity userEntity = userRepository.findById(id);
        if (userEntity == null) {
            throw new AuthenticationServiceException("UserEntity id not found!");
        }
        return new CustomUserDetails(userEntity);
    }

}
