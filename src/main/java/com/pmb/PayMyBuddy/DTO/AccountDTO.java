package com.pmb.PayMyBuddy.DTO;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pmb.PayMyBuddy.util.DateHandler;
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
    @JsonDeserialize(using = DateHandler.class)
    private LocalDate birthDate;
    @Email
    private String mail;
    private String password;
    private double balance;


}
