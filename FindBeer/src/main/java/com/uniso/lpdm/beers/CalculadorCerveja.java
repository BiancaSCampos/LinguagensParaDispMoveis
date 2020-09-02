package com.uniso.lpdm.beers;

import java.util.ArrayList;
import java.util.List;

public class CalculadorCerveja {

    public List<String> getMarcasCerveja(String cor){
        List<String> marcas = new ArrayList<>();
        if (cor.equals("amber")){
            marcas.add("Jack amber");
            marcas.add("Red Mose");
        }
        else {
            marcas.add("Jail pail ale");
            marcas.add("Gout stout");
        }

        return marcas;
    }
}
