package com.jmurray.android.challenge03;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jmurray.android.challenge03.databinding.FragmentNiceBinding;

public class MangleActivity extends AppCompatActivity {
    private Button mResestButton;
    private Button mReMangle;
    private TextView mNiceText;
    private TextView mRudeText;


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
        String firstName = intent.getStringExtra("firstName");
        final boolean isNice = intent.getBooleanExtra("isNice", true);

        final NameViewModel nvm = new NameViewModel(firstName, isNice);

        mReMangle = (Button) findViewById(R.id.remangle);
        mReMangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mangledName = nvm.getLastName();
                if(isNice) {//I don't like setting the textview this way but I'm not sure how else to do it
                    mNiceText = (TextView) findViewById(R.id.nice_mangled);
                    mNiceText.setText(mangledName);
                } else {
                    mRudeText = (TextView) findViewById(R.id.rude_mangled);
                    mRudeText.setText(mangledName);
                }
            }
        });

        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragment_container);

        Bundle bundle = new Bundle();
        if(isNice) {
            bundle.putString("firstName", firstName);
            bundle.putInt("isNice", 1);

            if (fragment == null) {
                fragment = new NiceFragment();
                fragment.setArguments(bundle);
                manager.beginTransaction()
                        .add(R.id.fragment_container, fragment)
                        .commit();
            }
        } else {
            bundle.putString("firstName", firstName);
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