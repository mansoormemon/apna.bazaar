package xyz.apna.bazaar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class BillingFragment extends DialogFragment {

    protected Button btnPay;
    protected TextView footnote;

    protected double totalPrice;

    public BillingFragment(double totalPrice_) {
        totalPrice = totalPrice_;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.fragment_billing, null);

        footnote = dialogView.findViewById(R.id.BIL_TV_footnote);
        footnote.setText(footnote.getText().toString().replace("%%price%%", String.valueOf(totalPrice)));

        btnPay = dialogView.findViewById(R.id.BIL_BTN_pay);
        btnPay.setOnClickListener(v -> {
            dismiss();
            new AlertDialog.Builder(getContext())
                    .setTitle("Success")
                    .setMessage("Your account was debited for Rs. " + totalPrice + ".")
                    .setNeutralButton(android.R.string.yes, null)
                    .setIcon(null)
                    .show();
        });

        builder.setView(dialogView);
        return builder.create();
    }
}
