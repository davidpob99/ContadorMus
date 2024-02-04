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
import androidx.appcompat.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.gson.Gson;

public class ContadorActivity extends AppCompatActivity implements View.OnClickListener {

    Partida mPartida;

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn101, btn102, btn103,
            btn104, btn105, btn106, btn107, btn108, btn109, btn1010, btn1011, btn1012;
    TextView tx1, tx2, v1, v2;
    TextView et1, et2;
    InterstitialAd mInterstitialAd;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);

        Gson gson = new Gson();
        final String mPartidaString = getIntent().getStringExtra("partidaActual");
        mPartida = gson.fromJson(mPartidaString, Partida.class);

        tx1 = (TextView) findViewById(R.id.textView2);
        tx2 = (TextView) findViewById(R.id.textView102);
        v1 = (TextView) findViewById(R.id.textView1);
        v2 = (TextView) findViewById(R.id.textView101);

        et1 = (TextView) findViewById(R.id.editText1);
        et2 = (TextView) findViewById(R.id.editText101);

        btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(this);
        btn4 = (Button) findViewById(R.id.button4);
        btn4.setOnClickListener(this);
        btn5 = (Button) findViewById(R.id.button5);
        btn5.setOnClickListener(this);
        btn6 = (Button) findViewById(R.id.button6);
        btn6.setOnClickListener(this);
        btn7 = (Button) findViewById(R.id.button7);
        btn7.setOnClickListener(this);
        btn8 = (Button) findViewById(R.id.button8);
        btn8.setOnClickListener(this);
        btn9 = (Button) findViewById(R.id.button9);
        btn9.setOnClickListener(this);
        btn10 = (Button) findViewById(R.id.button10);
        btn10.setOnClickListener(this);
        btn11 = (Button) findViewById(R.id.button11);
        btn11.setOnClickListener(this);
        btn12 = (Button) findViewById(R.id.button12);
        btn12.setOnClickListener(this);


        btn101 = (Button) findViewById(R.id.button101);
        btn101.setOnClickListener(this);
        btn102 = (Button) findViewById(R.id.button102);
        btn102.setOnClickListener(this);
        btn103 = (Button) findViewById(R.id.button103);
        btn103.setOnClickListener(this);
        btn104 = (Button) findViewById(R.id.button104);
        btn104.setOnClickListener(this);
        btn105 = (Button) findViewById(R.id.button105);
        btn105.setOnClickListener(this);
        btn106 = (Button) findViewById(R.id.button106);
        btn106.setOnClickListener(this);
        btn107 = (Button) findViewById(R.id.button107);
        btn107.setOnClickListener(this);
        btn108 = (Button) findViewById(R.id.button108);
        btn108.setOnClickListener(this);
        btn109 = (Button) findViewById(R.id.button109);
        btn109.setOnClickListener(this);
        btn1010 = (Button) findViewById(R.id.button1010);
        btn1010.setOnClickListener(this);
        btn1011 = (Button) findViewById(R.id.button1011);
        btn1011.setOnClickListener(this);
        btn1012 = (Button) findViewById(R.id.button1012);
        btn1012.setOnClickListener(this);
        /*btnmod = (Button) findViewById(R.id.bModern);
        btnmod.setOnClickListener(this);

        btnreset = (Button) findViewById(R.id.bReset);
        btnreset.setOnClickListener(this);*/


        et1.setText(mPartida.e1.getJugador1() + " - " + mPartida.e1.getJugador2());
        et2.setText(mPartida.e2.getJugador1() + " - " + mPartida.e2.getJugador2());
        actualizarMarcador();

        // ANUNCIOS
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        mAdView.loadAd(adRequest);
        mInterstitialAd = new InterstitialAd(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        volver();
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onResume() {
        super.onResume();
        actualizarMarcador();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                mPartida.e1.setPuntuacion(mPartida.getE1().getPuntuacion() + 1);
                comprobar();
                actualizarMarcador();
                break;
            case R.id.button2:
                mPartida.e1.setPuntuacion(mPartida.getE1().getPuntuacion() + 2);
                comprobar();
                actualizarMarcador();

                break;
            case R.id.button3:
                mPartida.e1.setPuntuacion(mPartida.getE1().getPuntuacion() + 3);
                comprobar();
                actualizarMarcador();

                break;
            case R.id.button4:
                mPartida.e1.setPuntuacion(mPartida.getE1().getPuntuacion() + 5);
                comprobar();
                actualizarMarcador();

                break;
            case R.id.button5:
                mPartida.e1.setPuntuacion(mPartida.getE1().getPuntuacion() + 10);
                comprobar();
                actualizarMarcador();

                break;
            case R.id.button6:
                mPartida.e1.setPuntuacion(mPartida.getE1().getPuntuacion() + 40);
                comprobar();
                actualizarMarcador();

                break;
            case R.id.button7:
                mPartida.e1.setPuntuacion(mPartida.getE1().getPuntuacion() - 1);
                comprobar();
                actualizarMarcador();
                break;
            case R.id.button8:
                mPartida.e1.setPuntuacion(mPartida.getE1().getPuntuacion() - 2);
                comprobar();
                actualizarMarcador();
                break;
            case R.id.button9:
                mPartida.e1.setPuntuacion(mPartida.getE1().getPuntuacion() - 3);
                comprobar();
                actualizarMarcador();
                break;
            case R.id.button10:
                mPartida.e1.setPuntuacion(mPartida.getE1().getPuntuacion() - 5);
                comprobar();
                actualizarMarcador();
                break;
            case R.id.button11:
                mPartida.e1.setPuntuacion(mPartida.getE1().getPuntuacion() - 10);
                comprobar();
                actualizarMarcador();
                break;
            case R.id.button12:
                mPartida.e1.setPuntuacion(mPartida.getE1().getPuntuacion() - 40);
                comprobar();
                actualizarMarcador();
                break;
            case R.id.button101:
                mPartida.e2.setPuntuacion(mPartida.getE2().getPuntuacion() + 1);
                comprobar();
                actualizarMarcador();

                break;
            case R.id.button102:
                mPartida.e2.setPuntuacion(mPartida.getE2().getPuntuacion() + 2);
                comprobar();
                actualizarMarcador();

                break;
            case R.id.button103:
                mPartida.e2.setPuntuacion(mPartida.getE2().getPuntuacion() + 3);
                comprobar();
                actualizarMarcador();

                break;
            case R.id.button104:
                mPartida.e2.setPuntuacion(mPartida.getE2().getPuntuacion() + 5);
                comprobar();
                actualizarMarcador();

                break;
            case R.id.button105:
                mPartida.e2.setPuntuacion(mPartida.getE2().getPuntuacion() + 10);
                comprobar();
                actualizarMarcador();

                break;
            case R.id.button106:
                mPartida.e2.setPuntuacion(mPartida.getE2().getPuntuacion() + 40);
                comprobar();
                actualizarMarcador();

                break;
            case R.id.button107:
                mPartida.e2.setPuntuacion(mPartida.getE2().getPuntuacion() - 1);
                comprobar();
                actualizarMarcador();
                break;
            case R.id.button108:
                mPartida.e2.setPuntuacion(mPartida.getE2().getPuntuacion() - 2);
                comprobar();
                actualizarMarcador();
                break;
            case R.id.button109:
                mPartida.e2.setPuntuacion(mPartida.getE2().getPuntuacion() - 3);
                comprobar();
                actualizarMarcador();
                break;
            case R.id.button1010:
                mPartida.e2.setPuntuacion(mPartida.getE2().getPuntuacion() - 5);
                comprobar();
                actualizarMarcador();
                break;
            case R.id.button1011:
                mPartida.e2.setPuntuacion(mPartida.getE2().getPuntuacion() - 10);
                comprobar();
                actualizarMarcador();
                break;
            case R.id.button1012:
                mPartida.e2.setPuntuacion(mPartida.getE2().getPuntuacion() - 40);
                comprobar();
                actualizarMarcador();
                break;
            /*case R.id.bReset:
                mPartida.e1.setPuntuacion(0);
                comprobar();
                actualizarMarcador();
                mPartida.e2.setPuntuacion(0);
                comprobar();
                actualizarMarcador();
                mPartida.e1.setJuegos(0);
                mPartida.e2.setJuegos(0);
                mPartida.e1.setVacas(0);
                vac1= "Juegos: " + String.valueOf(mPartida.e1.getJuegos()) + ", Vacas: " + String.valueOf(mPartida.e1.getVacas());
                v1.setText(vac1);
                mPartida.e2.setVacas(0);
                vac2= "Juegos: " + String.valueOf(mPartida.e2.getJuegos()) + ", Vacas: " + String.valueOf(mPartida.e2.getVacas());
                v2.setText(vac2);
                break;
            case R.id.bModern:
                volver();
                break;*/
        }
    }

    public void comprobar() {
        if (mPartida.e1.puntuacion >= 40) {
            mPartida.e1.puntuacion = 0;
            mPartida.e2.puntuacion = 0;
            mPartida.e1.juegos++;
            if (mPartida.e1.juegos == mPartida.njuegos) {
                mPartida.e1.juegos = 0;
                mPartida.e2.juegos = 0;
                mPartida.e1.vacas++;
                if (mPartida.e1.vacas == mPartida.nvacas) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Gana el equipo: " + mPartida.e1.nombre, Toast.LENGTH_LONG);
                    mPartida.finalizada = true;
                    mPartida.setMsg("HA GANADO " + mPartida.e1.nombre);
                    toast.show();
                    cargarAnuncio();
                    volver();
                }
            }

        } else if (mPartida.e2.puntuacion >= 40) {
            mPartida.e1.puntuacion = 0;
            mPartida.e2.puntuacion = 0;
            mPartida.e2.juegos++;
            if (mPartida.e2.juegos == mPartida.njuegos) {
                mPartida.e1.juegos = 0;
                mPartida.e2.juegos = 0;
                mPartida.e2.vacas++;
                if (mPartida.e2.vacas == mPartida.nvacas) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Gana el equipo: " + mPartida.e2.nombre, Toast.LENGTH_LONG);
                    mPartida.setMsg("HA GANADO " + mPartida.e2.nombre);
                    mPartida.finalizada = true;
                    toast.show();
                    cargarAnuncio();
                    volver();
                }
            }
        }
    }

    public void actualizarMarcador() {
        // Actualiza la puntuación
        tx1.setText(Integer.toString(mPartida.getE1().getPuntuacion()));
        tx2.setText(Integer.toString(mPartida.getE2().getPuntuacion()));
        v1.setText("Juegos: " + String.valueOf(mPartida.e1.getJuegos()) + ", Vacas: " + String.valueOf(mPartida.e1.getVacas()));
        v2.setText("Juegos: " + String.valueOf(mPartida.e2.getJuegos()) + ", Vacas: " + String.valueOf(mPartida.e2.getVacas()));
    }

    public void volver() {
        Gson gson = new Gson();
        String mPartidaString = gson.toJson(mPartida);
        Intent myIntent = new Intent(ContadorActivity.this, InfoPartidaActivity.class);
        myIntent.putExtra("partidaActual", mPartidaString); //Optional parameters
        startActivity(myIntent);
    }

    public void cargarAnuncio() {
        // set the ad unit ID
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequest);

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();
            }
        });
    }

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }
}
