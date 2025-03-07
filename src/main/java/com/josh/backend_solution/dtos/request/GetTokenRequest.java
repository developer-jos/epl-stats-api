package com.josh.backend_solution.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetTokenRequest {
    private String username;
    private String password;
}
