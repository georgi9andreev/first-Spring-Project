package com.excerciseallthings.excerciseallthings.reposotiry;

import com.excerciseallthings.excerciseallthings.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long>{
}
