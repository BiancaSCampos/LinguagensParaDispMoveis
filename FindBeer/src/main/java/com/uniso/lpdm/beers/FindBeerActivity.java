package com.uniso.lpdm.beers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FindBeerActivity extends AppCompatActivity {

    private CalculadorCerveja calculadora = new CalculadorCerveja();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }

    public void onClickFindBeer (View view){
        TextView marcasCerveja = (TextView) findViewById(R.id.brands);
        Spinner cores = (Spinner) findViewById(R.id.color);
        String tipoSelecionado = String.valueOf(cores.getSelectedItem());

        List<String> listaDeMarcas = calculadora.getMarcasCerveja(tipoSelecionado);

        StringBuilder marcasFormatadas = new StringBuilder();

        for (String brand: listaDeMarcas){
            marcasFormatadas.append(brand).append('\n');
        }

        marcasCerveja.setText(marcasFormatadas);
    }
}