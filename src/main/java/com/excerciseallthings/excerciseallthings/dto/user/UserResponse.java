package com.excerciseallthings.excerciseallthings.dto.user;

import com.excerciseallthings.excerciseallthings.dto.role.RoleResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class UserResponse {

    private Long id;
    private String username;
    private RoleResponse roleResponse;
}
