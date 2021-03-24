package com.example.application.views.restaurant.menus;

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
    List<Menu> lista=new ArrayList<>();
    private final RestaurantClientService service;

    public RestaurantMenuView(@Autowired RestaurantClientService service) {
        this.service=service;
        this.service.getMenuList(ComponentUtil.getData(UI.getCurrent(), Restaurant.class).getId(),results -> {
            getUI().get().access(() -> {

                System.out.println(results);
                lista=results;
            });
        });
        menus=new Grid<>();
        final ListDataProvider<Menu> dataProvider = new ListDataProvider<>(
                lista);
        menus.setDataProvider(dataProvider);
        HorizontalLayout layout=new HorizontalLayout();
        TextField name= new TextField("Menü név");
        Button add= new Button("Hozzáadás");
        Button foodadd= new Button("Étel hozzáadása");
        foodadd.setEnabled(false);
        add.addClickListener(buttonClickEvent -> {
            Restaurant r=ComponentUtil.getData(UI.getCurrent(), Restaurant.class);
            r.addMenu(new Menu(name.getValue(),r.getId()));
            this.service.addMenu(r,r.getLastMenu(),results -> {
                dataProvider.refreshAll();
            });
        });
        foodadd.addClickListener(buttonClickEvent -> {
            ComponentUtil.setData(UI.getCurrent(),Menu.class,selected);
            foodadd.getUI().ifPresent(ui ->
                    ui.navigate("etterem/listFood"));

        });
        layout.add(name,add,foodadd);
        menus.asSingleSelect().addValueChangeListener(event->{
            selected=event.getValue();
            foodadd.setEnabled(true);
        });
        add(layout,menus);

    }
}
