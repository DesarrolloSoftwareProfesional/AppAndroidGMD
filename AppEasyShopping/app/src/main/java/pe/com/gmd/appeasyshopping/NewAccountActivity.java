package pe.com.gmd.appeasyshopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                    Toast.makeText(NewAccountActivity.this, getResources().getString(R.string.msgIngresoUsuarioExitoso),
                            Toast.LENGTH_SHORT).show();
                   gotoLogin();

                }else
                {
                    Toast.makeText(NewAccountActivity.this, getResources().getString(R.string.msgIngresoUsuarioErrone),
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

        String user= txtUser.getText().toString().trim();
        String password = txtPassword.getText().toString().trim();
        String fullName = txtFullName.getText().toString().trim();
        String email = txtEmail.getText().toString().trim();

        if (user.isEmpty())
        {
            txtUser.setError(getResources().getString(R.string.msgUsuarioInvalido));
            return false;
        }

        if (password.isEmpty())
        {
            txtPassword.setError(getResources().getString(R.string.msgPasswordInvalido));
            return false;
        }

        if (fullName.isEmpty()){
            txtFullName.setError(getResources().getString(R.string.msgNombreInvalido));
            return false;
        }

        if (email.isEmpty()){
            txtEmail.setError(getResources().getString(R.string.msgEmailInvalido));
            return false;
        }

        if(!isEmailValid(email))
        {
            txtEmail.setError(getResources().getString(R.string.msgEmailFormatoInvalido));
            return false;
        }

        return true;
    }

    public boolean isEmailValid(String email) {
        String regExpn =
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        if(matcher.matches())
            return true;
        else
            return false;
    }

}
