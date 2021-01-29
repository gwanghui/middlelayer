package com.iot.service;

import io.grpc.stub.StreamObserver;

public class HelloWorldService extends HelloServiceGrpc.HelloServiceImplBase{
    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        System.out.println(
                "Handling hello endpoint: " + request.toString());


        String text = request.getFirstName() + " World";
        HelloResponse response =
                HelloResponse.newBuilder()
                        .setGreeting(text).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
