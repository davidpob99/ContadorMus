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

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PartidaViewHolder> {

    List<Partida> partidas;
    RecyclerViewClickListener listener;


    RVAdapter(List<Partida> partidas, RecyclerViewClickListener listener) {
        this.partidas = partidas;
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return partidas.size();
    }

    @Override
    public PartidaViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, viewGroup, false);
        final PartidaViewHolder pvh = new PartidaViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickItem(v, pvh.getLayoutPosition());
            }
        });
        return pvh;
    }

    @Override
    public void onBindViewHolder(PartidaViewHolder partidaViewHolder, int i) {
        partidaViewHolder.e1J.setText(partidas.get(i).getE1().getNombre() + " (" + partidas.get(i).getE1().getJugador1() + " - " + partidas.get(i).getE1().getJugador2() + ")");
        partidaViewHolder.e2J.setText(partidas.get(i).getE2().getNombre() + " (" + partidas.get(i).getE2().getJugador1() + " - " + partidas.get(i).getE2().getJugador2() + ")");

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        partidaViewHolder.fecha.setText(df.format(partidas.get(i).getFecha()));

        if (partidas.get(i).isFinalizada()) partidaViewHolder.terminada.setText("TERMINADA");
        else partidaViewHolder.terminada.setText("");

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class PartidaViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView e1J;
        TextView e2J;
        TextView fecha;
        TextView terminada;

        PartidaViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            e1J = itemView.findViewById(R.id.tvE1J);
            e2J = itemView.findViewById(R.id.tvE2J);
            fecha = itemView.findViewById(R.id.tvFecha);
            terminada = itemView.findViewById(R.id.tvTerminada);
        }
    }

}