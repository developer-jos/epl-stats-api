package com.josh.backend_solution.dtos.response;

public class HealthResponse {
    private String message;
    private String status;

    /**
     * Constructor to initialize the health response
     * @param message the health message
     * @param status the health status
     */
    public HealthResponse(String message, String status) {
        this.message = message;
        this.status = status;
    }
    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}

    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}

}
