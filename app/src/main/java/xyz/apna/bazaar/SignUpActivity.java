package xyz.apna.bazaar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class SignUpActivity extends AppCompatActivity {
    protected TextInputEditText boxEmail;
    protected TextInputEditText boxPassword;
    protected RadioGroup radioGender;
    protected TextInputEditText boxContact;
    protected CheckBox ckbLegal;
    protected Button btnSignUp;
    protected ImageButton btnGoogle;
    protected TextView linkSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_up);

        boxEmail = findViewById(R.id.SUA_TIET_email);

        boxPassword = findViewById(R.id.SUA_TIET_password);

        radioGender = findViewById(R.id.SUA_RG_gender);

        boxContact = findViewById(R.id.SUA_TIET_contact);

        ckbLegal = findViewById(R.id.SUA_CKB_legal);

        btnSignUp = findViewById(R.id.SUA_BTN_signUp);

        btnGoogle = findViewById(R.id.SUA_IBTN_google);
        btnGoogle.setOnClickListener(v -> {
            Toast.makeText(this, "Stub: Sign in with Google", Toast.LENGTH_SHORT).show();
        });

        linkSignIn = findViewById(R.id.SUA_TV_signIn);
        linkSignIn.setOnClickListener(v -> {
            Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
            startActivity(intent);
        });
    }

}
