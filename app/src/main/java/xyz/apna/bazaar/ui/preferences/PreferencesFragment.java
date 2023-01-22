package xyz.apna.bazaar.ui.preferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.auth.FirebaseAuth;

import xyz.apna.bazaar.MainActivity;
import xyz.apna.bazaar.R;
import xyz.apna.bazaar.SignInActivity;
import xyz.apna.bazaar.databinding.FragmentPreferencesBinding;

public class PreferencesFragment extends Fragment {

    private FragmentPreferencesBinding binding;

    protected Button btnSignIn;
    protected TextView linkSignOut;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PreferencesViewModel preferencesViewModel =
                new ViewModelProvider(this).get(PreferencesViewModel.class);

        binding = FragmentPreferencesBinding.inflate(inflater, container, false);

        Context context = requireContext();

        btnSignIn = binding.PRFBTNSignIn;
        linkSignOut = binding.PRFTVSignOut;

        boolean isSignedIn = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE)
                .getBoolean(getString(R.string.key_is_signed_in), false);

        btnSignIn.setVisibility(isSignedIn ? View.INVISIBLE : View.VISIBLE);
        linkSignOut.setVisibility(isSignedIn ? View.VISIBLE : View.INVISIBLE);

        btnSignIn.setOnClickListener(v -> {
            Intent intent = new Intent(context, SignInActivity.class);
            startActivity(intent);
        });

        linkSignOut.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getContext(), MainActivity.class));

            SharedPreferences.Editor preferencesEditor = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE).edit();
            preferencesEditor.putBoolean(getString(R.string.key_is_signed_in), false);
            preferencesEditor.apply();
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        binding = null;
    }
}
