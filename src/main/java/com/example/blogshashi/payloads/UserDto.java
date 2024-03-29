package com.example.blogshashi.payloads;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private Long id;
    @NotNull
    @NotBlank
    @NotEmpty
    private String name;
    @NotNull
    @Email
    @NotBlank
    @NotEmpty
    private String email;
    @NotNull
    @NotEmpty
    @Size(min = 3,max = 15, message = "password must be of 3 to 15 digits")
    private String password;
    @NotBlank
    private String about;

    private Set<RoleDto> roles = new HashSet<>();

}
