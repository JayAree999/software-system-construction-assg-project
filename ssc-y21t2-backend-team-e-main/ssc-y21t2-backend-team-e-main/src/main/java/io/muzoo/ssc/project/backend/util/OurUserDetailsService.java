package io.muzoo.ssc.project.backend.util;

import io.muzoo.ssc.project.backend.entity.UserDTO;
import io.muzoo.ssc.project.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

@Service
public class OurUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO u = userRepository.findFirstByUsername(username);
        if(u != null){
            return User.withUsername(u.getUsername())
                    .password(u.getPassword())
                    .roles(u.getRole())
                    .build();
        } else {
            throw new UsernameNotFoundException("Invalid username or password");
        }

    }
}
