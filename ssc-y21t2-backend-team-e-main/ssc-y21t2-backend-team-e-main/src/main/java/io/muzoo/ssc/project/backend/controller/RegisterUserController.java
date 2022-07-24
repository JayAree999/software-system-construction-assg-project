package io.muzoo.ssc.project.backend.controller;

import io.muzoo.ssc.project.backend.SimpleResponseDTO;
import io.muzoo.ssc.project.backend.entity.UserDTO;
import io.muzoo.ssc.project.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RegisterUserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/api/result_register")
    public SimpleResponseDTO processRegister(UserDTO u){
        try{
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if(principal != null && userRepository.findFirstByUsername(u.getUsername()) == null){
                u.setRole("USER");
                String encodePassword = passwordEncoder.encode(u.getPassword());
                u.setPassword(encodePassword);
                userRepository.save(u);
                return SimpleResponseDTO.
                        builder().
                        success(true).
                        message("You are successfully sign up").
                        build();
            }
            return SimpleResponseDTO.
                    builder().
                    success(false).
                    message("User is already exist").
                    build();

        } catch (Exception e) {
            e.printStackTrace();
            return SimpleResponseDTO.
                    builder().
                    success(false).
                    message(e.getMessage()).
                    build();
        }

    }
}
