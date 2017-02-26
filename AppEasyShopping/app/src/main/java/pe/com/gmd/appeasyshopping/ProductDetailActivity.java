package pe.com.gmd.appeasyshopping;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProductDetailActivity extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        obtenerControles();
        cargarDatosProducto();
    }

    private void obtenerControles()
    {
        tvNombre = (TextView) findViewById(R.id.tvNombreProducto);
        tvPrecio = (TextView) findViewById(R.id.tvPrecioProducto);
    }

    private void cargarDatosProducto() {

        String nombreProducto = "";
        String precioProducto = "";

        if (getIntent().getExtras().getString("nombreProducto")!=null)
        {
            nombreProducto = getIntent().getExtras().getString("nombreProducto").toString();
            tvNombre.setText(nombreProducto);
        }

        if(getIntent().getExtras().getString("precioProducto")!= null)
        {
            precioProducto = getIntent().getExtras().getString("precioProducto").toString();
            tvPrecio.setText(precioProducto);
        }
    }
}
