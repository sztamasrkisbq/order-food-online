package com.example.application.views.restaurant.menus;

import com.example.application.Singleton;
import com.example.application.data.entity.Menu;
import com.example.application.data.entity.Restaurant;
import com.example.application.data.service.RestaurantClientService;
import com.example.application.views.restaurant.main.RestaurantMainView;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Route(value = "etterem/menulist",layout = RestaurantMainView.class)
@PageTitle("Menük")
public class RestaurantMenuView extends VerticalLayout {
    Grid<Menu> menus;
    Menu selected=new Menu();
    Restaurant r;
    UI ui;
    List<Menu> lista=new ArrayList<>();
    private RestaurantClientService service;
    final ListDataProvider<Menu> dataProvider;
    public RestaurantMenuView(@Autowired RestaurantClientService service) {
        this.service=service;

        menus=new Grid<>();

        dataProvider = new ListDataProvider<>(
                lista);
        menus.setDataProvider(dataProvider);

        HorizontalLayout layout=new HorizontalLayout();
        TextField name= new TextField("Menü név");
        Button add= new Button("Hozzáadás");
        Button foodadd= new Button("Étel hozzáadása");
        foodadd.setEnabled(false);
        add.addClickListener(buttonClickEvent -> {

            r=ComponentUtil.getData(menus.getUI().get(),Restaurant.class);

            r.addMenu(new Menu(name.getValue(),r.getId()));
            this.service.addMenu(r,r.getLastmenu(),results -> {
                updateList();
            });

        });
        foodadd.addClickListener(buttonClickEvent -> {
            ComponentUtil.setData(menus.getUI().get(),Menu.class,selected);
            foodadd.getUI().ifPresent(ui ->
                    ui.navigate("etterem/listFood"));

        });
        layout.add(name,add,foodadd);
        menus.asSingleSelect().addValueChangeListener(event->{
            selected=event.getValue();
            foodadd.setEnabled(true);
        });
        add(layout,menus);
        ui=name.getUI().get();
        updateList();

    }
    void updateList(){
        this.service.getMenuList(ComponentUtil.getData(ui,Restaurant.class).getId(),results -> {
            getUI().get().access(() -> {

                System.out.println(results);
                lista=results;
                dataProvider.getItems().clear();
                dataProvider.getItems().addAll(lista);
                dataProvider.refreshAll();
            });
        });
    }
}
