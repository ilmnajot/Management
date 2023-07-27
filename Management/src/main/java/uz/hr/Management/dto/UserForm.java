package uz.hr.Management.dto;

import lombok.Data;

@Data
public class UserForm {
    private String name;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
}
