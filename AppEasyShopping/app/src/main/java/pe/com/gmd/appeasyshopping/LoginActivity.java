package pe.com.gmd.appeasyshopping;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.NotificationCompatSideChannelService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText textUser;
    private EditText textPassword;
    private TextView tvButton;
    private TextView tvNewAccount;
    private CheckBox chkGuardarUsuario;
    private static String mySharedPreferences = "myUsuario";
    private static String mykeyUsuarioSharedPerefences = "Usuario";
    private static String mykeyEstadoSharedPerefences = "EstadoShared";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ui();
    }

    private void ui() {
        textUser = (EditText) findViewById(R.id.textName);
        textPassword = (EditText) findViewById(R.id.textPass);
        tvButton = (TextView) findViewById(R.id.tvButton);
        tvNewAccount = (TextView) findViewById(R.id.tvNew);
        chkGuardarUsuario = (CheckBox) findViewById(R.id.chkGuardarUsuario);
        events();
        cargarUsuarioGuardado();
    }

    private void cargarUsuarioGuardado() {
        SharedPreferences sp = getSharedPreferences(mySharedPreferences, Context.MODE_PRIVATE);
        String nombreUsuario = sp.getString(mykeyUsuarioSharedPerefences, "");
        Boolean estadoShared = sp.getBoolean(mykeyEstadoSharedPerefences,false);
        if (estadoShared){
            chkGuardarUsuario.setChecked(true);
            if (!nombreUsuario.isEmpty()) {
                textUser.setText(nombreUsuario);
            }
        }
    }

    private void events() {
        tvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateFormError()) {
                    guardarUsuario();
                    gotoMain();
                } else {
                    Toast.makeText(LoginActivity.this, getResources().getString(R.string.descCamposInvalidos),
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

    private void guardarUsuario() {
        SharedPreferences sp = getSharedPreferences(mySharedPreferences, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if (chkGuardarUsuario.isChecked()) {
            editor.putBoolean(mykeyEstadoSharedPerefences,true);
            editor.putString(mykeyUsuarioSharedPerefences, textUser.getText().toString());
            //editor.putString("Password", textPassword.getText().toString());
            editor.apply();
        } else {
            editor.clear();
            editor.apply();
        }
    }

    private void gotoSignUp() {
        Intent intent = new Intent(this, NewAccountActivity.class);
        startActivity(intent);
        // finish();
    }

    private void gotoMain() {
        Intent intent = new Intent(this, PrincipalActivity.class);
        startActivity(intent);
        //  finish();
    }

    private boolean validateFormError() {
        String name = textUser.getText().toString().trim();
        String pass = textPassword.getText().toString().trim();

        if (name.isEmpty()) {
            textUser.setError(getResources().getString(R.string.alertIngresarNombre));
            return false;
        }

        if (pass.isEmpty()) {
            textPassword.setError(getResources().getString(R.string.alertIngresarContrasenia));
            return false;
        }
        return true;
    }
}
