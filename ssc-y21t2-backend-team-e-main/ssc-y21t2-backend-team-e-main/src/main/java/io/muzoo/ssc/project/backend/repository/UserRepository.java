package io.muzoo.ssc.project.backend.repository;

import io.muzoo.ssc.project.backend.entity.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;



@Repository

public interface UserRepository extends JpaRepository<UserDTO, Long> {


    UserDTO findFirstByUsername(String username);
    Optional<UserDTO> findUserById(Long userId);

}
