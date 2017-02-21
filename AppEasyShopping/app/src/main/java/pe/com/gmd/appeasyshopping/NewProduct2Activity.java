package pe.com.gmd.appeasyshopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NewProduct2Activity extends AppCompatActivity {

    private EditText etNombreProducto;
    private EditText etDescription;
    private EditText etPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product2);
        ui();
    }

    private void ui()
    {
        etNombreProducto = (EditText) findViewById(R.id.etNombreProducto);
        etDescription = (EditText) findViewById(R.id.etDescription);
        etPrecio = (EditText) findViewById(R.id.etPrecio);
        events();
    }

    private void events() {
        findViewById(R.id.btnOk2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateFormError()) {
                    gotoMain();
                }
                else{
                    Toast.makeText(NewProduct2Activity.this, "Campos inválidos...",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void gotoMain()
    {
        Intent intent = new Intent(this, NewProduct3Activity.class);
        startActivity(intent);
        //  finish();
    }

    private boolean validateFormError()
    {
        String producto = etNombreProducto.getText().toString().trim();
        String descripcion = etDescription.getText().toString().trim();
        String precio = etPrecio.getText().toString().trim();

        if(producto.isEmpty())
        {
            etNombreProducto.setError("Debe ingresar un nombre");
            return false;
        }

        if(descripcion.isEmpty())
        {
            etDescription.setError("Debe ingresar una descripción");
            return false;
        }

        if(precio.isEmpty())
        {
            etPrecio.setError("Debe ingresar un precio");
            return false;
        }
        return true;
    }
}
