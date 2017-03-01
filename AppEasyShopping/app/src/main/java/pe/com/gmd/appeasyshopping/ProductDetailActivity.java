package pe.com.gmd.appeasyshopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ProductDetailActivity extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvPrecio;
    private TextView tvDescription;
    private ImageView ivImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        obtenerControles();
      //  cargarCantidades();
        cargarDatosProducto();

        establecerEventos();
    }


    private void obtenerControles()
    {
        tvNombre = (TextView) findViewById(R.id.tvNombreProducto);
        tvPrecio = (TextView) findViewById(R.id.tvPrecioProducto);
        ivImagen = (ImageView) findViewById(R.id.ivImgProducto);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
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

    private void establecerEventos() {

        tvDescription.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                goToDescription();
            }
        });
    }

    private void goToDescription() {
        Intent descriptionActivity = new Intent(this, ProductDescriptionActivity.class);
        startActivity(descriptionActivity);
    }


    private void cargarCantidades(){

        final Spinner dropDownSpinner = (Spinner) findViewById(R.id.spCantidad);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Cantidad, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropDownSpinner.setAdapter(adapter);
        dropDownSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              //  Toast.makeText(ProductDetailActivity.this, dropDownSpinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(ProductDetailActivity.this, "No ha seleccionado una cantidad", Toast.LENGTH_SHORT).show();
            }
        });

        Spinner dialogSpinner = (Spinner) findViewById(R.id.spCantidad);
        dialogSpinner.setAdapter(adapter);
    }
}
