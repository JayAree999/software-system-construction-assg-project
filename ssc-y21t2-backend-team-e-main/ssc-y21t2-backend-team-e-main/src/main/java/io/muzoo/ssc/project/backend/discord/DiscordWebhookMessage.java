package io.muzoo.ssc.project.backend.discord;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Repository
public class DiscordWebhookMessage {

    @JsonProperty("username")
    private String username;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    @JsonProperty("content")
    private String content;
}