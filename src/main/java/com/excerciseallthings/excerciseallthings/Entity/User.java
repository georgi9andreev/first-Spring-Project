package com.excerciseallthings.excerciseallthings.Entity;
import com.excerciseallthings.excerciseallthings.dto.user.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "users")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "full_name", length = 255)
    private String username;

    @Column (name = "ucn", length = 255)
    private String ucn;


    @Column (name = "password", length = 255)
    private String password;

    @ManyToOne (fetch = FetchType.LAZY)
    private Role role;


}
