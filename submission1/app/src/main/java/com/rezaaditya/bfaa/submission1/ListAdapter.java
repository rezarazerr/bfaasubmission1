package com.rezaaditya.bfaa.submission1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    public Context context;
    private ArrayList<User> userArrayList;

    public ListAdapter(ArrayList<User> List) {

        this.userArrayList = List;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_user, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int position) {



//
        final User user = userArrayList.get(position);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("DATA_USER", user);
                context.startActivity(intent);
            }
        });
//
//
        viewHolder.img_user.setImageResource(user.getAvatar());
        viewHolder.tv_name.setText(user.getName());
        viewHolder.tv_company.setText(user.getCompany());



    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img_user;
        TextView tv_name,tv_company;
        ViewHolder(View view){
            super(view);

            context = view.getContext();
            img_user = view.findViewById(R.id.img_user);
            tv_name  = view.findViewById(R.id.tv_name);
            tv_company = view.findViewById(R.id.tv_company);
        }


    }


}
