package com.example.application.views.restaurant.foods;

import com.example.application.data.entity.Customer;
import com.example.application.data.entity.Food;
import com.example.application.data.entity.Menu;
import com.example.application.data.entity.Restaurant;
import com.example.application.data.service.RestaurantClientService;
import com.example.application.views.restaurant.main.RestaurantMainView;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.data.binder.BindingValidationStatus;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.validator.DateRangeValidator;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.data.validator.StringLengthValidator;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.function.SerializablePredicate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@PageTitle("Ételek")
@Route(value = "etterem/listFood",layout = RestaurantMainView.class)
public class RestaurantListFoodView extends VerticalLayout {

    Grid<Food> foods;
    Food selected;
    Food f;
    List<Food> lista=new ArrayList<>();
    private final  RestaurantClientService service;
    private ListDataProvider<Food> dataProvider;

    public RestaurantListFoodView(@Autowired RestaurantClientService service) {
        this.service=service;
        f=new Food();
        this.service.getFoodList(ComponentUtil.getData(UI.getCurrent(), Menu.class).getId(),results -> {
            getUI().get().access(() -> {

                System.out.println(results);
                lista=results;
            });
        });
        foods=new Grid<>();
        dataProvider = new ListDataProvider<>(
                lista);
        foods.setDataProvider(dataProvider);


        foods.asSingleSelect().addValueChangeListener(event->{
            selected=event.getValue();
        });


        add(addForm(),foods);

    }

    private FormLayout addForm(){
        FormLayout foodForm=new FormLayout();
        Binder<Food> binder=new Binder<>();

        TextField name = new TextField();
        name.setValueChangeMode(ValueChangeMode.EAGER);
        DatePicker startDate = new DatePicker();
        DatePicker endDate = new DatePicker();

        IntegerField price = new IntegerField();
        price.setValueChangeMode(ValueChangeMode.EAGER);
        TextArea allergens = new TextArea();
        allergens.setValueChangeMode(ValueChangeMode.EAGER);
        TextArea ingredients = new TextArea();
        ingredients.setValueChangeMode(ValueChangeMode.EAGER);

        Label infoLabel = new Label();
        NativeButton add = new NativeButton("Hozzáadás");
        NativeButton reset = new NativeButton("Reset");

        name.setRequiredIndicatorVisible(true);
        price.setRequiredIndicatorVisible(true);
        allergens.setRequiredIndicatorVisible(true);
        ingredients.setRequiredIndicatorVisible(true);

        foodForm.addFormItem(name, "Név");
        foodForm.addFormItem(startDate, "Kezdeti idő");
        foodForm.addFormItem(endDate, "Záró idő");
        foodForm.addFormItem(price, "Ár");
        foodForm.addFormItem(allergens, "Allergének");
        foodForm.addFormItem(ingredients, "Összetevők");

        // Button bar
        HorizontalLayout actions = new HorizontalLayout();
        actions.add(add, reset);
        add.getStyle().set("marginRight", "10px");

        // E-mail and phone have specific validators
        Binder.Binding<Food, LocalDate> startBinding = binder.forField(startDate)
                .withValidator(localDate -> (localDate.compareTo(endDate.getValue())>0),"Nem megfelelő intervallum")
                .bind(Food::getStartTimeLocal, Food::setStartTime);

        Binder.Binding<Food, LocalDate> endBinding = binder.forField(endDate)
                .withValidator(localDate -> (localDate.compareTo(startDate.getValue())<0),"Nem megfelelő intervallum")
                .bind(Food::getEndTimeLocal, Food::setEndTime);

        startDate.addValueChangeListener(event -> {if(!endDate.isEmpty())endBinding.validate();});
        endDate.addValueChangeListener(event -> {if(!startDate.isEmpty())startBinding.validate();});

        binder.forField(allergens)
                .bind(Food::getAllergens, Food::setAllergens);
        binder.forField(ingredients)
                .bind(Food::getIngredients, Food::setIngredients);
        binder.forField(price)
                .bind(Food::getPrice, Food::setPrice);
        binder.forField(name)
                .bind(Food::getName, Food::setName);


        add.addClickListener(event -> {
            if (binder.writeBeanIfValid(f)) {
                infoLabel.setText("Étel eltárolva: " + f);
                ComponentUtil.getData(UI.getCurrent(), Menu.class).addFood(f);
                this.service.addFood(ComponentUtil.getData(UI.getCurrent(), Menu.class).getRestId(),ComponentUtil.getData(UI.getCurrent(), Menu.class).getId(),f,results -> {
                    dataProvider.refreshAll();
                });
            } else {
                BinderValidationStatus<Food> validate = binder.validate();
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
        return foodForm;
    }
}
