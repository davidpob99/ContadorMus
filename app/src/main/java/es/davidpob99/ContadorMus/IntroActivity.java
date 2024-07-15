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

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class IntroActivity extends AppIntro {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        showStatusBar(false);
        setSkipText("SALTAR");
        setDoneText("HECHO");

        // Just set a title, description, background and image. AppIntro will do the rest.
        addSlide(AppIntroFragment.newInstance("Bienvenido",
                "Para comenzar, cree una nueva partida en '+' y rellene los datos. En esta vista se irán añadiendo las partidas. Para abrir una partida, toque en ella.",
                R.drawable.screenshot_main,
                getResources().getColor(R.color.colorPrimary)));

        addSlide(AppIntroFragment.newInstance("Información",
                "Para guardar una nueva jugada o lance, pulse en cualquiera de los botones inferiores, dependiendo si se prefiere el contador moderno (derecha) o el clásico (izquierda).",
                R.drawable.screenshot_info,
                getResources().getColor(R.color.colorPrimaryDark)));

        addSlide(AppIntroFragment.newInstance("Opción A: Contador Moderno",
                "Rellene los datos correspondientes a cada jugada y después de haber descubierto las cartas marque el ganador de cada una y pulse el botón.",
                R.drawable.screenshot_mano,
                getResources().getColor(R.color.colorAccent)));

        addSlide(AppIntroFragment.newInstance("Opción B: Contador Clásico",
                "Posibilidad de acceder al antiguo contador pulsando el botón izquierdo a la hora de comenzar una nueva jugada.",
                R.drawable.screenshot_classic,
                getResources().getColor(R.color.cardview_dark_background)));


    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Do something when users tap on Skip button.
        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        // Do something when users tap on Done button.
        finish();
    }
}
