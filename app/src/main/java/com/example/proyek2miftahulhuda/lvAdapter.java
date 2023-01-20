package com.example.proyek2miftahulhuda;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
public class lvAdapter extends ArrayAdapter {
    TypedArray array_logo;
    String[] array_judul;
    String[] array_ket;
    public lvAdapter(Context context, String[] judul1, String[] ket1, TypedArray logo1){
        super(context, R.layout.listview_utama,R.id.idJudul,judul1);
        this.array_logo = logo1;
        this.array_judul = judul1;
        this.array_ket = ket1;
    }
    @NonNull
    @Override
    public View getView (int pos, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.listview_utama,parent,false);
        ImageView tampil_logo = row.findViewById(R.id.idGambar);
        TextView tampil_judul = row.findViewById(R.id.idJudul);
        TextView tampil_ket = row.findViewById(R.id.idKet);
        tampil_logo.setImageResource(array_logo.getResourceId(pos, -1));
        tampil_judul.setText(array_judul[pos]);
        tampil_ket.setText(array_ket[pos]);
        return  row;
    }
}
