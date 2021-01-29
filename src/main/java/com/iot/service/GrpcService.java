package com.iot.service;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class GrpcService implements ApplicationRunner {
    private static final int PORT = 3030;
    private static final Server server = ServerBuilder.forPort(PORT)
            .addService(new HelloWorldService())
            .build();


    @Override
    public void run(ApplicationArguments args) throws Exception {
        server.start();
    }
}
