package com.example.application.views.restaurant.register;


import com.example.application.components.OpenHourComponent;
import com.example.application.data.entity.Customer;
import com.example.application.data.entity.Restaurant;
import com.example.application.data.service.CustomerClientService;
import com.example.application.data.service.RestaurantClientService;
import com.example.application.views.restaurant.main.RestaurantMainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.data.binder.BindingValidationStatus;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.data.validator.StringLengthValidator;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;

@PageTitle("Regisztráció")
@Route(value = "etterem/restregister",layout = RestaurantMainView.class)
public class RestaurantRegisterView extends VerticalLayout {

        FormLayout regForm;
        HashMap<String,String> days;
        Restaurant r;
        private final RestaurantClientService service;
    public RestaurantRegisterView(@Autowired RestaurantClientService service){
            this.service=service;
            r=new Restaurant();
            regForm=new FormLayout();
            Binder<Restaurant> binder=new Binder<>();
            days=new HashMap<>();

            TextField name = new TextField();
            name.setValueChangeMode(ValueChangeMode.EAGER);
            PasswordField password = new PasswordField();
            password.setValueChangeMode(ValueChangeMode.EAGER);
            EmailField email = new EmailField();
            email.setValueChangeMode(ValueChangeMode.EAGER);
            TextField phone = new TextField();
            phone.setValueChangeMode(ValueChangeMode.EAGER);
            TextField address = new TextField();
            address.setPlaceholder("8200 Veszprém, József Attila u. 34/2");
            address.setValueChangeMode(ValueChangeMode.EAGER);

            OpenHourComponent open=new OpenHourComponent();
            ListBox <String> lista=new ListBox<>();
            lista.setReadOnly(true);
            HorizontalLayout l=new HorizontalLayout();
            Button add= new Button("Hozzáad");
            add.addClickListener(buttonClickEvent -> {
                days.put(open.getValue().getKey(),open.getValue().getValue());
                lista.add(open.getValue().getKey()+" "+open.getValue().getValue());
            });
            l.add(open,add,lista);

            Label infoLabel = new Label();
            NativeButton reg = new NativeButton("Regisztráció");
            NativeButton reset = new NativeButton("Reset");

            name.setRequiredIndicatorVisible(true);
            password.setRequiredIndicatorVisible(true);
            email.setRequiredIndicatorVisible(true);
            phone.setRequiredIndicatorVisible(true);
            address.setRequiredIndicatorVisible(true);

            regForm.addFormItem(name, "Név");
            regForm.addFormItem(password, "Jelszó");
            regForm.addFormItem(email, "E-mail cím");
            regForm.addFormItem(phone, "Telefonszám");
            regForm.addFormItem(address, "Cím");
            regForm.addFormItem(l,"Napok");

            // Button bar
            HorizontalLayout actions = new HorizontalLayout();
            actions.add(reg, reset);
            reg.getStyle().set("marginRight", "10px");


            // E-mail and phone have specific validators
            Binder.Binding<Restaurant, String> emailBinding = binder.forField(email)
                    .withValidator(new EmailValidator("Nem megfelelő e-mail cím"))
                    .bind(Restaurant::getEmail, Restaurant::setEmail);

            Binder.Binding<Restaurant, String> phoneBinding = binder.forField(phone)
                    .withValidator(new StringLengthValidator("Nem megfelelő a telefonszám hossza",9,12))
                    .bind(Restaurant::getPhonenumber, Restaurant::setPhonenumber);

            email.addValueChangeListener(event -> phoneBinding.validate());
            phone.addValueChangeListener(event -> emailBinding.validate());


            binder.forField(password)
                    .withValidator(new StringLengthValidator(
                            "Adjon meg egy legalább 8 karakter hosszú jelszót", 8, null))
                    .bind(Restaurant::getPassword, Restaurant::setPassword);
            binder.forField(address)
                    .bind(Restaurant::getAddress, Restaurant::setAddress);
            binder.forField(name)
                    .bind(Restaurant::getName, Restaurant::setName);


            reg.addClickListener(event -> {
                if (binder.writeBeanIfValid(r)) {
                    infoLabel.setText("Saved bean values: " + r);
                    this.service.registerRestaurant(r,results -> {
                        if(results){
                        reg.getUI().ifPresent(ui ->
                                ui.navigate("etterem/login"));}
                        else{
                            BinderValidationStatus<Restaurant> validate = binder.validate();
                            String errorText = validate.getFieldValidationStatuses()
                                    .stream().filter(BindingValidationStatus::isError)
                                    .map(BindingValidationStatus::getMessage)
                                    .map(Optional::get).distinct()
                                    .collect(Collectors.joining(", "));
                            infoLabel.setText("Hibát észleltünk: " + errorText);
                        }
                    });
                } else {
                    BinderValidationStatus<Restaurant> validate = binder.validate();
                    String errorText = validate.getFieldValidationStatuses()
                            .stream().filter(BindingValidationStatus::isError)
                            .map(BindingValidationStatus::getMessage)
                            .map(Optional::get).distinct()
                            .collect(Collectors.joining(", "));
                    infoLabel.setText("Hibát észleltünk: " + errorText);
                }
            });

            reset.addClickListener(event -> {
                // clear fields by setting null
                binder.readBean(null);
                infoLabel.setText("");
            });
            add(regForm, actions, infoLabel);
    }
}
