package com.jmurray.android.challenge03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button mNiceButton;
    private Button mRudeButton;
    private EditText mFirstName;
    private Names names = new Names();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNiceButton = (Button)findViewById(R.id.mangle_nice);
        mNiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                call fragement here
                mFirstName = (EditText)findViewById(R.id.first_name);
                names.setLastName(true);
                mFirstName.setText(names.getLastName());
            }
        });

        mRudeButton = (Button)findViewById(R.id.mangle_rude);
        mRudeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                call fragment here
                mFirstName = (EditText)findViewById(R.id.first_name);
                names.setLastName(false);
                mFirstName.setText(names.getLastName());
            }
        });

    }

}