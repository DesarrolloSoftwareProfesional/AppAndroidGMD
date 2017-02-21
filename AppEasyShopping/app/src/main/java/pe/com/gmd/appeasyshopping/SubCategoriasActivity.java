package pe.com.gmd.appeasyshopping;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SubCategoriasActivity extends AppCompatActivity {
    private String nomCategoria="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_categorias);
        cargarParametros();
    }

    private void cargarParametros(){
        if (getIntent().getExtras().getString("nomCategoria")!=null){
            nomCategoria = getIntent().getExtras().getString("nomCategoria").toString().trim();
        }
        if (!nomCategoria.isEmpty()){
            Toast.makeText(this,nomCategoria,Toast.LENGTH_LONG).show();
        }
    }
}
