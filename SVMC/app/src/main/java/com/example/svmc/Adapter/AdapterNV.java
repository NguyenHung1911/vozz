package com.example.svmc.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.svmc.R;
import com.example.svmc.model.iteam;

import java.util.ArrayList;
import java.util.List;

public class AdapterNV extends RecyclerView.Adapter<AdapterNV.HomeViewHolder>{
    private ArrayList<iteam> list;
    private IteamListener iteamListener;

    public void setList(ArrayList<iteam> list) {
        this.list = list;
        notifyDataSetChanged();
    }


    public void setIteamListener(IteamListener iteamListener) {
        this.iteamListener = iteamListener;
    }

    public iteam getIteam(int pos) {
        return list.get(pos);
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.iteam, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        iteam it = list.get(position);
        holder.nameNV.setText(it.getName());
        holder.dateNV.setText(it.getDate());
        holder.timeStartNV.setText(it.getTimeStart());
        holder.timeEndNV.setText(it.getTimeEnd());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nameNV, dateNV, timeStartNV, timeEndNV;

        public HomeViewHolder(@NonNull View view) {
            super(view);
            nameNV = view.findViewById(R.id.nameNv);
            dateNV = view.findViewById(R.id.dateNV);
            timeStartNV = view.findViewById(R.id.timeStartNV);
            timeEndNV = view.findViewById(R.id.timeEndNV);

        }

        @Override
        public void onClick(View view) {
            if(iteamListener != null) {
                iteamListener.onIteamClick(view, getAdapterPosition());
            }
        }
    }

    public interface IteamListener {
        void onIteamClick(View view, int pos);
    }
}
