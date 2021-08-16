package com.example.demo.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSocketMessageBroker
public class MessageConfiguration extends AbstractWebSocketMessageBrokerConfigurer {
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/topic/","/queue/","/user/");
		config.setApplicationDestinationPrefixes("/ws");
	}
	@Override
	public void registerStompEndpoints(StompEndpointRegistry stmp) {
		stmp.addEndpoint("/greeting").setAllowedOrigins("http://localhost:8081/")
		.withSockJS();
	}

}
