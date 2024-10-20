package ru.maxima.app.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class AccountDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
