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
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.MobileAds;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public List<Partida> partidas;
    private RecyclerView rv;
    private RVAdapter adapter;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.title_activity_main);

        // PREFERENCIAS
        prefs = this.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        editor = prefs.edit();

        // Ver si es el primer uso de la app
        if (prefs.getBoolean("firstrun", true)) {
            editor.clear().commit(); // borrar todos los datos
            Intent myIntent = new Intent(MainActivity.this, IntroActivity.class);
            startActivity(myIntent);
        }
        // Iniciar AdMob
        new Thread(
                () -> {
                    MobileAds.initialize(this, initializationStatus -> {
                    });
                })
                .start();



        // Restaurar partidas guardadas
        Gson gson = new Gson();
        final String mPartidasGuardadas = prefs.getString("partidas", "");
        Type listType = new TypeToken<ArrayList<Partida>>() {
        }.getType();
        partidas = gson.fromJson(mPartidasGuardadas, listType);
        if (partidas == null) partidas = new ArrayList<>(); // Constructor para no romper la app
        // Log.i("RESTAURAR", String.valueOf(partidas.size()));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NuevoActivity.class));
            }
        });

        // RecyclerView
        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        initializeAdapter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        // Ver que entrada del menú ha sido pulsada
        switch (id) {
            case R.id.action_privacy: {
                Intent myIntent = new Intent(MainActivity.this, TextoActivity.class);
                myIntent.putExtra("action", "privacy");
                startActivity(myIntent);
                break;
            }
            case R.id.action_third: {
                Intent myIntent = new Intent(MainActivity.this, TextoActivity.class);
                myIntent.putExtra("action", "third");
                startActivity(myIntent);
                break;
            }
            case R.id.action_about: {
                Intent myIntent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(myIntent);
                break;
            }
            case R.id.action_tutorial: {
                Intent myIntent = new Intent(MainActivity.this, IntroActivity.class);
                startActivity(myIntent);
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();

        Gson gson = new Gson();

        if (getIntent().getStringExtra("partidaNueva") != null) {
            // Obtener la partida desde la actividad Nuevo y añadirla a la lista de partidas
            String mPartidaString = getIntent().getStringExtra("partidaNueva");
            Partida mPartida = gson.fromJson(mPartidaString, Partida.class);
            partidas.add(mPartida);
            // if (partidas.size()>0) Log.i("I",String.valueOf(partidas.get(partidas.size()-1).nvacas));
        }

        if (getIntent().getIntExtra("borrar", -1) != -1) {
            // Acción de borrar enviada desde InfoPartida
            int borrar = getIntent().getIntExtra("borrar", -1);
            partidas.remove(borrar);
            // if (partidas.size()>0) Log.i("I",String.valueOf(partidas.get(partidas.size()-1).nvacas));
        }

        if (prefs.getBoolean("firstrun", true)) {
            // Do first run stuff here then set 'firstrun' as false
            // using the following line to edit/commit prefs
            // Ya no es la primera partida, así que actualizamos la preferencia
            prefs.edit().putBoolean("firstrun", false).apply();
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Gson gson = new Gson();
        // Guardar la lista de partidas como json
        String spartidas = gson.toJson(partidas);
        editor.putString("partidas", spartidas);
        editor.commit();
        // Log.i("GUARDAR", String.valueOf(partidas));
    }

    private void initializeAdapter() {
        adapter = new RVAdapter(partidas, new RecyclerViewClickListener() {
            @Override
            public void onClickItem(View v, int position) {
                // Se ejecuta cuando se pulsa una partida
                Gson gson = new Gson();
                partidas.get(position).setPosicion(position);
                // Toast.makeText(MainActivity.this, "Clicked Item: " + position, Toast.LENGTH_SHORT).show();
                String partidaActual = gson.toJson(partidas.get(position));
                // String partidasTodas = gson.toJson(partidas);
                Intent myIntent = new Intent(MainActivity.this, InfoPartidaActivity.class);
                myIntent.putExtra("partidaActual", partidaActual); // Pasar a InfoPartida la partida actual
                // myIntent.putExtra("partidasTodas", partidasTodas);
                myIntent.putExtra("posicion", position); // Pasar a InfoPartida la posición de la partida pulsada
                startActivity(myIntent);
            }
        });
        rv.setAdapter(adapter);
    }


}
