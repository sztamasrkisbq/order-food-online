package com.example.application.views.customer.login;

import com.example.application.data.entity.Customer;
import com.example.application.data.service.CustomerClientService;
import com.example.application.views.customer.main.CustomerMainView;

import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@CssImport("./views/login/login-view.css")
@Route(value = "vendeg/custlogin", layout = CustomerMainView.class)
@PageTitle("Bejelentkezés")
public class CustomerLoginView extends VerticalLayout {

    private LoginForm login;
    private Button reg;

    private final CustomerClientService service;

    public CustomerLoginView(@Autowired CustomerClientService service) {
        this.service = service;
        login=new LoginForm();
        addClassName("customer-login-view");

        login.addLoginListener(loginEvent -> {
            this.service.login(loginEvent.getUsername(),loginEvent.getPassword(),results -> {
                ComponentUtil.setData(UI.getCurrent(), Customer.class, results);

            });
            login.getUI().ifPresent(ui ->
                    ui.navigate("vendeg/"));
        });
        reg = new Button("Regisztráció");
        reg.addClickListener(e -> {
            reg.getUI().ifPresent(ui ->
                    ui.navigate("vendeg/custregister"));
        });
        add(login,reg);
    }

}
