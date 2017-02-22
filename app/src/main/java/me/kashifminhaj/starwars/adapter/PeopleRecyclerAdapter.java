package me.kashifminhaj.starwars.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import me.kashifminhaj.starwars.R;

/**
 * Created by kashif on 20/2/17.
 */

public class PeopleRecyclerAdapter extends RecyclerView.Adapter<PeopleRecyclerAdapter.ViewHolder> {

    JSONArray mPeople = null;

    // helps the fragment to set retrieved data once it's ready
    public void setData(JSONArray jsonArray) {
        this.mPeople = jsonArray;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_character_item, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        /* Create Reference variables for our Views */
        TextView nameView = (TextView) holder.mCard.findViewById(R.id.card_character_name);
        TextView heightView = (TextView) holder.mCard.findViewById(R.id.card_character_height);
        TextView dobView = (TextView) holder.mCard.findViewById(R.id.card_character_dob);
        try {
            // choose one of the People and fetch their details
            JSONObject currPerson = mPeople.getJSONObject(position);
            nameView.setText(currPerson.getString("name"));
            heightView.setText(currPerson.getString("height"));
            dobView.setText(currPerson.getString("birth_year"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {

        /* if the data has not been loaded yet, then mPeople will be null
         * so we return 0 in that case indicating we have nothing to display
         */
        if (mPeople != null)
            return mPeople.length();
        else
            return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView mCard;

        public ViewHolder(CardView itemView) {
            super(itemView);
            mCard = itemView;
        }
    }
}