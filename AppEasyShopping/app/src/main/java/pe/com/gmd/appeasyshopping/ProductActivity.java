package pe.com.gmd.appeasyshopping;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pe.com.gmd.appeasyshopping.Clases.ProductAdapter;
import pe.com.gmd.appeasyshopping.Entidades.Producto;

import static pe.com.gmd.appeasyshopping.R.id.prodRecyclerView;

public class ProductActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        cargarProductos();
    }

    private void cargarProductos()
    {
        mRecyclerView=(RecyclerView)findViewById(prodRecyclerView);
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        List<Producto> lista = new ArrayList();
        lista.add(new Producto("1","Guitarra","Precio: $220.30","Cantidad: 50", R.drawable.guitarra));
        lista.add(new Producto("2","Trompeta","Precio: $320.30","Cantidad: 100", R.drawable.trompeta));
        lista.add(new Producto("3","Violin","Precio: $1560.50","Cantidad: 30", R.drawable.violin));
        lista.add(new Producto("4","Saxofón","Precio: $1560.50","Cantidad: 10", R.drawable.saxo));

        mAdapter = new ProductAdapter(lista, false);
        mRecyclerView.setAdapter(mAdapter);

    }
}
