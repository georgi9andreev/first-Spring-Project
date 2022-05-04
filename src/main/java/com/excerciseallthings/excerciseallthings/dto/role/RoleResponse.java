package com.excerciseallthings.excerciseallthings.dto.role;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RoleResponse {

    private Long id;
    private String name;
}
