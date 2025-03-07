package com.josh.backend_solution.services.impl;

import org.springframework.stereotype.Service;

@Service
public class PlayerManagementImpl {
    public void assignRoleToPlayer(String playerId, String role) {
        System.out.println("Assigned role: " + role + " to player ID: " + playerId);
    }
}
