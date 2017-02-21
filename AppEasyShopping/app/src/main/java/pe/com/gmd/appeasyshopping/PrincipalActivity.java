package pe.com.gmd.appeasyshopping;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import pe.com.gmd.appeasyshopping.Clases.MyAdapter;
import pe.com.gmd.appeasyshopping.Entidades.Categoria;

public class PrincipalActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        cargarRecycleView();
    }

    private void cargarRecycleView(){
        mRecyclerView=(RecyclerView)findViewById(R.id.myRecyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        //mAdapter = new MyAdapter(Arrays.asList(getResources().getStringArray(R.array.Categorias)));
        List<Categoria> listCat = new ArrayList();
        listCat.add(new Categoria("Instrumentos", "28 Tipo de Instrumentos",
                "100 Productos", R.drawable.instrumentos));
        listCat.add(new Categoria("accesorios", "28 Tipo de accesorios",
                "100 Productos", R.drawable.accesorios));
        listCat.add(new Categoria("computacion", "28 Tipo de Instrumentos",
                "100 Productos", R.drawable.computacion));
        listCat.add(new Categoria("consolas", "28 Tipo de Instrumentos",
                "100 Productos", R.drawable.consolas));
        listCat.add(new Categoria("deportes", "28 Tipo de Instrumentos",
                "100 Productos", R.drawable.deportes));
        listCat.add(new Categoria("moda", "28 Tipo de Instrumentos",
                "100 Productos", R.drawable.moda));
        listCat.add(new Categoria("hogar", "28 Tipo de Instrumentos",
                "100 Productos", R.drawable.hogar));

        mAdapter = new MyAdapter(listCat);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.principal_activity_actions,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_search:
                Toast.makeText(this,"Buscar Categoria",Toast.LENGTH_SHORT).show();
                break;
           case R.id.action_add:
                Intent inte = new Intent(this,NewProductActivity.class);
                startActivity(inte);
                break;
            case R.id.action_login:
                Intent intelog = new Intent(this,LoginActivity.class);
                startActivity(intelog);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
