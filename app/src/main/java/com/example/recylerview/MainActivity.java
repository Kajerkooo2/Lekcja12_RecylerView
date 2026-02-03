package com.example.recylerview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Produkt> produkty = new ArrayList<>();
    private RecyclerView recyclerView;
    private ZakupyAdapter zakupyAdapter;
    private Button buttonDodaj;

    private EditText editTextCena, editTextNazwa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        produkty.add(new Produkt("maslo",5.75));
        produkty.add(new Produkt("parowki",3.75));
        produkty.add(new Produkt("woda",2));
        produkty.add(new Produkt("Dubai Choclate",55.55));
        produkty.add(new Produkt("Coca-cola",9.80));
        produkty.add(new Produkt("Chips Lays Zielona Cebulka",7.99));
        produkty.add(new Produkt("Trunk dla doroslych",49.99));
        produkty.add(new Produkt("chleb",3.99));

        recyclerView = findViewById(R.id.recyclerView);
        zakupyAdapter = new ZakupyAdapter(MainActivity.this, produkty);
        recyclerView.setAdapter(zakupyAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        buttonDodaj = findViewById(R.id.buttonDodaj);
        editTextNazwa = findViewById(R.id.editTextNazwa);
        editTextCena = findViewById(R.id.editTextCena);

        buttonDodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nazwaProduktu = editTextNazwa.getText().toString();
                double cena = Double.parseDouble((editTextCena.getText().toString()));
                produkty.add(new Produkt(nazwaProduktu,cena));

                zakupyAdapter.notifyDataSetChanged();
                editTextCena.setText("");
                editTextNazwa.setText("");
            }

        });
    }
}