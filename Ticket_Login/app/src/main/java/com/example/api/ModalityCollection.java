package com.example.api;

import java.util.ArrayList;

public class ModalityCollection {

    public ArrayList fetch() {
        ArrayList list = new ArrayList();
        list.add(0, new Modality(1, "Natação"));
        list.add(1, new Modality(2, "Basquete"));
        list.add(2, new Modality(3, "Futebol"));

        return list;
    }
}
