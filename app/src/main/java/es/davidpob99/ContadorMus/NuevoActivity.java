/*
 * Copyright (c) 2016 - 2019 David Población.
 *
 * This file is part of ContadorMus.
 *
 * ContadorMus is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ContadorMus is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with ContadorMus.  If not, see <https://www.gnu.org/licenses/>.
 */

package es.davidpob99.ContadorMus;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

public class NuevoActivity extends AppCompatActivity {

    EditText e1Nombre;
    EditText e1J1;
    EditText e1J2;
    EditText e2Nombre;
    EditText e2J1;
    EditText e2J2;
    EditText nvacas;
    EditText njuegos;
    EditText observaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        e1Nombre = findViewById(R.id.etE1Nombre);
        e1J1 = findViewById(R.id.etE1J1);
        e1J2 = findViewById(R.id.etE1J2);
        e2Nombre = findViewById(R.id.etE2Nombre);
        e2J1 = findViewById(R.id.etE2J1);
        e2J2 = findViewById(R.id.etE2J2);
        njuegos = findViewById(R.id.etNJuegos);
        nvacas = findViewById(R.id.etNVacas);
        observaciones = findViewById(R.id.etObservaciones);

        FloatingActionButton fab = findViewById(R.id.check_nuevo);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Partida mPartida = new Partida((njuegos.getText().toString().matches("-?\\d+")) ? Integer.parseInt(njuegos.getText().toString()) : 3,
                        (nvacas.getText().toString().matches("-?\\d+")) ? Integer.parseInt(nvacas.getText().toString()) : 3,
                        new Equipo((!e1Nombre.getText().toString().matches("")) ? e1Nombre.getText().toString() : "Equipo 1",
                                (!e1J1.getText().toString().matches("")) ? e1J1.getText().toString() : "Jugador 1",
                                (!e1J2.getText().toString().matches("")) ? e1J2.getText().toString() : "Jugador 2"),
                        new Equipo((!e2Nombre.getText().toString().matches("")) ? e2Nombre.getText().toString() : "Equipo 2",
                                (!e2J1.getText().toString().matches("")) ? e2J1.getText().toString() : "Jugador 1",
                                (!e2J2.getText().toString().matches("")) ? e2J2.getText().toString() : "Jugador 2"),
                        (!observaciones.getText().toString().matches("")) ? observaciones.getText().toString() : "-");
                Gson gson = new Gson();
                String mPartidaString = gson.toJson(mPartida);
                Intent myIntent = new Intent(NuevoActivity.this, MainActivity.class);
                myIntent.putExtra("partidaNueva", mPartidaString); //Optional parameters
                NuevoActivity.this.startActivity(myIntent);

            }
        });


    }

}