package pe.com.gmd.appeasyshopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
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
        cargarSpinner();
    }

    private void cargarSpinner(){
        final Spinner dropDownSpinner = (Spinner) findViewById(R.id.dropDownSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Categorias, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropDownSpinner.setAdapter(adapter);
        dropDownSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(NewProduct2Activity.this, dropDownSpinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(NewProduct2Activity.this, "Nada fue seleccionado", Toast.LENGTH_SHORT).show();

            }
        });


        Spinner dialogSpinner = (Spinner) findViewById(R.id.dialogSpinner);
        dialogSpinner.setAdapter(adapter);
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
