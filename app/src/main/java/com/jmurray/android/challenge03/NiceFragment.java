package com.jmurray.android.challenge03;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jmurray.android.challenge03.databinding.FragmentNiceBinding;

public class NiceFragment extends Fragment {
    private Names names = new Names();

    public static NiceFragment newInstance() {
        return new NiceFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentNiceBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_nice, container, false);

        return binding.getRoot();
    }
//                    mFirstName = (EditText) findViewById(R.id.first_name);
//                    names.setLastName(true);
//                    mFirstName.setText(names.getLastName());

}
