package com.josh.backend_solution.dtos.response;

import java.util.List;

public class PermissionsResponse {
    private String playerId;
    private List<String> permissions;

    public PermissionsResponse(String playerId, List<String> permissions) {
        this.playerId = playerId;
        this.permissions = permissions;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}
