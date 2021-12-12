package app.web.pavelk.chat2.back1.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfigSpringSession implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        registry.enableStompBrokerRelay("/queue/", "/topic")
                .setUserDestinationBroadcast("/topic/user.1u")
                .setUserRegistryBroadcast("/topic/registry.1b")
                .setRelayHost("localhost")
                .setRelayPort(61613);

        registry.setApplicationDestinationPrefixes("/app", "/chatroom");
    }
}
