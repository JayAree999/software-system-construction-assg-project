package io.muzoo.ssc.project.backend.discord;

import io.muzoo.ssc.project.backend.entity.Todo;
import io.muzoo.ssc.project.backend.entity.UserDTO;
import io.muzoo.ssc.project.backend.repository.UserRepository;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;


@Component
@Data
@Transactional
@EnableScheduling
public class WebhookRequest  {

    @Autowired
    private UserRepository userRepository;

    private String webhookUrl;
    private String sender;
    private String senderProfile;
    private String message;
    private DiscordWebhookMessage discordWebhookMessage;
    private List<UserDTO> userDTOList = new ArrayList<>();


    public void sendDiscordWebHook(DiscordWebhookMessage discordWebhookMessage) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<DiscordWebhookMessage> entity = new HttpEntity(discordWebhookMessage, headers);
        RestTemplate rt = new RestTemplate();

        ResponseEntity<String> response;
        try {
            response = rt.exchange(
                    this.getWebhookUrl(),
                    HttpMethod.POST,
                    entity,
                    String.class);

        } catch (Exception e) {

        }
    }


        @Scheduled(fixedRate = 600000)
        public void toDiscordWebhookMessage () {
        try{

            userDTOList.addAll(userRepository.findAll());
            StringBuilder totalMessage = new StringBuilder();

            for (int i =0; i<userDTOList.size();i++) {

                UserDTO userInList = userDTOList.get(i);
                discordWebhookMessage = new DiscordWebhookMessage();
                discordWebhookMessage.setUsername(getSender());
                discordWebhookMessage.setAvatarUrl(getSenderProfile());
                String message;
                String username = userInList.getUsername();
                UserDTO userFirst = userRepository.findFirstByUsername(username);
                webhookUrl = userInList.getDiscordWebHook();
                //System.out.println(webhookUrl);
                List<Todo> todoList = userFirst.getTodoList();
                LocalDate nextDueDate = LocalDate.MAX;
                String nextTodo = "";
                for (Todo value : todoList) {
                    // Check for assignment with earliest due date
                    LocalDate dueDate = LocalDate.parse(value.getDueDate());
                    if (dueDate.isBefore(nextDueDate)) {
                        nextDueDate = dueDate;
                        nextTodo = value.getContent();
                    }
                }
                // Discord message for the user
                message = String.format("Hello, **%s**!\nYou have %s incomplete assignments.\nYour next assignment is:\n**%s** | **%s**\nTo view your full list of assignments, visit our [website](https://ssc-hw4.xyz).\n\n",
                        username, todoList.size(), nextTodo, nextDueDate);

                totalMessage.append(message);

                discordWebhookMessage.setContent(totalMessage.toString());
                this.sendDiscordWebHook(discordWebhookMessage);
                totalMessage.setLength(0);
                if (i == userDTOList.size()-1){
                    userDTOList.clear();
                }


            }

            } catch (ConcurrentModificationException e){

        }
        }


    }
