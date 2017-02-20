package me.kashifminhaj.starwars.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import me.kashifminhaj.starwars.Common;
import me.kashifminhaj.starwars.R;
import me.kashifminhaj.starwars.adapter.PeopleRecyclerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class PeopleFragment extends Fragment {

    PeopleRecyclerAdapter mAdapter;
    private Common mApp;


    public PeopleFragment() {
        // Required empty public constructor
    }

    public static PeopleFragment newInstance() {
        PeopleFragment fragment = new PeopleFragment();
        Bundle args = new Bundle();
        // use args.putInt() etc..;
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // get a reference to the object of our singleton class
        mApp = (Common) getActivity().getApplicationContext();
        // instantiate a new adapter for this Fragment
        mAdapter = new PeopleRecyclerAdapter();

        /* Create a string request object to get data from swapi.co
         * StringRequest constructor takes 4 arguments
         * 1. The HTTP request method, it could GET, POST, DELETE etc
         * 2. URL to make request to
         * 3. An implementation for Response.Listener interface ( Success Callback)
         * 4. An implementation for Response.ErrorListener interface ( Error callback)
         *
         */
        StringRequest req = new StringRequest(
                Request.Method.GET,
                "http://swapi.co/api/people/",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject resJSON = new JSONObject(response);
                            JSONArray peopleJSONArr = resJSON.getJSONArray("results");
                            // update the data in adapter
                            mAdapter.setData(peopleJSONArr);
                            // send a notification to adapter saying that the data has been updated
                            // this will cause the adapter to refresh views
                            mAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }

        );


        // finally we queue our request
        mApp.addToRequestQueue(req);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_people, container, false);
        // create a reference for the recycler view in this fragment's layout
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.people_recycler);

        // set the adapter we created in onCreate
        recyclerView.setAdapter(mAdapter);
        // we define a layout manager, it could be linear or grid
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return v;
    }

}
