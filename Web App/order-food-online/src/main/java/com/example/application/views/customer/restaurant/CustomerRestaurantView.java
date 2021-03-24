package com.example.application.views.customer.restaurant;

import com.example.application.data.entity.Restaurant;
import com.example.application.data.filter.RestaurantFilter;
import com.example.application.data.service.CustomerClientService;
import com.example.application.data.service.RestaurantClientService;
import com.example.application.views.customer.main.CustomerMainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


@Route(value = "vendeg/list",layout = CustomerMainView.class)
@RouteAlias(value = "",layout = CustomerMainView.class)
@PageTitle("Éttermek")
public class CustomerRestaurantView extends VerticalLayout {

    Grid<Restaurant> grid;
    TextField filter;
    //TextField address;
    private CustomerClientService service;
    List<Restaurant> data=new ArrayList<>();
    private ListDataProvider<Restaurant> dataProvider;
    RestaurantFilter filterObject;

    public CustomerRestaurantView(@Autowired CustomerClientService service) {
        this.service = service;
        grid=new Grid<>();
        grid.addColumn(Restaurant::getName).setHeader("Név");
        grid.addColumn(Restaurant::getAddress).setHeader("Cím");
        filterObject=new RestaurantFilter();

        dataProvider = new ListDataProvider<>(data);
        grid.setDataProvider(dataProvider);
        dataProvider.setFilter(restaurant->filterObject.test(restaurant));
        this.service.getRestaurantList(results -> {
            System.out.println(results);
            data=results;
            filter.getUI().get().access(() ->{
                    dataProvider.getItems().clear();
                    dataProvider.getItems().addAll(data);
                    dataProvider.refreshAll();
                    }
            );



        });
        System.out.println(data.size());

        filter=new TextField("Szűrő");
        filter.addValueChangeListener(e ->{
            filterObject.setAddress(e.getValue());
            dataProvider.refreshAll();
        });

        add(filter,grid);
    }

    private void getList(){

    }
}
