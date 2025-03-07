package com.josh.backend_solution.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetPlayerResponse {
    private Long id;
    private String name;
    private String nation;
    private String pos;
    private Integer age;
    private Integer mp;
    private Integer starts;
    private Double min;
    private Double gls;
    private Double ast;
    private String team;
}
