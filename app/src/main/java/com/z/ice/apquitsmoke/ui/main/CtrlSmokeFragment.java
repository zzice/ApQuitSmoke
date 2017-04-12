package com.z.ice.apquitsmoke.ui.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.viewanimator.ViewAnimator;
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
        // Inflate the layout for this fragment
        ViewAnimator viewAnimator = new ViewAnimator();
        return inflater.inflate(R.layout.fragment_ctrl_smoke, container, false);
    }

}
