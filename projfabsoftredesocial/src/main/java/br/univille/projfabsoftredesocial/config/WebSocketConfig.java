package br.univille.projfabsoftredesocial.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import br.univille.projfabsoftredesocial.controller.ChatController;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSocket

public class WebSocketConfig implements WebSocketConfigurer {
    @Autowired
    private ChatController chatController;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(chatController, "/ws/chat").setAllowedOrigins("*");
    }
}