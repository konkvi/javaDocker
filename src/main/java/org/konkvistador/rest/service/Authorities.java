package org.konkvistador.rest.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum Authorities {
    READ, WRITE, DELETE;

    public static List<Authorities> asList() {
        ArrayList<Authorities> list = new ArrayList<>();
        Collections.addAll(list, values());
        return list;
    }
}
