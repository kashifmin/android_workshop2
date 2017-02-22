package me.kashifminhaj.starwars.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import me.kashifminhaj.starwars.R;

public class CharDetailActivity extends AppCompatActivity {

    public static final String EXTRA_CHAROBJ = "char_obj";
    private JSONObject charObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_detail);

        // Retrieve arguments sent through the intent that started this activity
        Intent i = getIntent();
        if(i.hasExtra(EXTRA_CHAROBJ)) {
            try {
                charObj = new JSONObject(i.getStringExtra(EXTRA_CHAROBJ));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            // something went wrong!
            finish(); // just kill this activity
        }



    }
}
