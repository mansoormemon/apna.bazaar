package xyz.apna.bazaar.ui.preferences;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import xyz.apna.bazaar.SignInActivity;
import xyz.apna.bazaar.databinding.FragmentPreferencesBinding;

public class PreferencesFragment extends Fragment {

    private FragmentPreferencesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PreferencesViewModel preferencesViewModel =
                new ViewModelProvider(this).get(PreferencesViewModel.class);

        binding = FragmentPreferencesBinding.inflate(inflater, container, false);

        Context context = getContext();
        Button button = binding.PRFBTNSignIn;
        button.setOnClickListener(v -> {
            Intent intent = new Intent(context, SignInActivity.class);
            startActivity(intent);
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        binding = null;
    }
}
