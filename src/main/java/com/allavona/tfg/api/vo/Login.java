package com.allavona.tfg.api.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Login {
    private String username;
    private String password;
}
