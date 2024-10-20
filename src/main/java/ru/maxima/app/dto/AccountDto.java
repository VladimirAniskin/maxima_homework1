package ru.maxima.app.dto;


import lombok.*;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
