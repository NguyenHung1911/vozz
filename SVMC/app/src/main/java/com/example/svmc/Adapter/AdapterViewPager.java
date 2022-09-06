package com.example.svmc.Adapter;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.svmc.fragment.lichSu;
import com.example.svmc.fragment.nghiemVu;
import com.example.svmc.fragment.thongKe;

public class AdapterViewPager extends FragmentPagerAdapter {
    private int pageNumber;
    public AdapterViewPager(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.pageNumber = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new nghiemVu();
            case 1:
                return new lichSu();
            case 2:
                return new thongKe();
        }
        return null;
    }

    @Override
    public int getCount() {
        return this.pageNumber;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "nghiem vu";
            case 1:
                return "lich su";
            case 2:
                return "thong ke";
        }
        return null;
    }
}
