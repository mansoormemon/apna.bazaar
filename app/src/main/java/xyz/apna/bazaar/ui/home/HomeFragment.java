package xyz.apna.bazaar.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import xyz.apna.bazaar.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    SearchView svDefault;
    ImageButton ibtnNotifications;
    RecyclerView rvTopSelling;
    RecyclerView rvVegies;
    RecyclerView rvFruits;

    ArrayList<ItemCardModel> topSellingItems;
    ArrayList<ItemCardModel> vegeies;
    ArrayList<ItemCardModel> fruits;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);

        svDefault = binding.MHSVDefault;
        svDefault.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Stub: Search query", Toast.LENGTH_SHORT).show();
        });

        ibtnNotifications = binding.HMIBTNNotification;
        ibtnNotifications.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Stub: Notifications", Toast.LENGTH_SHORT).show();
        });

        topSellingItems = Inventory.getTopSellingProducts();
        rvTopSelling = binding.HMRVTopSelling;
        RecyclerViewAdapter adapterTopSelling = new RecyclerViewAdapter(topSellingItems);
        rvTopSelling.setAdapter(adapterTopSelling);
        rvTopSelling.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));

        vegeies = Inventory.getVegies();
        rvVegies = binding.HMRVVegies;
        RecyclerViewAdapter adapterVegies = new RecyclerViewAdapter(vegeies);
        rvVegies.setAdapter(adapterVegies);
        rvVegies.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));

        fruits = Inventory.getFruits();
        rvFruits = binding.HMRVFruits;
        RecyclerViewAdapter adapterFruits = new RecyclerViewAdapter(fruits);
        rvFruits.setAdapter(adapterFruits);
        rvFruits.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        binding = null;
    }
}
