package pe.com.gmd.appeasyshopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText textUser;
    private EditText textPassword;
    private TextView tvButton;
    private TextView tvNewAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ui();
    }

    private void ui()
    {
        textUser = (EditText) findViewById(R.id.textName);
        textPassword = (EditText) findViewById(R.id.textPass);
        tvButton= (TextView) findViewById(R.id.tvButton);
        tvNewAccount = (TextView) findViewById(R.id.tvNew);

        events();
    }

    private void events() {
        tvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateFormError()) {
                    gotoMain();
                }
                else{
                    Toast.makeText(LoginActivity.this, "Campos inválidos...",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoSignUp();
            }
        });

    }

    private void gotoSignUp()
    {
        Intent intent = new Intent(this, PrincipalActivity.class);
        startActivity(intent);
        // finish();
    }

    private void gotoMain()
    {
        Intent intent = new Intent(this, PrincipalActivity.class);
        startActivity(intent);
        //  finish();
    }

    private boolean validateFormError()
    {
        String name= textUser.getText().toString().trim();
        String pass= textPassword.getText().toString().trim();

        if(name.isEmpty())
        {
            textUser.setError("Debe ingresar un nombre");
            return false;
        }

        if(pass.isEmpty())
        {
            textPassword.setError("Debe ingresar un password");
            return false;
        }

        return true;
    }
}
