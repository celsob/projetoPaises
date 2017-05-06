package usjt.br.projetopaises;

import android.os.Bundle;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class ListapaisesActivity extends AppCompatActivity {
    Activity atividade;
    ArrayList<String> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_paises);
        atividade = this;
        Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.CHAVE);
        lista = buscaClientes(chave);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
    }

    public ArrayList<String> buscaClientes(String chave){
        ArrayList<String> lista = geraListaClientes();
        if(chave == null || chave.length() == 0){
            return lista;
        }else{
            ArrayList<String> subList = new ArrayList<>();
            for(String nome:lista){
                if(nome.toUpperCase().contains(chave.toUpperCase())){
                    subList.add(nome);
                }
            }
            return subList;
        }
    }



    public ArrayList<String> geraListaClientes() {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Oscar");
        lista.add("Rafael");
        lista.add("Celso");
        return lista;
    }
}
