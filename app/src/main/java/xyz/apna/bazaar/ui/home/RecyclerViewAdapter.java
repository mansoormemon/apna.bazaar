package xyz.apna.bazaar.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import xyz.apna.bazaar.R;


public class RecyclerViewAdapter extends
        RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView subTitle;
        public ImageView img;
        public TextView price;

        public ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.HM_ITMS_title);
            subTitle = itemView.findViewById(R.id.HM_ITMS_subTitle);
            img = itemView.findViewById(R.id.HM_ITMS_IV_product);
            price = itemView.findViewById(R.id.HM_ITMS_price);
        }
    }

    private final List<ItemCardModel> items;

    public RecyclerViewAdapter(List<ItemCardModel> items_) {
        items = items_;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.menu_item_card, parent, false);

        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemCardModel model = items.get(position);

        TextView title = holder.title;
        title.setText(model.getTitle());
        TextView subTitle = holder.subTitle;
        subTitle.setText(model.getSubTitle());
        ImageView img = holder.img;
        img.setBackgroundResource(model.getImgID());
        TextView price = holder.price;
        price.setText("Rs. " + model.getPrice());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
