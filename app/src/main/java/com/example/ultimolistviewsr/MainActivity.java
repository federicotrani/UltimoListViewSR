package com.example.ultimolistviewsr;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listViewContactos;
    private List<Contacto> listaContactos;
    private ContactoAdapter adapter;
    private SwipeRefreshLayout swipeContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaContactos = new ArrayList<>();

        cargarLista();

        adapter = new ContactoAdapter(listaContactos);

        listViewContactos = findViewById(R.id.listViewContactos);

        swipeContactos = findViewById(R.id.swipeContactos);

        listViewContactos.setAdapter(adapter);

        listViewContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Seleccionó: " + listaContactos.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });

        swipeContactos.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                cargarListaOnLine();

                adapter.notifyDataSetChanged();

                swipeContactos.setRefreshing(false);

            }
        });

    }

    private void cargarLista() {

        listaContactos.clear();
        listaContactos.add(new Contacto("Luis","Perez","luis@email.com","022-334455","Belgrano 222",R.drawable.masculino));
        listaContactos.add(new Contacto("Roberto","Fernandez","luis@email.com","022-334455","Belgrano 222",R.drawable.masculino));

    }

    private void cargarListaOnLine() {

        listaContactos.clear();
        listaContactos.add(new Contacto("Maria","Perez","luis@email.com","022-334455","Belgrano 222",R.drawable.femenino));
        listaContactos.add(new Contacto("Maria","Perez","luis@email.com","022-334455","Belgrano 222",R.drawable.femenino));
        listaContactos.add(new Contacto("Maria","Perez","luis@email.com","022-334455","Belgrano 222",R.drawable.femenino));
        listaContactos.add(new Contacto("Maria","Perez","luis@email.com","022-334455","Belgrano 222",R.drawable.femenino));
    }

}
