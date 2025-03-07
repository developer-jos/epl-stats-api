package com.josh.backend_solution.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetTokenResponse {
    private String accessToken;
    private String tokenType;
    private Integer expiresIn;
}
