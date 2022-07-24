package io.muzoo.ssc.project.backend.controller;

import io.muzoo.ssc.project.backend.SimpleResponseDTO;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthenticationController {

    @GetMapping("/api/test")
    public String test(){
        return "If this message is shown, it means login is successful because we didn't set to permit this path.";
    }

    @PostMapping("/api/register")
    public SimpleResponseDTO register(HttpServletRequest request){
        //request.setAttribute("user", new UserDTO());
        return SimpleResponseDTO.
                builder().
                success(true).
                message("You are registered successfully").
                build();
    }

    @PostMapping("/api/login")
    public SimpleResponseDTO login(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            // Check if there a current user logged in, if so log that user out first
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if(principal != null && principal instanceof org.springframework.security.core.userdetails.User){
                request.logout();
            }

            // logging in twice hash an error
            request.login(username, password);
            return SimpleResponseDTO.
                            builder().
                            success(true).
                            message("You are logged in successfully").
                            build();
        } catch (ServletException e) {
            return SimpleResponseDTO.
                            builder().
                            success(false).
                            message(e.getMessage()).
                            build();
        }
    }
    @GetMapping("/api/logout")
    public SimpleResponseDTO logout(HttpServletRequest request){
        try {
            request.logout();
            return SimpleResponseDTO.
                            builder().
                            success(true).
                            message("You are successfully logged out").
                            build();
        } catch (ServletException e) {
            return SimpleResponseDTO.
                            builder().
                            success(false).
                            message(e.getMessage()).
                            build();
        }

    }
}
