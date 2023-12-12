package com.example;

import com.example.grpc.GreetingRequest;
import com.example.grpc.GreetingResponse;
import com.example.grpc.GreetingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author Fu Chen
 * @version 1.0
 */
public class GreetingClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();
        GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);

        GreetingRequest request = GreetingRequest.newBuilder().setName("yang").build();
        GreetingResponse response = stub.greet(request);
        System.out.println("response = " + response.getGreeting());
        channel.shutdown();
    }
}
