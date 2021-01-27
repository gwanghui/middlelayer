package com.iot.config;

import io.moquette.broker.Server;
import io.moquette.broker.config.MemoryConfig;
import io.moquette.interception.InterceptHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Properties;

@Configuration
public class MqttBrokerConfig {
    @Bean
    public Server getServer() throws IOException {
        Properties properties = new Properties();
        MemoryConfig config = new MemoryConfig(properties);
        Server mqttBroker = new Server();
        mqttBroker.startServer(config);
        mqttBroker.addInterceptHandler(getInterceptHandler());
        Runtime.getRuntime().addShutdownHook(new Thread(mqttBroker::stopServer));

        return mqttBroker;
    }

    private InterceptHandler getInterceptHandler() {
        return new LogInterceptHandler();
    }
}
