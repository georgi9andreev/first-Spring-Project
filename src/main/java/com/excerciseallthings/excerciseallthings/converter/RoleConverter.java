package com.excerciseallthings.excerciseallthings.converter;


import com.excerciseallthings.excerciseallthings.Entity.Role;
import com.excerciseallthings.excerciseallthings.dto.role.RoleResponse;
import com.excerciseallthings.excerciseallthings.dto.role.RoleSaveRequest;
import com.excerciseallthings.excerciseallthings.dto.role.RoleUpdateRequest;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {

    //това е метод, който да ни конвертира от RoleSaveReques към Role
    public Role convert (RoleSaveRequest roleSaveRequest){
        return Role.builder()
                .name(roleSaveRequest.getName())
                .build();
    }

    //от Role iskame da сглобим RoleResponse само с име
    public RoleResponse convert (Role role){
        return RoleResponse.builder()
                .id(role.getId())
                .name(role.getName())
                .build();
    }

    public Role convert (RoleUpdateRequest roleUpdateRequest){
        return Role.builder()
                .id(roleUpdateRequest.getId())
                .name(roleUpdateRequest.getName())
                .build();
    }
}
