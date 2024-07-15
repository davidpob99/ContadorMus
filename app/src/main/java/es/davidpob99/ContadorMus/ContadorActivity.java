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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
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

        tx1 = findViewById(R.id.textView2);
        tx2 = findViewById(R.id.textView102);
        v1 = findViewById(R.id.textView1);
        v2 = findViewById(R.id.textView101);

        et1 = findViewById(R.id.editText1);
        et2 = findViewById(R.id.editText101);

        btn1 = findViewById(R.id.button1);
        btn1.setOnClickListener(this);
        btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        btn3 = findViewById(R.id.button3);
        btn3.setOnClickListener(this);
        btn4 = findViewById(R.id.button4);
        btn4.setOnClickListener(this);
        btn5 = findViewById(R.id.button5);
        btn5.setOnClickListener(this);
        btn6 = findViewById(R.id.button6);
        btn6.setOnClickListener(this);
        btn7 = findViewById(R.id.button7);
        btn7.setOnClickListener(this);
        btn8 = findViewById(R.id.button8);
        btn8.setOnClickListener(this);
        btn9 = findViewById(R.id.button9);
        btn9.setOnClickListener(this);
        btn10 = findViewById(R.id.button10);
        btn10.setOnClickListener(this);
        btn11 = findViewById(R.id.button11);
        btn11.setOnClickListener(this);
        btn12 = findViewById(R.id.button12);
        btn12.setOnClickListener(this);


        btn101 = findViewById(R.id.button101);
        btn101.setOnClickListener(this);
        btn102 = findViewById(R.id.button102);
        btn102.setOnClickListener(this);
        btn103 = findViewById(R.id.button103);
        btn103.setOnClickListener(this);
        btn104 = findViewById(R.id.button104);
        btn104.setOnClickListener(this);
        btn105 = findViewById(R.id.button105);
        btn105.setOnClickListener(this);
        btn106 = findViewById(R.id.button106);
        btn106.setOnClickListener(this);
        btn107 = findViewById(R.id.button107);
        btn107.setOnClickListener(this);
        btn108 = findViewById(R.id.button108);
        btn108.setOnClickListener(this);
        btn109 = findViewById(R.id.button109);
        btn109.setOnClickListener(this);
        btn1010 = findViewById(R.id.button1010);
        btn1010.setOnClickListener(this);
        btn1011 = findViewById(R.id.button1011);
        btn1011.setOnClickListener(this);
        btn1012 = findViewById(R.id.button1012);
        btn1012.setOnClickListener(this);

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

        et1.setText(mPartida.e1.getJugador1() + " - " + mPartida.e1.getJugador2());
        et2.setText(mPartida.e2.getJugador1() + " - " + mPartida.e2.getJugador2());
        actualizarMarcador();

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
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
                    showInterstitial();
                    // volver();
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
                    // volver();
                }
            }
        }
    }

    public void actualizarMarcador() {
        // Actualiza la puntuación
        tx1.setText(Integer.toString(mPartida.getE1().getPuntuacion()));
        tx2.setText(Integer.toString(mPartida.getE2().getPuntuacion()));
        v1.setText("Juegos: " + mPartida.e1.getJuegos() + ", Vacas: " + mPartida.e1.getVacas());
        v2.setText("Juegos: " + mPartida.e2.getJuegos() + ", Vacas: " + mPartida.e2.getVacas());
    }

    public void volver() {
        Gson gson = new Gson();
        String mPartidaString = gson.toJson(mPartida);
        Intent myIntent = new Intent(ContadorActivity.this, InfoPartidaActivity.class);
        myIntent.putExtra("partidaActual", mPartidaString); //Optional parameters
        startActivity(myIntent);
    }

    private void showInterstitial() {
        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
            @Override
            public void onAdClicked() {
                // Called when a click is recorded for an ad.
                Log.d(TAG, "Ad was clicked.");
                volver();
            }

            @Override
            public void onAdDismissedFullScreenContent() {
                // Called when ad is dismissed.
                // Set the ad reference to null so you don't show the ad a second time.
                Log.d(TAG, "Ad dismissed fullscreen content.");
                mInterstitialAd = null;
                volver();
            }

            @Override
            public void onAdFailedToShowFullScreenContent(AdError adError) {
                // Called when ad fails to show.
                Log.e(TAG, "Ad failed to show fullscreen content.");
                mInterstitialAd = null;
                volver();
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
            mInterstitialAd.show(ContadorActivity.this);
        } else {
            Log.d("Ads", "The interstitial ad wasn't ready yet.");
        }
    }
}
