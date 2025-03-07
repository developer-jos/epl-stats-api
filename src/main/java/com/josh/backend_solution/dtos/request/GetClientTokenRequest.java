package com.josh.backend_solution.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetClientTokenRequest {
    private String clientId;
    private String clientSecret;
}
