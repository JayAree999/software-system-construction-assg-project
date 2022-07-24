package io.muzoo.ssc.project.backend;

import io.muzoo.ssc.project.backend.entity.Todo;
import io.muzoo.ssc.project.backend.entity.UserDTO;
import io.muzoo.ssc.project.backend.repository.TodoRepository;
import io.muzoo.ssc.project.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class InitApplicationRunner implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // add default admin user and set password if missing
        UserDTO admin = userRepository.findFirstByUsername("admin");

        if (admin == null) {
            admin = new UserDTO();
            admin.setUsername("admin");

            admin.setLineID("poon12135");
            admin.setEmail("worwitpoon@gmail.com");
            admin.setDiscordWebHook("https://discord.com/api/webhooks/961787819980886067/YGTpUhjNmH2VHPYUXrTq1covTTMJdOTQ49J-6HzRD2g3KWk2E6wOFUrhxeqn9Vegctzs");
            admin.setPassword(passwordEncoder.encode("123456"));

            admin.setRole("ADMIN");
            Todo todo = new Todo();
            todo.setTodoID(1L);
            todo.setContent("Upload video to YT");
            todo.setDueDate("2023-12-27");
            admin.getTodoList().add(todo);
            todoRepository.save(todo);
            userRepository.save(admin);

        }

    }



}
