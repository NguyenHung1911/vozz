package com.example.svmc.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.svmc.Adapter.AdapterNV;
import com.example.svmc.R;
import com.example.svmc.SqliteHelper;
import com.example.svmc.UpdateActivity;
import com.example.svmc.model.iteam;

import java.util.ArrayList;
import java.util.List;

public class lichSu extends Fragment implements AdapterNV.IteamListener {
    private AdapterNV adapter;
    private SqliteHelper db;
    private RecyclerView recycler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lichsu, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycler = view.findViewById(R.id.recycleViewls);
        db = new SqliteHelper(getContext());
        adapter = new AdapterNV();
        ArrayList<iteam> list = new ArrayList<>();

        String s = "dm";
        list.add(new iteam(1, "ăn sáng", "từ: 11/2/2022", "đến: 11:30",
                "12:15", "ss", 0));
        list.add(new iteam(1, "ăn sáng", "từ: 11/2/2022", "đến: 11:30",
                "12:15", "ss", 0));
        list.add(new iteam(1, "ăn sáng", "từ: 11/2/2022", "đến: 11:30",
                "12:15", "ss", 0));
        list.add(new iteam(1, "ăn sáng", "từ: 11/2/2022", "đến: 11:30",
                "12:15", "ss", 0));
        list.add(new iteam(1, "ăn sáng", "từ: 11/2/2022", "đến: 11:30",
                "12:15", "ss", 0));
        list.add(new iteam(1, "ăn sáng", "từ: 11/2/2022", "đến: 11:30",
                "12:15", "ss", 0));
        list.add(new iteam(1, "ăn sáng", "từ: 11/2/2022", "đến: 11:30",
                "12:15", "ss", 0));
        list.add(new iteam(1, "ăn sáng", "từ: 11/2/2022", "đến: 11:30",
                "12:15", "ss", 0));
        list.add(new iteam(1, "ăn sáng", "từ: 11/2/2022", "đến: 11:30",
                "12:15", "ss", 0));
        list.add(new iteam(1, "ăn sáng", "từ: 11/2/2022", "đến: 11:30",
                "12:15", "ss", 0));

        adapter.setList(list);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recycler.setLayoutManager(manager);
        recycler.setHasFixedSize(true);
        recycler.setAdapter(adapter);
        adapter.setIteamListener(this);
    }


    @Override
    public void onIteamClick(View view, int pos) {

    }
}
