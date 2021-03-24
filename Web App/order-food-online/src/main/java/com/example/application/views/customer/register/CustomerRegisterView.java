package com.example.application.views.customer.register;

import com.example.application.data.entity.Customer;
import com.example.application.data.service.CustomerClientService;
import com.example.application.views.customer.main.CustomerMainView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.data.binder.BindingValidationStatus;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.data.validator.StringLengthValidator;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.function.SerializablePredicate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.stream.Collectors;

@Route(value = "vendeg/custregister", layout = CustomerMainView.class)
@PageTitle("Regisztráció")
public class CustomerRegisterView extends VerticalLayout {
    FormLayout regForm;
    Customer c;
    CustomerClientService service;

    public CustomerRegisterView(@Autowired CustomerClientService service){
        this.service=service;
        regForm=new FormLayout();
        c=new Customer();
        Binder<Customer> binder=new Binder<>();

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

        // Button bar
        HorizontalLayout actions = new HorizontalLayout();
        actions.add(reg, reset);
        reg.getStyle().set("marginRight", "10px");


        // E-mail and phone have specific validators
        Binder.Binding<Customer, String> emailBinding = binder.forField(email)
                .withValidator(new EmailValidator("Nem megfelelő e-mail cím"))
                .bind(Customer::getEmail, Customer::setEmail);

        Binder.Binding<Customer, String> phoneBinding = binder.forField(phone)
                .withValidator(new StringLengthValidator("Nem megfelelő a telefonszám hossza",9,12))
                .bind(Customer::getPhonenumber, Customer::setPhonenumber);

        email.addValueChangeListener(event -> phoneBinding.validate());
        phone.addValueChangeListener(event -> emailBinding.validate());


        binder.forField(password)
                .withValidator(new StringLengthValidator(
                        "Adjon meg egy legalább 8 karakter hosszú jelszót", 8, null))
                .bind(Customer::getPassword, Customer::setPassword);
        binder.forField(address)
                .bind(Customer::getAddress, Customer::setAddress);
        binder.forField(name)
                .bind(Customer::getName, Customer::setName);
        ;
        reg.addClickListener(event -> {
            if (binder.writeBeanIfValid(c)) {
                infoLabel.setText("Saved bean values: " + c);
                this.service.registerCustomer(c,results -> {
                    if (results) {
                    } else {
                        BinderValidationStatus<Customer> validate = binder.validate();
                        String errorText = validate.getFieldValidationStatuses()
                                .stream().filter(BindingValidationStatus::isError)
                                .map(BindingValidationStatus::getMessage)
                                .map(Optional::get).distinct()
                                .collect(Collectors.joining(", "));
                        infoLabel.setText("Hibát észleltünk: " + errorText);
                    }
                });
                    this.getUI().ifPresent(ui ->
                            ui.navigate("vendeg/list"));}
            else {
                BinderValidationStatus<Customer> validate = binder.validate();
                String errorText = validate.getFieldValidationStatuses()
                        .stream().filter(BindingValidationStatus::isError)
                        .map(BindingValidationStatus::getMessage)
                        .map(Optional::get).distinct()
                        .collect(Collectors.joining(", "));
                infoLabel.setText("Hibát észleltünk: " + errorText);
            }}
        );

        reset.addClickListener(event -> {
            // clear fields by setting null
            binder.readBean(null);
            infoLabel.setText("");
        });
        add(regForm, actions, infoLabel);
    }
}
