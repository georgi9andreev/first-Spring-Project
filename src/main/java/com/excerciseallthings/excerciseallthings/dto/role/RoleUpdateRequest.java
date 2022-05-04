package com.excerciseallthings.excerciseallthings.dto.role;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor

public class RoleUpdateRequest {

    @NotNull (message = "Id should not be null")
    private Long id;
    @NotNull  (message = "Name should not be null")
    private String name;
}
