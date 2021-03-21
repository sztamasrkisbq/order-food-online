package com.example.application.data.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.Serializable;

@SuppressWarnings("serial")
@Service
public class AsyncRestClientService implements Serializable {
    public static interface AsyncRestCallback<T> {
        void operationFinished(T results);
    }

    public void getDataBack(AsyncRestCallback<String> callback) {

        System.out.println("Setting up fetching all Comment objects through REST..");

        WebClient.RequestHeadersSpec<?> spec = WebClient.create().get().uri("http://localhost:888/greeting");

        spec.retrieve().toEntity(String.class).subscribe(result -> {

            final String comments = result.getBody();
            System.out.println(comments);
            callback.operationFinished(comments);
        });
    }
    }
