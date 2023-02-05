package com.allavona.tfg.api.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Login {
    private String username;
    private String password;
}
