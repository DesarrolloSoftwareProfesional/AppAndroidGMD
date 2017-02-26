package pe.com.gmd.appeasyshopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProductDetailActivity extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvPrecio;
    private ImageView ivImagen;

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
        ivImagen = (ImageView) findViewById(R.id.ivImgProducto);
    }

    private void cargarDatosProducto() {

        String nombreProducto = "";
        String precioProducto = "";
        String codigoProducto = "";

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

        if (getIntent().getExtras().getString("codigoProducto") != null)
        {
            codigoProducto = getIntent().getExtras().getString("codigoProducto").toString().trim();

            switch (codigoProducto){
                case "1":
                    ivImagen.setImageResource(R.drawable.guitarra1);
                    break;
                case "2":
                    ivImagen.setImageResource(R.drawable.guitarra2);
                    break;
                case "3":
                    ivImagen.setImageResource(R.drawable.guitarra3);
                    break;
                case "4":
                    ivImagen.setImageResource(R.drawable.guitarra4);
                    break;
                default:
                    break;
            }

        }



    }
}
