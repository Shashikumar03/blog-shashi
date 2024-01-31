package com.example.blogshashi.payloads;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

}
