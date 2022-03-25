package com.pmb.PayMyBuddy.DTO;

import lombok.*;

import javax.validation.constraints.Email;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    @Email
    private String mail;
    private String password;
    private double balance;


}
