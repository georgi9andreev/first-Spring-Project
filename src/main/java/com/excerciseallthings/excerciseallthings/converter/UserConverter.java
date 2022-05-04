package com.excerciseallthings.excerciseallthings.converter;


import com.excerciseallthings.excerciseallthings.Entity.User;
import com.excerciseallthings.excerciseallthings.dto.user.UserResponse;
import com.excerciseallthings.excerciseallthings.dto.user.UserSaveRequest;
import lombok.Builder;
import org.springframework.stereotype.Component;
@Builder
@Component
public class UserConverter {


    private final RoleConverter roleConverter;

    public UserConverter(RoleConverter roleConverter) {
        this.roleConverter = roleConverter;
    }

    public User convert (UserSaveRequest userSaveRequest) {
        return User.builder()
                .username(userSaveRequest.getUsername())
                .password(userSaveRequest.getPassword())
                .build();
    }


    public UserResponse convert (User user) {

        return UserResponse.builder()
                .id(user.getRole().getId())
                .username(user.getRole().getName())
                .roleResponse(roleConverter.convert(user.getRole()))
                .build();


//        Друг начин:
//         .roleResponse(roleConverter.convert(user.getRole())))
//         като горе добавяме -> Private final RoleConverter roleConverter + @AllArgsConstructor

    }
}


