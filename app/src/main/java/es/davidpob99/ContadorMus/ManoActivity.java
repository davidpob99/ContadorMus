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

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

public class ManoActivity extends AppCompatActivity {

    TextView e1Nombre;
    TextView e2Nombre;
    TextView e1Puntuacion;
    TextView e2Puntuacion;
    TextView grande;
    TextView chica;
    TextView par;
    TextView juego;

    RadioButton rb1Grande;
    RadioButton rb2Grande;
    RadioButton rb1Chica;
    RadioButton rb2Chica;
    RadioButton rb1Par;
    RadioButton rb2Par;
    RadioButton rb1Juego;
    RadioButton rb2Juego;

    Partida mPartida;
    InterstitialAd mInterstitialAd;

    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    Button b10;
    Button b11;
    Button b12;
    Button b13;
    Button b14;
    Button b15;
    Button b16;
    Button b17;
    Button b18;
    Button b19;
    Button b20;
    Button b21;
    Button b22;
    Button b23;
    Button b24;
    Button b25;
    Button b26;
    Button b27;
    Button b28;
    Button b29;
    Button b30;
    Button b31;
    Button b32;
    Button b33;
    Button b34;
    Button b35;
    Button b36;
    Button b37;
    Button b38;
    Button b39;
    Button b40;
    Button b41;
    Button b42;
    Button b43;
    Button b44;
    Button b45;
    Button b46;
    Button b47;
    Button b48;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mano);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Gson gson = new Gson();

        final String mPartidaString = getIntent().getStringExtra("partidaActual");
        mPartida = gson.fromJson(mPartidaString, Partida.class);

        e1Nombre = findViewById(R.id.tvE1Nombre);
        e2Nombre = findViewById(R.id.tvE2Nombre);

        e1Puntuacion = findViewById(R.id.tvE1Puntuacion);
        e2Puntuacion = findViewById(R.id.tvE2Puntuacion);

        grande = findViewById(R.id.tvGrande);
        chica = findViewById(R.id.tvChica);
        par = findViewById(R.id.tvPar);
        juego = findViewById(R.id.tvJuego);

        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        b10 = findViewById(R.id.button10);
        b11 = findViewById(R.id.button11);
        b12 = findViewById(R.id.button12);
        b13 = findViewById(R.id.button13);
        b14 = findViewById(R.id.button14);
        b15 = findViewById(R.id.button15);
        b16 = findViewById(R.id.button16);
        b17 = findViewById(R.id.button17);
        b18 = findViewById(R.id.button18);
        b19 = findViewById(R.id.button19);
        b20 = findViewById(R.id.button20);
        b21 = findViewById(R.id.button21);
        b22 = findViewById(R.id.button22);
        b23 = findViewById(R.id.button23);
        b24 = findViewById(R.id.button24);
        b25 = findViewById(R.id.button25);
        b26 = findViewById(R.id.button26);
        b27 = findViewById(R.id.button27);
        b28 = findViewById(R.id.button28);
        b29 = findViewById(R.id.button29);
        b30 = findViewById(R.id.button30);
        b31 = findViewById(R.id.button31);
        b32 = findViewById(R.id.button32);
        b33 = findViewById(R.id.button33);
        b34 = findViewById(R.id.button34);
        b35 = findViewById(R.id.button35);
        b36 = findViewById(R.id.button36);
        b37 = findViewById(R.id.button37);
        b38 = findViewById(R.id.button38);
        b39 = findViewById(R.id.button39);
        b40 = findViewById(R.id.button40);
        b41 = findViewById(R.id.button41);
        b42 = findViewById(R.id.button42);
        b43 = findViewById(R.id.button43);
        b44 = findViewById(R.id.button44);
        b45 = findViewById(R.id.button45);
        b46 = findViewById(R.id.button46);
        b47 = findViewById(R.id.button47);
        b48 = findViewById(R.id.button48);

        e1Nombre.setText(mPartida.e1.nombre);
        e2Nombre.setText(mPartida.e2.nombre);
        e1Puntuacion.setText(String.valueOf(mPartida.e1.puntuacion));
        e2Puntuacion.setText(String.valueOf(mPartida.e2.puntuacion));

        rb1Grande = findViewById(R.id.checkE1Grande);
        rb2Grande = findViewById(R.id.checkE2Grande);
        rb1Chica = findViewById(R.id.checkE1Chica);
        rb2Chica = findViewById(R.id.checkE2Chica);
        rb1Par = findViewById(R.id.checkE1Par);
        rb2Par = findViewById(R.id.checkE2Par);
        rb1Juego = findViewById(R.id.checkE1Juego);
        rb2Juego = findViewById(R.id.checkE2Juego);

        AdRequest adRequestInter = new AdRequest.Builder().build();
        InterstitialAd.load(this, getResources().getString(R.string.interstitial_full_screen), adRequestInter,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i(TAG, "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.d("Ads", loadAdError.toString());
                        mInterstitialAd = null;
                    }
                });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO : SETTERS GETTERS
                if (rb1Grande.isChecked())
                    mPartida.e1.puntuacion += Integer.valueOf(grande.getText().toString());
                else if (rb2Grande.isChecked())
                    mPartida.e2.puntuacion += Integer.valueOf(grande.getText().toString());
                if (rb1Chica.isChecked() && mPartida.e1.puntuacion < 40 && mPartida.e2.puntuacion < 40)
                    mPartida.e1.puntuacion += Integer.valueOf(chica.getText().toString());
                else if (rb2Chica.isChecked() && mPartida.e1.puntuacion < 40 && mPartida.e2.puntuacion < 40)
                    mPartida.e2.puntuacion += Integer.valueOf(chica.getText().toString());
                if (rb1Par.isChecked() && mPartida.e1.puntuacion < 40 && mPartida.e2.puntuacion < 40)
                    mPartida.e1.puntuacion += Integer.valueOf(par.getText().toString());
                else if (rb2Par.isChecked() && mPartida.e1.puntuacion < 40 && mPartida.e2.puntuacion < 40)
                    mPartida.e2.puntuacion += Integer.valueOf(par.getText().toString());
                if (rb1Juego.isChecked() && mPartida.e1.puntuacion < 40 && mPartida.e2.puntuacion < 40)
                    mPartida.e1.puntuacion += Integer.valueOf(juego.getText().toString());
                else if (rb2Juego.isChecked() && mPartida.e1.puntuacion < 40 && mPartida.e2.puntuacion < 40)
                    mPartida.e2.puntuacion += Integer.valueOf(juego.getText().toString());

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
                            showInterstitial();
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
                            showInterstitial();
                        }
                    }
                }
                if (!mPartida.finalizada)
                    volver(true);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Back button
        // grande.setFilters(new InputFilter[]{ new CustomRangeInputFilter(0,40)});
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        startActivity(new Intent(ManoActivity.this, InfoPartidaActivity.class));
        return super.onKeyDown(keyCode, event);
    }


    public void onClicked(View v) {
        switch (v.getId()) {
            case R.id.button1:
                grande.setText(String.valueOf(Integer.valueOf(grande.getText().toString()) + Integer.valueOf(b1.getText().toString())));
                break;
            case R.id.button2:
                grande.setText(String.valueOf(Integer.valueOf(grande.getText().toString()) + Integer.valueOf(b2.getText().toString())));
                break;
            case R.id.button3:
                grande.setText(String.valueOf(Integer.valueOf(grande.getText().toString()) + Integer.valueOf(b3.getText().toString())));
                break;
            case R.id.button4:
                grande.setText(String.valueOf(Integer.valueOf(grande.getText().toString()) + Integer.valueOf(b4.getText().toString())));
                break;
            case R.id.button5:
                grande.setText(String.valueOf(Integer.valueOf(grande.getText().toString()) + Integer.valueOf(b5.getText().toString())));
                break;
            case R.id.button6:
                grande.setText(String.valueOf(Integer.valueOf(grande.getText().toString()) + Integer.valueOf(b6.getText().toString())));
                break;
            case R.id.button7:
                grande.setText(String.valueOf(Integer.valueOf(grande.getText().toString()) - Integer.valueOf(b7.getText().toString())));
                break;
            case R.id.button8:
                grande.setText(String.valueOf(Integer.valueOf(grande.getText().toString()) - Integer.valueOf(b8.getText().toString())));
                break;
            case R.id.button9:
                grande.setText(String.valueOf(Integer.valueOf(grande.getText().toString()) - Integer.valueOf(b9.getText().toString())));
                break;
            case R.id.button10:
                grande.setText(String.valueOf(Integer.valueOf(grande.getText().toString()) - Integer.valueOf(b10.getText().toString())));
                break;
            case R.id.button11:
                grande.setText(String.valueOf(Integer.valueOf(grande.getText().toString()) - Integer.valueOf(b11.getText().toString())));
                break;
            case R.id.button12:
                grande.setText(String.valueOf(Integer.valueOf(grande.getText().toString()) - Integer.valueOf(b12.getText().toString())));
                break;
            case R.id.button13:
                chica.setText(String.valueOf(Integer.valueOf(chica.getText().toString()) + Integer.valueOf(b13.getText().toString())));
                break;
            case R.id.button14:
                chica.setText(String.valueOf(Integer.valueOf(chica.getText().toString()) + Integer.valueOf(b14.getText().toString())));
                break;
            case R.id.button15:
                chica.setText(String.valueOf(Integer.valueOf(chica.getText().toString()) + Integer.valueOf(b15.getText().toString())));
                break;
            case R.id.button16:
                chica.setText(String.valueOf(Integer.valueOf(chica.getText().toString()) + Integer.valueOf(b16.getText().toString())));
                break;
            case R.id.button17:
                chica.setText(String.valueOf(Integer.valueOf(chica.getText().toString()) + Integer.valueOf(b17.getText().toString())));
                break;
            case R.id.button18:
                chica.setText(String.valueOf(Integer.valueOf(chica.getText().toString()) + Integer.valueOf(b18.getText().toString())));
                break;
            case R.id.button19:
                chica.setText(String.valueOf(Integer.valueOf(chica.getText().toString()) - Integer.valueOf(b19.getText().toString())));
                break;
            case R.id.button20:
                chica.setText(String.valueOf(Integer.valueOf(chica.getText().toString()) - Integer.valueOf(b20.getText().toString())));
                break;
            case R.id.button21:
                chica.setText(String.valueOf(Integer.valueOf(chica.getText().toString()) - Integer.valueOf(b21.getText().toString())));
                break;
            case R.id.button22:
                chica.setText(String.valueOf(Integer.valueOf(chica.getText().toString()) - Integer.valueOf(b22.getText().toString())));
                break;
            case R.id.button23:
                chica.setText(String.valueOf(Integer.valueOf(chica.getText().toString()) - Integer.valueOf(b23.getText().toString())));
                break;
            case R.id.button24:
                par.setText(String.valueOf(Integer.valueOf(par.getText().toString()) + Integer.valueOf(b24.getText().toString())));
                break;
            case R.id.button25:
                par.setText(String.valueOf(Integer.valueOf(par.getText().toString()) + Integer.valueOf(b25.getText().toString())));
                break;
            case R.id.button26:
                par.setText(String.valueOf(Integer.valueOf(par.getText().toString()) + Integer.valueOf(b26.getText().toString())));
                break;
            case R.id.button27:
                par.setText(String.valueOf(Integer.valueOf(par.getText().toString()) + Integer.valueOf(b27.getText().toString())));
                break;
            case R.id.button28:
                par.setText(String.valueOf(Integer.valueOf(par.getText().toString()) + Integer.valueOf(b28.getText().toString())));
                break;
            case R.id.button29:
                par.setText(String.valueOf(Integer.valueOf(par.getText().toString()) + Integer.valueOf(b29.getText().toString())));
                break;
            case R.id.button30:
                par.setText(String.valueOf(Integer.valueOf(par.getText().toString()) - Integer.valueOf(b30.getText().toString())));
                break;
            case R.id.button31:
                par.setText(String.valueOf(Integer.valueOf(par.getText().toString()) - Integer.valueOf(b31.getText().toString())));
                break;
            case R.id.button32:
                par.setText(String.valueOf(Integer.valueOf(par.getText().toString()) - Integer.valueOf(b32.getText().toString())));
                break;
            case R.id.button33:
                par.setText(String.valueOf(Integer.valueOf(par.getText().toString()) - Integer.valueOf(b33.getText().toString())));
                break;
            case R.id.button34:
                par.setText(String.valueOf(Integer.valueOf(par.getText().toString()) - Integer.valueOf(b34.getText().toString())));
                break;
            case R.id.button35:
                par.setText(String.valueOf(Integer.valueOf(par.getText().toString()) - Integer.valueOf(b35.getText().toString())));
                break;
            case R.id.button36:
                juego.setText(String.valueOf(Integer.valueOf(juego.getText().toString()) + Integer.valueOf(b36.getText().toString())));
                break;
            case R.id.button37:
                juego.setText(String.valueOf(Integer.valueOf(juego.getText().toString()) + Integer.valueOf(b37.getText().toString())));
                break;
            case R.id.button38:
                juego.setText(String.valueOf(Integer.valueOf(juego.getText().toString()) + Integer.valueOf(b38.getText().toString())));
                break;
            case R.id.button39:
                juego.setText(String.valueOf(Integer.valueOf(juego.getText().toString()) + Integer.valueOf(b39.getText().toString())));
                break;
            case R.id.button40:
                juego.setText(String.valueOf(Integer.valueOf(juego.getText().toString()) + Integer.valueOf(b40.getText().toString())));
                break;
            case R.id.button41:
                juego.setText(String.valueOf(Integer.valueOf(juego.getText().toString()) + Integer.valueOf(b41.getText().toString())));
                break;
            case R.id.button42:
                juego.setText(String.valueOf(Integer.valueOf(juego.getText().toString()) - Integer.valueOf(b42.getText().toString())));
                break;
            case R.id.button43:
                juego.setText(String.valueOf(Integer.valueOf(juego.getText().toString()) - Integer.valueOf(b43.getText().toString())));
                break;
            case R.id.button44:
                juego.setText(String.valueOf(Integer.valueOf(juego.getText().toString()) - Integer.valueOf(b44.getText().toString())));
                break;
            case R.id.button45:
                juego.setText(String.valueOf(Integer.valueOf(juego.getText().toString()) - Integer.valueOf(b45.getText().toString())));
                break;
            case R.id.button46:
                juego.setText(String.valueOf(Integer.valueOf(juego.getText().toString()) - Integer.valueOf(b46.getText().toString())));
                break;
            case R.id.button47:
                juego.setText(String.valueOf(Integer.valueOf(juego.getText().toString()) - Integer.valueOf(b47.getText().toString())));
                break;
            case R.id.button48:
                chica.setText(String.valueOf(Integer.valueOf(chica.getText().toString()) - Integer.valueOf(b48.getText().toString())));
                break;

        }
    }

    public void volver(boolean from) {
        Gson gson = new Gson();
        String mPartidaString = gson.toJson(mPartida);
        Intent myIntent = new Intent(ManoActivity.this, InfoPartidaActivity.class);
        myIntent.putExtra("partidaActual", mPartidaString);
        if (from)
            myIntent.putExtra("from", "ManoActivity");
        startActivity(myIntent);
    }

    private void showInterstitial() {
        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
            @Override
            public void onAdClicked() {
                // Called when a click is recorded for an ad.
                Log.d(TAG, "Ad was clicked.");
                volver(false);
            }

            @Override
            public void onAdDismissedFullScreenContent() {
                // Called when ad is dismissed.
                // Set the ad reference to null so you don't show the ad a second time.
                Log.d(TAG, "Ad dismissed fullscreen content.");
                mInterstitialAd = null;
                volver(false);
            }

            @Override
            public void onAdFailedToShowFullScreenContent(AdError adError) {
                // Called when ad fails to show.
                Log.e(TAG, "Ad failed to show fullscreen content.");
                mInterstitialAd = null;
                volver(false);
            }

            @Override
            public void onAdImpression() {
                // Called when an impression is recorded for an ad.
                Log.d(TAG, "Ad recorded an impression.");
            }

            @Override
            public void onAdShowedFullScreenContent() {
                // Called when ad is shown.
                Log.d(TAG, "Ad showed fullscreen content.");
            }
        });
        if (mInterstitialAd != null) {
            mInterstitialAd.show(ManoActivity.this);
        } else {
            Log.d("Ads", "The interstitial ad wasn't ready yet.");
        }
    }
}
