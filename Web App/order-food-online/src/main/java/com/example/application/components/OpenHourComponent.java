package com.example.application.components;

import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.timepicker.TimePicker;
import javafx.util.Pair;

import java.time.LocalTime;
import java.util.Map;

public class OpenHourComponent extends CustomField<Pair<String,String>> {
    Select day;
    TimePicker start;
    TimePicker end;


    public OpenHourComponent() {
        day=new Select();
        start=new TimePicker();
        end=new TimePicker();
        day.setItems("Hétfő","Kedd","Szerda","Csütörtök","Péntek","Szombat","Vasárnap");
        day.setPlaceholder("Nap");
        add(day,start,end);
    }

    @Override
    protected Pair<String, String> generateModelValue() {
        return new Pair<String,String>(day.getValue().toString(),start.getValue().toString()+"-"+end.getValue().toString());
    }

    @Override
    protected void setPresentationValue(Pair<String, String> stringStringMap) {
        if (stringStringMap == null) {
            start.setValue(null);
            start.setValue(null);
        }
        else{
            day.setValue(stringStringMap.getKey());
            start.setValue(LocalTime.parse(stringStringMap.getValue().split("-")[0]));
            end.setValue(LocalTime.parse(stringStringMap.getValue().split("-")[1]));
        }
    }
}
