package com.example.application.data.service;

import org.springframework.stereotype.Service;

import java.io.Serializable;

@SuppressWarnings("serial")
@Service
public class AbstractAsyncClientService implements Serializable {
    public static interface AsyncRestCallback<T> {
        void operationFinished(T results);
    }
}
