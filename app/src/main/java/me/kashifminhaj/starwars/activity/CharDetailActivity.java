package me.kashifminhaj.starwars.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import me.kashifminhaj.starwars.Common;
import me.kashifminhaj.starwars.R;

public class CharDetailActivity extends AppCompatActivity {

    public static final String EXTRA_CHAROBJ = "char_obj";
    private JSONObject charObj;
    TextView name, dob, height;
    Button save;

    private Common mApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_detail);

        mApp = (Common) getApplicationContext();

        name = (TextView) findViewById(R.id.name);
        dob = (TextView) findViewById(R.id.dob);
        height = (TextView) findViewById(R.id.height);
        save = (Button) findViewById(R.id.save);

        // Retrieve arguments sent through the intent that started this activity
        Intent i = getIntent();
        if(i.hasExtra(EXTRA_CHAROBJ)) {
            try {
                charObj = new JSONObject(i.getStringExtra(EXTRA_CHAROBJ));
                name.setText(charObj.getString("name"));
                dob.setText(charObj.getString("birth_year"));
                height.setText(charObj.getString("height"));
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mApp.getSQLiteHandler().addChar(name.getText().toString(), dob.getText().toString(), height.getText().toString());
                        Toast.makeText(CharDetailActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();

                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            // something went wrong!
            finish(); // just kill this activity
        }




    }
}
