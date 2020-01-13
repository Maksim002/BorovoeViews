package com.timelysoft.borovoe.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntertainmentListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<>();

        List<String> technology = new ArrayList<>();
        technology.add("Понидельник");
        technology.add("Вторник");
        technology.add("Среда");
        technology.add("Четверг");
        technology.add("Пятница");
        technology.add("Суббота");
        technology.add("Воскресенье");

        expandableListDetail.put("График работы", technology);
        return expandableListDetail;
    }
}
