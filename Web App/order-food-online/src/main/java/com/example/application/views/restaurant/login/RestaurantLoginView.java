package com.example.application.views.restaurant.login;

import com.example.application.Singleton;
import com.example.application.data.entity.Customer;
import com.example.application.data.entity.Restaurant;
import com.example.application.data.service.RestaurantClientService;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.example.application.views.restaurant.main.RestaurantMainView;
import com.vaadin.flow.router.RouteAlias;
import org.springframework.beans.factory.annotation.Autowired;

@CssImport("./views/login/restaurant-login-view.css")
@Route(value = "etterem/login", layout = RestaurantMainView.class)
@RouteAlias(value = "etterem",layout = RestaurantMainView.class)
@PageTitle("Étterem Bejelentkezés")
public class RestaurantLoginView extends HorizontalLayout {

    private Button reg;
    private LoginForm login;
    Restaurant r;

    private final RestaurantClientService service;

    public RestaurantLoginView(@Autowired RestaurantClientService service) {
        this.service = service;
        addClassName("login-view");
        login=new LoginForm();
        reg = new Button("Regisztráció");
        login.addLoginListener(loginEvent -> {
            r=this.service.login(loginEvent.getUsername(),loginEvent.getPassword());
                ComponentUtil.setData(login.getUI().get(),Restaurant.class,r);
                asd();
        });
        reg = new Button("Regisztráció");
        reg.addClickListener(e -> {
            reg.getUI().ifPresent(ui ->
                    ui.navigate("etterem/restregister"));
        });
        add(login,reg);
    }


    void asd(){
        getUI().get().access(() -> {
        login.getUI().ifPresent(ui ->
                ui.navigate("etterem/menulist"));
    });}
}
