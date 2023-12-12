package com.example.grpc;

import io.grpc.stub.StreamObserver;

/**
 * @author Fu Chen
 * @version 1.0
 */
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase{

    @Override
    public void greet(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
        //super.greet(request, responseObserver);
        String name = request.getName();
        String greeting = "Hello, "+name+"!";
        GreetingResponse response = GreetingResponse.newBuilder().setGreeting(greeting).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
