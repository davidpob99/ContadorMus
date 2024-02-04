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

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Calendar;
import java.util.Date;

public class Partida implements Parcelable {
    public static final Creator<Partida> CREATOR = new Creator<Partida>() {
        @Override
        public Partida createFromParcel(Parcel in) {
            return new Partida(in);
        }

        @Override
        public Partida[] newArray(int size) {
            return new Partida[size];
        }
    };
    Equipo e1;
    Equipo e2;
    int njuegos;
    int nvacas;
    Date fecha;
    boolean finalizada;
    int posicion;
    String msg;
    String observaciones;

    public Partida(int nj, int nv, Equipo e1, Equipo e2, String observaciones) {
        this.njuegos = nj;
        this.nvacas = nv;
        this.e1 = e1;
        this.e2 = e2;
        this.fecha = Calendar.getInstance().getTime();
        this.finalizada = false;
        this.posicion = -1;
        this.msg = "EN JUEGO";
        this.observaciones = observaciones;
    }

    protected Partida(Parcel in) {
        njuegos = in.readInt();
        nvacas = in.readInt();
        finalizada = in.readByte() != 0;
        posicion = in.readInt();
        msg = in.readString();
        observaciones = in.readString();
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public Equipo getE1() {
        return e1;
    }

    public void setE1(Equipo e1) {
        this.e1 = e1;
    }

    public Equipo getE2() {
        return e2;
    }

    public void setE2(Equipo e2) {
        this.e2 = e2;
    }

    public int getNjuegos() {
        return njuegos;
    }

    public void setNjuegos(int njuegos) {
        this.njuegos = njuegos;
    }

    public int getNvacas() {
        return nvacas;
    }

    public void setNvacas(int nvacas) {
        this.nvacas = nvacas;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(njuegos);
        dest.writeInt(nvacas);
        dest.writeByte((byte) (finalizada ? 1 : 0));
        dest.writeInt(posicion);
        dest.writeString(msg);
        dest.writeString(observaciones);
    }
}
