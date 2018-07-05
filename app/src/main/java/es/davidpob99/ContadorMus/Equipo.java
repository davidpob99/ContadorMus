/*
 * Copyright (c) 2016 - 2018 David Población.
 *
 *     This file is part of ContadorMus.
 *
 *     ContadorMus is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Foobar is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with ContadorMus.  If not, see <https://www.gnu.org/licenses/>.
 *
 * Last modified 20/06/18 18:25
 */

package es.davidpob99.ContadorMus;

public class Equipo {
    String nombre;
    String jugador1;
    String jugador2;
    int juegos;
    int vacas;
    int puntuacion;


    public Equipo(String nombre, String j1, String j2) {
        this.nombre = nombre;
        this.jugador1 = j1;
        this.jugador2 = j2;
        this.juegos = 0;
        this.vacas = 0;
        this.puntuacion = 0;

    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getJugador1() {
        return jugador1;
    }

    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }

    public int getJuegos() {
        return juegos;
    }

    public void setJuegos(int juegos) {
        this.juegos = juegos;
    }

    public int getVacas() {
        return vacas;
    }

    public void setVacas(int vacas) {
        this.vacas = vacas;
    }
}
