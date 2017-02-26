package pe.com.gmd.appeasyshopping;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pe.com.gmd.appeasyshopping.Clases.ProductAdapter;
import pe.com.gmd.appeasyshopping.Entidades.Producto;

import static pe.com.gmd.appeasyshopping.R.id.prodListRecyclerView;

public class ProductListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        cargarListaProductos();
    }

    private void cargarListaProductos() {

        mRecyclerView=(RecyclerView)findViewById(prodListRecyclerView);
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        List<Producto> lista = new ArrayList();
        lista.add(new Producto("Guitarra Acústica Importada, Mastil Reforzado + Acccesorios","","Precio: $220.30", R.drawable.guitarra1));
        lista.add(new Producto("Guitarra Erasmo Falcon Clasica De Estudio D-carlo","","Precio: $320.30", R.drawable.guitarra2));
        lista.add(new Producto("Guitarra Martin Smith Acustica Jumbo Importada D-carlo","","Precio: $1560.50", R.drawable.guitarra3));
        lista.add(new Producto("Guitarra Electrica Importada Starsun Lespaul Custom /d-carlo","","Precio: $1560.50", R.drawable.guitarra4));

        mAdapter = new ProductAdapter(lista);
        mRecyclerView.setAdapter(mAdapter);
    }
}
