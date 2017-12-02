package com.jmurray.android.challenge03;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jmurray.android.challenge03.databinding.FragmentNiceBinding;

public class MainActivity extends AppCompatActivity {

    private Button mNiceButton;
    private Button mRudeButton;
    private EditText mFirstName;

    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirstName = (EditText) findViewById(R.id.first_name);

        mNiceButton = (Button) findViewById(R.id.mangle_nice);
        mNiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mFirstName.getText().toString().matches("")) {
                    Toast.makeText(MainActivity.this, R.string.no_first_name, Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Intent intent = new Intent(MainActivity.this, MangleActivity.class);
                    intent.putExtra("firstName", mFirstName.getText().toString());
                    intent.putExtra("isNice", true);
                    mFirstName.setText("");
                    startActivity(intent);
                }
            }
        });

        mRudeButton = (Button)findViewById(R.id.mangle_rude);
        mRudeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mFirstName.getText().toString().matches("")) {
                    Toast.makeText(MainActivity.this, R.string.no_first_name, Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Intent intent = new Intent(MainActivity.this, MangleActivity.class);
                    intent.putExtra("firstName", mFirstName.getText().toString());
                    intent.putExtra("isNice", false);
                    mFirstName.setText("");
                    startActivity(intent);
                }
            }
        });

    }

    protected  Fragment createFragment() {
        return new Fragment();
    }
}