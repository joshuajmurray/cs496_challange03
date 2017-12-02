package com.jmurray.android.challenge03;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MangleActivity extends AppCompatActivity {
    private Button mResestButton;
    private Button mReMangle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mangle);

        mResestButton = (Button) findViewById(R.id.reset);
        mResestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intent = getIntent();
        String pass = intent.getStringExtra("firstName");
        boolean isNice = intent.getBooleanExtra("isNice", true);

        final NameViewModel nvm = new NameViewModel(pass, isNice);

        mResestButton = (Button) findViewById(R.id.remangle);
        mResestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//testing remangle...
                Toast.makeText(MangleActivity.this, nvm.getLastName(), Toast.LENGTH_SHORT).show();
            }
        });

        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragment_container);

        Bundle bundle = new Bundle();
        if(isNice) {
            bundle.putString("firstName", pass);
            bundle.putInt("isNice", 1);

            if (fragment == null) {
                fragment = new NiceFragment();
                fragment.setArguments(bundle);
                manager.beginTransaction()
                        .add(R.id.fragment_container, fragment)
                        .commit();
            }
        } else {
            bundle.putString("firstName", pass);
            bundle.putInt("isNice", 0);

            if (fragment == null) {
                fragment = new RudeFragment();
                fragment.setArguments(bundle);
                manager.beginTransaction()
                        .add(R.id.fragment_container, fragment)
                        .commit();
            }
        }
    }
}