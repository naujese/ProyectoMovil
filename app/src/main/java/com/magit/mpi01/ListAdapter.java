package com.magit.mpi01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<ListElement> mData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(List<ListElement> itemList, Context context){
        this.mInflater=LayoutInflater.from(context);
        this.context=context;
        this.mData=itemList;
    }

    @Override
    public int getItemCount() { return mData.size();}

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view=mInflater.inflate(R.layout.list_element, null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position) {
        holder.bindData(mData.get(position));
    }

    public void setItems(List<ListElement> items) {mData=items;}

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImage;
        TextView locate, info;

        ViewHolder(View itemView) {
            super(itemView);
            iconImage=itemView.findViewById(R.id.iconImageView);
            locate=itemView.findViewById(R.id.locateTextView);
            info=itemView.findViewById(R.id.infoTextView);
        }

        void bindData(final  ListElement item) {
            iconImage.setImageIcon(item.setImage());
            locate.setText(item.getTexto());
            info.setText(item.getInfo());
        }
    }
}
