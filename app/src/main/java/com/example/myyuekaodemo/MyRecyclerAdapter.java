package com.example.myyuekaodemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 执笔画商
 * on 2018/1/16.
 * at 北京
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private MyBean[] myBeans;
    private Context mContext;

    public MyRecyclerAdapter(MyBean[] myBeans, Context mContext) {
        this.myBeans = myBeans;
        this.mContext = mContext;
    }

    @Override
    public int getItemViewType(int position) {
        return myBeans[position].getType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case 0:
                View receiveritemview = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
                holder = new ReceiverViewHolder(receiveritemview);
                break;
            case 1:

                View senditemview = LayoutInflater.from(mContext).inflate(R.layout.item2, parent, false);
                holder = new SendViewHolder(senditemview);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyBean myBean = myBeans[position];
        int type = myBean.getType();
        List<String> images = myBean.getImages();


        switch (type) {
            case 0:

                ((ReceiverViewHolder)holder).idTv.setText(myBeans[position].getId());
                ((ReceiverViewHolder)holder).nameTv.setText(myBeans[position].getName());
                ((ReceiverViewHolder)holder).priceTv.setText(myBeans[position].getPrice());

                break;
            case 1:

                ((SendViewHolder)holder).idTv1.setText(myBeans[position].getId());
                ((SendViewHolder)holder).nameTv1.setText(myBeans[position].getName());
                ((SendViewHolder)holder).priceTv1.setText(myBeans[position].getPrice());
                break;
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,ContentActivity.class);

                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return myBeans.length;
    }

    //    接受的viewholder
    public class ReceiverViewHolder extends RecyclerView.ViewHolder {

        private final TextView nameTv;
        private final TextView priceTv;
        private final TextView idTv;
        private final ImageView imageView;

        public ReceiverViewHolder(View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.name);
            priceTv = itemView.findViewById(R.id.price);
            idTv = itemView.findViewById(R.id.id);
            imageView = itemView.findViewById(R.id.image_view);

        }
    }

    //    发送的viewholder
    public class SendViewHolder extends RecyclerView.ViewHolder {

        private final TextView nameTv1;
        private final TextView priceTv1;
        private final TextView idTv1;
        private final ImageView imageView1;
        private final ImageView imageView2;
        private final ImageView imageView3;
        public SendViewHolder(View itemView) {
            super(itemView);
            nameTv1 = itemView.findViewById(R.id.name);
            priceTv1 = itemView.findViewById(R.id.price);
            idTv1 = itemView.findViewById(R.id.id);
            imageView1 = itemView.findViewById(R.id.image_view1);
            imageView2 = itemView.findViewById(R.id.image_view2);
            imageView3 = itemView.findViewById(R.id.image_view3);
        }
    }

}

