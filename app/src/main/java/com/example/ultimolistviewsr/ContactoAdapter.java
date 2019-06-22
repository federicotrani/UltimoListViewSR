package com.example.ultimolistviewsr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContactoAdapter extends BaseAdapter {

    List<Contacto> listaContacto;

    public ContactoAdapter(List<Contacto> listaContacto) {
        this.listaContacto = listaContacto;
    }

    @Override
    public int getCount() {
        return listaContacto.size();
    }

    @Override
    public Contacto getItem(int position) {
        return listaContacto.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;

        // optimizacion
        if(convertView==null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_contactos, null);
        }else{
            view = convertView;
        }

        Contacto item = getItem(position);

        ImageView imageViewFoto = view.findViewById(R.id.imageViewFoto);
        TextView textViewNombre = view.findViewById(R.id.textViewNombre);
        TextView textViewEmail = view.findViewById(R.id.textViewEmail);
        TextView textViewTelefono = view.findViewById(R.id.textViewTelefono);

        imageViewFoto.setImageResource(item.getFoto());
        textViewNombre.setText(item.toString());
        textViewEmail.setText(item.getEmail());
        textViewTelefono.setText(item.getTelefono());

        return view;
    }
}
