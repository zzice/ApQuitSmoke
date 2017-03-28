package com.z.ice.apquitsmoke.ui.main;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.z.ice.apquitsmoke.R;

import me.yokeyword.fragmentation.SupportFragment;

public class SelectModeFragment extends SupportFragment {


    public SelectModeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select_mode, container, false);
    }

}
