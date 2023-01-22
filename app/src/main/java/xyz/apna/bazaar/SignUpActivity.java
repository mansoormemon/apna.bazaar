package xyz.apna.bazaar;

import static android.view.WindowManager.LayoutParams;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class SignUpActivity extends AppCompatActivity {
    final int MIN_PASSWORD_LEN = 8;
    final String REQUIRED = "*Required";

    final String EMAIL_HELPER_TEXT = "Example: john@doe.com";
    final String CONTACT_HELPER_TEXT = "Example: +92 XXXXXXXXXX";

    protected TextInputEditText boxEmail;
    protected TextInputLayout lytEmail;

    protected TextInputEditText boxPassword;
    protected TextInputLayout lytPassword;

    protected RadioGroup radioGender;

    protected TextInputEditText boxContact;
    protected TextInputLayout lytContact;

    protected CheckBox ckbLegal;

    protected Button btnSignUp;

    protected TextView linkSignIn;

    protected ProgressBar progressBar;

    protected FirebaseAuth auth;
    protected FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_up);

        boxEmail = findViewById(R.id.SUA_TIET_email);
        lytEmail = findViewById(R.id.SUA_TIL_email);
        lytEmail.setHelperText(EMAIL_HELPER_TEXT);

        boxPassword = findViewById(R.id.SUA_TIET_password);
        lytPassword = findViewById(R.id.SUA_TIL_password);

        radioGender = findViewById(R.id.SUA_RG_gender);

        boxContact = findViewById(R.id.SUA_TIET_contact);
        lytContact = findViewById(R.id.SUA_TIL_contact);
        lytContact.setHelperText(CONTACT_HELPER_TEXT);

        ckbLegal = findViewById(R.id.SUA_CKB_legal);
        ckbLegal.setOnCheckedChangeListener((buttonView, isChecked) -> {
            btnSignUp.setEnabled(isChecked);
        });

        btnSignUp = findViewById(R.id.SUA_BTN_signUp);
        btnSignUp.setEnabled(false);

        progressBar = findViewById(R.id.SUA_PB_registering);

        FirebaseApp.initializeApp(getBaseContext());
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        btnSignUp.setOnClickListener(v -> {
            boolean isEmailValid = false;
            boolean isPasswordValid = false;
            boolean isContactValid = false;

            String email = Objects.requireNonNull(boxEmail.getText()).toString();
            String password = Objects.requireNonNull(boxPassword.getText()).toString();
            String contact = Objects.requireNonNull(boxContact.getText()).toString();

            if (email.isEmpty()) {
                lytEmail.setError(REQUIRED);
            } else if (!email.matches(String.valueOf(Patterns.EMAIL_ADDRESS))) {
                lytEmail.setError("Invalid email address");
            } else {
                lytEmail.setError(null);
                isEmailValid = true;
            }

            if (password.isEmpty()) {
                lytPassword.setError(REQUIRED);
            } else if (password.length() < MIN_PASSWORD_LEN) {
                lytPassword.setError("Password must be at least 8 characters long");
            } else {
                lytPassword.setError(null);
                isPasswordValid = true;
            }

            if (contact.isEmpty()) {
                lytContact.setError(REQUIRED);
            } else {
                lytContact.setError(null);
                isContactValid = true;
            }

            if (isEmailValid && isPasswordValid && isContactValid) {
                progressBar.setVisibility(View.VISIBLE);

                getWindow().setFlags(LayoutParams.FLAG_NOT_TOUCHABLE,
                        LayoutParams.FLAG_NOT_TOUCHABLE);

                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        Toast.makeText(SignUpActivity.this, "Registration successful.", Toast.LENGTH_SHORT).show();

                        SharedPreferences.Editor preferencesEditor = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE).edit();
                        preferencesEditor.putBoolean(getString(R.string.key_is_signed_in), true);
                        preferencesEditor.apply();
                    } else {
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
