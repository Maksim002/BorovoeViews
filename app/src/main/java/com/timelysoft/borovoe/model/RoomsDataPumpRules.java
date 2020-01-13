package com.timelysoft.borovoe.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RoomsDataPumpRules {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<>();

        List<String> rules = new ArrayList<>();
        rules.add("Время въезда и выезда");
        rules.add("Еда и напитки");
        rules.add("Спальные места");

        expandableListDetail.put("Правила размещения ", rules);
        return expandableListDetail;
    }
}

