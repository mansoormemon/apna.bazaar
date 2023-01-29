package xyz.apna.bazaar.ui.cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import xyz.apna.bazaar.Item;
import xyz.apna.bazaar.R;

public class CurrentFragment extends Fragment {

    protected Button btnCheckOut;

    protected ListView cartItems;
    protected TextView price;

    public CurrentFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_current, container, false);

        Item[] items = Item.load();
        double totalPrice = 0.0;

        String[] titles = new String[items.length];
        for (int i = 0; i < titles.length; ++i) {
            titles[i] = items[i].getName();
            totalPrice += items[i].getPrice();
        }

        cartItems = rootView.findViewById(R.id.CRT_LV_cartItems);
        ListItemAdapter adapter = new ListItemAdapter(getActivity(), titles, items);
        cartItems.setAdapter(adapter);

        price = rootView.findViewById(R.id.CRT_CUR_TV_price);
        price.setText(String.valueOf(totalPrice));

        btnCheckOut = rootView.findViewById(R.id.CRT_CUR_BTN_checkout);
        double finalTotalPrice = totalPrice;
        btnCheckOut.setOnClickListener(v -> {
            BillingFragment billingFragment = new BillingFragment(finalTotalPrice);
            billingFragment.show(getChildFragmentManager(), null);
        });

        return rootView;
    }
}
