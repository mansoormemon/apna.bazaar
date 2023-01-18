package xyz.apna.bazaar;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import xyz.apna.bazaar.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    protected ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.MA_NV_main);
        NavController navController =
                Navigation.findNavController(this, R.id.MA_F_host);
        NavigationUI.setupWithNavController(binding.MANVMain, navController);
    }

}