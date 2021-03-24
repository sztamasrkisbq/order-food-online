package com.example.application.data.service;

import com.example.application.data.entity.Customer;
import com.example.application.data.entity.Food;
import com.example.application.data.entity.Menu;
import com.example.application.data.entity.Restaurant;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Service
public class RestaurantClientService extends AbstractAsyncClientService{

    public  void registerRestaurant(Restaurant r, AsyncRestCallback<Boolean> callback) {
        System.out.println("Restaurant Register REST..");

        WebClient.RequestHeadersSpec<?> spec = WebClient.create().post().uri("http://localhost:888/restaurant/register").body(Mono.just(r), Restaurant.class);


        spec.retrieve().toEntity(Boolean.class).subscribe(result -> {

            System.out.println(result.toString());
            final Boolean comments = result.getBody();
            callback.operationFinished(comments);
        });
    }
    public  void login(String email,String pwd, AsyncRestCallback<Restaurant> callback) {
        System.out.println("Restaurant Login REST..");

        WebClient.RequestHeadersSpec<?> spec = WebClient.create().get().uri(uriBuilder -> uriBuilder.path("http://localhost:888/restaurant/login").queryParam("mail",email).queryParam("pwd",pwd).build());


        spec.retrieve().toEntity(Restaurant.class).subscribe(result -> {

            System.out.println(result.toString());
            final Restaurant comments = result.getBody();
            callback.operationFinished(comments);
        });
    }
    public  void getMenuList(Integer id,AsyncRestCallback<List<Menu>> callback) {
        System.out.println("GetMenuList REST..");

        WebClient.RequestHeadersSpec<?> spec = WebClient.create().get().uri(uriBuilder -> uriBuilder.path("http://localhost:888/restaurant/getMenu").queryParam("id",id).build());

        spec.retrieve().toEntityList(Menu.class).subscribe(result -> {

            System.out.println(result.toString());
            final List<Menu> comments = result.getBody();
            callback.operationFinished(comments);
        });
    }
    public  void getMenu(Menu m,AsyncRestCallback<Menu> callback) {
        System.out.println("GetMenu REST..");

        WebClient.RequestHeadersSpec<?> spec = WebClient.create().get().uri(uriBuilder -> uriBuilder.path("http://localhost:888/restaurant/getMenu").queryParam("id",m.getId()).build());

        spec.retrieve().toEntity(Menu.class).subscribe(result -> {

            System.out.println(result.toString());
            final Menu comments = result.getBody();
            callback.operationFinished(comments);
        });
    }
    public  void addMenu(Restaurant r,Menu m, AsyncRestCallback<Integer> callback) {
        System.out.println("AddMenu REST..");
        WebClient.RequestHeadersSpec<?> spec = WebClient.create().post().uri(uriBuilder -> uriBuilder.path("http://localhost:888/restaurant/addMenu").queryParam("restId",r.getId()).build()).body(Mono.just(m), Menu.class);

        spec.retrieve().toEntity(Integer.class).subscribe(result -> {

            System.out.println(result.toString());
            final Integer comments = result.getBody();
            m.setId(comments);
            callback.operationFinished(comments);
        });
    }
    public  void getFoodList(Integer id, AsyncRestCallback<List<Food>> callback) {
        System.out.println("GetFoodList REST..");

        WebClient.RequestHeadersSpec<?> spec = WebClient.create().get().uri(uriBuilder -> uriBuilder.path("http://localhost:888/restaurant/getFoods").queryParam("id",id).build());


        spec.retrieve().toEntityList(Food.class).subscribe(result -> {

            System.out.println(result.toString());
            final List<Food> comments = result.getBody();
            callback.operationFinished(comments);
        });
    }
    public  void getFood(Integer id, AsyncRestCallback<List<Food>> callback) {
        System.out.println("GetFood REST..");

        WebClient.RequestHeadersSpec<?> spec = WebClient.create().get().uri(uriBuilder -> uriBuilder.path("http://localhost:888/restaurant/getFood").queryParam("id",id).build());


        spec.retrieve().toEntityList(Food.class).subscribe(result -> {

            System.out.println(result.toString());
            final List<Food> comments = result.getBody();
            callback.operationFinished(comments);
        });
    }
    public  void addFood(Integer  rid,Integer mid,Food f, AsyncRestCallback<Integer> callback) {
        System.out.println("AddFood REST..");
        WebClient.RequestHeadersSpec<?> spec = WebClient.create().post().uri(uriBuilder -> uriBuilder.path("http://localhost:888/restaurant/addFood").queryParam("restId",rid).queryParam("menuId",mid).build()).body(Mono.just(f), Food.class);

        spec.retrieve().toEntity(Integer.class).subscribe(result -> {

            System.out.println(result.toString());
            final Integer comments = result.getBody();
            f.setId(comments);
            callback.operationFinished(comments);
        });
    }

}