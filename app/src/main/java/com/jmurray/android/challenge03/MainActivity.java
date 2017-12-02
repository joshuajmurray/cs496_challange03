package com.jmurray.android.challenge03;

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
                    FragmentNiceBinding binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.fragment_nice);
                    binding.niceMangled.setText(mFirstName.toString());

                    String pass = mFirstName.getText().toString();
                    bundle.putString("firstName", pass);
                    bundle.putInt("isNice", 1);

                    setContentView(R.layout.fragment_nice);
                    FragmentManager manager = getSupportFragmentManager();
                    Fragment fragment = manager.findFragmentById(R.id.nice_fragment);

                    if (fragment == null) {
                        fragment.setArguments(bundle);
                        manager.beginTransaction()
                                .add(R.id.nice_fragment, fragment)
                                .commit();
                    }
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
                    String pass = mFirstName.getText().toString();
                    bundle.putString("firstName", pass);
                    bundle.putInt("isNice", 0);

                    setContentView(R.layout.fragment_rude);
                    FragmentManager manager = getSupportFragmentManager();
                    Fragment fragment = manager.findFragmentById(R.id.rude_fragment);

                    if (fragment == null) {
                        fragment.setArguments(bundle);
//                        fragment = createFragment();
                        manager.beginTransaction()
                                .add(R.id.rude_fragment, fragment)
                                .commit();
                    }
                }
            }
        });

    }

    protected  Fragment createFragment() {
        return new Fragment();
    }
}