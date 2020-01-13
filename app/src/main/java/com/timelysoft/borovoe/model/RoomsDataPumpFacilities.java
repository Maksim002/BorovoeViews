package com.timelysoft.borovoe.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RoomsDataPumpFacilities {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<>();

        List<String> facilities = new ArrayList<>();
        facilities.add("Интернет");
        facilities.add("Основные");

        expandableListDetail.put("Удобства", facilities);
        return expandableListDetail;
    }
}

