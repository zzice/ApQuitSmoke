package com.z.ice.apquitsmoke.ui.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.z.ice.apquitsmoke.R;

/**
 * desc: CtrlSmokeFragment.java
 * date: 2017/4/11
 * author: Zice
 */
public class CtrlSmokeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ctrl_smoke, container, false);
        return view;
    }

}
