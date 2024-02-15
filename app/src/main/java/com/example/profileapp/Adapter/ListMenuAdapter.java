package com.example.profileapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.profileapp.DetailActivity;
import com.example.profileapp.Model.Menu;
import com.example.profileapp.R;
import com.example.profileapp.Utils;

import java.util.ArrayList;

public class ListMenuAdapter extends RecyclerView.Adapter<ListMenuAdapter.ListMenuViewHolder> {
    Context context;
    ArrayList<Menu> menuList;

    public ListMenuAdapter(Context context, ArrayList<Menu> menuList){
        this.context = context;
        this.menuList = menuList;
    }

    @NonNull
    @Override
    public ListMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_food_menu, parent, false);
        ListMenuViewHolder vh = new ListMenuViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ListMenuViewHolder holder, int position) {
        final Menu currentMenu = menuList.get(position);

        Glide.with(context)
                .load(Utils.getDrawable(context, currentMenu.getImage()))
                .into(holder.ivFoodThumbnail);

        holder.tvFoodTitle.setText(currentMenu.getTitle());
        holder.tvFoodPrice.setText(currentMenu.getPrice());
        holder.tvFoodDesc.setText(currentMenu.getDesc());

        holder.cvContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra("menuList", menuList);
                intent.putExtra("currentMenu", currentMenu);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public class ListMenuViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoodThumbnail;
        TextView tvFoodTitle, tvFoodDesc, tvFoodPrice;
        CardView cvContainer;
        public ListMenuViewHolder(@NonNull View itemView) {
            super(itemView);
            initUi();
        }

        private void initUi(){
            ivFoodThumbnail = itemView.findViewById(R.id.iv_food_thumbnail);
            tvFoodTitle = itemView.findViewById(R.id.tv_food_title);
            tvFoodDesc = itemView.findViewById(R.id.tv_food_desc);
            tvFoodPrice = itemView.findViewById(R.id.tv_food_price);
            cvContainer = itemView.findViewById(R.id.rvMenu);
        }
    }
}
