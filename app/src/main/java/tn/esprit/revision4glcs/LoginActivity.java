package tn.esprit.revision4glcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUserName, edtPassword;
    private CheckBox cbRemember;
    private Button btnLogin;

    private SharedPreferences mPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        cbRemember = findViewById(R.id.cbRemember);
        btnLogin = findViewById(R.id.btnLogin);

        mPref = getSharedPreferences("tn.esprit.revision4glcs", MODE_PRIVATE);

        btnLogin.setOnClickListener(view -> {
            if (validate()){

                SharedPreferences.Editor editor = mPref.edit();
                editor.putString("USER", edtUserName.getText().toString());
                editor.putString("PWD", edtPassword.getText().toString());
                editor.putBoolean("REMEMBER", cbRemember.isChecked());
                editor.apply();

                Intent mainIntent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(mainIntent);
                finish();
            }
        });
    }

    private boolean validate(){

        if (edtUserName.getText().toString().isEmpty()){
            Toast.makeText(this, "Empty Fields !", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (edtPassword.getText().toString().isEmpty()){
            Toast.makeText(this, "Empty Fields !", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!edtUserName.getText().toString().equals("admin") && edtPassword.getText().toString().equals("admin")){
            Toast.makeText(this, "Wrong Credentials !", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}