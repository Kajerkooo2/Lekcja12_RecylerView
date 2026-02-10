Recycler Viewer instrukcja:
Layout Setup
--
1. Dodanie klasy obiektu
2. Dodanie nowego layout res -> new -> new resource layout
3. Dodanie widoku elementu do tego nowego layout
4. Next -> uzupelnienie main layoutu -> dodanie recylerView (pamietac o dodaniu id do recyclerView bo domyslnie go nie ma)
---
   RecyclerView adapter class
6. Dodanie ZakupyAdapter (adapter do RecyclerView) -> extends RecyclerView.Adapter<ZakupyAdapter.ProduktViewHolder(showContextAction -> implementMethods)
potem ->  public class ProduktViewHolder extends RecyclerView.ViewHolder (kilkamy prawa showContextAction -> create constructor matching super)
7. Dodawanie zmiennych -> potem generowanie consturctora (trzeba dodac w konstruktorze Context context potem by dodac do niego inflater -> patrz kod)
8. Definiowanie widokow w ProduktViewHolder (  public CheckBox checkBoxView; ZakupyAdapter zakupyAdapter - > public ProduktViewHolder(@NonNull View itemView, ZakupyAdapter adapter) {
            super(itemView);
            checkBoxView = itemView.findViewById(R.id.checkBox);
            zakupyAdapter = adapter;
        })
9. Definowanie metod (w tym przypadku GetItemCount() na rozmiar listy produkty)
10. Modyfikacja metody OnCreate by zwracala nowy widok (View itemView = inflater.inflate(R.layout.product_layout,parent,false -> return new ProduktViewHolder(itemView,this))
11. Bindowanie pozycji listy w onBindViewHolder (holder.checkBoxView.setText(produkty.get(position).toString());)
---
Main Activity
12. Dodanie zmiennych potem -> dodanie przykladowych rekordow do listy
13. Podłaczenie recyclerView do listy -> na poczatku znalezienie reycler view po id (recyclerView = findViewById(R.id.recyclerView) -> potem zakupyAdapter = new ZakupyAdapter(MainActivity.this, produkty); -> no i podlaczenie do recyler
do adaptera -> recyclerView.setAdapter(zakupyAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
14. Dodawanie nowego elementu listy klasycznie na poczatku podlaczyc guziki, edit texty itp -> sluchacz klikniecia na guzik ->  @Override
            public void onClick(View view) {
                String nazwaProduktu = editTextNazwa.getText().toString();
                double cena = Double.parseDouble((editTextCena.getText().toString()));
                produkty.add(new Produkt(nazwaProduktu,cena));

                zakupyAdapter.notifyDataSetChanged();
                editTextCena.setText("");
                editTextNazwa.setText("");
            }
---
Powrot do Zakupy adapter (sprawdzanie czy produkt kupiony)
15. Dodanie implementacji View.Onclick w ProduktViewHolder -> potem showcontext -> implement methods (tworzy metode onclick)
16. Dodanie nowej zmiennej ktoryProdukt = getLayoutPostion() ->  Produkt produktAktualny = produkty.get(ktoruProdukt);
17. Dodanie if-a sprawdzajcego czy produkt jest zakupiony czy nie -> if(produktAktualny.isCzyKupione()){
                produktAktualny.setCzyKupione(false);
            }
            else{
                produktAktualny.setCzyKupione(true);
            }
            checkBoxView.setChecked(produktAktualny.isCzyKupione());
            zakupyAdapter.notifyDataSetChanged();
18.
