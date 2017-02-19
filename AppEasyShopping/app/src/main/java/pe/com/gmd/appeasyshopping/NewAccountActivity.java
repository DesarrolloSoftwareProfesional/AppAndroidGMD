package pe.com.gmd.appeasyshopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewAccountActivity extends AppCompatActivity {

    private EditText txtUser, txtPassword, txtFullName, txtEmail;
    private Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);

        formSignUp();
    }

    private void formSignUp() {

        txtUser = (EditText) findViewById(R.id.txtUserName);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtFullName = (EditText) findViewById(R.id.txtFullName);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        btnRegistrar = (Button) findViewById(R.id.btnRegistro);

        formEvents();
    }

    private void formEvents() {

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateFormError())
                {
                   gotoLogin();

                }else
                {
                    Toast.makeText(NewAccountActivity.this, "Ingreso de datos incorrecto",
                            Toast.LENGTH_SHORT).show();
                }
            }


        });
    }

    private void gotoLogin() {

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private boolean validateFormError() {

        return true;
    }
}
