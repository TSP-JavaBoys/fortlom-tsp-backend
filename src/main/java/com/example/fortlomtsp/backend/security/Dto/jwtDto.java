package com.example.fortlomtsp.backend.security.Dto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class jwtDto {
    private String token;

    public jwtDto() {
    }

    public jwtDto(String token) {
        this.token = token;
    }
}
