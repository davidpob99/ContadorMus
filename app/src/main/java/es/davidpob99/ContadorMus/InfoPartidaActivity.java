/*
 *  Copyright (c) 2024 David Población.
 *
 *  This file is part of ContadorMus.
 *
 *  ContadorMus is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  ContadorMus is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with ContadorMus.  If not, see <https://www.gnu.org/licenses/>.
 */

package es.davidpob99.ContadorMus;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class InfoPartidaActivity extends AppCompatActivity {

    Partida mPartida;

    TextView e1Nombre;
    TextView e2Nombre;
    TextView e1Puntuacion;
    TextView e2Puntuacion;
    TextView e1Juegos;
    TextView e2Juegos;
    TextView e1Vacas;
    TextView e2Vacas;
    TextView msg;
    TextView ayuda;
    TextView fecha;
    TextView observaciones;

    Button delete;
    Button reset;
    FloatingActionButton fab, fabClassic;

    Gson gson;
    int position;
    List<Partida> partidas;
    private AdView mAdView;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_partida);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gson = new Gson();

        // Obtener referencias
        e1Nombre = findViewById(R.id.tvE1Nombre);
        e2Nombre = findViewById(R.id.tvE2Nombre);
        e1Puntuacion = findViewById(R.id.tvE1Puntuacion);
        e2Puntuacion = findViewById(R.id.tvE2Puntuacion);
        e1Juegos = findViewById(R.id.tvE1Juegos);
        e2Juegos = findViewById(R.id.tvE2Juegos);
        e1Vacas = findViewById(R.id.tvE1Vacas);
        e2Vacas = findViewById(R.id.tvE2Vacas);
        msg = findViewById(R.id.tvMsg);
        ayuda = findViewById(R.id.tvAyuda);
        fecha = findViewById(R.id.tvFecha);
        observaciones = findViewById(R.id.tvObservaciones);

        delete = findViewById(R.id.bDelete);
        reset = findViewById(R.id.bReset);
        fab = findViewById(R.id.fab);
        fabClassic = findViewById(R.id.fabClassic);

        // ANUNCIOS
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        // PREFERENCIAS
        prefs = this.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        editor = prefs.edit();

        // Obtener la partida actual desde Main
        final String mPartidaString = getIntent().getStringExtra("partidaActual");
        if (mPartida == null)
            mPartida = gson.fromJson(mPartidaString, Partida.class);
        // Obtener la posición del elemento desde Main


        // Obtener las partidas desde las Preferencias
        final String mPartidasGuardadas = prefs.getString("partidas", "");
        Type listType = new TypeToken<ArrayList<Partida>>() {
        }.getType();
        partidas = gson.fromJson(mPartidasGuardadas, listType);
        if (mPartida == null)
            mPartida = partidas.get(position);

        position = mPartida.getPosicion();
        actualizarMarcador();

        // Acción del botón flotante
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String mPartidaString = gson.toJson(mPartida); // Pasar datos a json para otra actividad
                // Abrir otra actividad
                Intent myIntent = new Intent(InfoPartidaActivity.this, ManoActivity.class);
                myIntent.putExtra("partidaActual", mPartidaString);
                startActivity(myIntent);
            }
        });
        // Cuando se pulsa el botón de versión clásica (izquierda)
        fabClassic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String mPartidaString = gson.toJson(mPartida); // Pasar datos a json para otra actividad
                Intent myIntent = new Intent(InfoPartidaActivity.this, ContadorActivity.class);
                myIntent.putExtra("partidaActual", mPartidaString);
                startActivity(myIntent);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final String fromActivity = getIntent().getStringExtra("from");
        if (fromActivity != null && fromActivity.equals("ManoActivity"))
            fab.performClick();
    }

    @Override
    public void onPause() {
        super.onPause();
        // Actualizar la lista de partidas
        partidas.set(position, mPartida);
        // Log.i("PARTIDAS", String.valueOf(mPartida.e1.puntuacion));
        // Guardar la lista de partidas
        String spartidas = gson.toJson(partidas);
        editor.putString("partidas", spartidas);
        editor.commit();
    }

    public void onClickedDeleteItem(View v) {
        // Cuando se pulsa el botón de eliminar
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Estás seguro de eliminar la partida?")
                .setTitle("Eliminar")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel(); // cerrar diálogo
                    }
                })
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent myIntent = new Intent(InfoPartidaActivity.this, MainActivity.class);
                        myIntent.putExtra("borrar", position);
                        startActivity(myIntent);
                    }
                });
        AlertDialog dialogIcon = builder.create();
        dialogIcon.show();
    }

    public void onClickedResetItem(View v) {
        // Cuando se pulsa el botón de reiniciar
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Estás seguro de reiniciar la partida?")
                .setTitle("Reiniciar")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Poner todos los parámetros a 0
                        mPartida.e1.setPuntuacion(0);
                        mPartida.e2.setPuntuacion(0);
                        mPartida.e1.setJuegos(0);
                        mPartida.e2.setJuegos(0);
                        mPartida.e1.setVacas(0);
                        mPartida.e2.setVacas(0);
                        mPartida.setFecha(Calendar.getInstance().getTime());
                        mPartida.setFinalizada(false);
                        mPartida.setMsg("EN JUEGO");
                        fab.setEnabled(true);
                        fabClassic.setEnabled(true);
                        ayuda.setText(getResources().getString(R.string.infopartida_mayuda1));
                        fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#965994")));
                        fabClassic.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#005ecb")));
                        actualizarMarcador();
                    }
                });
        AlertDialog dialogIcon = builder.create();
        dialogIcon.show();
    }

    public void actualizarMarcador() {
        // Actualiza la puntuación
        e1Nombre.setText(mPartida.e1.getNombre() + "\n" + " (" + mPartida.e1.getJugador1() + " - " + mPartida.e1.getJugador2() + ")");
        e2Nombre.setText(mPartida.e2.getNombre() + "\n" + " (" + mPartida.e2.getJugador1() + " - " + mPartida.e2.getJugador2() + ")");
        e1Puntuacion.setText(String.valueOf(mPartida.e1.getPuntuacion()));
        e2Puntuacion.setText(String.valueOf(mPartida.e2.getPuntuacion()));
        e1Juegos.setText(mPartida.e1.getJuegos() + " / " + mPartida.getNjuegos());
        e2Juegos.setText(mPartida.e2.getJuegos() + " / " + mPartida.getNjuegos());
        e1Vacas.setText(mPartida.e1.getVacas() + " / " + mPartida.getNvacas());
        e2Vacas.setText(mPartida.e2.getVacas() + " / " + mPartida.getNvacas());
        msg.setText(String.valueOf(mPartida.getMsg()));
        DateFormat df = new SimpleDateFormat("EEEE, dd/MM/yyyy HH:mm:ss");
        fecha.setText(df.format(mPartida.getFecha()));
        observaciones.setText(mPartida.getObservaciones());

        if (mPartida.finalizada) {
            fab.setEnabled(false);
            fab.setBackgroundTintList(ColorStateList.valueOf(Color.GRAY));
            fabClassic.setEnabled(false);
            fabClassic.setBackgroundTintList(ColorStateList.valueOf(Color.GRAY));
            ayuda.setText(getResources().getString(R.string.infopartida_mayuda2));
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        startActivity(new Intent(InfoPartidaActivity.this, MainActivity.class));
        return super.onKeyDown(keyCode, event);
    }
}
