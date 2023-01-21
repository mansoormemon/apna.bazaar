package xyz.apna.bazaar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;

public class SignInActivity extends AppCompatActivity {
    protected TextInputEditText boxEmail;
    protected TextInputEditText boxPassword;
    protected TextView linkForgotPassword;
    protected Button btnSignIn;
    protected ImageButton btnGoogle;
    protected TextView linkSignUp;

    protected GoogleSignInOptions gso;
    protected GoogleSignInClient gsc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_in);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);

        boxEmail = findViewById(R.id.SIA_TIET_email);
        boxPassword = findViewById(R.id.SIA_TIET_password);

        linkForgotPassword = findViewById(R.id.SIA_TV_forgotPassword);
        linkForgotPassword.setOnClickListener(v -> Toast.makeText(this, "Stub: Forgot Password", Toast.LENGTH_SHORT).show());

        btnSignIn = findViewById(R.id.SIA_BTN_signIn);
        btnSignIn.setOnClickListener(v -> {
        });

        btnGoogle = findViewById(R.id.SIA_IBTN_google);
        btnGoogle.setOnClickListener(v -> {
            Intent signInIntent = gsc.getSignInIntent();
            startActivityForResult(signInIntent, 1000);
        });

        linkSignUp = findViewById(R.id.SIA_TV_signUp);
        linkSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try {
                task.getResult(ApiException.class);
                Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                startActivity(intent);
            } catch (ApiException e) {
                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
