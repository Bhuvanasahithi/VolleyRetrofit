package com.example.sahithi.objectparsing;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RetrofitAdapter extends RecyclerView.Adapter<RetrofitAdapter.MyViewHolder> {
    Context context;
    List<ImageModel> list;
    RetrofitAdapter(Context context,List<ImageModel> list)
    {
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.retrofit_data,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
            ImageModel imageModel=list.get(i);
            myViewHolder.textView.setText(imageModel.getId()+" "+imageModel.getAlbumId()+" "+imageModel.getTitle()+" "+imageModel.getUrl()+" "+imageModel.getThumbnailUrl());
            Picasso.with(context).load(imageModel.getThumbnailUrl()).into(myViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.imageview);
            textView=(TextView)itemView.findViewById(R.id.textview);
        }
    }
}
