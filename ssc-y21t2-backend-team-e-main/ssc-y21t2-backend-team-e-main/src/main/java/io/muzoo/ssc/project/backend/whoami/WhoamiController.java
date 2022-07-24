package io.muzoo.ssc.project.backend.whoami;

import io.muzoo.ssc.project.backend.entity.UserDTO;
import io.muzoo.ssc.project.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A controller to retrieve currently logged-in user
 */
@Service
@RestController
public class WhoamiController {

    @Autowired
    private UserRepository userRepository;

    /**
     *  Make sure that all API path begins with /api. This will be useful when we do proxy.
     * @return
     */
    @GetMapping("/api/whoami")
    public WhoamiDTO whoami(){
        // Put try around the statement because we can nested dot notation which could raise a NullPointException.
        try{
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if(principal != null && principal instanceof org.springframework.security.core.userdetails.User){
                // user is logged in
                org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) principal;
                UserDTO u = userRepository.findFirstByUsername(user.getUsername());
                return WhoamiDTO.builder()
                        .loggedIn(true)
                        .name(u.getUsername()) // we don't have name field so i use username but you can add it yourself.
                        .role(u.getRole())
                        .username(u.getUsername())
                        .id(u.getId())

                        .build();
            }
        } catch(Exception e) {

        }
        return WhoamiDTO.builder()
                .loggedIn(false)
                .build();
    }



}
