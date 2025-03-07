package com.josh.backend_solution.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GrantPermissionRequest {
    private String playerId;
    private String permission;
}
