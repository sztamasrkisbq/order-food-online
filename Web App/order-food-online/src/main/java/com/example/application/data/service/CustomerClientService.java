package com.example.application.data.service;

import com.example.application.data.entity.Customer;
import com.example.application.data.entity.Restaurant;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@SuppressWarnings("serial")
@Service
public class CustomerClientService extends AbstractAsyncClientService {

    public  void getRestaurantList(AsyncRestCallback<List<Restaurant>> callback) {
        System.out.println("Setting up fetching all Comment objects through REST..");

        WebClient.RequestHeadersSpec<?> spec = WebClient.create().get().uri("http://localhost:888/customer/getRestaurants");

        spec.retrieve().toEntityList(Restaurant.class).subscribe(result -> {

            System.out.println(result.toString());
            final List<Restaurant> comments = result.getBody();
            callback.operationFinished(comments);
        });
    }
    public  void registerCustomer(Customer c, AsyncRestCallback<Boolean> callback) {
        System.out.println("Register REST..");
        System.out.println(c.toString());

        WebClient.RequestHeadersSpec<?> spec = WebClient.create().post().uri("http://localhost:888/customer/register").body(Mono.just(c), Customer.class);


        spec.retrieve().toEntity(Boolean.class).subscribe(result -> {

            System.out.println(result.toString());
            final Boolean comments = result.getBody();
            callback.operationFinished(comments);
        });
    }
    public  void login(String email,String pwd, AsyncRestCallback<Customer> callback) {
        System.out.println("Login REST..");

        WebClient.RequestHeadersSpec<?> spec = WebClient.create().get().uri(uriBuilder -> uriBuilder.path("http://localhost:888/customer/login").queryParam("mail",email).queryParam("pwd",pwd).build());


        spec.retrieve().toEntity(Customer.class).subscribe(result -> {

            System.out.println(result.toString());
            final Customer comments = result.getBody();
            callback.operationFinished(comments);
        });
    }
}