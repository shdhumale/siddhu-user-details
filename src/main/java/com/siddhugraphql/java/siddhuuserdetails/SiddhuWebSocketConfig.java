package com.siddhugraphql.java.siddhuuserdetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class SiddhuWebSocketConfig implements WebSocketConfigurer {

    private final SiddhuGraphqlPublisher SiddhuGraphqlPublisher;

    @Autowired
    public SiddhuWebSocketConfig(SiddhuGraphqlPublisher SiddhuGraphqlPublisher) {
        this.SiddhuGraphqlPublisher = SiddhuGraphqlPublisher;
    }

    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new SiddhuWebSocketHandler(SiddhuGraphqlPublisher), "/stockticker").setAllowedOrigins("*");
    }
}

