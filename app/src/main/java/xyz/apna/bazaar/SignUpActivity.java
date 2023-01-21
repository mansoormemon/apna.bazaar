package xyz.apna.bazaar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class SignUpActivity extends AppCompatActivity {
    final int MIN_PASSWORD_LEN = 8;

    protected TextInputEditText boxEmail;
    protected TextInputEditText boxPassword;
    protected RadioGroup radioGender;
    protected TextInputEditText boxContact;
    protected CheckBox ckbLegal;
    protected Button btnSignUp;
    protected TextView linkSignIn;

    protected FirebaseAuth auth;
    protected FirebaseUser user;

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
        ProgressDialog progressDialog = new ProgressDialog(this);

        FirebaseApp.initializeApp(getBaseContext());
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        btnSignUp.setOnClickListener(v -> {
            String email = Objects.requireNonNull(boxEmail.getText()).toString();
            String password = Objects.requireNonNull(boxPassword.getText()).toString();
            String contact = Objects.requireNonNull(boxContact.getText()).toString();

            if (!email.matches(String.valueOf(Patterns.EMAIL_ADDRESS))) {
                boxEmail.setError("Enter correct email");
            } else if (password.isEmpty() || password.length() < MIN_PASSWORD_LEN) {
                boxPassword.setError("Enter correct password");
            } else {
                progressDialog.setMessage("Registering...");
                progressDialog.setTitle("Registration");
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();

                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        progressDialog.dismiss();
                        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        Toast.makeText(SignUpActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(SignUpActivity.this, String.valueOf(task.getException()), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        linkSignIn = findViewById(R.id.SUA_TV_signIn);
        linkSignIn.setOnClickListener(v -> {
            Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
            startActivity(intent);
        });
    }
}
