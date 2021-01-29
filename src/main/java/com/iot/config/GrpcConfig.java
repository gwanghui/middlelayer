package com.iot.config;

import com.iot.service.HelloWorldService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class GrpcConfig {
//    @Bean
//    public Server getGrpcServer() throws IOException, InterruptedException {
//        Server server = ServerBuilder.forPort(50051).addService(new HelloWorldService()).build().start();
//        if(server == null) {
//            return null;
//        }
//        server.awaitTermination();
//        return server;
//    }
}
