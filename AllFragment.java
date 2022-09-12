package com.example.svmc.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.svmc.Adapter.AdapterNV;
import com.example.svmc.AddActivity;
import com.example.svmc.R;
import com.example.svmc.SqliteHelper;
import com.example.svmc.UpdateActivity;
import com.example.svmc.model.NhiemVu;

import java.util.ArrayList;
import java.util.Calendar;

public class AllFragment extends Fragment implements AdapterNV.IteamListener {
    private static AdapterNV adapter;
    private static SqliteHelper db;
    private RecyclerView recycler;
    private static ArrayList<NhiemVu> list;
    private static TextView tv, tv_name;
    private static Button btn_search;
    private static Spinner sp1, sp2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all, container, false);
        tv = view.findViewById(R.id.soNv);
        sp1 = view.findViewById(R.id.spinner_allstatus);
        sp2 = view.findViewById(R.id.spinner_alltime);
        tv_name = view.findViewById(R.id.all_nameNv);
        btn_search = view.findViewById(R.id.all_btnsearch);

        recycler = view.findViewById(R.id.recycleViewls);
        db = new SqliteHelper(getContext());
        adapter = new AdapterNV();
        list = getAllList();


        tv.setText("so nhiem vu: " + list.size());
        adapter.setList(list);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recycler.setLayoutManager(manager);
        recycler.setHasFixedSize(true);
        recycler.setAdapter(adapter);

        adapter.setIteamListener(this);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namee = tv_name.getText().toString();
                namee = namee.trim();
                list.clear();
                list.addAll(getAllList());
                if (namee.equals("")) {
                    tv.setText("so nhiem vu: " + list.size());
                    adapter.notifyDataSetChanged();
                }
                else {
                    ArrayList<NhiemVu> list1 = new ArrayList<>();
                    for(NhiemVu nv : list) {
                        if(nv.getName().contains(namee)) {
                            list1.add(nv);
                        }
                    }
                    list.clear();
                    list.addAll(list1);
                    tv.setText("so nhiem vu: " + list.size());
                    tv_name.setText(null);
                    adapter.notifyDataSetChanged();
                }
            }
        });
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                AllFragment.updateUI();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                AllFragment.updateUI();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;
    }

    @Override
    public void onIteamClick(View view, int pos) {
        Intent intent = new Intent(getActivity(), UpdateActivity.class);
        NhiemVu nv = list.get(pos);
        intent.putExtra("nv", nv);
        startActivity(intent);
    }

    public static void updateUI() {
        list.clear();
        list.addAll(getAllList());
        tv.setText("so nhiem vu: " + list.size());
        adapter.notifyDataSetChanged();
    }

    public static ArrayList<NhiemVu> getAllList() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        int today = day + month * 30 + year * 365;

        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int timee = hours * 60 + minute;

        int status = sp1.getSelectedItemPosition();
        int time = sp2.getSelectedItemPosition();
        ArrayList<NhiemVu> list2 = new ArrayList<>();
        list2 = db.getAll();
        ArrayList<NhiemVu> list1 = new ArrayList<>();
        if(status == 0) {
            if(time == 0){
                for(NhiemVu nv : list2) {
                    list1.add(nv);
                }
            }
            else if(time == 1) {
                for(NhiemVu nv : list2) {
                    if(DateToDay(nv) < today) {
                        list1.add(nv);
                    }
                    else if(DateToDay(nv) == today && TimeToMinute(nv) < timee) {
                        list1.add(nv);
                    }
                }
            }else if(time == 2) {
                for(NhiemVu nv : list2) {
                    if(DateToDay(nv) > today) {
                        list1.add(nv);
                    }
                    else if(DateToDay(nv) == today && TimeToMinute(nv) >= timee) {
                        list1.add(nv);
                    }
                }
            }
        }
        else if(status == 1) {
            if(time == 0){
                for(NhiemVu nv : list2) {
                    if(nv.getTrangThai() != 0) {
                        list1.add(nv);
                    }
                }
            }
            else if(time == 1) {
                for(NhiemVu nv : list2) {
                    if(nv.getTrangThai() != 0) {
                        if (DateToDay(nv) < today) {
                            list1.add(nv);
                        } else if (DateToDay(nv) == today && TimeToMinute(nv) < timee) {
                            list1.add(nv);
                        }
                    }
                }
            }else if(time == 2) {
                for(NhiemVu nv : list2) {
                    if(nv.getTrangThai() != 0) {
                        if (DateToDay(nv) > today) {
                            list1.add(nv);
                        } else if (DateToDay(nv) == today && TimeToMinute(nv) >= timee) {
                            list1.add(nv);
                        }
                    }
                }
            }
        }
        else if(status == 2) {
            if(time == 0){
                for(NhiemVu nv : list2) {
                    if(nv.getTrangThai() == 0) {
                        list1.add(nv);
                    }
                }
            }
            else if(time == 1) {
                for(NhiemVu nv : list2) {
                    if(nv.getTrangThai() == 0) {
                        if (DateToDay(nv) < today) {
                            list1.add(nv);
                        }
                        else if (DateToDay(nv) == today && TimeToMinute(nv) < timee) {
                            list1.add(nv);
                        }
                    }
                }
            }else if(time == 2) {
                for(NhiemVu nv : list2) {
                    if(nv.getTrangThai() == 0) {
                        if (DateToDay(nv) > today) {
                            list1.add(nv);
                        }
                        else if (DateToDay(nv) == today && TimeToMinute(nv) >= timee) {
                            list1.add(nv);
                        }
                    }
                }
            }
        }
        return list1;
    }

    public static int DateToDay(NhiemVu nvv) {
        String s = nvv.getDate();
        String[] st = s.split("/");
        int res = Integer.parseInt(st[0]) + Integer.parseInt(st[1]) * 30 +
                Integer.parseInt(st[2]) * 365;
        return res;
    }

    public static int TimeToMinute(NhiemVu nvv) {
        String s = nvv.getTime();
        String[] st = s.split(":");
        int res = Integer.parseInt(st[0]) * 60 + Integer.parseInt(st[1]);
        return res;
    }

}
