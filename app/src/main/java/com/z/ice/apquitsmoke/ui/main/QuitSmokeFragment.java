package com.z.ice.apquitsmoke.ui.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.z.ice.apquitsmoke.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuitSmokeFragment extends Fragment {


    public QuitSmokeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quit_smoke, container, false);
        return view;
    }

}
