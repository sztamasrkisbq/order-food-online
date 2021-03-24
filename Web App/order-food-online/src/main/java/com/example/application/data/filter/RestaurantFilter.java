package com.example.application.data.filter;

import com.example.application.data.entity.Restaurant;
import org.apache.commons.lang3.StringUtils;

public class RestaurantFilter {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public boolean test(Restaurant restaurant) {
        if (address.length() > 0 && !StringUtils
                .containsIgnoreCase(String.valueOf(restaurant.getAddress()),
                        address)) {
            return false;
        }
        return true;
    }
}
