package com.sinno.ssms.model;

import com.sinno.ssms.model.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    String accessToken;
    int id;
    UserDTO userDTO;
}
