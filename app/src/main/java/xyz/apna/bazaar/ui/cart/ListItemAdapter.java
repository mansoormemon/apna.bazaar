package xyz.apna.bazaar.ui.cart;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import xyz.apna.bazaar.Item;
import xyz.apna.bazaar.R;

public class ListItemAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] titles;
    private final Item[] items;

    public ListItemAdapter(Activity context_, String[] titles_, Item[] items_) {
        super(context_, R.layout.menu_cart_items, titles_);

        context = context_;
        titles = titles_;
        items = items_;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        @SuppressLint({"ViewHolder", "InflateParams"}) View rowView = inflater.inflate(R.layout.menu_cart_items, null, true);

        TextView name = rowView.findViewById(R.id.CRT_ITMS_name);
        name.setText(items[position].getName());
        TextView price = rowView.findViewById(R.id.CRT_ITMS_price);
        price.setText(String.valueOf("Rs. " + items[position].getPrice()));
        TextView quantity = rowView.findViewById(R.id.CRT_ITMS_quantity);
        quantity.setText(String.valueOf(items[position].getQuantity()));
        TextView category = rowView.findViewById(R.id.CRT_ITMS_category);
        category.setText(items[position].getCategory());
        TextView unit = rowView.findViewById(R.id.CRT_ITMS_unit);
        unit.setText(items[position].getUnit());

        return rowView;
    }
}
