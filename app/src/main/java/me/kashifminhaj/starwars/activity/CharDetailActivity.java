package me.kashifminhaj.starwars.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import me.kashifminhaj.starwars.R;

public class CharDetailActivity extends AppCompatActivity {

    public static final String EXTRA_CHAROBJ = "char_obj";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_detail);
    }
}
