package me.kashifminhaj.starwars.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.kashifminhaj.starwars.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlanetsFragment extends Fragment {


    public PlanetsFragment() {
        // Required empty public constructor
    }

    public static PlanetsFragment newInstance() {
        PlanetsFragment fragment = new PlanetsFragment();
        Bundle args = new Bundle();
        // use args.putInt() etc..;
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_planets, container, false);
    }

}
