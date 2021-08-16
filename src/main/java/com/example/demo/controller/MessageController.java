package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@Autowired
	SimpMessageSendingOperations smso;
	
	@MessageMapping("/message")
	@SendTo("/topic/message")
	public String send(@Payload String message) {
		System.out.println(message);
		return message;
	}
	
	@MessageMapping("/sendMessage/{username}/{message}")
	@SendTo("/topic/sendMessage/{username}")
	public String chat(@DestinationVariable String username,@DestinationVariable String message) {
		if(username==null || username.length()<=1)
			username="ana";
		return username+" "+message;
	}
}
