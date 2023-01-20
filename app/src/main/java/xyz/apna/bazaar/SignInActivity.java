package xyz.apna.bazaar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class SignInActivity extends AppCompatActivity {
    protected TextInputEditText boxEmail;
    protected TextInputEditText boxPassword;
    protected TextView linkForgotPassword;
    protected Button btnSignIn;
    protected ImageButton btnGoogle;
    protected TextView linkSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_in);

        boxEmail = findViewById(R.id.SIA_TIET_email);
        boxPassword = findViewById(R.id.SIA_TIET_password);

        linkForgotPassword = findViewById(R.id.SIA_TV_forgotPassword);
        linkForgotPassword.setOnClickListener(v -> Toast.makeText(this, "Stub: Forgot Password", Toast.LENGTH_SHORT).show());

        btnSignIn = findViewById(R.id.SIA_BTN_signIn);
        btnSignIn.setOnClickListener(v -> {
        });

        btnGoogle = findViewById(R.id.SIA_IBTN_google);
        btnGoogle.setOnClickListener(v -> {
            Toast.makeText(this, "Stub: Sign in with Google", Toast.LENGTH_SHORT).show();
        });

        linkSignUp = findViewById(R.id.SIA_TV_signUp);
        linkSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
            startActivity(intent);
        });
    }
}
