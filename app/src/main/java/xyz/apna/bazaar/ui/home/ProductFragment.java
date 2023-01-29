package xyz.apna.bazaar.ui.home;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import xyz.apna.bazaar.R;

public class ProductFragment extends DialogFragment {

    private final ItemCardModel model;

    private int productQuantity = 1;

    public ProductFragment(ItemCardModel model_) {
        model = model_;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.fragment_product, null);

        ImageView img = dialogView.findViewById(R.id.PDT_IV_product);
        img.setBackgroundResource(model.getImgID());

        TextView title = dialogView.findViewById(R.id.PDT_TV_title);
        title.setText(model.getTitle());

        TextView subTitle = dialogView.findViewById(R.id.PDT_TV_subTitle);
        subTitle.setText(model.getSubTitle());

        TextView price = dialogView.findViewById(R.id.PDT_TV_price);
        price.setText("Rs. " + model.getPrice());

        TextView quantity = dialogView.findViewById(R.id.PDT_TV_quantity);
        quantity.setText(String.valueOf(productQuantity));

        FloatingActionButton increment = dialogView.findViewById(R.id.PDT_FBA_increment);
        FloatingActionButton decrement = dialogView.findViewById(R.id.PDT_FBA_decrement);
        decrement.setEnabled(false);
        increment.setOnClickListener(v -> {
            productQuantity += 1;
            quantity.setText(String.valueOf(productQuantity));
            decrement.setEnabled(productQuantity > 1);
        });
        decrement.setOnClickListener(v -> {
            productQuantity -= 1;
            quantity.setText(String.valueOf(productQuantity));
            decrement.setEnabled(productQuantity > 1);
        });

        Button addToCart = dialogView.findViewById(R.id.PDT_BTN_addToCart);
        addToCart.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Added to cart.", Toast.LENGTH_SHORT).show();
        });

        builder.setView(dialogView);
        return builder.create();
    }
}
