package io.muzoo.ssc.project.backend;


//import io.muzoo.ssc.project.backend.discord.WebhookRequest;
//import io.muzoo.ssc.project.backend.discord.DiscordMessageServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@SpringBootApplication

public class WebApplication {

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(WebApplication.class, args);
	}


}
