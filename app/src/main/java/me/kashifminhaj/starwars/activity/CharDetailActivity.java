package me.kashifminhaj.starwars.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import me.kashifminhaj.starwars.R;

public class CharDetailActivity extends AppCompatActivity {

    public static final String EXTRA_CHAROBJ = "char_obj";
    private JSONObject charObj;
    TextView name, dob, height;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_detail);

        name = (TextView) findViewById(R.id.name);
        dob = (TextView) findViewById(R.id.dob);
        height = (TextView) findViewById(R.id.height);

        // Retrieve arguments sent through the intent that started this activity
        Intent i = getIntent();
        if(i.hasExtra(EXTRA_CHAROBJ)) {
            try {
                charObj = new JSONObject(i.getStringExtra(EXTRA_CHAROBJ));
                name.setText(charObj.getString("name"));
                dob.setText(charObj.getString("birth_year"));
                height.setText(charObj.getString("height"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            // something went wrong!
            finish(); // just kill this activity
        }




    }
}
