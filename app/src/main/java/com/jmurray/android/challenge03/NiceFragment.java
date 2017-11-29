package com.jmurray.android.challenge03;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jmurray.android.challenge03.databinding.FragmentNiceBinding;

public class NiceFragment extends Fragment {
    private Names names = new Names();
    private Button mResetButton;
    private Button mMangleNice;
    private TextView mNiceMangled;

    public static NiceFragment newInstance() {
        return new NiceFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

//                    mFirstName = (EditText) findViewById(R.id.first_name);
//                    names.setLastName(true);
//                    mFirstName.setText(names.getLastName());

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final FragmentNiceBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_nice, container, false);

        mNiceMangled = (TextView) binding.niceFragment.findViewById(R.id.nice_mangled);

        mMangleNice = (Button) binding.niceFragment.findViewById(R.id.nice_mangled);
        mMangleNice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNiceMangled.setText("test");
            }
        });

        binding.niceReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        return binding.getRoot();
    }

}
