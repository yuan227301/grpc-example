package com.example;

import com.example.grpc.GreetingServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @author Fu Chen
 * @version 1.0
 */
public class GreetingServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8080)
                .addService(new GreetingServiceImpl())
                .build();
        server.start();
        System.out.println("server start on 8080");
        server.awaitTermination();
    }
}
