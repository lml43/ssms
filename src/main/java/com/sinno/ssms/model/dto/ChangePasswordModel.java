package com.sinno.ssms.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordModel implements Serializable {
    private int id;
    private String currentPassword;
    private String newPassword;
}
