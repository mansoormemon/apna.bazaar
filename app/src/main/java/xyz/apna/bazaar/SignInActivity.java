package xyz.apna.bazaar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {
    protected Button btnSignIn;
    protected TextView linkForgotPassword;
    protected TextView linkSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_in);

        btnSignIn = findViewById(R.id.SIA_BTN_signIn);
        btnSignIn.setOnClickListener(v -> {
            Toast.makeText(this, "Sign In", Toast.LENGTH_SHORT).show();
        });

        linkForgotPassword = findViewById(R.id.SIA_TV_forgotPassword);
        linkForgotPassword.setOnClickListener(v -> Toast.makeText(this, "Stub: Forgot Password", Toast.LENGTH_SHORT).show());

        linkSignUp = findViewById(R.id.SIA_TV_signUp);
        linkSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
            startActivity(intent);
        });
    }
}