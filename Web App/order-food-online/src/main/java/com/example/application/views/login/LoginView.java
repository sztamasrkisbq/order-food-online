package com.example.application.views.login;

import com.example.application.data.service.AsyncRestClientService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.login.AbstractLogin;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.example.application.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;

@CssImport("./views/login/login-view.css")
@Route(value = "login", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("Bejelentkezés")
public class LoginView extends HorizontalLayout {

    //private LoginForm login=new LoginForm();
    private Button reg;
    private TextField out;

    private final AsyncRestClientService service;

    public LoginView(@Autowired AsyncRestClientService service) {
        this.service = service;
        out=new TextField("asd","ASD");
        out.setVisible(true);
        addClassName("login-view");
        reg = new Button("Regisztráció");
        add(reg,out);
        reg.addClickListener(e -> {
            this.service.getDataBack(result -> {

                // We now have the results. But, because this call might happen outside normal
                // Vaadin calls, we need to make sure the HTTP Session data of this app isn't
                // violated. For this we use UI#access()
                getUI().get().access(() -> {

                    // Finally, we can modify the UI state. These changes are sent to the users
                    // browser immediately, because we have enable Websocket Server Push (@Push
                    // annotation in MainLayout).
                    System.out.println(result);
                    out.setValue(result.toString());
                });
            });
        });
    }

}
