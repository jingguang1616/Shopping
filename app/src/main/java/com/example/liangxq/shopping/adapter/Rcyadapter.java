package com.example.liangxq.shopping.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.liangxq.shopping.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Rcyadapter extends RecyclerView.Adapter {
    private ArrayList<String> list;
    private Context context;

    public Rcyadapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rcy_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        String s = list.get(position);
        ViewHolder holder1 = (ViewHolder) holder;
        Glide.with(context).load(s).into(holder1.rcyIv);
        holder1.itemTv2.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    static
    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rcy_iv)
        ImageView rcyIv;
        @BindView(R.id.item_tv1)
        TextView itemTv1;
        @BindView(R.id.item_tv2)
        TextView itemTv2;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
